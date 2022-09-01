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



/* JACE 8000 IoT controller */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Default web page
default_web = asset.resultsForQid(12230L);
if (default_web.contains("Baja-Station-Brand") && default_web.contains("Niagara-HostId: Qnx-TITAN")) return true;

// Redirected web page
redirect = asset.resultsForQid(13910L);
if (redirect.contains("Baja-Station-Brand") && redirect.contains("Niagara-HostId: Qnx-TITAN")) return true;

// HTTP response method
http_header = asset.resultsForQid(48118L);
if (http_header.contains("Baja-Station-Brand") && http_header.contains("Niagara-HostId: Qnx-TITAN")) return true;



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



/* Tyco iSTAR door controller (likely will flag on other Tyco/Sensormatic/Johnson Controls products) */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("VideoEdge")) return false;

// Search the redirected default web page
default_web_page = asset.resultsForQid(13910L);
if (default_web_page.contains("VideoEdge")) return false;

// Search the MAC address
mac_addr = asset.resultsForQid(43007L);
if (mac_addr.contains("DIGITAL-LOGIC")) return false;
if (mac_addr.contains(" 00:50:F9:")) return true;



/* Veritas NetBackup */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("Veritas") && ssl_cert.contains("Appliance")) return true;



/* VideoEdge NVR */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("VideoEdge")) return true;

// Search the redirected default web page
default_web_page = asset.resultsForQid(13910L);
if (default_web_page.contains("VideoEdge")) return true;



/* VMWare SRM */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("426 Upgrade Required") && default_web_page.contains("server: envoy")) return true;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("VMware") && ssl_cert.contains("SRM")) return true;



/* VMWare vCenter */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;


// Search the redirected default web page
default_web_page = asset.resultsForQid(13910L);
if (default_web_page.contains("ID_VC_Welcome")) return true;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("vCenterServer")) return true;



/* VMWare vSphere */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasAnyVuln([216079])) return true;

// Search the redirected default web page
default_web_page = asset.resultsForQid(13910L);
if (default_web_page.contains(":443/websso/") || default_web_page.contains(":5480") || default_web_page.contains("vsphere-client") || default_web_page.contains("ID_BrowseVCDatacenters")) return true;

// Search the LDAP info
ldap = asset.resultsForQid(45106L);
if (ldap.contains("dc=vsphere,dc=local")) return true;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("domainComponent vsphere") || ssl_cert.contains("vCenterServer")) return true;
