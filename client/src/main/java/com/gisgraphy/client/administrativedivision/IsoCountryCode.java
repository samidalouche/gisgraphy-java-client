package com.gisgraphy.client.administrativedivision;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @see <a href="http://en.wikipedia.org/wiki/ISO_3166"> ISO 3166 </a>
 * 
 * @author Sami Dalouche (sami.dalouche@gmail.com)
 *
 */
public final class IsoCountryCode {
    public final static class CountryCodeBuilder {
	private String iso3166Alpha2Code;
	private String iso3166Alpha3Code;
	private Integer iso3166NumericCode;
	public CountryCodeBuilder(String alpha2Code) {
	    this.iso3166Alpha2Code = alpha2Code;
	}
	public CountryCodeBuilder alpha3Code(String alpha3Code) {
	    this.iso3166Alpha3Code = alpha3Code;
	    return this;
	}
	public IsoCountryCode andNumericCode(int numericCode) {
	    this.iso3166NumericCode = numericCode;
	    return new IsoCountryCode(this.iso3166Alpha2Code, this.iso3166Alpha3Code, this.iso3166NumericCode);
	}
    }
    
    public static CountryCodeBuilder alpha2Code(String alpha2Code) {
	return new CountryCodeBuilder(alpha2Code);
    }

    private String iso3166Alpha2Code;
    private String iso3166Alpha3Code;
    private int iso3166NumericCode;

    private IsoCountryCode(String iso3166Alpha2Code, String iso3166Alpha3Code, int iso3166NumericCode) {
	super();
	Validate.notEmpty(iso3166Alpha2Code);
	Validate.notEmpty(iso3166Alpha3Code);
	this.iso3166Alpha2Code = iso3166Alpha2Code.toUpperCase();
	this.iso3166Alpha3Code = iso3166Alpha3Code.toUpperCase();
	this.iso3166NumericCode = iso3166NumericCode;
    }

    public String getIso3166Alpha2Code() {
	return iso3166Alpha2Code;
    }
    public String getIso3166Alpha3Code() {
	return iso3166Alpha3Code;
    }
    public int getIso3166NumericCode() {
	return iso3166NumericCode;
    }

    @Override
    public String toString() {
	return new ToStringBuilder(this,ToStringStyle.SHORT_PREFIX_STYLE)
		.append("alpha2", this.iso3166Alpha2Code)
		.append("alpha3", this.iso3166Alpha3Code)
		.append("numeric", this.iso3166NumericCode)
		.toString();
    }
    
    
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime
		* result
		+ ((iso3166Alpha2Code == null) ? 0 : iso3166Alpha2Code
			.hashCode());
	result = prime
		* result
		+ ((iso3166Alpha3Code == null) ? 0 : iso3166Alpha3Code
			.hashCode());
	result = prime * result + iso3166NumericCode;
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
	IsoCountryCode other = (IsoCountryCode) obj;
	if (iso3166Alpha2Code == null) {
	    if (other.iso3166Alpha2Code != null)
		return false;
	} else if (!iso3166Alpha2Code.equals(other.iso3166Alpha2Code))
	    return false;
	if (iso3166Alpha3Code == null) {
	    if (other.iso3166Alpha3Code != null)
		return false;
	} else if (!iso3166Alpha3Code.equals(other.iso3166Alpha3Code))
	    return false;
	if (iso3166NumericCode != other.iso3166NumericCode)
	    return false;
	return true;
    }

}
