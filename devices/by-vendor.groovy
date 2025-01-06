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



/* Aiphone */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasVulnWithResults(86002,"AIPHONE")) return true;
if (asset.hasVulnWithResults(38655,"AIPHONE")) return true;



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



/* Algo */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasVulnWithResults(12230,"http://www.algosolutions.com/register")) return true;
if (asset.hasVulnWithResults(13910,"http://www.algosolutions.com/register")) return true;
if (asset.hasVulnWithResults(11827,"http://www.algosolutions.com/register")) return true;

if (asset.hasVulnWithResults(78000,"Algo Communication Products")) return true;
if (asset.hasVulnWithResults(78000,"support@algosolutions.com")) return true;

if (asset.hasVulnWithResults(43007,"00:22:EE:")) return true;



/* Apple */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasVulnWithResults(12230,"AirTunes")) return true;
if (asset.hasVulnWithResults(86000,"AirTunes")) return true;
if (asset.hasVulnWithResults(86565,"AirTunes")) return true;
if (asset.hasVulnWithResults(48118,"AirTunes")) return true;
if (asset.hasVulnWithResults(13910,"AirTunes")) return true;



/* Arista */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasAnyVuln([45601])) return true;

// Search the default web page after following redirects
if (asset.hasVulnWithResults(13910,"Arista Command API")) return true;
if (asset.hasVulnWithResults(13910,"<title>Arista</title>")) return true;
if (asset.hasVulnWithResults(13910,"Arista Analytics Node")) return true;

if (asset.hasVulnWithResults(48118,"/explorer.html")) return true;

// Search the SSL cert
if (asset.hasVulnWithResults(86002,"Arista Networks")) return true;
if (asset.hasVulnWithResults(86002,"bigswitch.com")) return true;
if (asset.hasVulnWithResults(86002,"Big Switch Networks")) return true;

if (asset.hasVulnWithResults(12230,"/favicons/dmf/browserconfig.xml")) return true;
if (asset.hasVulnWithResults(13910,"/favicons/dmf/browserconfig.xml")) return true;

if (asset.hasVulnWithResults(12230,"/eapi/") && asset.hasVulnWithResults(12230,"Server: nginx")) return true;



/* Aruba Networks */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasAnyVuln([45274])) return true;

if (asset.hasVulnWithResults(12230,"/tips/welcome.action")) return true;
if (asset.hasVulnWithResults(48118,"/tips/welcome.action")) return true;

// Search the default web page after following redirects
if (asset.hasVulnWithResults(13910,"Management by Central. No UI access.")) return true;
if (asset.hasVulnWithResults(13910,"/nextgen/ui/index")) return true;
if (asset.hasVulnWithResults(13910,"arubanetworks")) return true;
if (asset.hasVulnWithResults(13910,"Aruba Networks")) return true;
if (asset.hasVulnWithResults(13910,"arubalp=")) return true;
if (asset.hasVulnWithResults(13910,"cppmContent")) return true;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (asset.hasVulnWithResults(86002,"Aruba Networks")) return true;
if ((ssl_cert.contains("Aruba") && ssl_cert.contains("HPE") && ssl_cert.contains("Roseville"))) return true;

// SNMP data
if (asset.hasVulnWithResults(78000,"Aruba ")) return true;

// Telnet
if (asset.hasVulnWithResults(38007,"Aruba ")) return true;

// MAC address
if (asset.hasVulnWithResults(43007,"10:4F:58:")) return true;

// SSH banner
if (asset.hasVulnWithResults(38050,"SSH-2.0-Mocana SSH 6.3")) return true;

// HTTP unavailable
if (asset.hasVulnWithResults(86383,"available only on Master IAP")) return true;
if (asset.hasVulnWithResults(86383,"arubanetworks")) return true;



/* Avaya */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
if (asset.hasVulnWithResults(12230,"Start Element Manager")) return true;
if (asset.hasVulnWithResults(12230,"/cgi-bin/common/issue")) return true;
if (asset.hasVulnWithResults(12230,"aamwc-theme")) return true;
if (asset.hasVulnWithResults(12230,"/oam/em.web/north_panel.htm")) return true;
if (asset.hasVulnWithResults(12230,"Avaya Media Server")) return true;
if (asset.hasVulnWithResults(12230,"Avaya Aura")) return true;
if (asset.hasVulnWithResults(12230,"Recommended access to System Manager is")) return true;

