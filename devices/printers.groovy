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
if (asset.hasVulnWithResults(12230,"/general/status.html") && asset.hasVulnWithResults(12230,"debut")) return true;

// Search the redirected web page
if (asset.hasVulnWithResults(13910,"solutions.brother.com") || asset.hasVulnWithResults(13910,"Brother MFC") || asset.hasVulnWithResults(13910,"possibleprintnum")) return true;

// SNMP response
if (asset.hasVulnWithResults(78000,"Brother ")) return true;



/* Canon printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
if (asset.hasVulnWithResults(12230,"CANON HTTP Server") || asset.hasVulnWithResults(12230,"canonlogo") || asset.hasVulnWithResults(12230,"Copyright CANON") || asset.hasVulnWithResults(12230,"user can log in without") || asset.hasVulnWithResults(12230,":8000/rps/")) return true;

// Search the redirected web page
if (asset.hasVulnWithResults(13910,"CANON HTTP Server") || asset.hasVulnWithResults(13910,"canonlogo") || asset.hasVulnWithResults(13910,"Copyright CANON") || asset.hasVulnWithResults(13910,"user can log in without") || asset.hasVulnWithResults(13910,":8000/rps/")) return true;

// Search the SSL cert
if (asset.hasVulnWithResults(86002,"Canon iR-ADV") || asset.hasVulnWithResults(86002,"Canon Imaging Product") || asset.hasVulnWithResults(86002,"CANON ELECTRONICS")) return true;

// SNMP response
if (asset.hasVulnWithResults(78000,"Canon ")) return true;

// Search FTP response
if (asset.hasVulnWithResults(27113,"Canon") && asset.hasVulnWithResults(27113,"Print")) return true;

// Search the web server version
if (asset.hasVulnWithResults(86000,"CANON HTTP Server")) return true;



/* Dell printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// SNMP response
if (asset.hasVulnWithResults(78000,"Xerox")) return false;
if (asset.hasVulnWithResults(78000,"Dell") && asset.hasVulnWithResults(78000,"Laser")) return true;

// FTP response
if (asset.hasVulnWithResults(27113,"Xerox")) return false;
if (asset.hasVulnWithResults(27113,"Dell") && asset.hasVulnWithResults(27113,"Laser")) return true;

// Web server
if (asset.hasVulnWithResults(86000,"EWS-NIC5")) return true;

// web response
if (asset.hasVulnWithResults(12230,"Dell") && asset.hasVulnWithResults(12230,"/printer/status") && asset.hasVulnWithResults(12230,"style_new")) return true;

// redirected web response
if (asset.hasVulnWithResults(13910,"Dell") && asset.hasVulnWithResults(13910,"Laser") && asset.hasVulnWithResults(13910,"framelogo") && asset.hasVulnWithResults(13910,"TopLogo")) return true;



/* DYMO printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the SNMP data
if (asset.hasVulnWithResults(78000,"LabelWriter")) return true;

// Default web page
if (asset.hasVulnWithResults(12230,"DYMO LabelWriter Print Server")) return true;

// HTTP auth detection
if (asset.hasVulnWithResults(86728,"DYMO LabelWriter Print Server")) return true;



/* EFI/Fiery printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
if (asset.hasVulnWithResults(12230,"wt2parser.cgi")) return true;

// Search the redirected web page
if (asset.hasVulnWithResults(13910,"wt2parser.cgi")) return true;

// Search the FTP response
if (asset.hasVulnWithResults(27113,"220 EFI FTP Print")) return true;

// Search the SSL cert
if (asset.hasVulnWithResults(86002,"EFI") && asset.hasVulnWithResults(86002,"Fiery")) return true;



/* Epson printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
if (asset.hasVulnWithResults(12230,"SEIKO EPSON") || asset.hasVulnWithResults(12230,"EpsonNet") || asset.hasVulnWithResults(12230,"EPSON-HTTP")) return true;

// Search the SSL cert
if (asset.hasVulnWithResults(86002,"SEIKO EPSON")) return true;

// SNMP response
if (asset.hasVulnWithResults(78000,"EPSON") && (asset.hasVulnWithResults(78000,"Printer") || asset.hasVulnWithResults(78000,"Print Server"))) return true;

// Web server version
if (asset.hasVulnWithResults(86000,"Epson UPnP SDK")) return true;



/* HID printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the SNMP data
if (asset.hasVulnWithResults(78000,"www.hidglobal.com") || asset.hasVulnWithResults(78000,"HDP5000")) return true;



/* HP printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasAnyVuln([45146,78018,12275])) return true;

// Search the default web page
if (asset.hasVulnWithResults(12230,"/hp/device/DeviceStatus") || asset.hasVulnWithResults(12230,"setupSectionDiv") || asset.hasVulnWithResults(12230,"Actual cartridge life remaining may vary.") || asset.hasVulnWithResults(12230,"and its HP Jetdirect print server") || asset.hasVulnWithResults(12230,"/help/engl/ewshelp.htm") || asset.hasVulnWithResults(12230,"Generic image of a printer") || asset.hasVulnWithResults(12230,"/SSI/supply_status.htm") || asset.hasVulnWithResults(12230,"/hp/device/SignIn/Index") || asset.hasVulnWithResults(12230,"InternalPages_Index_SuppliesStatus") || asset.hasVulnWithResults(12230,"HP LaserJet M605") || asset.hasVulnWithResults(12230,"info_deviceStatus") || asset.hasVulnWithResults(12230,"titleColonSemicolonSeparatedCssList") || asset.hasVulnWithResults(12230,"hpGasGaugeBorder")) return true;

// Search the redirected web page
if (asset.hasVulnWithResults(13910,"/hp/device/DeviceStatus") || asset.hasVulnWithResults(13910,"setupSectionDiv") || asset.hasVulnWithResults(13910,"Actual cartridge life remaining may vary.") || asset.hasVulnWithResults(13910,"and its HP Jetdirect print server") || asset.hasVulnWithResults(13910,"/help/engl/ewshelp.htm") || asset.hasVulnWithResults(13910,"Generic image of a printer") || asset.hasVulnWithResults(13910,"/SSI/supply_status.htm") || asset.hasVulnWithResults(13910,"/hp/device/SignIn/Index") || asset.hasVulnWithResults(13910,"InternalPages_Index_SuppliesStatus") || asset.hasVulnWithResults(13910,"HP LaserJet M605") || asset.hasVulnWithResults(13910,"info_deviceStatus") || asset.hasVulnWithResults(13910,"titleColonSemicolonSeparatedCssList") || asset.hasVulnWithResults(13910,"hpGasGaugeBorder")) return true;

// Search FTP directory listing
if (asset.hasVulnWithResults(27367,"JetDirect")) return true;

// Search FTP response
if (asset.hasVulnWithResults(27113,"220 JD FTP Server Ready")) return true;

// Search the SSL cert
if (asset.hasVulnWithResults(86002,"Jetdirect") || asset.hasVulnWithResults(86002,"LaserJet") || asset.hasVulnWithResults(86002,"HP-IPG")) return true;

// Search SNMP info
if (asset.hasVulnWithResults(78000,"HP ETHERNET MULTI-ENVIRONMENT") || asset.hasVulnWithResults(78000,"JETDIRECT")) return true;

// Search HP info
if (asset.hasVulnWithResults(45145,"HP ETHERNET MULTI-ENVIRONMENT") || asset.hasVulnWithResults(45145,"JETDIRECT") || (asset.hasVulnWithResults(45145,"Make") && (asset.hasVulnWithResults(45145,"Model") || asset.hasVulnWithResults(45145,"Firmware") || asset.hasVulnWithResults(45145,"Serial")))) return true;

// Directories exist
if (asset.hasVulnWithResults(86672,"/hp/device/") && !(asset.hasVulnWithResults(86672,"/invisionboard/") || asset.hasVulnWithResults(86672,"phpmynewsletter") || asset.hasVulnWithResults(86672,"postnuke") || asset.hasVulnWithResults(86672,"phpnuke") || asset.hasVulnWithResults(86672,"phpShare") || asset.hasVulnWithResults(86672,"mediawiki") || asset.hasVulnWithResults(86672,"zencart") || asset.hasVulnWithResults(86672,"WebCalendar") || asset.hasVulnWithResults(86672,"zeroboard") || asset.hasVulnWithResults(86672,"phpmyadmin") || asset.hasVulnWithResults(86672,"awstats") || asset.hasVulnWithResults(86672,"yapig") || asset.hasVulnWithResults(86672,"tomatocart") || asset.hasVulnWithResults(86672,"seopanel") || asset.hasVulnWithResults(86672,"zpanel") || asset.hasVulnWithResults(86672,"phpwebthings") || asset.hasVulnWithResults(86672,"jscripts") || asset.hasVulnWithResults(86672,"drupal") || asset.hasVulnWithResults(86672,"coregui") || asset.hasVulnWithResults(86672,"owa/auth"))) return true;

// Search web server
if (asset.hasVulnWithResults(86000,"Designjet")) return true;

// Search response method
if (asset.hasVulnWithResults(48118,"Designjet")) return true;



/* Konica Minolta printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the Telnet response
if (asset.hasVulnWithResults(38007,"KONICA MINOLTA")) return true;

// Search FTP response
if (asset.hasVulnWithResults(27113,"KONICA MINOLTA")) return true;

// Web server version
if (asset.hasVulnWithResults(86000,"Konica Minolta Printer")) return true;

// SNMP response
if (asset.hasVulnWithResults(78000,"KONICA MINOLTA bizhub")) return true;

// Search the default web page
if (asset.hasVulnWithResults(12230,"URL=/wcd/js_error.xml") || asset.hasVulnWithResults(12230,"/wcd/index.html")) return true;

// MAC address
if (asset.hasVulnWithResults(43007,"MINOLTA")) return true;

// Web server pipelining
if (asset.hasVulnWithResults(86565,"/wcd/js_error.xml") || asset.hasVulnWithResults(86565,"/wcd/index.html")) return true;

// SSL certificate
if (asset.hasVulnWithResults(86002,"KONICA MINOLTA bizhub") || asset.hasVulnWithResults(86002,"KONICA_MINOLTA_bizhub")) return true;



/* Kyocera printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// SNMP response
if (asset.hasVulnWithResults(78000,"KYOCERA Document Solutions Printing System") || asset.hasVulnWithResults(78000,"KYOCERA Printer") || asset.hasVulnWithResults(78000,"IB-21E")) return true;

// Search FTP response
if (asset.hasVulnWithResults(27113,"TASKalfa") || asset.hasVulnWithResults(27113,"IB-21E") || asset.hasVulnWithResults(27113,"NS-30 Ver")) return true;

// Search the default web page
if (asset.hasVulnWithResults(12230,"/startwlm/Start_Wlm.htm") || asset.hasVulnWithResults(12230,"KYOCERA MITA Corporation") || (asset.hasVulnWithResults(12230,"NS-30") && asset.hasVulnWithResults(12230,"NetworkScanner"))) return true;

// Search NetBIOS info
if (asset.hasVulnWithResults(70004,"NetPrinters")) return true;



/* Lexmark printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
if (asset.hasVulnWithResults(12230,"/cgi-bin/dynamic/topbar.html") || asset.hasVulnWithResults(12230,"is not a single variable so it is a function")) return true;

// Search FTP response
if (asset.hasVulnWithResults(27113,"Lexmark")) return true;

// Search SSL cert
if (asset.hasVulnWithResults(86002,"organizationalUnitName PS&SD") && asset.hasVulnWithResults(86002,"organizationName Lexmark")) return true;

if (asset.hasAnyVuln([43505,38715])) return true;



/* Muratec printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// SNMP response
if (asset.hasVulnWithResults(78000,"Muratec ")) return true;

// MAC address
if (asset.hasVulnWithResults(43007,"MURATA")) return true;



/* Oce printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the HTTP header
if (asset.hasVulnWithResults(48118,"Oce Express")) return true;

// SNMP response
if (asset.hasVulnWithResults(78000,"Oce, ") || asset.hasVulnWithResults(78000,"PlotWave")) return true;



/* OKI printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// SNMP response
if (asset.hasVulnWithResults(78000,"OKI ") || asset.hasVulnWithResults(78000,"OkiLAN")) return true;



/* Panasonic printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// SNMP response
if (asset.hasVulnWithResults(78000,"Panasonic UF") || asset.hasVulnWithResults(78000,"Panasonic KX") || asset.hasVulnWithResults(78000,"Panasonic DP") || asset.hasVulnWithResults(78000,"Panasonic KV")) return true;

// Search MAC address
if (asset.hasVulnWithResults(43007,"MATSUHITA") || asset.hasVulnWithResults(43007,"MATSUSHITA")) return true;



/* Ricoh/Savin/Lanier printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
if ((asset.hasVulnWithResults(12230,"websys") && asset.hasVulnWithResults(12230,"webArch")) || asset.hasVulnWithResults(12230,"wt2parser") || asset.hasVulnWithResults(12230,"Web Image Monitor") || asset.hasVulnWithResults(12230,"top_head.cgi") || asset.hasVulnWithResults(12230,"Knopflerfish")) return true;

// Search the redirected web page
if ((asset.hasVulnWithResults(13910,"websys") && asset.hasVulnWithResults(13910,"webArch")) || asset.hasVulnWithResults(13910,"wt2parser") || asset.hasVulnWithResults(13910,"Web Image Monitor") || asset.hasVulnWithResults(13910,"top_head.cgi") || asset.hasVulnWithResults(13910,"Knopflerfish")) return true;

// Search FTP response
if (asset.hasVulnWithResults(27113,"RICOH ") || asset.hasVulnWithResults(27113,"LANIER ") || asset.hasVulnWithResults(27113,"SAVIN ")) return true;

// SNMP response
if (asset.hasVulnWithResults(78000,"RICOH") || asset.hasVulnWithResults(78000,"SAVIN Network Printer") || asset.hasVulnWithResults(78000,"LANIER")) return true;

// Search the Telnet response
if (asset.hasVulnWithResults(38007,"Maintenance Shell") && asset.hasVulnWithResults(38007,"User access verification")) return true;

// Remote Shell vuln
if (asset.hasVulnWithResults(38020,"service rsh/rexec and os RICOH PRINTER")) return true;

// MAC address
if (asset.hasVulnWithResults(43007,"RICOH COMPANY")) return true;

// Autocomplete
if (asset.hasVulnWithResults(36729,"/images/RICOH.gif") || asset.hasVulnWithResults(36729,"Web Image Monitor") || (asset.hasVulnWithResults(36729,"websys") && asset.hasVulnWithResults(36729,"webArch"))) return true;



/* Samsung printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
if (asset.hasVulnWithResults(12230,"/sws/images/fav.ico")) return true;

// SNMP response
if (asset.hasVulnWithResults(78000,"Samsung M283x")) return true;

// Devices available
if (asset.hasVulnWithResults(78009,"Samsung M283x") || asset.hasVulnWithResults(78009,"Samsung Copy Service")) return true;



/* Sharp printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
if (asset.hasVulnWithResults(12230,"browser of frame dealing") || asset.hasVulnWithResults(12230,"Can't read file /default-web")) return true;

// Search FTP response
if (asset.hasVulnWithResults(27113,"SHARP MX") || asset.hasVulnWithResults(27113,"SHARP AR") || asset.hasVulnWithResults(27113,"Sharp DX")) return true;

// Search SNMP response
if (asset.hasVulnWithResults(78000,"SHARP MX") || asset.hasVulnWithResults(78000,"SHARP AR") || asset.hasVulnWithResults(78000,"Sharp DX")) return true;

// Search Telnet response
if (asset.hasVulnWithResults(38007,"SHARP MX") || asset.hasVulnWithResults(38007,"SHARP AR") || asset.hasVulnWithResults(38007,"Sharp DX")) return true;

// Search the SSL cert
if ((asset.hasVulnWithResults(86002,"Sharp Corporation") && asset.hasVulnWithResults(86002,"Document Systems Group")) || asset.hasVulnWithResults(86002,"SHARP MX")) return true;



/* Source Technologies printers */
// Note: We had to add logic into our tag to exclude any Lexmark systems, as some Lexmark printers are rebranded Source printers and were flagging.

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search FTP response
if (asset.hasVulnWithResults(27113,"Source Technologies")) return true;

