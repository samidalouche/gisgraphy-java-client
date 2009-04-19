package com.gisgraphy.client.domain;

import java.io.Serializable;

/**
 * Represents a Continent (i.e. Europe, Asia..). The continents have been
 * imported from Geonames Continent List, so it is not necessary to have a
 * featureSource, since it's always Geonames.
 * 
 * Code is written Upper case !!
 * 
 * @author Sami Dalouche (sami.dalouche@gmail.com)
 * 
 */
public class Continent implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * @see #getGeonamesCode()
     */
    private String geonamesCode;

    /**
     * @see #getGeonamesName()
     */
    private String geonamesName;

    /**
     * @see #getId()
     */
    private Long id;

    /**
     * @param geonamesCode
     * @param geonamesName
     */
    public Continent(String geonamesCode, String geonamesName) {
	super();
	this.geonamesCode = geonamesCode;
	this.geonamesName = geonamesName;
    }

    /**
     * 
     */
    @SuppressWarnings("unused")
    private Continent() {
	super();
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

    /**
     * 
     * @return
     */
    public String getGeonamesCode() {
	return this.geonamesCode;
    }

    public String getGeonamesName() {
	return this.geonamesName;
    }

    public Long getId() {
	return this.id;
    }

    @Override
    public int hashCode() {
	final int PRIME = 31;
	int result = 1;
	result = PRIME * result
		+ ((geonamesCode == null) ? 0 : geonamesCode.hashCode());
	return result;
    }

    /**
     * @see #getGeonamesCode()
     * @param geonamesCode
     */
    public void setGeonamesCode(String geonamesCode) {
	this.geonamesCode = geonamesCode;
    }

    /**
     * @see #getGeonamesName()
     * @param geonamesName
     */
    public void setGeonamesName(String geonamesName) {
	this.geonamesName = geonamesName;
    }

    /**
     * @see #getId()
     * @param id
     */
    public void setId(Long id) {
	this.id = id;
    }

}