// Search the redirected default web page
if (asset.hasVulnWithResults(13910,"Avaya, Inc")) return true;
if (asset.hasVulnWithResults(13910,"Avaya one")) return true;
if (asset.hasVulnWithResults(13910,"Start Element Manager")) return true;

if (asset.hasVulnWithResults(86002,"Avaya")) return true;
if (asset.hasVulnWithResults(86002,"AVAYA")) return true;

// Search the HTTP response method
http_response = asset.resultsForQid(48118L);
if (http_response.contains("Avaya Media Server")) return true;

// Search the IMAP message
imap = asset.resultsForQid(50010L);
if (imap.contains("CallPilot")) return true;

// Search the SMTP banner
smtp = asset.resultsForQid(74042L);
if (smtp.contains("IP Office Voicemail Pro")) return true;

// Search the SSL cert
if (asset.hasVulnWithResults(86002,"AVAYA") || asset.hasVulnWithResults(86002,"Avaya Inc")) return true;



/* Avigilon */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasVulnWithResults(12230,"It appears that the application isn't quite finished starting up.")) return true;
if (asset.hasVulnWithResults(13910,"Avigilon Corporation")) return true;
if (asset.hasVulnWithResults(13910,"Ic menu available")) return true;
if (asset.hasVulnWithResults(13910,"Avigilon_logo")) return true;
if (asset.hasVulnWithResults(13910,"It appears that the application isn't quite finished starting up.")) return true;

if (asset.hasVulnWithResults(86002,"avigilon.com")) return true;



/* Axway */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page after redirect
default_web_page = asset.resultsForQid(13910L);
if (default_web_page.contains(":/enduser/")) return true;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("support@axway.com")) return true;



/* Barracuda Networks */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasVulnWithResults(86002,"Barracuda Networks")) return true;
if (asset.hasVulnWithResults(13910,"Barracuda Networks, Inc")) return true;
if (asset.hasVulnWithResults(86565,"support@barracuda.com")) return true;



/* BeyondTrust */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasVulnWithResults(48118,"nsbase_session")) return true;
if (asset.hasVulnWithResults(48118,"Set-Cookie: ns_s=")) return true;
if (asset.hasVulnWithResults(12230,"pinned-remotesupport")) return true;
if (asset.hasVulnWithResults(13910,"pinned-remotesupport")) return true;
if (asset.hasVulnWithResults(48118,"pinned-remotesupport")) return true;
if (asset.hasVulnWithResults(86565,"pinned-remotesupport")) return true;
if (asset.hasVulnWithResults(12230,"BeyondTrust Corporation")) return true;
if (asset.hasVulnWithResults(13910,"BeyondTrust Corporation")) return true;
if (asset.hasVulnWithResults(86565,"BeyondTrust Corporation")) return true;
if (asset.hasVulnWithResults(86002,"BeyondTrust")) return true;

if (asset.hasAnyVuln([730326,48134,48277])) return true;



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



/* Cisco (excludes softphones) */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasAnyVuln([45306])) return false;
if (asset.hasVulnWithResults(12230,"Redundant high-end Cisco Systems perimeter firewalls")) return false;
if (asset.hasVulnWithResults(12230,"Cisco Unified IP Phone Cisco Communicator")) return false;
if (asset.hasVulnWithResults(86565,"Cisco Unified IP Phone Cisco Communicator")) return false;
if (asset.hasVulnWithResults(45331,"Cisco Unified IP Phone Cisco Communicator")) return false;

if (asset.hasVulnWithResults(86565,"/CGI/Java/Serviceability?adapter=device.statistics.device") || asset.hasVulnWithResults(86565,"Cisco IP Phone")) return true;
if (asset.hasVulnWithResults(12230,"/CGI/Java/Serviceability?adapter=device.statistics.device") || asset.hasVulnWithResults(12230,"Cisco IP Phone")) return true;

