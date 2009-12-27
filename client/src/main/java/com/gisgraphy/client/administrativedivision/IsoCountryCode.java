package com.gisgraphy.client.administrativedivision;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
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
	return new HashCodeBuilder()
		.append(iso3166Alpha2Code)
		.append(iso3166Alpha3Code)
		.append(iso3166NumericCode)
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
	IsoCountryCode other = (IsoCountryCode) obj;
	
	return new EqualsBuilder()
		.append(iso3166Alpha2Code, other.getIso3166Alpha2Code())
		.append(iso3166Alpha3Code, other.getIso3166Alpha3Code())
		.append(iso3166NumericCode, other.getIso3166NumericCode())
		.isEquals();
	
    }

}
