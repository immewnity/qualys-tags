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



/* Cisco */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasAnyVuln([45306,45032,45483,70028,70053,90924,105025])) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
// Search the redirected web page
redir_page = asset.resultsForQid(13910L);
// Search the pipelining
pipelining = asset.resultsForQid(86565L);

if (default_web_page.contains("Cisco Unified IP Phone Cisco Communicator")) return false;
if (redir_page.contains("Cisco Unified IP Phone Cisco Communicator")) return false;
if (pipelining.contains("Cisco Unified IP Phone Cisco Communicator")) return false;

if (pipelining.contains("/CGI/Java/Serviceability?adapter=device.statistics.device") || pipelining.contains("Cisco IP Phone") || pipelining.contains("Cisco Unified IP Phone") || pipelining.contains("localmenus.cgi")) return true;
if (default_web_page.contains("/CGI/Java/Serviceability?adapter=device.statistics.device") || default_web_page.contains("Cisco IP Phone") || default_web_page.contains("Cisco Unified IP Phone") || default_web_page.contains("localmenus.cgi")) return true;
if (redir_page.contains("/CGI/Java/Serviceability?adapter=device.statistics.device") || redir_page.contains("Cisco IP Phone") || redir_page.contains("Cisco Unified IP Phone") || redir_page.contains("localmenus.cgi")) return true;
if (asset.hasAnyVuln([730229,45331,13821,13499])) return true;

// Search through SSH banner
ssh_version = asset.resultsForQid(38050L);
if (ssh_version.contains("SSH-2.0-1.00")) return true;

// Search web server version
web_server = asset.resultsForQid(86000L);
if (web_server.contains("Allegro-Software-RomPager/4.34")) return true;

// Search through SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains("organizationalUnitName VTG") && ssl_cert.contains("organizationName Cisco")) return true;
if (ssl_cert.contains("PID:CP-8831") || ssl_cert.contains("PID:CP-8851")) return true;



/* Polycom */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the SIP data
sip_data = asset.resultsForQid(38443L);
if (sip_data.contains("PolycomSoundStationIP") || sip_data.contains("PolycomRealPresenceTrio") || sip_data.contains("PolycomVVX")) return true;

// Search the default web page
webpage = asset.resultsForQid(12230L);
if (webpage.contains("Polycom SoundPoint IP Telephone")) return true;



/* Yealink */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the SIP data
sip_data = asset.resultsForQid(38443L);
if (sip_data.contains("Yealink")) return true;