// Search the default web page
if (asset.hasVulnWithResults(12230,"Cisco Connection Online") || asset.hasVulnWithResults(12230,"Cisco Codec:") || asset.hasVulnWithResults(12230,"Server: cisco-IOS") || asset.hasVulnWithResults(12230,"Cisco Systems") || asset.hasVulnWithResults(12230,"url ='/webui';window.location.href=url") || asset.hasVulnWithResults(12230,"icon_styles_ciscologo") || asset.hasVulnWithResults(12230,"and Cisco Systems are registered trademarks or trademarks of Cisco Systems") || asset.hasVulnWithResults(12230,"Cisco Unified Contact Center") || asset.hasVulnWithResults(12230,"ciscologo.gif") || asset.hasVulnWithResults(12230,"governing Cisco cryptographic products") || asset.hasVulnWithResults(12230,"default page when just a URL is entered") || asset.hasVulnWithResults(12230,"level 15 access")) return true;

// Search the default redirected web page
if (asset.hasVulnWithResults(13910,"Cisco Connection Online") || asset.hasVulnWithResults(13910,"Cisco Codec:") || asset.hasVulnWithResults(13910,"Server: cisco-IOS") || asset.hasVulnWithResults(13910,"Cisco Systems") || asset.hasVulnWithResults(13910,"url ='/webui';window.location.href=url") || asset.hasVulnWithResults(13910,"icon_styles_ciscologo") || asset.hasVulnWithResults(13910,"and Cisco Systems are registered trademarks or trademarks of Cisco Systems") || asset.hasVulnWithResults(13910,"Cisco Unified Contact Center") || asset.hasVulnWithResults(13910,"ciscologo.gif") || asset.hasVulnWithResults(13910,"governing Cisco cryptographic products") || asset.hasVulnWithResults(13910,"default page when just a URL is entered") || asset.hasVulnWithResults(13910,"level 15 access")) return true;

// Search the SSH banner
if (asset.hasVulnWithResults(38050,"Cisco")) return true;
if (asset.hasVulnWithResults(38050,"SSH-2.0-OpenSSH_5.5 FIPS")) return true;

// Search the NTP data
if (asset.hasVulnWithResults(38293,"cisco")) return true;

// Search the SSL cert
if (asset.hasVulnWithResults(86002,"Cisco Systems") || asset.hasVulnWithResults(86002,"IOS-Self-Signed-Certificate") || asset.hasVulnWithResults(86002,"C-series CIMC") || asset.hasVulnWithResults(86002,"Cisco Self Signed")) return true;

// Search the SSL web server version
if (asset.hasVulnWithResults(86001,"cisco-IOS")) return true;

// Search the Telnet banner
if (asset.hasVulnWithResults(38007,"Cisco Configuration")) return true;

// Search the SIP information
if (asset.hasVulnWithResults(38438,"Cisco-SIPGateway")) return true;

// Search the SSL cert
if (asset.hasVulnWithResults(86002,"TG SSL CA") || asset.hasVulnWithResults(86002,"/O=Cisco/")) return true;

// Search the SMTP banner
if (asset.hasVulnWithResults(74042,"UnityMailer")) return true;

if (asset.hasVulnWithResults(12230,"url ='/webui';window.location.href=url;")) return true;
if (asset.hasVulnWithResults(13910,"url ='/webui';window.location.href=url;")) return true;
if (asset.hasVulnWithResults(38050,"SSH-2.0-Cisco-1.25")) return true;
if (asset.hasVulnWithResults(86002,"IOS-Self-Signed-Certificate")) return true;
if (asset.hasVulnWithResults(86001,"Cisco HTTP Server")) return true;

if (asset.hasAnyVuln([45635,45634,45633,45632,106203,38211,43001,13605,13811,13488,13662,38673,38667,42395,38250,45172,45566,106173])) return true;



/* Citrix */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasAnyVuln([48183,10030,106202])) return true;

