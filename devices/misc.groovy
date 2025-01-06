/*
 * Groovy scripts for use in Qualys tags
 * 
 * Various device types
 * 
 * Disclaimer: Scripts are not guaranteed to be perfect - false positive and false negative results are possible. Pull requests to improve the scripts are welcomed.
 * 
 * (c) Matthew Verive
 * Licensed under the MIT License
 */



/* Aiphone intercom system */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the SSL certificate
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("Aiphone") && ssl_cert.contains("IS-System")) return true;



/* BrightSign digital signage */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasTag("Cloud Agent")) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("Diagnostic Web Server")) return true;



/* Canon document scanner */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("Canon USA") && ssl_cert.contains("ICS")) return true;

// Search the web page
default_web = asset.resultsForQid(12230L);
if (default_web.contains("chorin-webapp")) return true;



/* Citrix NetScaler ADC */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasAnyVuln([48183,10030,106157])) return true;

if (asset.hasVulnWithResults(12230,"<span>NetScaler ADC</span>")) return true;
if (asset.hasVulnWithResults(13910,"<span>NetScaler ADC</span>")) return true;
if (asset.hasVulnWithResults(86002,"Citrix ANG")) return true;
if (asset.hasVulnWithResults(86002,"Citrix ADM")) return true;
if (asset.hasVulnWithResults(12230,"ns_logo2_color_negative")) return true;
if (asset.hasVulnWithResults(13910,"ns_logo2_color_negative")) return true;



/* Dell iDRAC */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the SNMP info
snmp_info = asset.resultsForQid(78000L);
if (snmp_info.contains("dell.com") && snmp_info.contains("idrac")) return true;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("restgui/start.html")) return true;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if ((ssl_cert.contains("Dell") && ssl_cert.contains("Remote Access Group")) || (ssl_cert.contains("Dell") && ssl_cert.contains("iDRAC"))) return true;

if (asset.hasAnyVuln([13826,13376,13918,13370,13478])) return true;



/* HP iLO */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search through SSH banner
ssh_version = asset.resultsForQid(38050L);
if (ssh_version.contains("SSH-2.0-RomSShell_4.62") || ssh_version.contains("SSH-2.0-mpSSH_0.2.1")) return true;

// UPnP service
upnp = asset.resultsForQid(45187L);
if (upnp.contains("HP-iLO")) return true;

// SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("organizationalUnitName ISS")) return true;

// Web server version
web_server = asset.resultsForQid(86000L);
if (web_server.contains("Allegro-Software-RomPager/4.62")) return true;

if (asset.hasAnyVuln([730068,13306,13358,13492,13359,43572,43578,13493,43557,730100,10240,43500,13510,11987,13228,43573,13220,13964,13635])) return true;



/* HP ScanJet document scanner */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the web page
if (asset.hasVulnWithResults(12230,"HP ScanJet")) return true;
if (asset.hasVulnWithResults(13910,"HP ScanJet")) return true;
if (asset.hasVulnWithResults(13531,"HP ScanJet")) return true;
if (asset.hasVulnWithResults(86565,"HP ScanJet")) return true;



/* HP StorageWorks MSA */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// SSH banner
ssh_banner = asset.resultsForQid(38050L);
if (ssh_banner.contains("Iconfidant_2.3.11") || ssh_banner.contains("Iconfidant 2.3.11")) return true;



/* HPE BladeSystem */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("HPE BladeSystem")) return true;

// Search SSH banner
ssh_banner = asset.resultsForQid(38050L);
if (ssh_banner.contains("SSH-2.0-OpenSSH_OA")) return true;



/* HPE System Management */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("HPE System Management") || default_web_page.contains("red2301") || default_web_page.contains("cpqlogin")) return true;

// Search the redirected default web page
default_web_page = asset.resultsForQid(13910L);
if (default_web_page.contains("HPE System Management") || default_web_page.contains("red2301") || default_web_page.contains("cpqlogin")) return true;



/* Microchip SyncServer */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasVulnWithResults(12230,"Microchip - SyncServer")) return true;
if (asset.hasVulnWithResults(13910,"Microchip - SyncServer")) return true;
if (asset.hasVulnWithResults(86565,"Microchip - SyncServer")) return true;
if (asset.hasVulnWithResults(12230,"mfcon.png")) return true;



/* Pitney Bowes postage meter */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("PitneyBowesInc")) return true;



/* Presentation system (AWIND-based), includesBarco wePresent, Extron ShareLink, InFocus LiteShow, Crestron AirMedia, and more */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the SNMP data
snmp = asset.resultsForQid(78000L);
if (snmp.contains("Awind") || snmp.contains("wePresent-WiPG") || snmp.contains("Crestron Electronics AM-100")) return true;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("organizationName AWiND") || ssl_cert.contains("awindinc.com")) return true;

