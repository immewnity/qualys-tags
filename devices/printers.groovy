/*
 * Groovy scripts for use in Qualys tags
 * 
 * Printers, including MFPs, receipt printers, etc.
 * 
 * Disclaimer: Scripts are not guaranteed to be perfect - false positive and false negative results are possible. Pull requests to improve the scripts are welcomed.
 * 
 * (c) Matthew Verive
 * Licensed under the MIT License
 */



/* Brother printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("/general/status.html") && default_web_page.contains("debut")) return true;

// Search the redirected web page
default_web_page = asset.resultsForQid(13910L);
if (default_web_page.contains("solutions.brother.com") || default_web_page.contains("Brother MFC") || default_web_page.contains("possibleprintnum")) return true;

// SNMP response
snmp = asset.resultsForQid(78000L);
if (snmp.contains("Brother ")) return true;



/* Canon printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("CANON HTTP Server") || default_web_page.contains("canonlogo") || default_web_page.contains("Copyright CANON") || default_web_page.contains("user can log in without") || default_web_page.contains(":8000/rps/")) return true;

// Search the redirected web page
default_web_page = asset.resultsForQid(13910L);
if (default_web_page.contains("CANON HTTP Server") || default_web_page.contains("canonlogo") || default_web_page.contains("Copyright CANON") || default_web_page.contains("user can log in without") || default_web_page.contains(":8000/rps/")) return true;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("Canon iR-ADV") || ssl_cert.contains("Canon Imaging Product") || ssl_cert.contains("CANON ELECTRONICS")) return true;

// SNMP response
snmp = asset.resultsForQid(78000L);
if (snmp.contains("Canon ")) return true;

// Search FTP response
ftp_response = asset.resultsForQid(27113L);
if (ftp_response.contains("Canon") && ftp_response.contains("Print")) return true;

// Search the web server version
web_server = asset.resultsForQid(86000L);
if (web_server.contains("CANON HTTP Server")) return true;



/* Dell printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// SNMP response
snmp = asset.resultsForQid(78000L);
if (snmp.contains("Xerox")) return false;
if (snmp.contains("Dell") && snmp.contains("Laser")) return true;

// FTP response
ftp = asset.resultsForQid(27113L);
if (ftp.contains("Xerox")) return false;
if (ftp.contains("Dell") && ftp.contains("Laser")) return true;

// Web server
web_server = asset.resultsForQid(86000L);
if (web_server.contains("EWS-NIC5")) return true;

// web response
default_web = asset.resultsForQid(12230L);
if (default_web.contains("Dell") && default_web.contains("/printer/status") && default_web.contains("style_new")) return true;

// redirected web response
web_redirect = asset.resultsForQid(13910L);
if (web_redirect.contains("Dell") && web_redirect.contains("Laser") && web_redirect.contains("framelogo") && web_redirect.contains("TopLogo")) return true;



/* DYMO printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the SNMP data
snmp = asset.resultsForQid(78000L);
if (snmp.contains("LabelWriter")) return true;

// Default web page
default_page = asset.resultsForQid(12230L);
if (default_page.contains("DYMO LabelWriter Print Server")) return true;

// HTTP auth detection
http_auth = asset.resultsForQid(86728L);
if (http_auth.contains("DYMO LabelWriter Print Server")) return true;



/* EFI/Fiery printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("wt2parser.cgi")) return true;

// Search the redirected web page
redir_web_page = asset.resultsForQid(13910L);
if (redir_web_page.contains("wt2parser.cgi")) return true;

// Search the FTP response
ftp = asset.resultsForQid(27113L);
if (ftp.contains("220 EFI FTP Print")) return true;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("EFI") && ssl_cert.contains("Fiery")) return true;



/* Epson printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("SEIKO EPSON") || default_web_page.contains("EpsonNet") || default_web_page.contains("EPSON-HTTP")) return true;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("SEIKO EPSON")) return true;

// SNMP response
snmp = asset.resultsForQid(78000L);
if (snmp.contains("EPSON") && (snmp.contains("Printer") || snmp.contains("Print Server"))) return true;

// Web server version
web_server = asset.resultsForQid(86000L);
if (web_server.contains("Epson UPnP SDK")) return true;



/* HID printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the SNMP data
snmp = asset.resultsForQid(78000L);
if (snmp.contains("www.hidglobal.com") || snmp.contains("HDP5000")) return true;



/* HP printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasAnyVuln([45146,78018,12275])) return true;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("/hp/device/DeviceStatus") || default_web_page.contains("setupSectionDiv") || default_web_page.contains("Actual cartridge life remaining may vary.") || default_web_page.contains("and its HP Jetdirect print server") || default_web_page.contains("/help/engl/ewshelp.htm") || default_web_page.contains("Generic image of a printer") || default_web_page.contains("/SSI/supply_status.htm") || default_web_page.contains("/hp/device/SignIn/Index") || default_web_page.contains("InternalPages_Index_SuppliesStatus") || default_web_page.contains("HP LaserJet M605") || default_web_page.contains("info_deviceStatus") || default_web_page.contains("titleColonSemicolonSeparatedCssList") || default_web_page.contains("hpGasGaugeBorder")) return true;

// Search the redirected web page
redirected_web_page = asset.resultsForQid(13910L);
if (redirected_web_page.contains("/hp/device/DeviceStatus") || redirected_web_page.contains("setupSectionDiv") || redirected_web_page.contains("Actual cartridge life remaining may vary.") || redirected_web_page.contains("and its HP Jetdirect print server") || redirected_web_page.contains("/help/engl/ewshelp.htm") || redirected_web_page.contains("Generic image of a printer") || redirected_web_page.contains("/SSI/supply_status.htm") || redirected_web_page.contains("/hp/device/SignIn/Index") || redirected_web_page.contains("InternalPages_Index_SuppliesStatus") || redirected_web_page.contains("HP LaserJet M605") || redirected_web_page.contains("info_deviceStatus") || redirected_web_page.contains("titleColonSemicolonSeparatedCssList") || redirected_web_page.contains("hpGasGaugeBorder")) return true;

// Search FTP directory listing
ftp_listing = asset.resultsForQid(27367L);
if (ftp_listing.contains("JetDirect")) return true;

// Search FTP response
ftp_response = asset.resultsForQid(27113L);
if (ftp_response.contains("220 JD FTP Server Ready")) return true;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("Jetdirect") || ssl_cert.contains("LaserJet") || ssl_cert.contains("HP-IPG")) return true;

// Search SNMP info
snmp = asset.resultsForQid(78000L);
if (snmp.contains("HP ETHERNET MULTI-ENVIRONMENT") || snmp.contains("JETDIRECT")) return true;

// Search HP info
hp_info = asset.resultsForQid(45145L);
if (hp_info.contains("HP ETHERNET MULTI-ENVIRONMENT") || hp_info.contains("JETDIRECT") || (hp_info.contains("Make") && (hp_info.contains("Model") || hp_info.contains("Firmware") || hp_info.contains("Serial")))) return true;

// Directories exist
directories_exist = asset.resultsForQid(86672L);
if (directories_exist.contains("/hp/device/") && !(directories_exist.contains("/invisionboard/") || directories_exist.contains("phpmynewsletter") || directories_exist.contains("postnuke") || directories_exist.contains("phpnuke") || directories_exist.contains("phpShare") || directories_exist.contains("mediawiki") || directories_exist.contains("zencart") || directories_exist.contains("WebCalendar") || directories_exist.contains("zeroboard") || directories_exist.contains("phpmyadmin") || directories_exist.contains("awstats") || directories_exist.contains("yapig") || directories_exist.contains("tomatocart") || directories_exist.contains("seopanel") || directories_exist.contains("zpanel") || directories_exist.contains("phpwebthings") || directories_exist.contains("jscripts") || directories_exist.contains("drupal") || directories_exist.contains("coregui") || directories_exist.contains("owa/auth"))) return true;

if (asset.getOperatingSystem()=="HP JetDirect") return true;

// Search OS detected
os_detection = asset.resultsForQid(45017L);
if (os_detection.contains("HP JetDirect")) return true;

// Search web server
web_server = asset.resultsForQid(86000L);
if (web_server.contains("Designjet")) return true;

// Search response method
resp_method = asset.resultsForQid(48118L);
if (resp_method.contains("Designjet")) return true;



/* Konica Minolta printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the Telnet response
telnet = asset.resultsForQid(38007L);
if (telnet.contains("KONICA MINOLTA")) return true;

// Search FTP response
ftp_response = asset.resultsForQid(27113L);
if (ftp_response.contains("KONICA MINOLTA")) return true;

// Web server version
web_server = asset.resultsForQid(86000L);
if (web_server.contains("Konica Minolta Printer")) return true;

// SNMP response
snmp = asset.resultsForQid(78000L);
if (snmp.contains("KONICA MINOLTA bizhub")) return true;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("URL=/wcd/js_error.xml") || default_web_page.contains("/wcd/index.html")) return true;

// MAC address
mac_address = asset.resultsForQid(43007L);
if (mac_address.contains("MINOLTA")) return true;

// Web server pipelining
pipelining = asset.resultsForQid(86565L);
if (pipelining.contains("/wcd/js_error.xml") || pipelining.contains("/wcd/index.html")) return true;

// SSL certificate
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("KONICA MINOLTA bizhub") || ssl_cert.contains("KONICA_MINOLTA_bizhub")) return true;



/* Kyocera printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// SNMP response
snmp = asset.resultsForQid(78000L);
if (snmp.contains("KYOCERA Document Solutions Printing System") || snmp.contains("KYOCERA Printer") || snmp.contains("IB-21E")) return true;

// Search FTP response
ftp_response = asset.resultsForQid(27113L);
if (ftp_response.contains("TASKalfa") || ftp_response.contains("IB-21E") || ftp_response.contains("NS-30 Ver")) return true;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("/startwlm/Start_Wlm.htm") || default_web_page.contains("KYOCERA MITA Corporation") || (default_web_page.contains("NS-30") && default_web_page.contains("NetworkScanner"))) return true;

// Search NetBIOS info
netbios = asset.resultsForQid(70004L);
if (netbios.contains("NetPrinters")) return true;



/* Lexmark printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("/cgi-bin/dynamic/topbar.html") || default_web_page.contains("is not a single variable so it is a function")) return true;

// Search FTP response
ftp_response = asset.resultsForQid(27113L);
if (ftp_response.contains("Lexmark")) return true;

// Search SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("organizationalUnitName PS&SD") && ssl_cert.contains("organizationName Lexmark")) return true;

if (asset.hasAnyVuln([43505,38715])) return true;



/* Muratec printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// SNMP response
snmp = asset.resultsForQid(78000L);
if (snmp.contains("Muratec ")) return true;

// MAC address
mac_addr = asset.resultsForQid(43007L);
if (mac_addr.contains("MURATA")) return true;



/* Oce printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the HTTP header
http_header = asset.resultsForQid(48118L);
if (http_header.contains("Oce Express")) return true;

// SNMP response
snmp = asset.resultsForQid(78000L);
if (snmp.contains("Oce, ") || snmp.contains("PlotWave")) return true;



/* OKI printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// SNMP response
snmp = asset.resultsForQid(78000L);
if (snmp.contains("OKI ") || snmp.contains("OkiLAN")) return true;



/* Panasonic printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// SNMP response
snmp = asset.resultsForQid(78000L);
if (snmp.contains("Panasonic UF") || snmp.contains("Panasonic KX") || snmp.contains("Panasonic DP") || snmp.contains("Panasonic KV")) return true;

// Search MAC address
mac_addr = asset.resultsForQid(43007L);
if (mac_addr.contains("MATSUHITA") || mac_addr.contains("MATSUSHITA")) return true;



/* Ricoh/Savin/Lanier printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if ((default_web_page.contains("websys") && default_web_page.contains("webArch")) || default_web_page.contains("wt2parser") || default_web_page.contains("Web Image Monitor") || default_web_page.contains("top_head.cgi")) return true;

// Search the redirected web page
redir_web_page = asset.resultsForQid(13910L);
if ((redir_web_page.contains("websys") && redir_web_page.contains("webArch")) || redir_web_page.contains("wt2parser") || redir_web_page.contains("Web Image Monitor") || redir_web_page.contains("top_head.cgi")) return true;

// Search FTP response
ftp_response = asset.resultsForQid(27113L);
if (ftp_response.contains("RICOH ") || ftp_response.contains("LANIER ") || ftp_response.contains("SAVIN ")) return true;

// SNMP response
snmp = asset.resultsForQid(78000L);
if (snmp.contains("RICOH") || snmp.contains("SAVIN Network Printer") || snmp.contains("LANIER")) return true;

// Search the Telnet response
telnet = asset.resultsForQid(38007L);
if (telnet.contains("Maintenance Shell") && telnet.contains("User access verification")) return true;

// Remote Shell vuln
remote_shell = asset.resultsForQid(38020L);
if (remote_shell.contains("service rsh/rexec and os RICOH PRINTER")) return true;

// MAC address
mac_address = asset.resultsForQid(43007L);
if (mac_address.contains("RICOH COMPANY")) return true;

// Autocomplete
autocomplete = asset.resultsForQid(86729L);
if (autocomplete.contains("/images/RICOH.gif") || autocomplete.contains("Web Image Monitor") || (autocomplete.contains("websys") && autocomplete.contains("webArch"))) return true;



/* Samsung printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("/sws/images/fav.ico")) return true;

// SNMP response
snmp = asset.resultsForQid(78000L);
if (snmp.contains("Samsung M283x")) return true;

// Devices available
devices = asset.resultsForQid(78009L);
if (devices.contains("Samsung M283x") || devices.contains("Samsung Copy Service")) return true;



/* Sharp printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("browser of frame dealing") || default_web_page.contains("Can't read file /default-web")) return true;

// Search FTP response
ftp_response = asset.resultsForQid(27113L);
if (ftp_response.contains("SHARP MX") || ftp_response.contains("SHARP AR") || ftp_response.contains("Sharp DX")) return true;

// Search SNMP response
snmp_response = asset.resultsForQid(78000L);
if (snmp_response.contains("SHARP MX") || snmp_response.contains("SHARP AR") || snmp_response.contains("Sharp DX")) return true;

// Search Telnet response
telnet = asset.resultsForQid(38007L);
if (telnet.contains("SHARP MX") || telnet.contains("SHARP AR") || telnet.contains("Sharp DX")) return true;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if ((ssl_cert.contains("Sharp Corporation") && ssl_cert.contains("Document Systems Group")) || ssl_cert.contains("SHARP MX")) return true;



/* Source Technologies printers */
// Note: We had to add logic into our tag to exclude any Lexmark systems, as some Lexmark printers are rebranded Source printers and were flagging.

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search FTP response
ftp_response = asset.resultsForQid(27113L);
if (ftp_response.contains("Source Technologies")) return true;

