/*
 * Groovy scripts for use in Qualys tags
 * 
 * Useful tags to determine when something went wrong with Qualys
 * 
 * Disclaimer: Scripts are not guaranteed to be perfect - false positive and false negative results are possible. Pull requests to improve the scripts are welcomed.
 * 
 * (c) Matthew Verive
 * Licensed under the MIT License
 */



/* Cloud Agent unable to check in */
// This usually means the agent is unable to connect to Qualys's servers, but can be the result of other issues as well, such as a malfunctioning service
// Requires a tag named "Cloud Agent" to be present on all agent-tracked hosts

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasTag("Cloud Agent")) return false;

if (asset.hasAnyVuln([45421,48143])) return true;

// Default web page
if (asset.hasVulnWithResults(12230,"Qualys-Correlation")) return true;

// Default redirected web page
if (asset.hasVulnWithResults(13910,"Qualys-Correlation")) return true;

// Running services (Windows)
services = asset.resultsForQid(45414L);
if (services.contains("QualysAgent")) return true;

// Running services (Unix)
services = asset.resultsForQid(45460L);
if (services.contains("qualys-cloud-agent")) return true;

// Port detected
if (asset.hasVulnWithResults(82023,"QUALYS_CORRELATION")) return true;



/* Registry access denied */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

error_message = asset.resultsForQid(90194L);
if (error_message.contains("Access to Remote Registry Service is denied")) return true;
