package com.gisgraphy.client.administrativedivision;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * The FIPS code for a Country.
 * 
 * A country (as defined by ISO) might not have any associated FIPS Code.
 * It also happens that several ISO countries have the same FIPS code. 
 * (e.g. : Finland, and aalen island ). In these cases, Finland would have
 * the original FIPS code, and aalen island would have this code as its
 * equivalent FIPS code
 * 
 * @author Sami Dalouche (sami.dalouche@gmail.com)
 *
 */
public final class FipsCountryCode {
    private String fipsCode;
    private String equivalentFipsCode;
    
    private FipsCountryCode(String fipsCode, String equivalentFipsCode) {
	super();
	
	this.fipsCode = fipsCode;
	this.equivalentFipsCode = equivalentFipsCode;
    }
    
    public static FipsCountryCode fipsCountryCode(String fipsCode) {
	return new FipsCountryCode(fipsCode, null);
    }
    
    public String getFipsCode() {
        return fipsCode;
    }

    public String getEquivalentFipsCode() {
        return equivalentFipsCode;
    }

    public static FipsCountryCode equivalentFipsCountryCode(String equivalentFipsCode) {
	return new FipsCountryCode(null, equivalentFipsCode);
    }
    
    public static FipsCountryCode noFipsCode() {
	return new FipsCountryCode(null, null);
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime
		* result
		+ ((equivalentFipsCode == null) ? 0 : equivalentFipsCode
			.hashCode());
	result = prime * result
		+ ((fipsCode == null) ? 0 : fipsCode.hashCode());
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
	FipsCountryCode other = (FipsCountryCode) obj;
	if (equivalentFipsCode == null) {
	    if (other.equivalentFipsCode != null)
		return false;
	} else if (!equivalentFipsCode.equals(other.equivalentFipsCode))
	    return false;
	if (fipsCode == null) {
	    if (other.fipsCode != null)
		return false;
	} else if (!fipsCode.equals(other.fipsCode))
	    return false;
	return true;
    }
    
    @Override
    public String toString() {
	return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("fipsCode", this.fipsCode)
		.append("equivalentFipsCode", this.equivalentFipsCode).toString();
    }
}
