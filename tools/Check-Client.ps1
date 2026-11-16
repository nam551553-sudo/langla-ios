param([string]$JavaHome='',[string]$CoreJar='',[string]$LauncherJar='',[switch]$Graphics)
$ErrorActionPreference='Stop'
$root=(Resolve-Path -LiteralPath (Join-Path $PSScriptRoot '..')).Path
if(-not $JavaHome){$config=Get-Content -LiteralPath (Join-Path $root 'release-config.json') -Raw | ConvertFrom-Json;$JavaHome=$config.javaHome}
if(-not $CoreJar){$CoreJar=Join-Path $root 'desktop/build/libs/LangLaLau.jar'}
if(-not $LauncherJar){$LauncherJar=Join-Path $root 'launcher/build/libs/LangLaBlue.jar'}
$CoreJar=(Resolve-Path -LiteralPath $CoreJar).Path;$LauncherJar=(Resolve-Path -LiteralPath $LauncherJar).Path
$output=Join-Path $root 'build/client-checks';$classes=Join-Path $output 'classes'
New-Item -ItemType Directory -Force $classes | Out-Null
$cp=$CoreJar+';'+$LauncherJar
$sources=@(Get-ChildItem -LiteralPath (Join-Path $root 'test') -Recurse -Filter '*.java' -File | ForEach-Object FullName)
$ErrorActionPreference='Continue'
& (Join-Path $JavaHome 'bin/javac.exe') -encoding UTF-8 -cp $cp -d $classes @sources 2> (Join-Path $output 'compile.log')
$compileExit=$LASTEXITCODE
$ErrorActionPreference='Stop'
if($compileExit -ne 0){Get-Content (Join-Path $output 'compile.log') -Tail 25;throw 'Client checks did not compile'}
$cp=$classes+';'+$cp+';'+(Join-Path $root 'test')
$checks=@('beatdz.PacketFramingCheck','beatdz.GoldTopUpQrCheck','beatdz.MadaraAttachmentCheck','beatdz.CapeAttachmentCheck','beatdz.AndroidMotionCheck','beatdz.CostumeMovementCheck','CombatSenderCheck','beatdz.MapPrefetchCheck','AutoOptionsCheck','beatdz.BulkItemUseCheck','LauncherUpdateCheck','com.langla.launcher.LauncherRecoveryCheck','com.langla.launcher.SignedUpdateCheck','beatdz.LuckyDialogCheck','beatdz.MobTargetHudCheck')
$graphicsChecks=@('beatdz.MultiSessionLoadCheck','beatdz.QuestTrackerTabCheck','beatdz.CardArtworkCheck','beatdz.RecoveryAndConsumableCheck','beatdz.ImageTabIsolationCheck','beatdz.EquipmentTapCheck')
if($Graphics){$checks+=$graphicsChecks}
$passed=@()
foreach($name in $checks){
    $runtime=Join-Path $output $name
    New-Item -ItemType Directory -Force $runtime | Out-Null
    $arguments=@('-cp',$cp,$name)
    if($name -in $graphicsChecks){$arguments+='--software'}
    $stdout=Join-Path $runtime 'stdout.log';$stderr=Join-Path $runtime 'stderr.log'
    # Start-Process joins ArgumentList; quote classpath for workspaces with spaces.
    $arguments[1]='"'+$arguments[1]+'"'
    $process=Start-Process -FilePath (Join-Path $JavaHome 'bin/java.exe') -ArgumentList $arguments -WorkingDirectory $runtime -WindowStyle Hidden -RedirectStandardOutput $stdout -RedirectStandardError $stderr -PassThru
    # Retain the native handle so Windows PowerShell can read a fast process's exit code.
    $null=$process.Handle
    try {
        if(-not $process.WaitForExit(60000)){throw "Client check timed out: $name"}
        $log=Get-Content -LiteralPath $stdout -Raw
        if($process.ExitCode -ne 0 -or -not($log -match 'PASS')){Get-Content $stderr -Tail 15;Get-Content $stdout -Tail 10;throw "Client check failed: $name"}
        $passed+=$name
        Select-String -LiteralPath $stdout -Pattern '^PASS|Frame work' | ForEach-Object Line
    } finally {if(-not $process.HasExited){$process.Kill()};$process.Dispose()}
}
$report=@{coreSha256=(Get-FileHash -LiteralPath $CoreJar -Algorithm SHA256).Hash;launcherSha256=(Get-FileHash -LiteralPath $LauncherJar -Algorithm SHA256).Hash;passed=$passed;checkedAt=[DateTime]::UtcNow.ToString('o')}
[IO.File]::WriteAllText((Join-Path $output 'result.json'),($report|ConvertTo-Json -Depth 5),[Text.UTF8Encoding]::new($false))
