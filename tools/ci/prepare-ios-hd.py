"""Bundle the verified high-density archives so iOS can unpack them offline."""
import hashlib
from concurrent.futures import ThreadPoolExecutor
from pathlib import Path
from tempfile import TemporaryDirectory
from urllib.request import Request, urlopen

ARCHIVES = {
    3: (111457702, "92cd3dcc4b3ae3e5a3fd6f285dd5fa3bd68224737615cec54d31250a656775b1"),
    4: (99900531, "dcb29a88c0246b6ebe484b76cbd693a74c2adfff17bffb4fd23d6c2e14bd0f39"),
}
PART_BYTES = 4 * 1024 * 1024


def download_part(density, size, start, destination):
    end = min(size, start + PART_BYTES) - 1
    url = f"http://103.77.172.222/langlaapp/img/zoom{density}/iconClient.zip"
    request = Request(url, headers={"Range": f"bytes={start}-{end}"})
    for attempt in range(3):
        try:
            with urlopen(request, timeout=60) as response:
                if response.status != 206 or response.headers.get("Content-Range") != f"bytes {start}-{end}/{size}":
                    raise OSError("Unexpected archive range response")
                data = response.read(end - start + 2)
            if len(data) != end - start + 1:
                raise OSError("Incomplete archive range")
            destination.write_bytes(data)
            return destination
        except OSError:
            if attempt == 2:
                raise


def main():
    with TemporaryDirectory() as temporary, ThreadPoolExecutor(max_workers=12) as pool:
        staging = Path(temporary)
        downloads = {
            density: [
                pool.submit(download_part, density, size, start, staging / f"{density}-{start}")
                for start in range(0, size, PART_BYTES)
            ]
            for density, (size, _) in ARCHIVES.items()
        }
        for density, parts in downloads.items():
            target = Path(f"ios/bootstrap/data/ios-hd/zoom{density}/iconClient.zip")
            target.parent.mkdir(parents=True, exist_ok=True)
            digest = hashlib.sha256()
            staged_archive = staging / f"zoom{density}.zip"
            with staged_archive.open("wb") as output:
                for part in parts:
                    data = part.result().read_bytes()
                    digest.update(data)
                    output.write(data)
            if digest.hexdigest() != ARCHIVES[density][1]:
                raise OSError(f"Unexpected SHA-256 for zoom{density}")
            target.write_bytes(staged_archive.read_bytes())
            print(f"Verified zoom{density} ({target.stat().st_size} bytes)", flush=True)


if __name__ == "__main__":
    main()
