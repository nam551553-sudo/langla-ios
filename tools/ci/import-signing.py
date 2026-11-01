"""Import GitHub Secrets into a temporary macOS keychain; never print secrets."""
import base64
import datetime
import os
from pathlib import Path
import plistlib
import re
import secrets
import subprocess
import sys

temp = Path(os.environ['RUNNER_TEMP']) / 'langla-signing'
keychain = temp / 'build.keychain-db'
marker = temp / 'installed-profile.txt'

def run(*args, capture=False):
    result = subprocess.run(args, stdout=subprocess.PIPE if capture else None)
    if result.returncode:
        # CalledProcessError would include command-line certificate passwords.
        raise SystemExit('Apple signing command failed: ' + args[1])
    return result

if '--cleanup' in sys.argv:
    if marker.exists():
        profile = Path(marker.read_text())
        allowed = Path.home() / 'Library/MobileDevice/Provisioning Profiles'
        if profile.parent == allowed and profile.suffix == '.mobileprovision':
            profile.unlink(missing_ok=True)
    if keychain.exists():
        subprocess.run(['security', 'delete-keychain', str(keychain)], check=False)
    if temp.exists():
        for path in temp.iterdir():
            if path.is_file():
                path.unlink()
        temp.rmdir()
    sys.exit(0)

for name in ('IOS_CERTIFICATE_P12_BASE64', 'IOS_CERTIFICATE_PASSWORD', 'IOS_PROVISION_PROFILE_BASE64'):
    if not os.environ.get(name):
        raise SystemExit('Missing GitHub Secret: ' + name)
temp.mkdir(mode=0o700, exist_ok=True)
for name, filename in [('IOS_CERTIFICATE_P12_BASE64', 'certificate.p12'),
                       ('IOS_PROVISION_PROFILE_BASE64', 'profile.mobileprovision')]:
    path = temp / filename
    path.write_bytes(base64.b64decode(os.environ[name], validate=True))
    path.chmod(0o600)
profile = plistlib.loads(run('security', 'cms', '-D', '-i', str(temp / 'profile.mobileprovision'), capture=True).stdout)
if profile['ExpirationDate'] <= datetime.datetime.now(datetime.timezone.utc).replace(tzinfo=None):
    raise SystemExit('Provisioning profile has expired')
bundle = dict(line.split('=', 1) for line in Path('ios/robovm.properties').read_text().splitlines() if '=' in line)['app.id']
app_id = profile['Entitlements']['application-identifier'].split('.', 1)[1]
if not (app_id == bundle or (app_id.endswith('*') and bundle.startswith(app_id[:-1]))):
    raise SystemExit('Provisioning profile does not match the app bundle ID')
uuid = profile['UUID']
if not re.fullmatch(r'[A-Fa-f0-9-]+', uuid):
    raise SystemExit('Invalid profile UUID')
installed = Path.home() / 'Library/MobileDevice/Provisioning Profiles' / (uuid + '.mobileprovision')
installed.parent.mkdir(parents=True, exist_ok=True)
if installed.exists():
    raise SystemExit('Refusing to overwrite an existing provisioning profile')
installed.write_bytes((temp / 'profile.mobileprovision').read_bytes())
marker.write_text(str(installed))
password = secrets.token_urlsafe(32)
run('security', 'create-keychain', '-p', password, str(keychain))
run('security', 'set-keychain-settings', '-lut', '21600', str(keychain))
run('security', 'unlock-keychain', '-p', password, str(keychain))
run('security', 'import', str(temp / 'certificate.p12'), '-P', os.environ['IOS_CERTIFICATE_PASSWORD'],
    '-A', '-t', 'cert', '-f', 'pkcs12', '-k', str(keychain))
run('security', 'set-key-partition-list', '-S', 'apple-tool:,apple:,codesign:', '-s', '-k', password, str(keychain))
old = run('security', 'list-keychains', '-d', 'user', capture=True).stdout.decode()
existing = re.findall(r'"([^"]+)"', old)
run('security', 'list-keychains', '-d', 'user', '-s', str(keychain), *existing)
identities = run('security', 'find-identity', '-v', '-p', 'codesigning', str(keychain), capture=True).stdout.decode()
match = re.search(r'\b([A-F0-9]{40})\s+"', identities)
if not match:
    raise SystemExit('No valid Apple signing identity in certificate')
with open(os.environ['GITHUB_ENV'], 'a', encoding='utf-8') as env:
    env.write('IOS_SIGN_IDENTITY=' + match.group(1) + '\nIOS_PROFILE_UUID=' + uuid + '\n')
    env.write('KEYCHAIN_PASSWORD=' + password + '\n')
print('::add-mask::' + password)
