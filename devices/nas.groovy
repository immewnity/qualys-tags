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
if (asset.hasVulnWithResults(12230,"url=/static/index.html")) return true;

// Search shared folders
if (asset.hasVulnWithResults(70030,"LinkStation") || asset.hasVulnWithResults(70030,"TeraStation")) return true;

// Search SSL cert
if (asset.hasVulnWithResults(86002,"organizationalUnitName NAS") && asset.hasVulnWithResults(86002,"organizationName buffalo")) return true;



/* InfiniBox */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
if (asset.hasVulnWithResults(12230,"InfiniBox")) return true;

// Search the redirected web page
if (asset.hasVulnWithResults(13910,"InfiniBox")) return true;

// Search SSL cert
if (asset.hasVulnWithResults(86002,"Infinilab") || asset.hasVulnWithResults(86002,"Infinidat")) return true;



/* iomega/Lenovo */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
if (asset.hasVulnWithResults(12230,"Set-Cookie: iomega=") || asset.hasVulnWithResults(12230,"restricted to MediaServer") || asset.hasVulnWithResults(12230,"Iomega StorCenter")) return true;

// Search the redirected web page
if (asset.hasVulnWithResults(13910,"Iomega StorCenter")) return true;

// Search shared folders
if (asset.hasVulnWithResults(70030,"Lenovo ix4") || asset.hasVulnWithResults(70030,"Lenovo ix2")) return true;



/* iXsystems / TrueNAS */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasVulnWithResults(12230,"TrueNAS") || asset.hasVulnWithResults(13910,"TrueNAS") || asset.hasVulnWithResults(13910,"ix-blue") || asset.hasVulnWithResults(12230,"ix-blue")) return true;

// Search SSL cert
if (asset.hasVulnWithResults(86002,"iXsystems") || asset.hasVulnWithResults(86002,"ixsystems.com")) return true;



/* Netgear */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the redirected default web page
if (asset.hasVulnWithResults(13910,"NETGEAR ReadyNAS")) return true;

// Search shared folders
if (asset.hasVulnWithResults(70030,"NAS4360")) return true;

// Search iSCSI auth info
if (asset.hasVulnWithResults(38660,"netgear:nas")) return true;



/* QNAP */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
if (asset.hasVulnWithResults(12230,"location.hostname+pt+redirect_suffix")) return true;

// Search SSL cert
if (asset.hasVulnWithResults(86002,"organizationalUnitName NAS") && asset.hasVulnWithResults(86002,"organizationName QNAP")) return true;

if (asset.hasAnyVuln([48121,13154])) return true;



/* Seagate */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
if (asset.hasVulnWithResults(12230,"sign in to Seagate Central")) return true;

// Search the FTP banner
if (asset.hasVulnWithResults(27113,"Seagate Central")) return true;

// Search SSL cert
if (asset.hasVulnWithResults(86002,"Seagate Central")) return true;

// Search NetBIOS
if (asset.hasVulnWithResults(70030,"Seagate Central")) return true;



/* Synology */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
if (asset.hasVulnWithResults(12230,"Synology") || asset.hasVulnWithResults(12230,"SYNO.Core.Desktop") || asset.hasVulnWithResults(12230,"RackStation")) return true;

// Search the redirected web page
if (asset.hasVulnWithResults(13910,"Synology") || asset.hasVulnWithResults(13910,"SYNO.Core.Desktop") || asset.hasVulnWithResults(13910,"RackStation")) return true;

// Search SSH banner
if (asset.hasVulnWithResults(38050,"SSH-2.0-OpenSSH_6.8p1-hpn14v6")) return true;

// Search HTTP header
if (asset.hasVulnWithResults(48118,"synology")) return true;

// Search SSL cert
if (asset.hasVulnWithResults(86002,"Synology")) return true;



/* Western Digital */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the redirected default web page
if (asset.hasVulnWithResults(13910,"X-Orion-Version")) return true;

// Search shared folders
if (asset.hasVulnWithResults(70030,"My Book Live Network Storage")) return true;
