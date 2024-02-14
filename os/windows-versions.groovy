/*
 * Groovy scripts for use in Qualys tags
 * 
 * Windows release versions (e.g. 1909 for the second major release of 2019)
 * 
 * Disclaimer: Scripts are not guaranteed to be perfect - false positive and false negative results are possible. Pull requests to improve the scripts are welcomed.
 * 
 * (c) Matthew Verive
 * Licensed under the MIT License
 */



/* Windows version 1507 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

String ReleaseId = "1507";
String BuildNo = "10240";

// Windows Product Type
win_prod_type = asset.resultsForQid(90107L);
if (win_prod_type.contains("ReleaseId = " + ReleaseId) || win_prod_type.contains("CurrentBuildNumber = " + BuildNo)) return true;

// Windows 10 detected
win_prod_type = asset.resultsForQid(45342L);
if (win_prod_type.contains("ReleaseId = " + ReleaseId)) return true;

if (asset.hasAnyVuln([105718])) return true;



/* Windows version 1511 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

String ReleaseId = "1511";
String BuildNo = "10586";

// Windows Product Type
win_prod_type = asset.resultsForQid(90107L);
if (win_prod_type.contains("ReleaseId = " + ReleaseId) || win_prod_type.contains("CurrentBuildNumber = " + BuildNo)) return true;

// Windows 10 detected
win_prod_type = asset.resultsForQid(45342L);
if (win_prod_type.contains("ReleaseId = " + ReleaseId)) return true;

if (asset.hasAnyVuln([105733])) return true;



/* Windows version 1607 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

String ReleaseId = "1607";
String BuildNo = "14393";

// Windows Product Type
win_prod_type = asset.resultsForQid(90107L);
if (win_prod_type.contains("ReleaseId = " + ReleaseId) || win_prod_type.contains("CurrentBuildNumber = " + BuildNo)) return true;

// Windows 10 detected
win_prod_type = asset.resultsForQid(45342L);
if (win_prod_type.contains("ReleaseId = " + ReleaseId)) return true;

if (asset.hasAnyVuln([105753])) return true;



/* Windows version 1703 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

String ReleaseId = "1703";
String BuildNo = "15063";

// Windows Product Type
win_prod_type = asset.resultsForQid(90107L);
if (win_prod_type.contains("ReleaseId = " + ReleaseId) || win_prod_type.contains("CurrentBuildNumber = " + BuildNo)) return true;

// Windows 10 detected
win_prod_type = asset.resultsForQid(45342L);
if (win_prod_type.contains("ReleaseId = " + ReleaseId)) return true;

if (asset.hasAnyVuln([105784])) return true;



/* Windows version 1709 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

String ReleaseId = "1709";
String BuildNo = "16299";

// Windows Product Type
win_prod_type = asset.resultsForQid(90107L);
if (win_prod_type.contains("ReleaseId = " + ReleaseId) || win_prod_type.contains("CurrentBuildNumber = " + BuildNo)) return true;

// Windows 10 detected
win_prod_type = asset.resultsForQid(45342L);
if (win_prod_type.contains("ReleaseId = " + ReleaseId)) return true;

if (asset.hasAnyVuln([105941])) return true;



/* Windows version 1803 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

String ReleaseId = "1803";
String BuildNo = "17134";

// Windows Product Type
win_prod_type = asset.resultsForQid(90107L);
if (win_prod_type.contains("ReleaseId = " + ReleaseId) || win_prod_type.contains("CurrentBuildNumber = " + BuildNo)) return true;

// Windows 10 detected
win_prod_type = asset.resultsForQid(45342L);
if (win_prod_type.contains("ReleaseId = " + ReleaseId)) return true;



/* Windows version 1809 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

String ReleaseId = "1809";
String BuildNo = "17763";

// Windows Product Type
win_prod_type = asset.resultsForQid(90107L);
if (win_prod_type.contains("ReleaseId = " + ReleaseId) || win_prod_type.contains("CurrentBuildNumber = " + BuildNo)) return true;

// Windows 10 detected
win_prod_type = asset.resultsForQid(45342L);
if (win_prod_type.contains("ReleaseId = " + ReleaseId)) return true;

if (asset.hasAnyVuln([105960])) return true;



/* Windows version 1903 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

String ReleaseId = "1903";
String BuildNo = "18362";

// Windows Product Type
win_prod_type = asset.resultsForQid(90107L);
if (win_prod_type.contains("ReleaseId = " + ReleaseId) || win_prod_type.contains("CurrentBuildNumber = " + BuildNo)) return true;

// Windows 10 detected
win_prod_type = asset.resultsForQid(45342L);
if (win_prod_type.contains("ReleaseId = " + ReleaseId)) return true;

if (asset.hasAnyVuln([105959,105993])) return true;



/* Windows version 1909 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

String ReleaseId = "1909";
String BuildNo = "18363";

// Windows Product Type
win_prod_type = asset.resultsForQid(90107L);
if (win_prod_type.contains("ReleaseId = " + ReleaseId) || win_prod_type.contains("CurrentBuildNumber = " + BuildNo)) return true;

// Windows 10 detected
win_prod_type = asset.resultsForQid(45342L);
if (win_prod_type.contains("ReleaseId = " + ReleaseId)) return true;



/* Windows version 2004 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

String ReleaseId = "2004";
String BuildNo = "19041";

// Windows Product Type
win_prod_type = asset.resultsForQid(90107L);
if (win_prod_type.contains("ReleaseId = " + ReleaseId) || win_prod_type.contains("CurrentBuildNumber = " + BuildNo)) return true;

// Windows 10 detected
win_prod_type = asset.resultsForQid(45342L);
if (win_prod_type.contains("ReleaseId = " + ReleaseId)) return true;



/* Windows version 20H2 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

String DisplayVersion = "20H2";
String BuildNo = "19042";

// Windows Product Type
win_prod_type = asset.resultsForQid(90107L);
if (win_prod_type.contains("DisplayVersion = 21H1")) return false;
if (win_prod_type.contains("CurrentBuildNumber = " + BuildNo) || win_prod_type.contains("DisplayVersion = " + DisplayVersion)) return true;

if (asset.hasAnyVuln([106074])) return true;



/* Windows version 21H1 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

String DisplayVersion = "21H1";
String BuildNo = "19043";

// Windows Product Type
win_prod_type = asset.resultsForQid(90107L);
if (win_prod_type.contains("CurrentBuildNumber = " + BuildNo) || win_prod_type.contains("DisplayVersion = " + DisplayVersion)) return true;



/* Windows version 21H2 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

String DisplayVersion = "21H2";
String Win10BuildNo = "19044";
String Win11BuildNo = "22000";

// Windows Product Type
win_prod_type = asset.resultsForQid(90107L);
if (win_prod_type.contains("CurrentBuildNumber = " + Win10BuildNo) || win_prod_type.contains("CurrentBuildNumber = " + Win11BuildNo) || win_prod_type.contains("DisplayVersion = " + DisplayVersion)) return true;



/* Windows version 22H2 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

String DisplayVersion = "22H2";
String Win10BuildNo = "19045";
String Win11BuildNo = "22621";

// Windows Product Type
win_prod_type = asset.resultsForQid(90107L);
if (win_prod_type.contains("CurrentBuildNumber = " + Win10BuildNo) || win_prod_type.contains("CurrentBuildNumber = " + Win11BuildNo) || win_prod_type.contains("DisplayVersion = " + DisplayVersion)) return true;



/* Windows version 23H2 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

String DisplayVersion = "23H2";
String Win11BuildNo = "22631";

// Windows Product Type
win_prod_type = asset.resultsForQid(90107L);
if (win_prod_type.contains("CurrentBuildNumber = " + Win11BuildNo) || win_prod_type.contains("DisplayVersion = " + DisplayVersion)) return true;
