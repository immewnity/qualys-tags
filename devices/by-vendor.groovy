/*
 * Groovy scripts for use in Qualys tags
 * 
 * Devices by vendor (manufacturer/distributor/etc.)
 * 
 * Disclaimer: Scripts are not guaranteed to be perfect - false positive and false negative results are possible. Pull requests to improve the scripts are welcomed.
 * 
 * (c) Matthew Verive
 * Licensed under the MIT License
 */



/* Accops */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("accopshysecureclient") || default_web_page.contains("Accops Systems")) return true;

// Search the DEFLATE algorithm
telnet = asset.resultsForQid(42416L);
if (telnet.contains("accopshysecureclient")) return true;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("Accops Technologies") || ssl_cert.contains("accops.com")) return true;



/* Arista */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page after following redirects
default_web_page = asset.resultsForQid(13910L);
if (default_web_page.contains("Arista Command API")) return true;

// Search the HTTP response
http_response = asset.resultsForQid(48118L);
if (http_response.contains("/explorer.html")) return true;



/* Aruba Networks */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasAnyVuln([45274])) return true;

// Search the default web page after following redirects
default_web_page = asset.resultsForQid(13910L);
if (default_web_page.contains("arubanetworks") || default_web_page.contains("Aruba Networks") || default_web_page.contains("arubalp=") || default_web_page.contains("/nextgen/ui/index")) return true;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("Aruba Networks")) return true;

// SNMP data
snmp = asset.resultsForQid(78000L);
if (snmp.contains("Aruba ")) return true;

// Telnet
telnet = asset.resultsForQid(38007L);
if (telnet.contains("Aruba ")) return true;

// MAC address
mac_addr = asset.resultsForQid(43007L);
if (mac_addr.contains("SNMP 10:4F:58:")) return true;



/* Avaya */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("/cgi-bin/common/issue") || default_web_page.contains("aamwc-theme") || default_web_page.contains("/oam/em.web/north_panel.htm") || default_web_page.contains("Avaya Media Server") || default_web_page.contains("Avaya Aura") || default_web_page.contains("Recommended access to System Manager is")) return true;

// Search the redirected default web page
redirected_web_page = asset.resultsForQid(13910L);
if (redirected_web_page.contains("Avaya, Inc") || redirected_web_page.contains("Avaya one")) return true;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("organizationName Avaya") || ssl_cert.contains("organizationalUnitName Avaya") || ssl_cert.contains("organizationName AVAYA") || ssl_cert.contains(",O=AVAYA")) return true;

// Search the HTTP response method
http_response = asset.resultsForQid(86002L);
if (http_response.contains("Avaya Media Server")) return true;

// Search the IMAP message
imap = asset.resultsForQid(50010);
if (imap.contains("CallPilot")) return true;

/* Axway */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page after redirect
default_web_page = asset.resultsForQid(13910L);
if (default_web_page.contains(":/enduser/")) return true;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("support@axway.com")) return true;



/* BeyondTrust */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the HTTP response
http_response = asset.resultsForQid(48118L);
if (http_response.contains("nsbase_session")) return true;



/* Blue Coat */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page after redirect
default_web_page = asset.resultsForQid(13910L);
if (default_web_page.contains("BlueCoat")) return true;

// Search HTTP response
http_response = asset.resultsForQid(48118L);
if (http_response.contains("Blue Coat")) return true;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("Blue Coat")) return true;



/* Brocade */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("organizationName Brocade")) return true;

// Search the Telnet banner
telnet = asset.resultsForQid(38007L);
if (telnet.contains("Fabric OS")) return true;



/* Check Point */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("Check Point SVN foundation") || default_web_page.contains("Check Point Certificate Services")) return true;

// Search the redirected default web page
redirected_web_page = asset.resultsForQid(13910L);
if (redirected_web_page.contains("Check Point SVN foundation") || redirected_web_page.contains("Check Point Certificate Services")) return true;

