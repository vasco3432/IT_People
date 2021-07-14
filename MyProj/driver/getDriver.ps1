Function Get-ChromeVersion {Try{
    (Get-Item (Get-ItemProperty 'HKLM:\SOFTWARE\Microsoft\Windows\CurrentVersion\App Paths\chrome.exe' -ErrorAction Stop).'(Default)').VersionInfo.FileVersion;
}Catch{
    Throw "Google Chrome not found in registry";
}}

$ChromeVersion = Get-ChromeVersion -ErrorAction Stop;
$ChromeVersion = $ChromeVersion.Substring(0, $ChromeVersion.LastIndexOf("."));
Write-Output "Google Chrome version $ChromeVersion found on machine";

$ChromeDriverVersion = (Invoke-WebRequest "https://chromedriver.storage.googleapis.com/LATEST_RELEASE_$ChromeVersion").Content;
Write-Output "Latest matching version of Chrome Driver is $ChromeDriverVersion";

Invoke-WebRequest "https://chromedriver.storage.googleapis.com/$ChromeDriverVersion/chromedriver_win32.zip" -OutFile "$PSScriptRoot/chromedriver_win32.zip";
Expand-Archive "$PSScriptRoot/chromedriver_win32.zip" -DestinationPath "$PSScriptRoot/chromedriver" -force;

Write-Output "Chrome Driver $ChromeDriverVersion has been deployed on $PSScriptRoot/chromedriver";