if (asset.hasVulnWithResults(86002,"Citrix")) return true;
if (asset.hasVulnWithResults(12230,"Citrix Login")) return true;
if (asset.hasVulnWithResults(13910,"Citrix Login")) return true;
if (asset.hasVulnWithResults(86002,"Citrix ADM")) return true;
if (asset.hasVulnWithResults(86002,"Citrix ANG")) return true;

if (asset.hasVulnWithResults(12230,"Trailing phrase after here")) return true;
if (asset.hasVulnWithResults(13910,"Trailing phrase after here")) return true;
if (asset.hasVulnWithResults(12230,"/logon/LogonPoint/tmindex.html")) return true;
if (asset.hasVulnWithResults(13910,"/logon/LogonPoint/tmindex.html")) return true;
if (asset.hasVulnWithResults(12230,"/vpn/resources.js")) return true;
if (asset.hasVulnWithResults(13910,"/vpn/resources.js")) return true;
if (asset.hasVulnWithResults(12230,"ns_logo2_color_negative")) return true;
if (asset.hasVulnWithResults(13910,"ns_logo2_color_negative")) return true;
if (asset.hasVulnWithResults(12230,"<span>NetScaler ADC</span>")) return true;
if (asset.hasVulnWithResults(13910,"<span>NetScaler ADC</span>")) return true;
if (asset.hasVulnWithResults(48118,"NSC_TEMP=xyz")) return true;
if (asset.hasVulnWithResults(48118,"/logon/LogonPoint/tmindex.html")) return true;



/* Continental Access */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasVulnWithResults(12230,"Continental Access")) return true;
if (asset.hasVulnWithResults(12230,"/img/oem/cont/")) return true;
if (asset.hasVulnWithResults(13910,"Continental Access")) return true;
if (asset.hasVulnWithResults(13910,"/img/oem/cont/")) return true;



/* Crestron */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the SSL cert
if (asset.hasVulnWithResults(86002,"Crestron")) return true;

// Search the MAC address
mac = asset.resultsForQid(43007L);
if (mac.contains("CRESTRON ELECTRONICS")) return true;



/* Dell */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasAnyVuln([375659,376132,376023,376022])) return true;

processor_bios = asset.resultsForQid(43567L);
if (processor_bios.contains("Dell Inc")) return true;

model_info = asset.resultsForQid(45304L);
if (model_info.contains("Dell ")) return true;

chassis = asset.resultsForQid(43733L);
if (chassis.contains("Dell Inc")) return true;

if (asset.hasVulnWithResults(43007,"AC:1A:3D:")) return true;



/* Emerson/Liebert/Vertiv */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the Telnet response
telnet = asset.resultsForQid(38007L);
if (telnet.contains("Emerson Network Power") || telnet.contains("RDU-HOST login")) return true;

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
if (default_web_page.contains("F5 Networks Configuration") || default_web_page.contains("F5 Networks, Inc.") || default_web_page.contains("Server: BigIP") || default_web_page.contains("BIGIPAuthCookie") || default_web_page.contains("/tmui/login.jsp")) return true;

// Search the redirected web page
redir_web_page = asset.resultsForQid(13910L);
if (redir_web_page.contains("F5 Networks Configuration") || redir_web_page.contains("F5 Networks, Inc.") || redir_web_page.contains("Server: BigIP") || redir_web_page.contains("BIGIPAuthCookie") || redir_web_page.contains("tmui/login/css/login.css")) return true;

if (asset.hasAnyVuln([42400,38833,730489])) return true;

// Search the web server version
web_server = asset.resultsForQid(86000L);
if (web_server.contains("BigIP")) return true;

// Search the SSL web server version
ssl_web_server = asset.resultsForQid(86001L);
if (ssl_web_server.contains("BigIP")) return true;

// Pipelining
pipelining = asset.resultsForQid(86565L);
if (pipelining.contains("Server: BigIP") || pipelining.contains("/tmui/login.jsp") || pipelining.contains("Location: /tmui/login.jsp")) return true;

// HTTP response method
http_response = asset.resultsForQid(48118L);
if (http_response.contains("Server: BigIP") || http_response.contains("/tmui/login.jsp") || http_response.contains("Location: /tmui/login.jsp")) return true;