// Search the NetBIOS workgroup
netbios_workgroup = asset.resultsForQid(82062L);
if (netbios_workgroup.contains("MIRROROP")) return true;

// Search the NetBIOS bindings
netbios = asset.resultsForQid(70004L);
if (netbios.contains("MIRROROP") || netbios.contains("LITESHOW")) return true;

// Search the NetBIOS name
netbios = asset.resultsForQid(70004L);
if (netbios.contains("LITESHOW")) return true;

if (asset.hasAnyVuln([13230])) return true;



/* Prima Nova access control */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("NovaDrive")) return true;



/* Raspberry Pi */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// VNC Banner
vnc_banner = asset.resultsForQid(38062L);
if (vnc_banner.contains("RFB 005.000")) return true;

// SSH Banner
ssh_banner = asset.resultsForQid(38050L);
if (ssh_banner.contains("Raspbian")) return true;



/* RMG/Symon/Korbyt digital signage */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasTag("Cloud Agent")) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("LogoSymon") || default_web_page.contains("SDA Login")) return true;

// Search the redirected web page
default_web_page = asset.resultsForQid(13910L);
if (default_web_page.contains("LogoSymon") || default_web_page.contains("SDA Login")) return true;



/* RoomWizard (Steelcase/PolyVision) */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("RoomHomepage")) return true;

// Search the redirected web page
redirected_web_page = asset.resultsForQid(13910L);
if (redirected_web_page.contains("RoomWizard setup")) return true;



/* Scan2Net document scanner */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("Scan2Net") || ssl_cert.contains("imageaccess.de") || ssl_cert.contains("Scan2net") || ssl_cert.contains("Image Access GmbH")) return true;

// Search the admin interface
admin = asset.resultsForQid(48144L);
if (admin.contains("Enhanced Scanning Technology")) return true;



/* Tridium Niagara / JACE 8000 IoT controller */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Default web page
if (asset.hasVulnWithResults(12230,"Baja-Station-Brand") && asset.hasVulnWithResults(12230,"Niagara-HostId")) return true;

// Redirected web page
if (asset.hasVulnWithResults(13910,"Baja-Station-Brand") && asset.hasVulnWithResults(13910,"Niagara-HostId")) return true;

// HTTP response method
if (asset.hasVulnWithResults(48118,"Baja-Station-Brand") && asset.hasVulnWithResults(48118,"Niagara-HostId")) return true;

// SSL certificate
if (asset.hasVulnWithResults(86002,"Tridium") && asset.hasVulnWithResults(86002,"Niagara4")) return true;



/* Tyco iSTAR door controller (may flag on other Tyco/Sensormatic/Johnson Controls products) */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
if (asset.hasVulnWithResults(12230,"VideoEdge")) return false;

// Search the redirected default web page
if (asset.hasVulnWithResults(13910,"VideoEdge")) return false;

// Search the MAC address
if (asset.hasVulnWithResults(43007,"DIGITAL-LOGIC")) return false;
if (asset.hasVulnWithResults(43007," 00:50:F9:")) return true;
if (asset.hasVulnWithResults(86002,"iSTAR Ultra")) return true;
if (asset.hasVulnWithResults(12230,"iuvweb_icon")) return true;
if (asset.hasVulnWithResults(12230,"iSTARUltra_Icon_96x96")) return true;
if (asset.hasVulnWithResults(12230,"istarClient")) return true;
if (asset.hasVulnWithResults(12230,"iStarSettings")) return true;
if (asset.hasVulnWithResults(13910,"iuvweb_icon")) return true;
if (asset.hasVulnWithResults(13910,"iSTARUltra_Icon_96x96")) return true;
if (asset.hasVulnWithResults(13910,"istarClient")) return true;
if (asset.hasVulnWithResults(13910,"iStarSettings")) return true;



/* Tyco NVR */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasVulnWithResults(86002,"Tyco International") && asset.hasVulnWithResults(86002,"American Dynamics") && asset.hasVulnWithResults(86002,"DNS:NVR")) return true;



/* Veritas NetBackup */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("Veritas") && ssl_cert.contains("Appliance")) return true;



/* VideoEdge NVR */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
if (asset.hasVulnWithResults(12230,"VideoEdge")) return true;

// Search the redirected default web page
if (asset.hasVulnWithResults(13910,"VideoEdge")) return true;

if (asset.hasVulnWithResults(86565,"/session/login/") && asset.hasVulnWithResults(86002,"Victor Unified Video Management")) return true;