// Search the open TCP ports
tcp_ports = asset.resultsForQid(82023L);
if (tcp_ports.contains("FW1 ica services") || tcp_ports.contains("CheckPoint Internal CA")) return true;

// Search the IKE service
ike_service = asset.resultsForQid(45018L);
if (ike_service.contains("CheckPoint")) return true;



/* Cisco */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("Cisco Connection Online") || default_web_page.contains("Cisco Codec:") || default_web_page.contains("Server: cisco-IOS") || default_web_page.contains("Cisco Systems") || default_web_page.contains("url ='/webui';window.location.href=url") || default_web_page.contains("icon_styles_ciscologo") || default_web_page.contains("and Cisco Systems are registered trademarks or trademarks of Cisco Systems") || default_web_page.contains("Cisco Unified Contact Center") || default_web_page.contains("ciscologo.gif") || default_web_page.contains("governing Cisco cryptographic products") || default_web_page.contains("default page when just a URL is entered")) return true;

// Search the default redirected web page
default_web_page = asset.resultsForQid(13910L);
if (default_web_page.contains("Cisco Connection Online") || default_web_page.contains("Cisco Codec:") || default_web_page.contains("Server: cisco-IOS") || default_web_page.contains("Cisco Systems") || default_web_page.contains("url ='/webui';window.location.href=url") || default_web_page.contains("icon_styles_ciscologo") || default_web_page.contains("and Cisco Systems are registered trademarks or trademarks of Cisco Systems") || default_web_page.contains("Cisco Unified Contact Center") || default_web_page.contains("ciscologo.gif") || default_web_page.contains("governing Cisco cryptographic products") || default_web_page.contains("default page when just a URL is entered")) return true;

// Search the SSH banner
ssh_banner = asset.resultsForQid(38050L);
if (ssh_banner.contains("Cisco")) return true;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("Cisco Systems") || ssl_cert.contains("IOS-Self-Signed-Certificate") || ssl_cert.contains("C-series_CIMC")) return true;

// Search the SSL web server version
ssl_server = asset.resultsForQid(86001L);
if (ssl_server.contains("cisco-IOS")) return true;

// Search the Telnet banner
telnet_banner = asset.resultsForQid(38007L);
if (telnet_banner.contains("Cisco Configuration")) return true;

// Search the SIP information
sip_info = asset.resultsForQid(38438L);
if (sip_info.contains("Cisco-SIPGateway")) return true;

// Search the SMTP banner
sip_info = asset.resultsForQid(74042L);
if (sip_info.contains("UnityMailer")) return true;

if (asset.hasAnyVuln([38211,43001,13605,13811,13488,13662,38673,38667,42395,38250])) return true;



/* Crestron */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("Crestron")) return true;



/* Emerson/Liebert/Vertiv */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the Telnet response
telnet = asset.resultsForQid(38007L);
if (telnet.contains("Emerson Network Power")) return true;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("Pealse enable the cookie of your web browser") || default_web_page.contains("redirect to default.html for UMS device")) return true;

// Search the SNMP info
snmp = asset.resultsForQid(78000L);
if (snmp.contains("Emerson") && snmp.contains("Smart PDU")) return true;



/* F5 Networks */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("F5 Networks Configuration") || default_web_page.contains("F5 Networks, Inc.")) return true;



/* Forcepoint */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("Forcepoint") || default_web_page.contains("Websense")) return true;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("Forcepoint") || ssl_cert.contains("Websense")) return true;



/* Fortinet */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("Fortinet")) return true;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("Warning: this page requires Javascript. To correctly view, please enable it in your browser.")) return true;

// Search the redirected default web page
redirected_web_page = asset.resultsForQid(13910L);
if (redirected_web_page.contains("Warning: this page requires Javascript. To correctly view, please enable it in your browser.")) return true;



/* Grandstream */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the telnet banner
telnet = asset.resultsForQid(38007L);
if (telnet.contains("Grandstream")) return true;



