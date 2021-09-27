/*
 * Groovy scripts for use in Qualys tags
 * 
 * NAS (Network Attached Storage)
 * 
 * Disclaimer: Scripts are not guaranteed to be perfect - false positive and false negative results are possible. Pull requests to improve the scripts are welcomed.
 * 
 * (c) Matthew Verive
 * Licensed under the MIT License
 */



/* Microsoft Exchange Server */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Yes
if(asset.hasAnyVuln([74166,105016,105414,105557,105711,74152,74154,74155,105205,74156,50098,74157,74206,74232,74261,74256,74263,74266,74255,74267,121445,74158,74159,74160,74164,105888,105889,105890,50107,50108,50109])) return true;

// No
if(asset.hasAnyVuln([43188])) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if ((default_web_page.contains("/owa/") || default_web_page.contains("/OWA/") || default_web_page.contains("/Owa/") || default_web_page.contains("X-FEServer")) && default_web_page.contains("Microsoft-IIS")) return true;

// Search the redirected default web page
redirected_web_page = asset.resultsForQid(13910L);
if ((redirected_web_page.contains("/owa/") || redirected_web_page.contains("/OWA/") || redirected_web_page.contains("/Owa/") || redirected_web_page.contains("X-FEServer")) && redirected_web_page.contains("Microsoft-IIS")) return true;

// HTTP response method
http_method = asset.resultsForQid(48118L);
if ((http_method.contains("/owa") || http_method.contains("/OWA") || http_method.contains("/Owa") || http_method.contains("X-FEServer")) && http_method.contains("Microsoft-IIS")) return true;

// Directories exist
directories_exist = asset.resultsForQid(86672L);
if ((directories_exist.contains("/OWA/") || directories_exist.contains("/owa/") || directories_exist.contains("/Owa/")) && !(directories_exist.contains("/invisionboard/") || directories_exist.contains("phpmynewsletter") || directories_exist.contains("postnuke") || directories_exist.contains("phpnuke") || directories_exist.contains("phpShare") || directories_exist.contains("mediawiki") || directories_exist.contains("zencart") || directories_exist.contains("WebCalendar") || directories_exist.contains("zeroboard") || directories_exist.contains("phpmyadmin") || directories_exist.contains("awstats") || directories_exist.contains("yapig") || directories_exist.contains("tomatocart") || directories_exist.contains("seopanel") || directories_exist.contains("zpanel") || directories_exist.contains("phpwebthings") || directories_exist.contains("jscripts") || directories_exist.contains("drupal") || directories_exist.contains("coregui") || directories_exist.contains("owa/auth"))) return true;



/* Microsoft Internet Information Services (IIS) */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("iisstart.png") || default_web_page.contains("iis-85.png") || default_web_page.contains("iis-8.png") || default_web_page.contains("linkid=66138") || default_web_page.contains("LinkID=209093") || default_web_page.contains("<title>IIS7") || default_web_page.contains("Please do not alter this file. It may be replaced if you upgrade your web server") || default_web_page.contains("Microsoft-IIS")) return true;

// HTTP response
http_response = asset.resultsForQid(48118L);
if (http_response.contains("Microsoft-IIS")) return true;

// No HTTP security header
http_header = asset.resultsForQid(11827L);
if (http_header.contains("Microsoft-IIS")) return true;

// Default install page
default_install = asset.resultsForQid(87089L);
if (default_install.contains("Microsoft-IIS")) return true;

// SMTP banner
smtp_banner = asset.resultsForQid(74042L);
if (smtp_banner.contains("Microsoft ESMTP MAIL Service")) return true;

if (asset.hasAnyVuln([12049,86484,45104,86693,11773,105777,105873,105453,105454,105455,105456,105658,10176,45158])) return true;



/* Microsoft Remote Desktop Web Client (RD Web Access) */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("/RDWeb\"") || default_web_page.contains("Error: Unable to display RD Web Access") || default_web_page.contains("/TSWeb\"") || default_web_page.contains("/tsweb\"") || default_web_page.contains("/rdweb\"") || default_web_page.contains("CheckBoxAutoLogon")) return true;

// Search the redirected default web page
redirected_web_page = asset.resultsForQid(13910L);
if (redirected_web_page.contains("/RDWeb\"") || redirected_web_page.contains("Error: Unable to display RD Web Access") || redirected_web_page.contains("/TSWeb\"") || redirected_web_page.contains("/tsweb\"") || redirected_web_page.contains("/rdweb\"") || redirected_web_page.contains("CheckBoxAutoLogon")) return true;

// Directories requiring auth
auth_directories = asset.resultsForQid(86671L);
if (auth_directories.contains("/RDWeb") || auth_directories.contains("/TSWeb") || auth_directories.contains("/tsweb") || auth_directories.contains("/rdweb")) return true;

// HTTP response method
http_method = asset.resultsForQid(48118L);
if (http_method.contains("/RDWeb") || http_method.contains("/TSWeb") || http_method.contains("/tsweb") || http_method.contains("/rdweb")) return true;

// Directories exist
directories_exist = asset.resultsForQid(86672L);
if ((directories_exist.contains("/RDWeb/") || directories_exist.contains("/TSWeb/") || directories_exist.contains("/tsweb/") || directories_exist.contains("/rdweb/")) && !(directories_exist.contains("/invisionboard/") || directories_exist.contains("phpmynewsletter"))) return true;



/* RealVNC */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasAnyVuln([118023])) return true;

vnc_banner = asset.resultsForQid(38062L);
if (vnc_banner.contains("RFB 004")) return true;

if (asset.hasSoftwareByName("VNC Free Edition")) return true;



/* WordPress */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Yes
if(asset.hasAnyVuln([11764])) return true;

// PHP info
php_info = asset.resultsForQid(45110L);
if (php_info.contains("WordPress") || php_info.contains("wp-includes")) return true;

// PHP information leakage vuln
php_vuln = asset.resultsForQid(38811L);
if (php_vuln.contains("WordPress")) return true;
