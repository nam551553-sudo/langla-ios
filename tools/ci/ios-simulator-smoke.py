"""Build and run the CI-only app on a fresh simulator; require actual login readiness."""
import json
import os
from pathlib import Path
import plistlib
import shutil
import subprocess
import time
import zipfile

def run(*args, **kwargs):
    return subprocess.run(args, check=True, **kwargs)

runtimes = json.loads(run('xcrun', 'simctl', 'list', 'runtimes', '-j', capture_output=True).stdout)['runtimes']
available = [r for r in runtimes if r.get('isAvailable') and r['identifier'].startswith('com.apple.CoreSimulator.SimRuntime.iOS-')]
if not available:
    raise SystemExit('No iOS simulator runtime installed')
runtime = next((r for r in available if r['version'] == '18.5'), available[-1])
types = json.loads(run('xcrun', 'simctl', 'list', 'devicetypes', '-j', capture_output=True).stdout)['devicetypes']
phone = next(t for t in types if t['name'] == 'iPhone 16 Pro Max')
udid = run('xcrun', 'simctl', 'create', 'LangLa CI clean install', phone['identifier'], runtime['identifier'],
           capture_output=True, text=True).stdout.strip()
properties = Path('ios/robovm.properties')
properties.write_text(properties.read_text().replace('app.mainclass=com.beatdz.langlalau.IOSLauncher',
                      'app.mainclass=com.beatdz.langlalau.IOSStartupSmoke'))
try:
    run('./gradlew', '-Pios', '-PiosSmoke', '-PreleaseBuild=' + os.environ['BUILD_NUMBER'],
        '-Probovm.archs=arm64-simulator', '-Probovm.iosSkipSigning=true',
        '-Probovm.sdk.version=' + runtime['version'],
        '-Dorg.gradle.jvmargs=-Xmx4g -XX:MaxMetaspaceSize=1g -Dfile.encoding=UTF-8',
        ':ios:createIPA', '--max-workers=2', '--no-daemon', '--stacktrace')
    # Archive packaging leaves a complete .app next to its simulator-only IPA.
    app = None
    for info_path in Path('.').rglob('Info.plist'):
        try:
            candidate = plistlib.loads(info_path.read_bytes())
        except Exception:
            continue
        if (candidate.get('CFBundleIdentifier') == 'com.beatdz.langlalau'
                and 'iPhoneSimulator' in candidate.get('CFBundleSupportedPlatforms', [])
                and (info_path.parent / 'resource/background.jpg').is_file()
                and (info_path.parent / 'lib').is_dir()):
            app = info_path.parent
            break
    if app is None:
        print('Produced plist files:', [str(p) for p in Path('.').rglob('Info.plist')], flush=True)
        raise SystemExit('Complete simulator bundle (plist, resources, lib) was not produced')
    print('Installed bundle source:', app, flush=True)
    if app.suffix != '.app':
        packaged = Path(os.environ['RUNNER_TEMP']) / 'LangLaLau-smoke.app'
        shutil.copytree(app, packaged)
        app = packaged
    print('Simulator app:', app, flush=True)
    info = plistlib.loads((app / 'Info.plist').read_bytes())
    bundle = info['CFBundleIdentifier']
    # RoboVM's own simulator launcher supplies external framework search paths.
    # simctl needs the matching simulator slices embedded in the app instead.
    frameworks = app / 'Frameworks'
    for jar in (Path.home() / '.gradle/caches/modules-2/files-2.1/com.badlogicgames.gdx').rglob('*natives-ios.jar'):
        with zipfile.ZipFile(jar) as native:
            for name in native.namelist():
                if '-simulator/' not in name or '.framework/' not in name or name.endswith('/'):
                    continue
                relative = Path(name.split('-simulator/', 1)[1])
                if relative.is_absolute() or '..' in relative.parts:
                    raise SystemExit('Invalid native framework member')
                destination = frameworks / relative
                destination.parent.mkdir(parents=True, exist_ok=True)
                destination.write_bytes(native.read(name))
    for framework in frameworks.glob('*.framework'):
        binary = framework / framework.stem
        binary.chmod(0o755)
        run('codesign', '--force', '--sign', '-', str(framework))
    if not (frameworks / 'gdx.framework/gdx').exists():
        raise SystemExit('GDX simulator framework was not found')
    run('codesign', '--force', '--sign', '-', str(app))
    run('xcrun', 'simctl', 'boot', udid)
    run('xcrun', 'simctl', 'bootstatus', udid, '-b')
    run('xcrun', 'simctl', 'install', udid, str(app))
    with open('ios-native-smoke.log', 'w') as log:
        process = subprocess.Popen(['xcrun', 'simctl', 'launch', '--console', udid, bundle],
                                   stdout=log, stderr=subprocess.STDOUT)
        deadline = time.monotonic() + 360
        printed = 0
        try:
            while process.poll() is None and time.monotonic() < deadline:
                time.sleep(1)
                text = Path('ios-native-smoke.log').read_text(errors='replace')
                if len(text) > printed:
                    print(text[printed:], end='', flush=True)
                    printed = len(text)
                if 'PASS IOS_NATIVE_STARTUP' in text or 'FAIL IOS_NATIVE_STARTUP' in text:
                    break
        finally:
            if process.poll() is None:
                process.terminate()
                try:
                    process.wait(timeout=10)
                except subprocess.TimeoutExpired:
                    process.kill()
    text = Path('ios-native-smoke.log').read_text(errors='replace')
    print(text[-20000:])
    if 'PASS IOS_NATIVE_STARTUP' not in text:
        raise SystemExit('Native iOS startup did not reach login; inspect ios-native-smoke.log')
finally:
    subprocess.run(['xcrun', 'simctl', 'shutdown', udid], check=False)
    subprocess.run(['xcrun', 'simctl', 'delete', udid], check=False)
