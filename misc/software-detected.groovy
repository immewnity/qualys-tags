/*
 * Groovy scripts for use in Qualys tags
 * 
 * Software detected
 * 
 * Disclaimer: Scripts are not guaranteed to be perfect - false positive and false negative results are possible. Pull requests to improve the scripts are welcomed.
 * 
 * (c) Matthew Verive
 * Licensed under the MIT License
 */



/* IBM WebSphere */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("IBM WebSphere Application Server")) return true;

if (asset.hasAnyVuln([373874,373712,373713,373420,373412,373443,373496,373454,373478,373479,373401,373100,372856,372860,372522,372316,372312,372318,372314,372315,372317,372256,372227,372168,372169,372170,372155,372157,372158,372144,372004,371843,371830,371688,371698,371586,371685,371689,371704,371660,371593,371594,371325,371334,371360,371379,371316,371289,371270,371269,371262,371234,371235,371228,371225,371227,371204,371207,371193,371200,371203,371190,371191,371192,371194,371195,371196,371197,371198,371199,371205,371064,371065,105762,371029,371030,105754,370925,370946,370908,370882,370817,370809,370813,370815,370816,370807,370795,370792,370779,370750,370752,370762,370772,370774,370758,370749,370751,370742,370728,370725,370711,370696,370701,370702,370644,370616,370611,86499,370586,105730,370571,370558,370539,370518,370516,370517,370503,370493,370494,370483,370473,370460,370424,370388,370345,370342,105707,370322,124612,370305,370294,370295,370287,87229,370159,370099,370068,124880,124745,124686,124682,124629,124380,124378,124213,89003,89004,89005,123974,86129,89001,89002,124157,124158,124156,124155,124147,86151,86173,124146,123973,87230,86147,86018,87273,13084,87258,87241,87023,87237,87227,120842,87183,105495,87140,87132,120709,87127,120669,87124,87125,120657,120607,86966,87112,87111,120292,87108,87107,105452,87094,87090,87091,87092,87087,87085,87081,87082,87084,87063,86994,87079,87080,87001,87066,87067,87071,87072,87073,87074,87075,87076,87077,87060,87062,87064,87065,87068,87069,87070,87054,87055,87056,87058,87059,87052,87053,87051,87050,87049,87048,87047,87046,87045,87032,87039,87040,87041,87042,87043,87044,87037,87035,87036,87033,87034,87031,87030,87024,87025,87026,87027,87028,87029,87022,119706,87019,87021,87020,87000,87015,87016,87017,87013,87014,87007,87008,87010,87011,87012,87003,87004,87005,87006,86995,86996,86997,86998,86999,86992,86964,86989,86988,86987,86986,86985,86984,86980,86979,86978,86977,86974,86973,86971,86972,86970,86969,86963,86965,86968,86967,86960,86958,86957,86956,86955,45128,86949,86944,86936,86934,86932,86930,86924,86921,86917,86912,86902,86889,86876,86872,86866,86862,86860,86858,42021,86853,86841,116412,86829,86770,86750,86747,86742,86741,86706,86677,86676,86673,86449,10976,10896,10895,10894,86393,86282,10366,86178,86176,86095])) return true;



/* IceWarp */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// IMAP banner
imap_banner = asset.resultsForQid(50010L);
if (imap_banner.contains("IceWarp")) return true;

// POP3 banner
pop3_banner = asset.resultsForQid(50000L);
if (pop3_banner.contains("IceWarp")) return true;

// SMTP banner
smtp_banner = asset.resultsForQid(74042L);
if (smtp_banner.contains("IceWarp")) return true;



/* iMail Server (Ipswich/Progress */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// SMTP banner
smtp_banner = asset.resultsForQid(74042L);
if (smtp_banner.contains("NT-ESMTP Server X1")) return true;



/* Microsoft Exchange Server */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Yes
if(asset.hasAnyVuln([74166,105016,105414,105557,105711,74152,74154,74155,105205,74156,50098,74157,74206,74232,74261,74256,74263,74266,74255,74267,121445,74158,74159,74160,74164,105888,105889,105890,50107,50108,50109])) return true;

// No
if(asset.hasAnyVuln([43188])) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if ((default_web_page.contains("/owa/") || default_web_page.contains("/OWA/") || default_web_page.contains("/Owa/") || default_web_page.contains("X-FEServer")) && default_web_page.contains("Microsoft-IIS")) return true;

// Search the redirected default web page
redirected_web_page = asset.resultsForQid(13910L);
if ((redirected_web_page.contains("/owa/") || redirected_web_page.contains("/OWA/") || redirected_web_page.contains("/Owa/") || redirected_web_page.contains("X-FEServer")) && redirected_web_page.contains("Microsoft-IIS")) return true;

