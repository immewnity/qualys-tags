/*
 * Groovy scripts for use in Qualys tags
 * 
 * IP phones, including conference phones
 * 
 * Disclaimer: Scripts are not guaranteed to be perfect - false positive and false negative results are possible. Pull requests to improve the scripts are welcomed.
 * 
 * (c) Matthew Verive
 * Licensed under the MIT License
 */



/* Cisco */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("/CGI/Java/Serviceability?adapter=device.statistics.device") || default_web_page.contains("Cisco IP Phone")) return true;

// Search the pipelining
pipelining = asset.resultsForQid(86565L);
if (pipelining.contains("/CGI/Java/Serviceability?adapter=device.statistics.device") || default_web_page.contains("Cisco IP Phone")) return true;

if (asset.hasAnyVuln([45331,13821,13499])) return true;

// Search through SSH banner
ssh_version = asset.resultsForQid(38050L);
if (ssh_version.contains("SSH-2.0-1.00")) return true;



/* Polycom */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the SIP data
sip_data = asset.resultsForQid(38443L);
if (sip_data.contains("PolycomSoundStationIP") || sip_data.contains("PolycomRealPresenceTrio") || sip_data.contains("PolycomVVX")) return true;



/* Yealink */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the SIP data
sip_data = asset.resultsForQid(38443L);
if (sip_data.contains("Yealink")) return true;