// Search SNMP info
snmp = asset.resultsForQid(78000L);
if (snmp.contains("Source Technologies")) return true;

// Search Telnet
telnet = asset.resultsForQid(38007L);
if (telnet.contains("Source Technologies")) return true;



/* Toshiba printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("TopAccess")) return true;

// Search the redirected web page
redir_web_page = asset.resultsForQid(13910L);
if (redir_web_page.contains("TopAccess")) return true;

// Search the SNMP info
snmp = asset.resultsForQid(78000L);
if (snmp.contains("TOSHIBA e-STUDIO")) return true;



/* Xerox printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("Fuji Xerox Co") || default_web_page.contains("XEROX WORKCENTRE") || default_web_page.contains("XEROX ColorQube") || default_web_page.contains("/stat/index.php?tab=status")) return true;

// Search FTP response
ftp_response = asset.resultsForQid(27113L);
if (ftp_response.contains("Dell") && ftp_response.contains("Laser")) return false;
if (ftp_response.contains("XEROX") || ftp_response.contains("Xerox")) return true;

// SNMP response
snmp = asset.resultsForQid(78000L);
if (snmp.contains("Dell") && snmp.contains("Laser")) return false;
if (snmp.contains("Xerox WorkCentre")) return true;

// MAC address
mac_addr = asset.resultsForQid(43007L);
if (mac_addr.contains("FUJI-XEROX") || (snmp.contains("XEROX CORPORATION") && !snmp.contains("00:00:00:00:00:00"))) return true;

if (asset.hasAnyVuln([45147,45149,45148])) return true;



/* Zebra printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("Zebra Technologies") || default_web_page.contains("ZEBRA.COM")) return true;

// Search MAC address
mac = asset.resultsForQid(43007L);
if (mac.contains("Zebra Technologies")) return true;

// SNMP response
snmp = asset.resultsForQid(78000L);
if (snmp.contains("ZebraNet")) return true;

// Telnet
telnet = asset.resultsForQid(38007L);
if (telnet.contains("ZebraNet")) return true;
