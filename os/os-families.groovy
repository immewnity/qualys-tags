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


/* AlmaLinux */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Detect Linux version
if (asset.hasVulnWithResults(45353,"almalinux.org")) return true;

// Yum repo list
if (asset.hasVulnWithResults(45294,"name=AlmaLinux")) return true;



/* Amazon Linux */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Detect Linux version
linux_version = asset.resultsForQid(45353L);
if (linux_version.contains("amzn2")) return true;

// YUM repos
yum_repos = asset.resultsForQid(45294L);
if (yum_repos.contains("amzn2-core") || yum_repos.contains("Amazon Linux") || yum_repos.contains("managed with amazon-linux-extras")) return true;

if (asset.hasAnyVuln([352855,106213])) return true;



/* CentOS */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasAnyVuln([256546,256558,256581,256604,256616,256622,256645,256716,256718,256734,256736,256739,256773,256782,256796,256828,256897,256904,256916,256934,256965,257035,257047,257070,257073,257092])) return true;

if (asset.hasVulnWithResults(45294,"CentOS-Base.repo")) return true;
if (asset.hasVulnWithResults(45353,"kbuilder.bsys.centos.org")) return true;



/* Debian */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasTag("OS family: Ubuntu")) return false;

// /etc/issue
etc_issue = asset.resultsForQid(45046L);
if (etc_issue.contains("Debian")) return true;

// Unix Server Information
unix_info = asset.resultsForQid(45037L);
if (unix_info.contains("Debian Release")) return true;

// Detect Linux version
linux_version = asset.resultsForQid(45353L);
if (linux_version.contains("Debian")) return true;

// SSH banner
ssh_banner = asset.resultsForQid(38050L);
if (ssh_banner.contains("Debian")) return true;

// APT sources.list
sources_list = asset.resultsForQid(45293L);
if (sources_list.contains("Debian GNU")) return true;



/* FreeBSD */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasVulnWithResults(38293,"FreeBSD")) return true;



/* macOS */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasAnyVuln([45620,43566,43110,375113,45072,45238,374668,373187,374335,375114,373498,374919,45542,45558])) return true;

if (asset.hasVulnWithResults(38062,"RFB 003.889")) return true;

if (asset.hasVulnWithResults(43007,"ac:de:48:00:11:22")) return true;



/* OpenBSD */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasAnyVuln([370434])) return true;

// Unix server info
unix_info = asset.resultsForQid(45037L);
if (unix_info.contains("OpenBSD")) return true;

// Syslog
syslog = asset.resultsForQid(45069L);
if (syslog.contains("OpenBSD")) return true;



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



/* OpenVMS */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// NTP information
ntp_info = asset.resultsForQid(38293L);
if (ntp_info.contains("OpenVMS")) return true;



/* Oracle Linux */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// YUM repos
yum_repos = asset.resultsForQid(45294L);
if (yum_repos.contains("Oracle Linux") || yum_repos.contains("Oracle Enterprise Linux")) return true;

if (asset.hasAnyVuln([159318,159338,159258,159310,159308,159329,159000,159112,159141,159179,159276,159304,159306,159315,159328,159340,158950,158966,158986,159011,159018,159026,159045,159096,159113,159132,159157,159236,159271,159263,159251,159257])) return true;

// Unix services
unix_services = asset.resultsForQid(45294L);
if (unix_services.contains("ol-consolebaud.service")) return true;

if (asset.hasVulnWithResults(86000,"Oracle Linux")) return true;



/* Red Hat */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Detect Linux version
linux_version = asset.resultsForQid(45353L);
if (linux_version.contains("redhat.com")) return true;

// YUM repos
yum_repos = asset.resultsForQid(45294L);
if (yum_repos.contains("Red Hat Enterprise Linux") || yum_repos.contains("Managed by (rhsm) subscription-manager")) return true;

if (asset.hasAnyVuln([106238,106237,106236,239506,239541,239467,239535,239540,375544,239539,239546,239524,239534,239403,239339,239379,239202])) return true;

if (asset.hasVulnWithResults(38007,"Red Hat Linux release")) return true;



/* Solaris */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasAnyVuln([105462,38574,105369,105502,105615,105741,45177])) return true;

// Telnet banner
telnet = asset.resultsForQid(38007L);
if (telnet.contains("SunOS")) return true;

// SNMP info
snmp = asset.resultsForQid(78000L);
if (snmp.contains("SunOS")) return true;



/* Ubuntu */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// /etc/issue
etc_issue = asset.resultsForQid(45046L);
if (etc_issue.contains("Ubuntu")) return true;

// Detect Linux version
linux_version = asset.resultsForQid(45353L);
if (linux_version.contains("Ubuntu")) return true;

// SMTP banner
smtp_banner = asset.resultsForQid(74042L);
if (smtp_banner.contains("ESMTP Postfix (Ubuntu)")) return true;

// APT sources.list
sources_list = asset.resultsForQid(45293L);
if (sources_list.contains("from the Ubuntu security team")) return true;

if (asset.hasAnyVuln([105617,198438,105568,105715,198434])) return true;

// SSH Banner
if (asset.hasVulnWithResults(38050,"Ubuntu")) return true;



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
