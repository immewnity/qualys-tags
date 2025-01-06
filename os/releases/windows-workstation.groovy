/*
 * Groovy scripts for use in Qualys tags
 * 
 * Windows workstation/desktop releases
 * 
 * Disclaimer: Scripts are not guaranteed to be perfect - false positive and false negative results are possible. Pull requests to improve the scripts are welcomed.
 * 
 * (c) Matthew Verive
 * Licensed under the MIT License
 */



/* Windows XP */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if(asset.hasAnyVuln([105543,105353,105352,105358,105549,105378,116815,90691,90177,90182,38094,91593,90282,90283,90504,90236,90193,19167,45061,45062,105196,105198,105199,105197,105200,105201,105202,105203,105195,105180,105181,105182,90205,105046,105047,105048,105049,105036,100019])) return true;



/* Windows Vista */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if(asset.hasAnyVuln([105338,105405,105710,90501,90468,90396,90402])) return true;



/* Windows 7 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if(asset.hasAnyVuln([105793,105499,45340])) return true;



/* Windows 8 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if(asset.hasAnyVuln([105649,45344])) return true;



/* Windows 8.1 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if(asset.hasAnyVuln([45346])) return true;



/* Windows 10 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Windows Product Type
win_prod_type = asset.resultsForQid(90107L);
if (win_prod_type.contains("ProductType = WinNT") && win_prod_type.contains("ProductName = Windows_10_")) return true;

// Installed patches
patches = asset.resultsForQid(91328L);
if (patches.contains("KB5003791") || patches.contains("KB5016705") || patches.contains("KB4562830") || patches.contains("KB5018506") || patches.contains("KB5020613") || patches.contains("KB5007273") || patches.contains("KB5014032") || patches.contains("KB5015895") || patches.contains("KB5014671") || patches.contains("KB5019959") || patches.contains("KB5000983")) return true;

if(asset.hasAnyVuln([106204,105998,105815,105817,105871,105718,105733,105753,105784,105941,91496,91540,45342])) return true;



/* Windows 11 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if(asset.hasAnyVuln([45513])) return true;

// Windows Product Type
win_prod_type = asset.resultsForQid(90107L);
if (win_prod_type.contains("ProductType = WinNT") && win_prod_type.contains("ProductName = Windows_11_")) return true;
if (win_prod_type.contains("ProductType = WinNT") && win_prod_type.contains("CurrentBuild = 22000")) return true;