/* Honeywell */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("hwell.jpg") && default_web_page.contains("Access Control Device")) return true;

// Search the redirected default web page
redirected_web_page = asset.resultsForQid(13910L);
if (redirected_web_page.contains("Copyright Honeywell Inc")) return true;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("Honeywell") || ssl_cert.contains("Maxpro_MAXPRO-NVR1")) return true;



/* HP */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Model information
model = asset.resultsForQid(45304L);
if (model.contains("HP ") || model.contains("EliteDesk") || model.contains("EliteBook") || model.contains("ProLiant") || model.contains("Compaq")) return true;



/* IDEMIA */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("<title>IDEMIA</title>") || default_web_page.contains("MA5G_general_configurations")) return true;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("MORPHOACCESS")) return true;



/* Juniper Networks */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("juniper.net") || default_web_page.contains("Juniper Networks") || default_web_page.contains("Juniper Web Device")) return true;

// Search the default web page after following redirects
default_web_page = asset.resultsForQid(13910L);
if (default_web_page.contains("juniper.net") || default_web_page.contains("Juniper Networks") || default_web_page.contains("Juniper Web Device")) return true;

// Search the NTP reply
ntp = asset.resultsForQid(38293L);
if (ntp.contains("JUNOS") || ntp.contains("FreeBSDJNPR")) return true;

if (asset.getOperatingSystem.contains("JUNOS") || asset.getOperatingSystem.contains("FreeBSDJNPR") || asset.getOperatingSystem.contains("Juniper")) return true;



/* Meraki */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("Meraki") || default_web_page.contains("meraki")) return true;

// Search the SNMP information
snmp = asset.resultsForQid(78000L);
if (snmp.contains("Meraki")) return true;



/* NEC */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("NEC Corporation")) return true;



/* Opengear */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("Opengear.com")) return true;



/* Palo Alto Networks */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("Location: /php/login.php")) return true;

// Search the redirected default web page
redirected_web_page = asset.resultsForQid(13910L);
if (redirected_web_page.contains("Creating administrative session. Please wait") || redirected_web_page.contains("logo-pan-") || redirected_web_page.contains("PAN_FORM_CONTENT")) return true;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("organizationName Palo Alto") || ssl_cert.contains("paloaltonetworks.com")) return true;



/* Riverbed */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the redirected default web page
redirected_web_page = asset.resultsForQid(13910L);
if (redirected_web_page.contains("UX RIVERBED ORANGE") || redirected_web_page.contains("Riverbed SteelHead") || redirected_web_page.contains("Use of this Riverbed product is subject")) return true;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("Riverbed Technology")) return true;



/* Ruckus Wireless */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("Ruckus Wireless")) return true;



/* SafeNet */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page after redirect
default_web_page = asset.resultsForQid(13910L);
if (default_web_page.contains("SafeNet_logo_with_tagline_web") || default_web_page.contains("IngrianConfigForm") || default_web_page.contains("SafeNet Inc.") || default_web_page.contains("safenet_ui_v2")) return true;

// Search SSH banner
ssh_banner = asset.resultsForQid(38050L);
if (ssh_banner.contains("SSH-2.0-Ingrian_SSH")) return true;

// Search SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("Ingrian Networks") || ssl_cert.contains("ingrian.com")) return true;



/* SolarWinds */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Check the software names, as well as a list of known QIDs
if (asset.hasSoftwareByName("Solarwinds") || asset.hasSoftwareByName("SolarWinds") || asset.hasSoftwareByName("solarwinds") || asset.hasSoftwareByName("Dameware") || asset.hasSoftwareByName("DameWare") || asset.hasSoftwareByName("dameware") || asset.hasAnyVuln("11657","13458","13535","13661","13903","13906","116593","118055","118101","120251","121467","124834","370078","370137","370138","370160","371807","372573","374560","27049","27219","27225","27238","27246","27256","27300","27307","38255","38531","120827","372235")) return true;

