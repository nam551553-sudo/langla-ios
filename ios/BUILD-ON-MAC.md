# iOS startup/fullscreen fix, build 124

Extract the complete source ZIP into a new folder on the Mac. Keep the Apple signing
identity and provisioning profile used for your previous successful IPA build.

Use Xcode and JDK 21. In Terminal, from the folder containing `gradlew`:

```bash
export JAVA_HOME=$(/usr/libexec/java_home -v 21)
chmod +x gradlew
./gradlew -Pios -PreleaseBuild=124 :ios:clean :ios:createIPA
```

Install the newly built IPA with your existing signing/install method. The bundle ID
is still `com.beatdz.langlalau`. Check CFBundleVersion is 124 to distinguish this fix.
The launch screen must be compiled by Xcode/ibtool; RoboVM processes the storyboard
from `ios/launch/Base.lproj/LaunchScreen.storyboard` via `ios/robovm.xml`.

The first launch downloads game data and artwork automatically. Keep a working
network connection; the full-resolution UI archive can exceed 100 MB. The loading
progress stays visible on iOS and a retry dialog appears if a transfer fails.

Changes: landscape-only configuration, status bar hidden, auto-hidden home indicator,
launch storyboard for current iPhone screen sizes, no desktop tab-bar gutter on iOS,
automatic first-run asset download, visible progress, UI-thread retry handling,
cross-thread readiness visibility, bounded retry for invalid game-data files.

Deployment target remains iOS 12.0+, arm64 iPhone/iPad. This is a configured target,
not a guarantee that every device/OS version has been tested. Windows checks Java
compilation and exercises the iOS code branch with real OpenGL/downloads; it cannot
build/link/sign an IPA or validate UIKit, Xcode's storyboard compiler, or an iPhone.

On the iPhone 12 Pro Max/iOS 18, verify: screen fills the display, the status bar and
desktop 1/+ tabs are absent, progress appears on first launch, login screen opens,
touch targets align after rotation, and online login/gameplay work with your server.
For any remaining failure, capture the `Startup`/RoboVM log in Xcode Devices and Simulators.

References: [Apple launch-screen key](https://developer.apple.com/documentation/bundleresources/information-property-list/uilaunchstoryboardname),
[libGDX iOS configuration](https://github.com/libgdx/libgdx/blob/1.12.1/backends/gdx-backend-robovm/src/com/badlogic/gdx/backends/iosrobovm/IOSApplicationConfiguration.java).


Build 124 additionally rejects truncated compressed input without looping, invalidates
only the broken core-data cache and its correctly classified revision marker, and
continues to the manifest even when local warmup failed. iOS cached preparation runs
on the render thread without HTTP recovery. Core data is bundled under ios/bootstrap
as a first-launch fallback; the manifest still checks for current server data.
The screen shows the current initialization stage and any recovery warning.
