/*
 * Groovy scripts for use in Qualys tags
 * 
 * Various device types
 * 
 * Disclaimer: Scripts are not guaranteed to be perfect - false positive and false negative results are possible. Pull requests to improve the scripts are welcomed.
 * 
 * (c) Matthew Verive
 * Licensed under the MIT License
 */



/* HP iLO */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search through SSH banner
ssh_version = asset.resultsForQid(38050L);
if (ssh_version.contains("SSH-2.0-RomSShell_4.62") || ssh_version.contains("SSH-2.0-mpSSH_0.2.1")) return true;

// UPnP service
upnp = asset.resultsForQid(45187L);
if (upnp.contains("HP-iLO")) return true;

// SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("organizationalUnitName ISS")) return true;

if (asset.hasAnyVuln([730068,13306,13358,13492,13359,43572,43578,13493,43557,730100,10240,43500,13510,11987,13228,43573,13220,13964,13635])) return true;



/* Pitney Bowes postage meter */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("PitneyBowesInc")) return true;



/* Raspberry Pi */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// VNC Banner
vnc_banner = asset.resultsForQid(38062L);
if (vnc_banner.contains("RFB 005.000")) return true;

// SSH Banner
ssh_banner = asset.resultsForQid(38050L);
if (ssh_banner.contains("Raspbian")) return true;
