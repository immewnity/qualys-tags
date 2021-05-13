/*
 * Groovy scripts for use in Qualys tags
 * 
 * Operating system families - 
 * 
 * Disclaimer: Scripts are not guaranteed to be perfect - false positive and false negative results are possible. Pull requests to improve the scripts are welcomed.
 * 
 * (c) Matthew Verive
 * Licensed under the MIT License
 */



/* macOS */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasAnyVuln([43566,43110,375113,45072,45238,374668,373187,374335,375114,373498,374919])) return true;

// VNC Banner
vnc_banner = asset.resultsForQid(38062L);
if (vnc_banner.contains("RFB 003.889")) return true;



/* OpenServer */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// POP banner
pop_banner = asset.resultsForQid(50000L);
if (pop_banner.contains("SCO POP3 server")) return true;

// FTP banner
ftp_banner = asset.resultsForQid(27113L);
if (ftp_banner.contains("FTP server (Version 2.1WU(1))")) return true;

// Default web page
webpage = asset.resultsForQid(12230L);
if (webpage.contains("/mana/mana/menu.mana")) return true;



/* Solaris */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasAnyVuln([105462,38574,105369,105502,105615,105741,45177])) return true;

// Telnet banner
telnet = asset.resultsForQid(38007L);
if (telnet.contains("SunOS")) return true;

// SNMP info
snmp = asset.resultsForQid(78000L);
if (snmp.contains("SunOS")) return true;



/* Windows Server */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Windows Product Type
win_prod_type = asset.resultsForQid(90107L);
if (win_prod_type.contains("InstallationType = Client") || win_prod_type.contains("ProductType = WinNT")) return false;
if (win_prod_type.contains("ProductType = ServerNT") || win_prod_type.contains("ProductType = LanmanNT") || win_prod_type.contains("InstallationType = Server")) return true;

if (asset.hasAnyVuln([105632,105340,105339,45341,45343,45345,45347,45348,45349,45350,45351,45419,90237,90388,105449,105497,91426,91537,105215,90238,105217])) return true;



/* Windows Workstation */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Windows Product Type
win_prod_type = asset.resultsForQid(90107L);
if (win_prod_type.contains("ProductType = WinNT") || win_prod_type.contains("InstallationType = Client")) return true;

if(asset.hasAnyVuln([105941,105793,105499,105361,105817,105871,105718,105733,105753,105784,105338,105405,105710,105543,105353,105352,105358,105649,45340,90704,45344,45346,70005,70010,70015,70013,91496,91540,45342,105229,90501,90691,116815,90177,90182,38094,91593,90282,90283,90504,90236,90193,90375,45061,45062,90205,105046,105047,105048,105049,105036,100019,105196,105198,105199,105197,105200,105201,105202,105203,105195,105180,105181,105182])) return true;