if (asset.hasAllPortsOpen([4353,22,161,443])) return true;



/* Forcepoint */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("Forcepoint") || default_web_page.contains("Websense")) return true;

if (asset.hasVulnWithResults(86002,"Forcepoint")) return true;
if (asset.hasVulnWithResults(86002,"Websense")) return true;



/* Fortinet */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasVulnWithResults(86002,"Fortinet")) return true;

if (asset.hasAnyVuln([106199])) return true;

if (asset.hasVulnWithResults(12230,"Warning: this page requires Javascript. To correctly view, please enable it in your browser.")) return true;
if (asset.hasVulnWithResults(13910,"Warning: this page requires Javascript. To correctly view, please enable it in your browser.")) return true;



/* Gemalto */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasVulnWithResults(86002,"Gemalto")) return true;



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

if (asset.hasVulnWithResults(86002,"Honeywell")) return true;



/* HP */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Model information
model = asset.resultsForQid(45304L);
if (model.contains("HP ") || model.contains("EliteDesk") || model.contains("EliteBook") || model.contains("ProLiant") || model.contains("Compaq")) return true;

// Default web page
default_webpage = asset.resultsForQid(12230L);
if (default_webpage.contains("HPE Virtual Connect") || default_webpage.contains("HP Virtual Connect") || default_webpage.contains("Hewlett Packard") || default_webpage.contains("Hewlett-Packard")) return true;

// Redirected web page
redirected_webpage = asset.resultsForQid(13910L);
if (redirected_webpage.contains("HPE Virtual Connect") || redirected_webpage.contains("HP Virtual Connect") || redirected_webpage.contains("Hewlett Packard") || redirected_webpage.contains("Hewlett-Packard") || redirected_webpage.contains("login.ssi")) return true;

// SSL Certificate
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("Hewlett Packard") || ssl_cert.contains("Hewlett-Packard") || ssl_cert.contains("Virtual Connect Manager")) return true;

// Search the SSL cert
if (asset.hasVulnWithResults(86002,"Hewlett-Packard")) return true;
if (asset.hasVulnWithResults(86002,"HP Inc.")) return true;

if (asset.hasVulnWithResults(78000,"HP VC FlexFabric")) return true;



/* IBM/Lenovo */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the Telnet banner
telnet_banner = asset.resultsForQid(38007L);
if (telnet_banner.contains("Welcome to the server management network terminal!")) return true;

if (asset.hasAnyVuln([11682,12706])) return true;



/* IDEMIA */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("<title>IDEMIA</title>") || default_web_page.contains("MA5G_general_configurations")) return true;

if (asset.hasVulnWithResults(86002,"MORPHOACCESS")) return true;
if (asset.hasVulnWithResults(86002,"IDEMIA")) return true;



/* Ixia BreakingPoint */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasVulnWithResults(86002,"bpointsys")) return true;



/* Johnson Controls */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasVulnWithResults(86002,"jci.com")) return true;



/* Juniper Networks */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasAnyVuln([45603,106184,106178,106176,106179,106181,106183,106174,106182,106175,106180,106177])) return true;

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



/* Lantronix */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasAnyVuln([48041])) return true;

// Search the default web page
if (asset.hasVulnWithResults(12230,"ltx_conf")) return true;

// General information about this host
if (asset.hasVulnWithResults(78000,"Lantronix")) return true;
if (asset.hasVulnWithResults(78000,"V6.1.0.1") && asset.hasVulnWithResults(78000,"060120")) return true;
if (asset.hasVulnWithResults(78000,"V6.10.0.3") && asset.hasVulnWithResults(78000,"171229")) return true;



/* Lenel */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasVulnWithResults(86002,"O=Lenel")) return true;



/* Meraki */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("Meraki") || default_web_page.contains("meraki")) return true;

// Search the SNMP information
snmp = asset.resultsForQid(78000L);
if (snmp.contains("Meraki")) return true;



