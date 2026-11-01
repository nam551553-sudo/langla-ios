# LangLa iOS 124 - GitHub Actions

Source client libGDX/RoboVM, bundle ID `com.beatdz.langlalau`.
Goi nay giu cac sua loi khoi dong va man hinh iOS cua build 124.
Chua kiem chung tren iPhone bang IPA build tu GitHub Actions.

## Dua source len GitHub

Tao repository Public ten `langla-ios` tren tai khoan cua ban.
Giai nen ZIP source GitHub vao mot thu muc moi. Dung GitHub Desktop de
Add local repository, tao Git repository neu duoc hoi, commit va Publish
repository. Bao gom thu muc an `.github` trong commit.
Khong upload ca thu muc workspace goc vi co goi server va du lieu local.
ZIP source da chon rieng file client can de build.

## Build khi chua co chung chi Apple

1. Mo repository > Actions > Build iOS IPA > Run workflow.
2. Chon `signing: unsigned`, giu build number `124`, bam Run workflow.
3. Sau khi job thanh cong, tai artifact `LangLa-iOS-124-unsigned` va giai nen.
4. IPA nay chua ky: can ky bang AltStore/Sideloadly truoc khi cai len iPhone.

Workflow chay macOS 15, Xcode 16.4, Java 21, Gradle Wrapper va RoboVM 2.3.23.
Neu runner khong con Xcode 16.4, buoc Prepare build se dung de bao loi.
Neu build hong, gui log cua buoc Build IPA; file ZIP source khong phai IPA.

## Build IPA co ky Apple sau nay

Can chung chi Apple co private key xuat thanh `.p12` va provisioning profile
con han, phu hop bundle ID va cach phan phoi. Profile Ad Hoc/Development
phai chua thiet bi can cai. App Store profile dung de phan phoi qua Apple,
khong cho phep cai truc tiep nhu Ad Hoc.

Trong Settings > Secrets and variables > Actions > New repository secret, tao:

- `IOS_CERTIFICATE_P12_BASE64`: noi dung base64 cua file `.p12`.
- `IOS_CERTIFICATE_PASSWORD`: mat khau file `.p12`.
- `IOS_PROVISION_PROFILE_BASE64`: noi dung base64 cua `.mobileprovision`.

Tren Mac co the tao noi dung base64 vao clipboard:

```sh
base64 -i /duong/dan/certificate.p12 | pbcopy
base64 -i /duong/dan/profile.mobileprovision | pbcopy
```

Chay tung lenh va dan vao secret tuong ung truoc khi copy file tiep theo.
Khong commit chung chi, profile, mat khau hay base64 vao repo Public.
Sau khi da them secrets, Run workflow voi `signing: signed`.
Workflow dung keychain tam, kiem tra han/bundle ID cua profile va don dep
file ky sau build. Apple quyet dinh kha nang cai/chay theo chung chi va profile.

## Tai lieu

- [RoboVM Gradle plugin 2.3.23](https://github.com/MobiVM/robovm/blob/robovm-2.3.23/plugins/gradle/README.md)
- [macOS 15 runner image](https://github.com/actions/runner-images/blob/main/images/macos/macos-15-Readme.md)
- [Apple code signing](https://developer.apple.com/support/code-signing/)

Windows OpenGL DLLs are omitted from this iOS repository.
