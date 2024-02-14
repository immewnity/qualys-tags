/*
 * Groovy scripts for use in Qualys tags
 * 
 * Various Active Directory tags - you will need to modify for your environment
 * 
 * Disclaimer: Scripts are not guaranteed to be perfect - false positive and false negative results are possible. Pull requests to improve the scripts are welcomed.
 * 
 * (c) Matthew Verive
 * Licensed under the MIT License
 */

/* Domain - currently configured for just base domain */
if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

String NetBIOSName = "MYDOMAIN"; //Put your domain's NetBIOS name (pre-Windows 2000 name) here
String SecondLevelDomain = "MyDomain"; //Put the second-level domain here
String TopLevelDomain = "local"; //Put the TLD here

String FullDomain = SecondLevelDomain + "." + TopLevelDomain;
String FullDomainLC = SecondLevelDomain.toLowerCase() + "." + TopLevelDomain.toLowerCase();
String DCFormat = "DC=" + SecondLevelDomain + ",DC=" + TopLevelDomain;

// NetBIOS Bindings Information
netbios_bindings = asset.resultsForQid(70004L);
if (netbios_bindings.contains(NetBIOSName + " Domain Name")) return true;

// Windows Host Domain Information
host_domain = asset.resultsForQid(45265L);
if (host_domain.contains("Domain = " + FullDomain)) return true;

// Windows Hostname and Domain Name Information
hostname_domain = asset.resultsForQid(45325L);
if (hostname_domain.contains("Domain = " + FullDomain)) return true;

// Search through AD OU data
ad_ou = asset.resultsForQid(48032L);
if (ad_ou.contains(DCFormat)) return true;

// Search LDAP reply
ldap = asset.resultsForQid(45016L);
if (ldap.contains("namingContexts: DC=DomainDnsZones," + DCFormat)) return true;

// Search SSL cert
ssl_cert = asset.resultsForQid(86002L);
if (ssl_cert.contains(DCFormat) || ssl_cert.contains("." + FullDomain)) return true;

// DNS info
dns_info = asset.resultsForQid(6L);
if (dns_info.contains("." + FullDomain) || dns_info.contains("." + FullDomainLC)) return true;

// Host Names Found
hostnames = asset.resultsForQid(45039L);
if (hostnames.contains("." + FullDomain + " NTLM") || hostnames.contains("." + FullDomainLC +" NTLM")) return true;

// Linux Hostname
linux_hostname = asset.resultsForQid(45361L);
if (linux_hostname.contains("." + FullDomainLC) || linux_hostname.contains("." + FullDomain)) return true;

if (asset.getNetbiosName().endsWith("." + FullDomainLC) || asset.getNetbiosName().endsWith("." + FullDomain)) return true;
if (asset.getHostName().endsWith("." + FullDomainLC) || asset.getHostName().endsWith("." + FullDomain)) return true;



/* Organizational Unit - not the full tree, just that it's within this (doesn't have to be most immediate parent) */

if(asset.getAssetType()!=Asset.AssetType.HOST) return false;

String theOU = "My Organizational Unit";//Put your OU here

// Search through AD OU data
ad_ou = asset.resultsForQid(48032L);
if (ad_ou.contains("OU=" + theOU)) return true;

// Group Policy settings
gpo = asset.resultsForQid(105238L);
if (gpo.contains("OU=" + theOU)) return true;

// Search LDAP reply
ldap = asset.resultsForQid(45016L);
if (ldap.contains("OU=" + theOU)) return true;

// Search SSL cert
ldap = asset.resultsForQid(86002L);
if (ldap.contains("OU=" + theOU)) return true;
