package com.gisgraphy.client.administrativedivision;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
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
	return new HashCodeBuilder()
		.append(phonePrefix)
		.append(postalCodeMask)
		.append(postalCodeRegex)
		.append(spokenLanguages)
		.append(topLevelDomain)
		.toHashCode();
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
	
	return new EqualsBuilder()
		.append(phonePrefix, other.getPhonePrefix())
		.append(postalCodeMask, other.getPostalCodeMask())
		.append(postalCodeRegex, other.getPostalCodeRegex())
		.append(spokenLanguages, other.getSpokenLanguages())
		.append(topLevelDomain, other.getTopLevelDomain())
		.isEquals();
    }
    
    @Override
    public String toString() {
	return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
    
}
