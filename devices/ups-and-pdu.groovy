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
ftp_response = asset.resultsForQid(27113L);
if (ftp_response.contains("Network Management Card AOS")) return true;

// Search the SNMP info
snmp = asset.resultsForQid(78000L);
if (snmp.contains("APC Web")) return true;

// Search the SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("American Power Conversion Corp")) return true;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("/home.htm") && default_web_page.contains("See Other")) return true;

// Search the redirected default web page
redirected_web_page = asset.resultsForQid(13910L);
if (redirected_web_page.contains("/home.htm") && redirected_web_page.contains("See Other")) return true;

// HTTP response method
http_method = asset.resultsForQid(48118L);
if (http_method.contains("/home.htm") && http_method.contains("See Other")) return true;

// Search the MAC address
ssl_cert = asset.resultsForQid(43007L);
if (ssl_cert.contains("AMERICAN POWER CONVERSION CORP")) return true;



/* CyberPower */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search FTP response
ftp_response = asset.resultsForQid(27113L);
if (ftp_response.contains("CyberPower FTP Service")) return true;



/* Tripp Lite */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// MAC address
mac_addr = asset.resultsForQid(43007L);
if (mac_addr.contains("Tripp Lite")) return true;

// SNMP info
snmp = asset.resultsForQid(78000L);
if (snmp.contains("POWERALERT") || snmp.contains("tripplite")) return true;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("PowerAlert Device Manager")) return true;

// SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("poweralert") || ssl_cert.contains("tripplite")) return true;

// Search Telnet response
telnet_response = asset.resultsForQid(38007L);
if (telnet_response.contains("poweralert") || telnet_response.contains("PowerAlert") || telnet_response.contains("POWERALERT")) return true;