/* VMware ESXi*/

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasVulnWithResults(45017,"VMware ESXi")) return true;
if (asset.hasVulnWithResults(45017,":vmware:esxi:")) return true;

if (asset.hasAnyVuln([45589,105608,105580,105767,105769,105928,106098,106100,216108,216090,216091,216085,216086,216087,216088,216089,216083,216082,216081,216080,120077,216015,216014,216013,216012,216011,216005,216019,216022,216039,216043,216055,216062,216066,216009,216006,216010,216007,216004,216016,216018,216021,216046,216042,216050,216060,216065,216112,216041,216056,216003,216017,216020,216023,216038,216048,216054,216070,216078,216094,216002,216111,216049,216063,216076,216040,216053,216058,216069,216072,216084,216093,216073,216110,216139,216154,216152,216159,216164,216059,216071,216077,216099,216102,216115,216120,216129,216064,216092,216001,216109,216119,216118,216117,216131,216138,216151,216162,216200,216165,216175,216184,216191,216221,216197,216210,216217,216100,216103,216114,216140,216142,216150,216163,216166,216178,216201,216174,216185,216208,216211,216190,216198,216196,216215,216218,216223,216227,216233,216237,216241,216249,216252,216258,216264,216278,216281,216294,216308,216305,216291,216298,216311,216116,216130,216156,216167,216172,216202,216173,216186,216187,216209,216231,216189,216216,216245,216219,216230,216224,216228,216232,216236,216242,216251,216248,216257,216262,216279,216292,216295,216297,216309,216304,216212,216312,216229,216235,216243,216244,216250,216247,216256,216282,216263,216283,216280,216284,216293,216296,216299,216310,216303,216301,216302,11507])) return true;

if (asset.hasVulnWithResults(12230,"ID_EESX_Welcome")) return true;
if (asset.hasVulnWithResults(12230,"VMware ESXi is virtual infrastructure software for partitioning")) return true;
if (asset.hasVulnWithResults(13910,"ID_EESX_Welcome")) return true;
if (asset.hasVulnWithResults(13910,"VMware ESXi is virtual infrastructure software for partitioning")) return true;
if (asset.hasVulnWithResults(86002,"vmca@vmware.com")) return true;
if (asset.hasVulnWithResults(86002,"VMware ESX Server Default Certificate")) return true;



/* VMware NSX */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasVulnWithResults(48118,"/nsx/index.html")) return true;
if (asset.hasVulnWithResults(48118,"Server: NSX")) return true;
if (asset.hasVulnWithResults(86565,"/nsx/index.html")) return true;
if (asset.hasVulnWithResults(86565,"Server: NSX")) return true;
if (asset.hasVulnWithResults(12230,"/nsx/index.html")) return true;
if (asset.hasVulnWithResults(12230,"Server: NSX")) return true;
if (asset.hasVulnWithResults(13910,"VMware NSX | Login")) return true;
if (asset.hasVulnWithResults(13910,"VMware&nbsp;NSX")) return true;



/* VMWare SRM (Site Recovery Manager) */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasVulnWithResults(48118,"/configure/app/landing/index.html")) return true;
if (asset.hasVulnWithResults(86565,"/configure/app/landing/index.html")) return true;
if (asset.hasVulnWithResults(12230,"/configure/app/landing/index.html")) return true;
if (asset.hasVulnWithResults(13910,"/configure/app/landing/index.html")) return true;



/* VMWare vCenter Server */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasVulnWithResults(45017,"VMware vCenter Server Appliance")) return true;
if (asset.hasVulnWithResults(45017,"vcenter_server_appliance")) return true;
if (asset.hasVulnWithResults(12230,"ID_BrowseVCDatacenters")) return true;
if (asset.hasVulnWithResults(13910,"ID_BrowseVCDatacenters")) return true;

if (asset.hasAnyVuln([216267,216271,216285,216288,216300,216240,216123,216276,216273,216193,216205,216246,216214,216222,216254,216260,216266,216270,216286,216289,216306,216157,216171,216239,216275,216272,216253,216259,216265,216268,216287,216290,216307,216314,216317,216238,216313,216315,216316,216141,216153,216106,730102,11699,121532])) return true;
if (asset.hasAnyVuln([105940,106099,106101,216220,216095,216096,216097,216121,216098,216104,216105,216122,121274,216225,119075,216134,216135,216136,216127,216133,216149,216161,216168,216126,216124,216148,216160,216169,216194,216203,216137,216132,216277,216274,216125,216128,216170,216147,216158,216192,216195,216213,216255,216261])) return true;



/* VMWare vSphere Replication */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasVulnWithResults(13910,"VMware vSphere Replication")) return true;

if (asset.hasAnyVuln([375829])) return true;