// Search SNMP info
if (asset.hasVulnWithResults(78000,"Source Technologies")) return true;

// Search Telnet
if (asset.hasVulnWithResults(38007,"Source Technologies")) return true;



/* Toshiba printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
if (asset.hasVulnWithResults(12230,"TopAccess")) return true;

// Search the redirected web page
if (asset.hasVulnWithResults(13910,"TopAccess")) return true;

// Search the SNMP info
if (asset.hasVulnWithResults(78000,"TOSHIBA e-STUDIO")) return true;



/* Xerox printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
if (asset.hasVulnWithResults(12230,"Fuji Xerox Co") || asset.hasVulnWithResults(12230,"XEROX WORKCENTRE") || asset.hasVulnWithResults(12230,"XEROX ColorQube") || asset.hasVulnWithResults(12230,"/stat/index.php?tab=status")) return true;

// Search FTP response
if (asset.hasVulnWithResults(27113,"Dell") && asset.hasVulnWithResults(27113,"Laser")) return false;
if (asset.hasVulnWithResults(27113,"XEROX") || asset.hasVulnWithResults(27113,"Xerox")) return true;

// SNMP response
if (asset.hasVulnWithResults(78000,"Dell") && asset.hasVulnWithResults(78000,"Laser")) return false;
if (asset.hasVulnWithResults(78000,"Xerox WorkCentre")) return true;

// MAC address
if (asset.hasVulnWithResults(43007,"FUJI-XEROX") || (asset.hasVulnWithResults(43007,"XEROX CORPORATION") && !asset.hasVulnWithResults(43007,"00:00:00:00:00:00"))) return true;

if (asset.hasAnyVuln([45147,45149,45148])) return true;



/* Zebra printers */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
if (asset.hasVulnWithResults(12230,"Zebra Technologies") || asset.hasVulnWithResults(12230,"ZEBRA.COM")) return true;

// Search MAC address
if (asset.hasVulnWithResults(43007,"Zebra Technologies")) return true;

// SNMP response
if (asset.hasVulnWithResults(78000,"ZebraNet")) return true;

// Telnet
if (asset.hasVulnWithResults(38007,"ZebraNet")) return true;
