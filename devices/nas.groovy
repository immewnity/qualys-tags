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



/* Buffalo */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("url=/static/index.html")) return true;

// Search shared folders
shared_folders = asset.resultsForQid(70030L);
if (shared_folders.contains("LinkStation") || shared_folders.contains("TeraStation")) return true;

// Search SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("organizationalUnitName NAS") && ssl_cert.contains("organizationName buffalo")) return true;



/* iomega/Lenovo */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("Set-Cookie: iomega=") || default_web_page.contains("restricted to MediaServer") || default_web_page.contains("Iomega StorCenter")) return true;

// Search the redirected web page
redirected_web_page = asset.resultsForQid(12230L);
if (redirected_web_page.contains("Iomega StorCenter")) return true;

// Search shared folders
shared_folders = asset.resultsForQid(70030L);
if (shared_folders.contains("Lenovo ix4") || shared_folders.contains("Lenovo ix2")) return true;



/* Netgear */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the redirected default web page
default_web_page = asset.resultsForQid(13910L);
if (default_web_page.contains("NETGEAR ReadyNAS")) return true;

// Search shared folders
shared_folders = asset.resultsForQid(70030L);
if (shared_folders.contains("NAS4360")) return true;

// Search iSCSI auth info
iscsi = asset.resultsForQid(38660L);
if (iscsi.contains("netgear:nas")) return true;



/* QNAP */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("location.hostname+pt+redirect_suffix")) return true;

// Search SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("organizationalUnitName NAS") && ssl_cert.contains("organizationName QNAP")) return true;

if (asset.hasAnyVuln([48121,13154])) return true;



/* Seagate */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("user name and password to sign in to Seagate Central") || default_web_page.contains("application_window.title_bar.logo.tooltip")) return true;

// Search FTP response
ftp_response = asset.resultsForQid(27113L);
if (ftp_response.contains("Welcome to Seagate Central")) return true;

// Search SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("Seagate Central Shared Storage") || ssl_cert.contains("fadsjkl@fadsjl.com")) return true;



/* Synology */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("Synology&nbsp;RackStation") || default_web_page.contains("SYNO.Core.Desktop") || default_web_page.contains("RackStation provides a full-featured network attached storage")) return true;

// Search SSH banner
ssh_banner = asset.resultsForQid(38050L);
if (ssh_banner.contains("SSH-2.0-OpenSSH_6.8p1-hpn14v6")) return true;

// Search SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("organizationalUnitName FTP Team") && ssl_cert.contains("organizationName Synology")) return true;



/* Western Digital */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the redirected default web page
default_web_page = asset.resultsForQid(13910L);
if (default_web_page.contains("X-Orion-Version")) return true;

// Search shared folders
shared_folders = asset.resultsForQid(70030L);
if (shared_folders.contains("My Book Live Network Storage")) return true;