/* Mitel */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasVulnWithResults(74042,"Mitel5000")) return true;
if (asset.hasVulnWithResults(86002,"Mitel Networks Corporation")) return true;
if (asset.hasVulnWithResults(86002,"www.mitel.com")) return true;
if (asset.hasVulnWithResults(12230,"MiVoice Office")) return true;
if (asset.hasVulnWithResults(13910,"MiVoice Office")) return true;
if (asset.hasVulnWithResults(48144,"Mitel")) return true;



/* NEC */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("NEC Corporation")) return true;



/* NetApp */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasVulnWithResults(12230,"data-netapp-id")) return true;
if (asset.hasVulnWithResults(13910,"data-netapp-id")) return true;
if (asset.hasVulnWithResults(12230,"X-Powered-By: NetApp Application Server")) return true;
if (asset.hasVulnWithResults(13910,"X-Powered-By: NetApp Application Server")) return true;
if (asset.hasVulnWithResults(12230,"Server: NetApp")) return true;
if (asset.hasVulnWithResults(13910,"Server: NetApp")) return true;
if (asset.hasVulnWithResults(38293,"Data ONTAP")) return true;
if (asset.hasVulnWithResults(12230,"/sysmgr/v4/")) return true;
if (asset.hasVulnWithResults(13910,"/sysmgr/v4/")) return true;
if (asset.hasVulnWithResults(48118,"/sysmgr/v4/")) return true;
if (asset.hasVulnWithResults(12230,"/sysmgr/SysMgr.html")) return true;
if (asset.hasVulnWithResults(13910,"/sysmgr/SysMgr.html")) return true;
if (asset.hasVulnWithResults(48118,"/sysmgr/SysMgr.html")) return true;
if (asset.hasVulnWithResults(48118,"UnifiedManager")) return true;
if (asset.hasVulnWithResults(38660,".com.netapp:")) return true;
if (asset.hasVulnWithResults(86002,"UnifiedManager")) return true;
if (asset.hasVulnWithResults(86002,"NetApp Data Broker")) return true;
if (asset.hasVulnWithResults(86002,"NetApp TLV")) return true;

if (asset.hasAnyVuln([62044,11956,38762,38758,38749,38753])) return true;



/* Netgear */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasAnyVuln([45481])) return true;

if (asset.hasVulnWithResults(12230,"Netgear Page Title")) return true;
if (asset.hasVulnWithResults(13910,"Netgear Page Title")) return true;



/* Opengear */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("Opengear.com")) return true;



/* Oracle */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasTag("Device: Oracle Enterprise Session Border Controller")) return true;

// Search the default web page
if (asset.hasVulnWithResults(12230,"Oracle ESBC")) return true;

// Search the redirected web page
if (asset.hasVulnWithResults(13910,"Oracle ESBC")) return true;

// Search nginx vuln info
if (asset.hasVulnWithResults(730096,"Oracle ESBC")) return true;



/* Palo Alto Networks */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasAnyVuln([45602,48198])) return true;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("Location: /php/login.php")) return true;

// Search the redirected default web page
redirected_web_page = asset.resultsForQid(13910L);
if (redirected_web_page.contains("Creating administrative session. Please wait") || redirected_web_page.contains("logo-pan-") || redirected_web_page.contains("PAN_FORM_CONTENT")) return true;

if (asset.hasVulnWithResults(86002,"Palo Alto Networks")) return true;
if (asset.hasVulnWithResults(86002,"paloaltonetworks")) return true;



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



/* Samsung */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Telnet banner
telnet = asset.resultsForQid(38007L);
if (telnet.contains("SAMSUNG ELECTRONICS")) return true;

if (asset.hasVulnWithResults(86002,"SmartViewSDK")) return true;
if (asset.hasVulnWithResults(12230,"/home/monitoring.cgi")) return true;
if (asset.hasVulnWithResults(13910,"/home/monitoring.cgi")) return true;
if (asset.hasVulnWithResults(12230,"/wmf/index.html")) return true;
if (asset.hasVulnWithResults(13910,"/wmf/index.html")) return true;



/* Schneider Electric / APC */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the SSL cert
if (asset.hasVulnWithResults(86002,"Schneider Electric") || asset.hasVulnWithResults(86002,"WebStation is using modern browser features for better performance and a better user experience")) return true;

