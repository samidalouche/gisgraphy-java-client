package com.gisgraphy.client.continent;

import java.io.Serializable;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Represents a Continent (i.e. Europe, Asia..).
 * 
 * @see ContinentRepository
 */
public final class Continent implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public static Continent continent(String code) {
	return new Continent(code, code);
    }
    private String geonamesCode;
    private String geonamesName;

    /**
     * @param geonamesCode
     * @param geonamesName
     */
    private Continent(String geonamesCode, String geonamesName) {
	super();
	Validate.notEmpty(geonamesCode);
	Validate.notEmpty(geonamesName);
	this.geonamesCode = geonamesCode;
	this.geonamesName = geonamesName;
    }

   
    public String getCode() {
	return getGeonamesCode();
    }

    public String getGeonamesCode() {
	return this.geonamesCode;
    }
    
    public String getGeonamesName() {
	return this.geonamesName;
    }
    
    public String getName() {
	return getGeonamesName();
    }

    public Continent withCode(String code) {
	return new Continent(code, this.getName());
    }
    
    public Continent withName(String name) {
	return new Continent(this.getCode(), name);
    }
    
    
    @Override
    public int hashCode() {
	return new HashCodeBuilder()
		.append(geonamesCode)
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
	final Continent other = (Continent) obj;
	
	return new EqualsBuilder()
		.append(geonamesCode, other.getGeonamesCode())
		.isEquals();
    }
    
    @Override
    public String toString() {
	return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("code", this.getCode())
		.append("name", this.getName()).toString();
    }

}
