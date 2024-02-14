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
if (asset.hasVulnWithResults(12230,"/mjpg/1/video.mjpg") || asset.hasVulnWithResults(12230,"/view/multiView.shtml") || asset.hasVulnWithResults(12230,"<title>AXIS</title>")) return true;

// Search the redirected default web page
if (asset.hasVulnWithResults(13910,"/mjpg/1/video.mjpg") || asset.hasVulnWithResults(13910,"/view/multiView.shtml") || asset.hasVulnWithResults(13910,"<title>AXIS</title>")) return true;

// Directories requiring auth
if (asset.hasVulnWithResults(86671,"axis-cgi")) return true;

// Search FTP response
if (asset.hasVulnWithResults(27113,"AXIS") && asset.hasVulnWithResults(27113,"Network Camera")) return true;



/* Dahua/Honeywell */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
if (asset.hasVulnWithResults(12230,"use_AUserPwdCfmTip") || asset.hasVulnWithResults(12230,"ability with IntrusionTrace and LoiterTrace") || asset.hasVulnWithResults(12230,"main-selsct") || asset.hasVulnWithResults(12230,"fn-width436")) return true;

// Search the redirected default web page
if (asset.hasVulnWithResults(13910,"use_AUserPwdCfmTip") || asset.hasVulnWithResults(13910,"ability with IntrusionTrace and LoiterTrace") || asset.hasVulnWithResults(13910,"main-selsct") || asset.hasVulnWithResults(13910,"fn-width436")) return true;



/* Hikvision */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
if (asset.hasVulnWithResults(12230,"doc/page/login.asp") || asset.hasVulnWithResults(12230,"/doc/page/login.asp") || asset.hasVulnWithResults(12230,"doc/en/login.asp") || asset.hasVulnWithResults(12230,"/doc/en/login.asp") || asset.hasVulnWithResults(12230,"Hikvision-Webs")) return true;

// Search the redirected web page
if (asset.hasVulnWithResults(13910,"doc/page/login.asp") || asset.hasVulnWithResults(13910,"/doc/page/login.asp") || asset.hasVulnWithResults(13910,"doc/en/login.asp") || asset.hasVulnWithResults(13910,"/doc/en/login.asp") || asset.hasVulnWithResults(13910,"Hikvision-Webs")) return true;

// Search the headers
if (asset.hasVulnWithResults(48118,"Hikvision-Webs")) return true;

// Search the security header missing
if (asset.hasVulnWithResults(11827,"Hikvision-Webs")) return true;



/* Illustra */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
if (asset.hasVulnWithResults(12230,"lgnLocalStorageGet") || asset.hasVulnWithResults(12230,"randomish number that can be added to URLS") || asset.hasVulnWithResults(12230,"url=/guest/main.html") || asset.hasVulnWithResults(12230,"below field is just to fake browser not to autofill values")) return true;

// Search the redirected default web page
if (asset.hasVulnWithResults(13910,"lgnLocalStorageGet") || asset.hasVulnWithResults(13910,"randomish number that can be added to URLS") || asset.hasVulnWithResults(13910,"url=/guest/main.html") || asset.hasVulnWithResults(13910,"below field is just to fake browser not to autofill values")) return true;

// Search the SSL certificate
if (asset.hasVulnWithResults(82002,"Tyco Security Products")) return true;



/* Panasonic/FLIR */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
if (asset.hasVulnWithResults(12230,"prew_downloadplugin") || asset.hasVulnWithResults(12230,"/html/previewindex.htm") || asset.hasVulnWithResults(12230,"BackUpEndTimeChanged") || asset.hasVulnWithResults(12230,"reginFocus")) return true;



/* Samsung / Wisenet */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
if (asset.hasVulnWithResults(12230,"/home/monitoring.cgi")) return true;

// SNMP info
if (asset.hasVulnWithResults(78000,"SAMSUNG iPolis")) return true;

// Search the redirected default web page
if (asset.hasVulnWithResults(13910,"home/monitoring.cgi")) return true;

if (asset.hasVulnWithResults(12230,"/wmf/index.html")) return true;
if (asset.hasVulnWithResults(13910,"/wmf/index.html")) return true;



/* Synology/Raysharp */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
if (asset.hasVulnWithResults(12230,"RSVideoOcx") || asset.hasVulnWithResults(12230,"eg: http://172.18.13.44/")) return true;

// Search the redirected default web page
if (asset.hasVulnWithResults(13910,"RSVideoOcx") || asset.hasVulnWithResults(13910,"eg: http://172.18.13.44/")) return true;

// Search the SSL cert
if (asset.hasVulnWithResults(86002,"raysharp")) return true;