if (asset.hasVulnWithResults(43007,"AMERICAN POWER CONVERSION")) return true;
if (asset.hasVulnWithResults(43007,"00:C0:B7:")) return true;
if (asset.hasVulnWithResults(78000,"APC Web/SNMP")) return true;
if (asset.hasVulnWithResults(78000,"apc_hw")) return true;

if (asset.hasVulnWithResults(86002,"American Power Conversion")) return true;



/* Silex */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasVulnWithResults(27113,"Welcome to SX-3000GB")) return true;
if (asset.hasVulnWithResults(38007,"SX010203 login")) return true;



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

if (asset.hasVulnWithResults(13910,"splunk-phantom-logo")) return true;
if ((asset.hasVulnWithResults(13910,"/en-US/") && asset.hasVulnWithResults(13910,"The resource has moved temporarily"))) return true;
if (asset.hasVulnWithResults(48118,"Splunkd")) return true;
if (asset.hasVulnWithResults(86002,"Splunk")) return true;
if (asset.hasVulnWithResults(86002,"splunkcloud")) return true;


/* Super Micro */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasVulnWithResults(86002,"Super Micro Computer")) return true;
if (asset.hasVulnWithResults(38169,"Super Micro Computer")) return true;
if (asset.hasVulnWithResults(38685,"Super Micro Computer")) return true;
if (asset.hasVulnWithResults(38170,"Super Micro Computer")) return true;
if (asset.hasVulnWithResults(38172,"Super Micro Computer")) return true;
if (asset.hasVulnWithResults(38173,"Super Micro Computer")) return true;
if (asset.hasVulnWithResults(38600,"Super Micro Computer")) return true;
if (asset.hasVulnWithResults(38167,"Super Micro Computer")) return true;
if (asset.hasVulnWithResults(86002,"Super_Micro_Computer")) return true;
if (asset.hasVulnWithResults(38169,"Super_Micro_Computer")) return true;
if (asset.hasVulnWithResults(38685,"Super_Micro_Computer")) return true;
if (asset.hasVulnWithResults(38170,"Super_Micro_Computer")) return true;
if (asset.hasVulnWithResults(38172,"Super_Micro_Computer")) return true;
if (asset.hasVulnWithResults(38173,"Super_Micro_Computer")) return true;
if (asset.hasVulnWithResults(38600,"Super_Micro_Computer")) return true;
if (asset.hasVulnWithResults(38167,"Super_Micro_Computer")) return true;



/* Trend Micro */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasVulnWithResults(86002,"Trend Micro")) return true;



/* Valcom */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasVulnWithResults(38443,"Valcom")) return true;
if (asset.hasVulnWithResults(38438,"Valcom")) return true;
if (asset.hasVulnWithResults(38435,"Valcom")) return true;



/* VMware */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasAnyVuln([216079,730034,730355,106100])) return true;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains(":443/websso/") || default_web_page.contains("vRealize Operations") || default_web_page.contains(":5480") || default_web_page.contains("vsphere-client") || default_web_page.contains("ID_BrowseVCDatacenters") || default_web_page.contains("ID_VC_Welcome")) return true;

// Search the redirected default web page
redir_web_page = asset.resultsForQid(13910L);
if (redir_web_page.contains(":443/websso/") || redir_web_page.contains("vRealize Operations") || redir_web_page.contains(":5480") || redir_web_page.contains("vsphere-client") || redir_web_page.contains("ID_BrowseVCDatacenters") || redir_web_page.contains("ID_VC_Welcome")) return true;

// Search the LDAP info
ldap = asset.resultsForQid(45106L);
if (ldap.contains("dc=vsphere,dc=local")) return true;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("domainComponent vsphere") || ssl_cert.contains("vCenterServer") || ssl_cert.contains("VMware")) return true;

if (asset.hasVulnWithResults(86565,"/configure/app/landing/index.html")) return true;
if (asset.hasVulnWithResults(86383,"N7Vmacore4Http20NamedPipeServiceSpecE")) return true;
