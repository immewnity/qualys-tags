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

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasAnyVuln([45421])) return true;

// Default web page
web_page = asset.resultsForQid(12230L);
if (web_page.contains("Qualys-Correlation")) return true;

// Default redirected web page
web_page = asset.resultsForQid(13910L);
if (web_page.contains("Qualys-Correlation")) return true;

// Running services (Windows)
services = asset.resultsForQid(45414L);
if (services.contains("QualysAgent")) return true;

// Running services (Unix)
services = asset.resultsForQid(45460L);
if (services.contains("qualys-cloud-agent")) return true;



/* Registry access denied */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

error_message = asset.resultsForQid(90194L);
if (error_message.contains("Access to Remote Registry Service is denied")) return true;
