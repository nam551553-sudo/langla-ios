"""Create a clean public-source ZIP without server files or local caches."""
from pathlib import Path
import sys
import zipfile

root = Path(__file__).resolve().parent.parent
folders = ['src', 'resource', 'music', 'sound', 'support', 'DanhHieu', 'ios',
           'core', 'desktop', 'launcher', 'gradle', '.github', 'tools/ci']
excluded = {'build', '.gradle', '__pycache__', '.idea', '.git'}
secret_suffixes = {'.pk8', '.pem', '.jks', '.keystore', '.p12', '.pfx', '.mobileprovision'}
files = []
for folder in folders:
    for path in (root / folder).rglob('*'):
        if (path.is_file() and not excluded.intersection(path.relative_to(root).parts)
                and path.suffix.lower() not in secret_suffixes):
            files.append(path)
for name in ['build.gradle', 'settings.gradle', 'gradlew', 'gradlew.bat',
             'version.properties', '.gitignore', 'README-GITHUB-IOS.md']:
    files.append(root / name)
files.append(Path(__file__).resolve())
with zipfile.ZipFile(sys.argv[1], 'w', zipfile.ZIP_DEFLATED, compresslevel=6) as archive:
    for path in sorted(files):
        archive.write(path, path.relative_to(root).as_posix())
print('Exported', len(files), 'files to', sys.argv[1])
