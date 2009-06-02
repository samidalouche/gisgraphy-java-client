package com.gisgraphy.client.domain;

public final class AdministrativeCountryInformation {
    private String topLevelDomain;
    private String phonePrefix;
    private String postalCodeMask;
    private String postalCodeRegex;
    
    private AdministrativeCountryInformation() {}
    
    private AdministrativeCountryInformation(String topLevelDomain, String phonePrefix, String postalCodeMask, String postalCodeRegex) {
	super();
	this.topLevelDomain = topLevelDomain;
	this.phonePrefix = phonePrefix;
	this.postalCodeMask = postalCodeMask;
	this.postalCodeRegex = postalCodeRegex;
    }
    
    public static AdministrativeCountryInformation administrativeCountryInformation() {
	return new AdministrativeCountryInformation();
    }
    
    public AdministrativeCountryInformation withTopLevelDomain(String topLevelDomain) {
	return new AdministrativeCountryInformation(topLevelDomain, this.phonePrefix, this.postalCodeMask, this.postalCodeRegex);
    }
    
    public AdministrativeCountryInformation withPhonePrefix(String phonePrefix) {
	return new AdministrativeCountryInformation(this.topLevelDomain, phonePrefix, this.postalCodeMask, this.postalCodeRegex);
    }
    
    public AdministrativeCountryInformation withPostalCodeMask(String postalCodeMask) {
	return new AdministrativeCountryInformation(this.topLevelDomain, this.phonePrefix, postalCodeMask, this.postalCodeRegex);
    }
    
    public AdministrativeCountryInformation withPostalCodeRegex(String postalCodeRegex) {
	return new AdministrativeCountryInformation(this.topLevelDomain, this.phonePrefix, this.postalCodeMask, postalCodeRegex);
    }

    public String getTopLevelDomain() {
        return topLevelDomain;
    }

    public String getPhonePrefix() {
        return phonePrefix;
    }

    public String getPostalCodeMask() {
        return postalCodeMask;
    }

    public String getPostalCodeRegex() {
        return postalCodeRegex;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((phonePrefix == null) ? 0 : phonePrefix.hashCode());
	result = prime * result
		+ ((postalCodeMask == null) ? 0 : postalCodeMask.hashCode());
	result = prime * result
		+ ((postalCodeRegex == null) ? 0 : postalCodeRegex.hashCode());
	result = prime * result
		+ ((topLevelDomain == null) ? 0 : topLevelDomain.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	AdministrativeCountryInformation other = (AdministrativeCountryInformation) obj;
	if (phonePrefix == null) {
	    if (other.phonePrefix != null)
		return false;
	} else if (!phonePrefix.equals(other.phonePrefix))
	    return false;
	if (postalCodeMask == null) {
	    if (other.postalCodeMask != null)
		return false;
	} else if (!postalCodeMask.equals(other.postalCodeMask))
	    return false;
	if (postalCodeRegex == null) {
	    if (other.postalCodeRegex != null)
		return false;
	} else if (!postalCodeRegex.equals(other.postalCodeRegex))
	    return false;
	if (topLevelDomain == null) {
	    if (other.topLevelDomain != null)
		return false;
	} else if (!topLevelDomain.equals(other.topLevelDomain))
	    return false;
	return true;
    }
    
    
}
