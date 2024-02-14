/*
 * Groovy scripts for use in Qualys tags
 * 
 * TLS/SSL versions in use
 * 
 * Disclaimer: Scripts are not guaranteed to be perfect - false positive and false negative results are possible. Pull requests to improve the scripts are welcomed.
 * 
 * (c) Matthew Verive
 * Licensed under the MIT License
 */

/* SSLv2 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// SSL server info
ssl_server = asset.resultsForQid(38116L);
if (ssl_server.contains("SSLv2 PROTOCOL IS ENABLED")) return true;

if (asset.hasAnyVuln([38139,90360])) return true;

// SSL protocol info
ssl_protocol = asset.resultsForQid(38706L);
if (ssl_protocol.contains("SSLv2")) return true;

// SSL key exchange methods
ssl_methods = asset.resultsForQid(38704L);
if (ssl_methods.contains("SSLv2")) return true;



/* SSLv3 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// SSL server info
ssl_server = asset.resultsForQid(38116L);
if (ssl_server.contains("SSLv3 PROTOCOL IS ENABLED")) return true;

if (asset.hasAnyVuln([38606,38603,45230,90985])) return true;

// SSL protocol info
ssl_protocol = asset.resultsForQid(38706L);
if (ssl_protocol.contains("SSLv3")) return true;

// SSL key exchange methods
ssl_methods = asset.resultsForQid(38704L);
if (ssl_methods.contains("SSLv3")) return true;



/* TLSv1.0 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// SSL server info
ssl_server = asset.resultsForQid(38116L);
if (ssl_server.contains("TLSv1 PROTOCOL IS ENABLED")) return true;



/* TLSv1.1 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// SSL server info
ssl_server = asset.resultsForQid(38116L);
if (ssl_server.contains("TLSv1.1 PROTOCOL IS ENABLED")) return true;

// SSL protocol info
ssl_protocol = asset.resultsForQid(38706L);
if (ssl_protocol.contains("TLSv1.1")) return true;

// SSL key exchange methods
ssl_methods = asset.resultsForQid(38704L);
if (ssl_methods.contains("TLSv1.1")) return true;



/* TLSv1.2 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// SSL server info
ssl_server = asset.resultsForQid(38116L);
if (ssl_server.contains("TLSv1.2 PROTOCOL IS ENABLED")) return true;

// SSL protocol info
ssl_protocol = asset.resultsForQid(38706L);
if (ssl_protocol.contains("TLSv1.2")) return true;

// SSL key exchange methods
ssl_methods = asset.resultsForQid(38704L);
if (ssl_methods.contains("TLSv1.2")) return true;



/* TLSv1.3 */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// SSL server info
ssl_server = asset.resultsForQid(38116L);
if (ssl_server.contains("TLSv1.3 PROTOCOL IS ENABLED")) return true;

// SSL protocol info
ssl_protocol = asset.resultsForQid(38706L);
if (ssl_protocol.contains("TLSv1.3")) return true;

// SSL key exchange methods
ssl_methods = asset.resultsForQid(38704L);
if (ssl_methods.contains("TLSv1.3")) return true;
