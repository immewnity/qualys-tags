/*
 * Groovy scripts for use in Qualys tags
 * 
 * UPS (Uninterruptible Power Supply) and PDU (Power Distribution Unit)
 * 
 * Disclaimer: Scripts are not guaranteed to be perfect - false positive and false negative results are possible. Pull requests to improve the scripts are welcomed.
 * 
 * (c) Matthew Verive
 * Licensed under the MIT License
 */



/* APC/Schneider Electric */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search FTP response
if (asset.hasVulnWithResults(27113,"Network Management Card AOS")) return true;

// Search the SNMP info
if (asset.hasVulnWithResults(78000,"APC Web")) return true;

// Search the SSL cert
if (asset.hasVulnWithResults(86002,"American Power Conversion") || asset.hasVulnWithResults(86002,"APC Engineering")) return true;

// Search the default web page
if (asset.hasVulnWithResults(12230,"/home.htm") && asset.hasVulnWithResults(12230,"See Other")) return true;

// Search the redirected default web page
if ((asset.hasVulnWithResults(13910,"/home.htm") && asset.hasVulnWithResults(13910,"See Other")) || asset.hasVulnWithResults(13910,"as we make calls in the ExportGraphJSO that are looking") || asset.hasVulnWithResults(13910,"isxc desktop")) return true;

// HTTP pipelining
if (asset.hasVulnWithResults(86565,"/home.htm") && asset.hasVulnWithResults(86565,"See Other")) return true;

// HTTP response method
if (asset.hasVulnWithResults(48118,"/home.htm") && asset.hasVulnWithResults(48118,"See Other")) return true;

// Search the MAC address
if (asset.hasVulnWithResults(43007,"AMERICAN POWER CONVERSION CORP")) return true;

// SSH banner
if (asset.hasVulnWithResults(38050,"SSH-2.0-cryptlib")) return true;



/* Chatsworth eConnect */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
if (asset.hasVulnWithResults(12230,"eConnect") && asset.hasVulnWithResults(12230,"url=login.lp")) return true;

// Search the SSL cert
if (asset.hasVulnWithResults(86002,"eConnect") && asset.hasVulnWithResults(86002,"Chatsworth")) return true;



/* CyberPower */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search FTP response
if (asset.hasVulnWithResults(27113,"CyberPower FTP")) return true;

// Search plain text auth
if (asset.hasVulnWithResults(86728,"login_pass.cgi")) return true;



/* Emerson */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
if (asset.hasVulnWithResults(78000,"Emerson") && asset.hasVulnWithResults(78000,"Smart PDU")) return true;



/* Tripp Lite */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// MAC address
if (asset.hasVulnWithResults(43007,"Tripp Lite")) return true;

// SNMP info
if (asset.hasVulnWithResults(78000,"POWERALERT") || asset.hasVulnWithResults(78000,"tripplite")) return true;

// Search the default web page
if (asset.hasVulnWithResults(12230,"PowerAlert Device Manager")) return true;

// SSL cert
if (asset.hasVulnWithResults(86002,"poweralert") || asset.hasVulnWithResults(86002,"tripplite")) return true;

// Search Telnet response
if (asset.hasVulnWithResults(38007,"poweralert") || asset.hasVulnWithResults(38007,"PowerAlert") || asset.hasVulnWithResults(38007,"POWERALERT")) return true;
