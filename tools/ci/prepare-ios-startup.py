"""Fetch pinned, current startup artwork without downloading the entire icon library."""
import hashlib
import json
from concurrent.futures import ThreadPoolExecutor
from pathlib import Path
from tempfile import TemporaryDirectory
from urllib.request import Request, urlopen
from zipfile import ZipFile


def main():
    archives = json.loads(Path('tools/ci/ios-startup-artifacts.json').read_text(encoding='utf-8'))
    with TemporaryDirectory() as temporary, ThreadPoolExecutor(max_workers=8) as pool:
        def part(archive, start):
            end = min(archive['size'], start + 1024 * 1024) - 1
            request = Request(archive['url'], headers={'Range': f'bytes={start}-{end}'})
            for attempt in range(3):
                try:
                    with urlopen(request, timeout=60) as response:
                        if response.status != 206 or response.headers.get('Content-Range') != f"bytes {start}-{end}/{archive['size']}":
                            raise OSError('Unexpected startup artwork range')
                        data = response.read(end - start + 2)
                    if len(data) != end - start + 1:
                        raise OSError('Incomplete startup artwork range')
                    destination = Path(temporary, f"{archive['density']}-{start}")
                    destination.write_bytes(data)
                    return destination
                except OSError:
                    if attempt == 2:
                        raise

        jobs = [(archive, [pool.submit(part, archive, start) for start in range(0, archive['size'], 1024 * 1024)])
                for archive in archives]
        for archive, parts in jobs:
            directory = Path(f"ios/bootstrap/data/ios-hd/zoom{archive['density']}")
            directory.mkdir(parents=True, exist_ok=True)
            target = directory / 'iconClient.zip'
            digest = hashlib.sha256()
            with target.open('wb') as output:
                for future in parts:
                    data = future.result().read_bytes()
                    digest.update(data)
                    output.write(data)
            if digest.hexdigest() != archive['sha256']:
                raise OSError('Startup artwork SHA-256 does not match the pinned release')
            with ZipFile(target) as source:
                if len(source.infolist()) != archive['entries'] or source.testzip() is not None:
                    raise OSError('Startup artwork contents are incomplete')
            (directory / 'source-size.txt').write_text(str(archive['sourceSize']) + '\n', encoding='ascii')
            print(f"Verified current zoom{archive['density']} startup artwork: {archive['size']:,} bytes", flush=True)


if __name__ == '__main__':
    main()
