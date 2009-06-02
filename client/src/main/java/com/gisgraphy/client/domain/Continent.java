package com.gisgraphy.client.domain;

import java.io.Serializable;

import org.apache.commons.lang.Validate;

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
	final int PRIME = 31;
	int result = 1;
	result = PRIME * result
		+ ((geonamesCode == null) ? 0 : geonamesCode.hashCode());
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
	final Continent other = (Continent) obj;
	if (geonamesCode == null) {
	    if (other.geonamesCode != null)
		return false;
	} else if (!geonamesCode.equals(other.geonamesCode))
	    return false;
	return true;
    }

}