// Search in the installed applications list
installed_software = asset.resultsForQid(90235L);
if (installed_software.contains("Solarwinds") || installed_software.contains("SolarWinds") || installed_software.contains("solarwinds") || installed_software.contains("Dameware") || installed_software.contains("DameWare") || installed_software.contains("dameware") || installed_software.contains("RhinoSoft") || installed_software.contains("Rhino Software")) return true;

// Search in the services lists
services = asset.resultsForQid(90065L);
if (services.contains("Solarwinds") || services.contains("SolarWinds") || services.contains("solarwinds") || services.contains("Dameware") || services.contains("DameWare") || services.contains("dameware")) return true;
services = asset.resultsForQid(105187L);
if (services.contains("Solarwinds") || services.contains("SolarWinds") || services.contains("solarwinds") || services.contains("Dameware") || services.contains("DameWare") || services.contains("dameware")) return true;
services = asset.resultsForQid(45414L);
if (services.contains("Solarwinds") || services.contains("SolarWinds") || services.contains("solarwinds") || services.contains("Dameware") || services.contains("DameWare") || services.contains("dameware")) return true;

// Search in the startup list
startup = asset.resultsForQid(90074L);
if (startup.contains("Solarwinds") || startup.contains("SolarWinds") || startup.contains("solarwinds") || startup.contains("Dameware") || startup.contains("DameWare") || startup.contains("dameware")) return true;

// Search certs
certificates = asset.resultsForQid(45231L);
if (certificates.contains("Solarwinds") || certificates.contains("SolarWinds") || certificates.contains("solarwinds") || certificates.contains("Dameware") || certificates.contains("DameWare") || certificates.contains("dameware")) return true;

// Search list of admins
admins = asset.resultsForQid(105231L);
if (admins.contains("Solarwinds") || admins.contains("SolarWinds") || admins.contains("solarwinds") || admins.contains("Dameware") || admins.contains("DameWare") || admins.contains("dameware")) return true;

// Search in the drivers list for DameWare
drivers = asset.resultsForQid(90066L);
if (drivers.contains("Dameware") || drivers.contains("DameWare") || drivers.contains("dameware")) return true;

// Search in the TCP services list for DameWare
tcp_services = asset.resultsForQid(82023L);
if (tcp_services.contains("Dameware") || tcp_services.contains("DameWare") || tcp_services.contains("dameware")) return true;



/* SonicWALL */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains ("SonicWall") || (default_web_page.contains ("logo_sw") && default_web_page.contains ("Network Security Appliance"))) return true;

// Search the default redirected web page
default_web_page = asset.resultsForQid(13910L);
if (default_web_page.contains ("SonicWall") || (default_web_page.contains ("logo_sw") && default_web_page.contains ("Network Security Appliance"))) return true;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("SonicWall") || ssl_cert.contains("SonicWALL")) return true;

// Search the SSL web server version
ssl_server = asset.resultsForQid(86001L);
if (ssl_server.contains("SonicWall") || ssl_server.contains("SonicWALL")) return true;

// Search the web server version
webserver = asset.resultsForQid(86000L);
if (webserver.contains("SonicWALL")) return true;

// Search the HTTP response method
http_response = asset.resultsForQid(48118L);
if (http_response.contains("SonicWALL")) return true;

if (asset.hasAnyVuln([730122,375410,13995,10369,370319,13224,12670,87157])) return true;



/* Splunk */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page after redirect
default_web_page = asset.resultsForQid(13910L);
if (default_web_page.contains("splunk-phantom-logo") || (default_web_page.contains("/en-US/") && default_web_page.contains("The resource has moved temporarily"))) return true;

// Search HTTP header
http_header = asset.resultsForQid(48118L);
if (http_header.contains("Splunkd")) return true;

// Search SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("Splunk")) return true;



/* Super Micro */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("Super Micro Computer")) return true;

if (asset.hasAnyVuln([11950])) return true;
