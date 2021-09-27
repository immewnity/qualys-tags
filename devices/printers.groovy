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
if (default_web_page.contains("CANON HTTP Server") || default_web_page.contains("canonlogo") || default_web_page.contains("canonlogo") || default_web_page.contains("Copyright CANON") || default_web_page.contains("user can log in without")) return true;

// Search the redirected web page
default_web_page = asset.resultsForQid(13910L);
if (default_web_page.contains("CANON HTTP Server") || default_web_page.contains("canonlogo") || default_web_page.contains("canonlogo") || default_web_page.contains("Copyright CANON") || default_web_page.contains("user can log in without")) return true;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("Canon iR-ADV") || ssl_cert.contains("Canon Imaging Product") || ssl_cert.contains("CANON ELECTRONICS")) return true;

// SNMP response
snmp = asset.resultsForQid(78000L);
if (snmp.contains("Canon ")) return true;

// Search FTP response
ftp_response = asset.resultsForQid(27113L);
if (ftp_response.contains("Canon") && ftp_response.contains("Print")) return true;



/* Dell printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// SNMP response
snmp = asset.resultsForQid(78000L);
if (snmp.contains("Dell") && snmp.contains("Laser")) return true;

// FTP response
ftp = asset.resultsForQid(27113L);
if (ftp.contains("Dell") && ftp.contains("Laser")) return true;

// web response
default_web = asset.resultsForQid(12230L);
if (default_web.contains("Dell") && default_web.contains("/printer/status") && default_web.contains("style_new")) return true;



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



/* HP printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasAnyVuln([45146,45145,78018,12275])) return true;

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
if (ssl_cert.contains("Jetdirect") || ssl_cert.contains("LaserJet")) return true;

// Search SNMP info
snmp = asset.resultsForQid(78000L);
if (snmp.contains("HP ETHERNET MULTI-ENVIRONMENT")) return true;

// Directories exist
directories_exist = asset.resultsForQid(86672L);
if (directories_exist.contains("/hp/device/") && !(directories_exist.contains("/invisionboard/") || directories_exist.contains("phpmynewsletter") || directories_exist.contains("postnuke") || directories_exist.contains("phpnuke") || directories_exist.contains("phpShare") || directories_exist.contains("mediawiki") || directories_exist.contains("zencart") || directories_exist.contains("WebCalendar") || directories_exist.contains("zeroboard") || directories_exist.contains("phpmyadmin") || directories_exist.contains("awstats") || directories_exist.contains("yapig") || directories_exist.contains("tomatocart") || directories_exist.contains("seopanel") || directories_exist.contains("zpanel") || directories_exist.contains("phpwebthings") || directories_exist.contains("jscripts") || directories_exist.contains("drupal") || directories_exist.contains("coregui") || directories_exist.contains("owa/auth"))) return true;

if (asset.getOperatingSystem()=="HP JetDirect") return true;

// Search OS detected
os_detection = asset.resultsForQid(45017L);
if (os_detection.contains("HP JetDirect")) return true;



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



/* Kyocera printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// SNMP response
snmp = asset.resultsForQid(78000L);
if (snmp.contains("KYOCERA Document Solutions Printing System")) return true;

// Search FTP response
ftp_response = asset.resultsForQid(27113L);
if (ftp_response.contains("TASKalfa")) return true;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("/startwlm/Start_Wlm.htm") || default_web_page.contains("KYOCERA MITA Corporation")) return true;



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

if (asset.hasAnyVuln([43505])) return true;



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

// Search FTP response
ftp_response = asset.resultsForQid(27113L);
if (ftp_response.contains("RICOH ") || ftp_response.contains("LANIER ") || ftp_response.contains("SAVIN ")) return true;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("/web/guest/en/websys/webArch/mainFrame.cgi") || default_web_page.contains("URL=wt2parser.cgi?home_en") || default_web_page.contains("Web Image Monitor") || default_web_page.contains("/en/top_head.cgi")) return true;

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



/* Sharp printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("browser of frame dealing") || default_web_page.contains("Can't read file /default-web")) return true;

// Search FTP response
ftp_response = asset.resultsForQid(27113L);
if (ftp_response.contains("SHARP MX") || ftp_response.contains("SHARP AR")) return true;

// Search SNMP response
snmp_response = asset.resultsForQid(78000L);
if (snmp_response.contains("SHARP MX") || snmp_response.contains("SHARP AR")) return true;

// Search Telnet response
telnet = asset.resultsForQid(38007L);
if (telnet.contains("SHARP MX") || telnet.contains("SHARP AR")) return true;

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
if (ftp_response.contains("XEROX") || ftp_response.contains("Xerox")) return true;

// SNMP response
snmp = asset.resultsForQid(78000L);
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
