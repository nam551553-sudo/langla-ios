"""Transcode iOS music while retaining the legacy extensionless byte encoding."""
from pathlib import Path
from subprocess import run
from tempfile import TemporaryDirectory


def shifted(content, direction):
    amount = (len(content) & 255) or 100
    return bytes((value + direction * amount) & 255 for value in content)


with TemporaryDirectory() as work:
    source, output = Path(work, "source.mp3"), Path(work, "output.mp3")
    original_size = 0
    packaged_size = 0
    for track in sorted(Path("music").iterdir()):
        if not track.is_file() or not track.name.isascii() or not track.name.isdigit():
            continue
        original = track.read_bytes()
        original_size += len(original)
        source.write_bytes(shifted(original, -1))
        run(["ffmpeg", "-nostdin", "-hide_banner", "-loglevel", "error", "-y",
             "-i", str(source), "-vn", "-map_metadata", "-1",
             "-ac", "1", "-ar", "24000", "-c:a", "libmp3lame", "-b:a", "40k", str(output)],
            check=True)
        compact = shifted(output.read_bytes(), 1)
        if len(compact) < len(original):
            track.write_bytes(compact)
        packaged_size += min(len(compact), len(original))
    print(f"Bundled music: {original_size:,} -> {packaged_size:,} bytes")