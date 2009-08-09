package com.gisgraphy.client.administrativedivision;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.gisgraphy.client.language.Iso639Language;
import com.google.common.collect.ImmutableList;

public final class GeonamesAdministrativeCountryInformation implements AdministrativeCountryInformation {
    private String topLevelDomain;
    private String phonePrefix;
    private String postalCodeMask;
    private String postalCodeRegex;
    private ImmutableList<Iso639Language> spokenLanguages = ImmutableList.of();
    
    private GeonamesAdministrativeCountryInformation() {}
    
    private GeonamesAdministrativeCountryInformation(String topLevelDomain, String phonePrefix, String postalCodeMask, String postalCodeRegex, Iterable<Iso639Language> spokenLanguages) {
	super();
	this.topLevelDomain = topLevelDomain;
	this.phonePrefix = phonePrefix;
	this.postalCodeMask = postalCodeMask;
	this.postalCodeRegex = postalCodeRegex;
	this.spokenLanguages = ImmutableList.copyOf(spokenLanguages);
    }
    
    public static GeonamesAdministrativeCountryInformation administrativeCountryInformation() {
	return new GeonamesAdministrativeCountryInformation();
    }
    
    public GeonamesAdministrativeCountryInformation withTopLevelDomain(String topLevelDomain) {
	return new GeonamesAdministrativeCountryInformation(topLevelDomain, this.phonePrefix, this.postalCodeMask, this.postalCodeRegex, this.spokenLanguages);
    }
    
    public GeonamesAdministrativeCountryInformation withPhonePrefix(String phonePrefix) {
	return new GeonamesAdministrativeCountryInformation(this.topLevelDomain, phonePrefix, this.postalCodeMask, this.postalCodeRegex, this.spokenLanguages);
    }
    
    public GeonamesAdministrativeCountryInformation withPostalCodeMask(String postalCodeMask) {
	return new GeonamesAdministrativeCountryInformation(this.topLevelDomain, this.phonePrefix, postalCodeMask, this.postalCodeRegex, this.spokenLanguages);
    }
    
    public GeonamesAdministrativeCountryInformation withPostalCodeRegex(String postalCodeRegex) {
	return new GeonamesAdministrativeCountryInformation(this.topLevelDomain, this.phonePrefix, this.postalCodeMask, postalCodeRegex, this.spokenLanguages);
    }
    
    public AdministrativeCountryInformation withSpokenLanguages(Iterable<Iso639Language> spokenLanguages) {
	return new GeonamesAdministrativeCountryInformation(this.topLevelDomain, this.phonePrefix, this.postalCodeMask, postalCodeRegex, spokenLanguages);
    }

    /* (non-Javadoc)
     * @see com.gisgraphy.client.administrativedivision.AdministrativeCountryInformation#getTopLevelDomain()
     */
    public String getTopLevelDomain() {
        return topLevelDomain;
    }

    /* (non-Javadoc)
     * @see com.gisgraphy.client.administrativedivision.AdministrativeCountryInformation#getPhonePrefix()
     */
    public String getPhonePrefix() {
        return phonePrefix;
    }

    /* (non-Javadoc)
     * @see com.gisgraphy.client.administrativedivision.AdministrativeCountryInformation#getPostalCodeMask()
     */
    public String getPostalCodeMask() {
        return postalCodeMask;
    }

    /* (non-Javadoc)
     * @see com.gisgraphy.client.administrativedivision.AdministrativeCountryInformation#getPostalCodeRegex()
     */
    public String getPostalCodeRegex() {
        return postalCodeRegex;
    }

    /* (non-Javadoc)
     * @see com.gisgraphy.client.administrativedivision.AdministrativeCountryInformation#getSpokenLanguages()
     */
    public ImmutableList<Iso639Language> getSpokenLanguages() {
        return spokenLanguages;
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
		+ ((spokenLanguages == null) ? 0 : spokenLanguages.hashCode());
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
	GeonamesAdministrativeCountryInformation other = (GeonamesAdministrativeCountryInformation) obj;
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
	if (spokenLanguages == null) {
	    if (other.spokenLanguages != null)
		return false;
	} else if (!spokenLanguages.equals(other.spokenLanguages))
	    return false;
	if (topLevelDomain == null) {
	    if (other.topLevelDomain != null)
		return false;
	} else if (!topLevelDomain.equals(other.topLevelDomain))
	    return false;
	return true;
    }
    
    @Override
    public String toString() {
	return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
    
}
