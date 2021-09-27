/*
 * Groovy scripts for use in Qualys tags
 * 
 * Windows Server releases
 * 
 * Disclaimer: Scripts are not guaranteed to be perfect - false positive and false negative results are possible. Pull requests to improve the scripts are welcomed.
 * 
 * (c) Matthew Verive
 * Licensed under the MIT License
 */



/* Windows Server 2003 */
// This includes Server 2003 R2, since build number is the same and it acts more like a service pack compared to later R2 releases

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Windows Product Type
win_prod_type = asset.resultsForQid(90107L);
if (win_prod_type.contains("ProductType = ServerNT") && win_prod_type.contains("CurrentBuild = 3790")) return true;

if(asset.hasAnyVuln([105632,105339,105340,105658,91129,90238,90237,90388,74188,90326,105066,105079,105067,105068,105069,105078,105070,105071,105072,105076,105073,105075,105074])) return true;



/* Windows Server 2008 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Windows Product Type
win_prod_type = asset.resultsForQid(90107L);
if (win_prod_type.contains("ProductType = ServerNT") && win_prod_type.contains("CurrentBuild = 6003")) return true;

if(asset.hasAnyVuln([105858,105449,90502,45343,90580,45341])) return true;



/* Windows Server 2008 R2 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Windows Product Type
win_prod_type = asset.resultsForQid(90107L);
if (win_prod_type.contains("ProductType = ServerNT") && (win_prod_type.contains("CurrentBuild = 7600") || win_prod_type.contains("CurrentBuild = 7601"))) return true;

if(asset.hasAnyVuln([105859,105497,90742,45345])) return true;



/* Windows Server 2012 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Windows Product Type
win_prod_type = asset.resultsForQid(90107L);
if (win_prod_type.contains("ProductType = ServerNT") && win_prod_type.contains("CurrentBuild = 9200")) return true;

if(asset.hasAnyVuln([45350,45351])) return true;



/* Windows Server 2012 R2 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if(asset.hasAnyVuln([45348])) return true;

// Windows Product Type
win_prod_type = asset.resultsForQid(90107L);
if (win_prod_type.contains("ProductType = ServerNT") && win_prod_type.contains("ProductName = Windows Server 2012 R2")) return true;
if (win_prod_type.contains("ProductType = ServerNT") && win_prod_type.contains("CurrentBuild = 9600")) return true;



/* Windows Server 2016 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if(asset.hasAnyVuln([45347,45349])) return true;

// Windows Product Type
win_prod_type = asset.resultsForQid(90107L);
if (win_prod_type.contains("ProductType = ServerNT") && win_prod_type.contains("ProductName = Windows Server 2016")) return true;
if (win_prod_type.contains("ProductType = ServerNT") && win_prod_type.contains("CurrentBuild = 14393")) return true;



/* Windows Server 2019 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if(asset.hasAnyVuln([45419])) return true;

// Windows Product Type
win_prod_type = asset.resultsForQid(90107L);
if (win_prod_type.contains("ProductType = ServerNT") && win_prod_type.contains("ProductName = Windows Server 2019")) return true;



/* Windows Server 2022 */
// Untested

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Windows Product Type
win_prod_type = asset.resultsForQid(90107L);
if (win_prod_type.contains("ProductType = ServerNT") && win_prod_type.contains("ProductName = Windows Server 2022")) return true;
