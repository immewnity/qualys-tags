/*
 * Groovy scripts for use in Qualys tags
 * 
 * IP cameras
 * 
 * Disclaimer: Scripts are not guaranteed to be perfect - false positive and false negative results are possible. Pull requests to improve the scripts are welcomed.
 * 
 * (c) Matthew Verive
 * Licensed under the MIT License
 */



/* Arecont Vision */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("Arecont Vision")) return true;

if (asset.hasAnyVuln([43372])) return true;



/* Axis */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("/mjpg/1/video.mjpg") || default_web_page.contains("/view/multiView.shtml")) return true;

// Directories requiring auth
directories = asset.resultsForQid(86671L);
if (directories.contains("axis-cgi")) return true;

// Search FTP response
ftp_response = asset.resultsForQid(27113L);
if (ftp_response.contains("AXIS") && ftp_response.contains("Network Camera")) return true;



/* Dahua/Honeywell */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("use_AUserPwdCfmTip") || default_web_page.contains("ability with IntrusionTrace and LoiterTrace") || default_web_page.contains("main-selsct") || default_web_page.contains("fn-width436")) return true;

// Search the redirected default web page
default_web_page = asset.resultsForQid(13910L);
if (default_web_page.contains("use_AUserPwdCfmTip") || default_web_page.contains("ability with IntrusionTrace and LoiterTrace") || default_web_page.contains("main-selsct") || default_web_page.contains("fn-width436")) return true;



/* Hikvision */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("doc/page/login.asp") || default_web_page.contains("/doc/page/login.asp")) return true;



/* Illustra */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("lgnLocalStorageGet") || default_web_page.contains("randomish number that can be added to URLS") || default_web_page.contains("url=/guest/main.html")) return true;

// Search the redirected default web page
default_web_page = asset.resultsForQid(13910L);
if (default_web_page.contains("lgnLocalStorageGet") || default_web_page.contains("randomish number that can be added to URLS") || default_web_page.contains("url=/guest/main.html")) return true;



/* Panasonic/FLIR */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("prew_downloadplugin") || default_web_page.contains("/html/previewindex.htm") || default_web_page.contains("BackUpEndTimeChanged") || default_web_page.contains("reginFocus")) return true;



/* Samsung */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("/home/monitoring.cgi")) return true;

// SNMP info
telnet = asset.resultsForQid(78000L);
if (telnet.contains("SAMSUNG iPolis")) return true;

// Search the redirected default web page
default_web_page = asset.resultsForQid(13910L);
if (default_web_page.contains("home/monitoring.cgi")) return true;



/* Synology/Raysharp */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("RSVideoOcx") || default_web_page.contains("eg: http://172.18.13.44/")) return true;

// Search the redirected default web page
default_web_page = asset.resultsForQid(13910L);
if (default_web_page.contains("RSVideoOcx") || default_web_page.contains("eg: http://172.18.13.44/")) return true;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("raysharp")) return true;