// HTTP response method
http_method = asset.resultsForQid(48118L);
if ((http_method.contains("/owa") || http_method.contains("/OWA") || http_method.contains("/Owa") || http_method.contains("X-FEServer")) && http_method.contains("Microsoft-IIS")) return true;

// Directories exist
directories_exist = asset.resultsForQid(86672L);
if ((directories_exist.contains("/OWA/") || directories_exist.contains("/owa/") || directories_exist.contains("/Owa/")) && !(directories_exist.contains("/invisionboard/") || directories_exist.contains("phpmynewsletter") || directories_exist.contains("postnuke") || directories_exist.contains("phpnuke") || directories_exist.contains("phpShare") || directories_exist.contains("mediawiki") || directories_exist.contains("zencart") || directories_exist.contains("WebCalendar") || directories_exist.contains("zeroboard") || directories_exist.contains("phpmyadmin") || directories_exist.contains("awstats") || directories_exist.contains("yapig") || directories_exist.contains("tomatocart") || directories_exist.contains("seopanel") || directories_exist.contains("zpanel") || directories_exist.contains("phpwebthings") || directories_exist.contains("jscripts") || directories_exist.contains("drupal") || directories_exist.contains("coregui") || directories_exist.contains("owa/auth"))) return true;



/* Microsoft Internet Information Services (IIS) */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("iisstart.png") || default_web_page.contains("iis-85.png") || default_web_page.contains("iis-8.png") || default_web_page.contains("linkid=66138") || default_web_page.contains("LinkID=209093") || default_web_page.contains("<title>IIS7") || default_web_page.contains("Please do not alter this file. It may be replaced if you upgrade your web server") || default_web_page.contains("Microsoft-IIS")) return true;

// HTTP response
http_response = asset.resultsForQid(48118L);
if (http_response.contains("Microsoft-IIS")) return true;

// No HTTP security header
http_header = asset.resultsForQid(11827L);
if (http_header.contains("Microsoft-IIS")) return true;

// Default install page
default_install = asset.resultsForQid(87089L);
if (default_install.contains("Microsoft-IIS")) return true;

// SMTP banner
smtp_banner = asset.resultsForQid(74042L);
if (smtp_banner.contains("Microsoft ESMTP MAIL Service")) return true;

if (asset.hasAnyVuln([12049,86484,45104,86693,11773,105777,105873,105453,105454,105455,105456,105658,10176,45158])) return true;



/* Microsoft Remote Desktop Web Client (RD Web Access) */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Search the default web page
default_web_page = asset.resultsForQid(12230L);
if (default_web_page.contains("/RDWeb\"") || default_web_page.contains("Error: Unable to display RD Web Access") || default_web_page.contains("/TSWeb\"") || default_web_page.contains("/tsweb\"") || default_web_page.contains("/rdweb\"") || default_web_page.contains("CheckBoxAutoLogon")) return true;

// Search the redirected default web page
redirected_web_page = asset.resultsForQid(13910L);
if (redirected_web_page.contains("/RDWeb\"") || redirected_web_page.contains("Error: Unable to display RD Web Access") || redirected_web_page.contains("/TSWeb\"") || redirected_web_page.contains("/tsweb\"") || redirected_web_page.contains("/rdweb\"") || redirected_web_page.contains("CheckBoxAutoLogon")) return true;

// Directories requiring auth
auth_directories = asset.resultsForQid(86671L);
if (auth_directories.contains("/RDWeb") || auth_directories.contains("/TSWeb") || auth_directories.contains("/tsweb") || auth_directories.contains("/rdweb")) return true;

// HTTP response method
http_method = asset.resultsForQid(48118L);
if (http_method.contains("/RDWeb") || http_method.contains("/TSWeb") || http_method.contains("/tsweb") || http_method.contains("/rdweb")) return true;

// Directories exist
directories_exist = asset.resultsForQid(86672L);
if ((directories_exist.contains("/RDWeb/") || directories_exist.contains("/TSWeb/") || directories_exist.contains("/tsweb/") || directories_exist.contains("/rdweb/")) && !(directories_exist.contains("/invisionboard/") || directories_exist.contains("phpmynewsletter"))) return true;



/* RealVNC */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

if (asset.hasAnyVuln([118023])) return true;

vnc_banner = asset.resultsForQid(38062L);
if (vnc_banner.contains("RFB 004")) return true;

if (asset.hasSoftwareByName("VNC Free Edition")) return true;



/* Sendmail */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// SMTP banner
smtp_banner = asset.resultsForQid(74042L);
if (smtp_banner.contains("Sendmail")) return true;



/* WordPress */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

// Yes
if(asset.hasAnyVuln([11764])) return true;

// PHP info
php_info = asset.resultsForQid(45110L);
if (php_info.contains("WordPress") || php_info.contains("wp-includes")) return true;

// PHP information leakage vuln
php_vuln = asset.resultsForQid(38811L);
if (php_vuln.contains("WordPress")) return true;
