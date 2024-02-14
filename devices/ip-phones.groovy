/*
 * Groovy scripts for use in Qualys tags
 * 
 * IP phones, including conference phones. Softphones are intended to be excluded from these tags.
 * 
 * Disclaimer: Scripts are not guaranteed to be perfect - false positive and false negative results are possible. Pull requests to improve the scripts are welcomed.
 * 
 * (c) Matthew Verive
 * Licensed under the MIT License
 */



/* Avaya */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search web server version
if (asset.hasVulnWithResults(78000,"Linux av96x1")) return true;



/* Cisco */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasAnyVuln([45306,45032,45483,70028,70053,90924,105025])) return false;

if (asset.hasVulnWithResults(12230,"Cisco Unified IP Phone Cisco Communicator")) return false;
if (asset.hasVulnWithResults(13910,"Cisco Unified IP Phone Cisco Communicator")) return false;
if (asset.hasVulnWithResults(86565,"Cisco Unified IP Phone Cisco Communicator")) return false;

if (asset.hasVulnWithResults(86565,"/CGI/Java/Serviceability?adapter=device.statistics.device") || asset.hasVulnWithResults(86565,"Cisco IP Phone") || asset.hasVulnWithResults(86565,"Cisco Unified IP Phone") || asset.hasVulnWithResults(86565,"localmenus.cgi") || asset.hasVulnWithResults(86565,"3pccTitle")) return true;
if (asset.hasVulnWithResults(12230,"/CGI/Java/Serviceability?adapter=device.statistics.device") || asset.hasVulnWithResults(12230,"Cisco IP Phone") || asset.hasVulnWithResults(12230,"Cisco Unified IP Phone") || asset.hasVulnWithResults(12230,"localmenus.cgi") || asset.hasVulnWithResults(12230,"3pccTitle")) return true;
if (asset.hasVulnWithResults(13910,"/CGI/Java/Serviceability?adapter=device.statistics.device") || asset.hasVulnWithResults(13910,"Cisco IP Phone") || asset.hasVulnWithResults(13910,"Cisco Unified IP Phone") || asset.hasVulnWithResults(13910,"localmenus.cgi") || asset.hasVulnWithResults(13910,"3pccTitle")) return true;
if (asset.hasAnyVuln([730229,45331,13821,13499])) return true;

// Search through SSH banner
if (asset.hasVulnWithResults(38050,"SSH-2.0-1.00")) return true;

// Search web server version
if (asset.hasVulnWithResults(86000,"Allegro-Software-RomPager/4.34")) return true;

// Search through SSL cert
if (asset.hasVulnWithResults(86002,"organizationalUnitName VTG") && asset.hasVulnWithResults(86002,"organizationName Cisco")) return true;
if (asset.hasVulnWithResults(86002,"PID:CP-8831") || asset.hasVulnWithResults(86002,"PID:CP-8851")) return true;

// Search admin interface
if (asset.hasVulnWithResults(48144,"Cisco IP Phone")) return true;



/* NEC */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// SIP info
if (asset.hasVulnWithResults(38435,"User-Agent: NEC ITX-1615")) return true;
if (asset.hasVulnWithResults(38438,"User-Agent: NEC ITX-1615")) return true;
if (asset.hasVulnWithResults(38443,"User-Agent: NEC ITX-1615")) return true;

// Web page
if (asset.hasVulnWithResults(12230,"Web Programming") && asset.hasVulnWithResults(12230,"NEC Platforms")) return true;
if (asset.hasVulnWithResults(13910,"Web Programming") && asset.hasVulnWithResults(13910,"NEC Platforms")) return true;



/* Polycom */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the SIP data
if (asset.hasVulnWithResults(38443,"PolycomSoundStationIP") || asset.hasVulnWithResults(38443,"PolycomRealPresenceTrio") || asset.hasVulnWithResults(38443,"PolycomVVX")) return true;

// Search the default web page
if (asset.hasVulnWithResults(12230,"Polycom SoundPoint IP Telephone")) return true;

if (asset.hasVulnWithResults(86002,"Polycom")) return true;



/* Yealink */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the SIP data
if (asset.hasVulnWithResults(38443,"Yealink")) return true;

if (asset.hasVulnWithResults(12230,"Yealink T54W Phone")) return true;
if (asset.hasVulnWithResults(13910,"Yealink T54W Phone")) return true;
if (asset.hasVulnWithResults(86002,"Yealink Equipment")) return true;
