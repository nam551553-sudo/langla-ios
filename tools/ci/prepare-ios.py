"""Validate workflow input before modifying RoboVM build metadata."""
import os
import re
from pathlib import Path

number = os.environ['BUILD_NUMBER']
if not re.fullmatch(r'[1-9][0-9]{0,8}', number):
    raise SystemExit('build_number must be a positive integer with at most 9 digits')
if os.environ['SIGNING_MODE'] not in ('unsigned', 'signed'):
    raise SystemExit('Unknown signing mode')
path = Path('ios/robovm.properties')
text = path.read_text(encoding='utf-8')
for key, value in [('app.version', '1.1.' + number), ('app.build', number)]:
    text, count = re.subn(r'^' + re.escape(key) + r'=.*$', key + '=' + value,
                          text, flags=re.MULTILINE)
    if count != 1:
        raise SystemExit('Missing or duplicate property: ' + key)
path.write_text(text, encoding='utf-8')
