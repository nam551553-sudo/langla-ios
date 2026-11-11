"""Keep the base UI and skill icons in the app. Event artwork is already hosted per icon."""
from pathlib import Path, PurePosixPath
from zipfile import ZIP_DEFLATED, ZipFile


def compact(archive: Path) -> None:
    revision = archive.stat().st_size
    temporary = archive.with_suffix('.compact')
    with ZipFile(archive) as original, ZipFile(temporary, 'w', ZIP_DEFLATED, compresslevel=6) as output:
        for entry in original.infolist():
            if entry.is_dir():
                continue
            icon = PurePosixPath(entry.filename).stem
            if icon.isdecimal() and int(icon) > 2000:
                continue
            output.writestr(entry.filename, original.read(entry))
    temporary.replace(archive)
    archive.with_name('source-size.txt').write_text(str(revision) + '\n', encoding='ascii')
    print(f'{archive.parent.name}: {revision:,} → {archive.stat().st_size:,} bytes')


if __name__ == '__main__':
    for zoom in (3, 4):
        compact(Path(f'ios/bootstrap/data/ios-hd/zoom{zoom}/iconClient.zip'))
