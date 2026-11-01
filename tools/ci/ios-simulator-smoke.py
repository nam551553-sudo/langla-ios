"""Build and run the CI-only app on a fresh simulator; require actual login readiness."""
import json
import os
from pathlib import Path
import plistlib
import subprocess

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
        '-Probovm.arch=arm64', '-Probovm.iosSkipSigning=true', '-Probovm.skipLaunch=true',
        '-Probovm.device.name=iPhone 16 Pro Max', '-Probovm.sdk.version=' + runtime['version'],
        '-Dorg.gradle.jvmargs=-Xmx4g -XX:MaxMetaspaceSize=1g -Dfile.encoding=UTF-8',
        ':ios:launchIPhoneSimulator', '--max-workers=2', '--no-daemon', '--stacktrace')
    apps = list(Path('ios/build').rglob('LangLaLau.app'))
    if not apps:
        raise SystemExit('Simulator app was not produced')
    app = apps[0]
    info = plistlib.loads((app / 'Info.plist').read_bytes())
    bundle = info['CFBundleIdentifier']
    run('xcrun', 'simctl', 'boot', udid)
    run('xcrun', 'simctl', 'bootstatus', udid, '-b')
    run('xcrun', 'simctl', 'install', udid, str(app))
    with open('ios-native-smoke.log', 'w') as log:
        result = subprocess.run(['xcrun', 'simctl', 'launch', '--console', udid, bundle],
                                stdout=log, stderr=subprocess.STDOUT, timeout=360)
    text = Path('ios-native-smoke.log').read_text(errors='replace')
    print(text[-20000:])
    if result.returncode or 'PASS IOS_NATIVE_STARTUP' not in text:
        raise SystemExit('Native iOS startup did not reach login; inspect ios-native-smoke.log')
finally:
    subprocess.run(['xcrun', 'simctl', 'shutdown', udid], check=False)
    subprocess.run(['xcrun', 'simctl', 'delete', udid], check=False)
