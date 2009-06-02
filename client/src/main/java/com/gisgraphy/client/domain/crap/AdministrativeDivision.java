/**
 *
 */
package com.gisgraphy.client.domain.crap;

import java.io.Serializable;


/**
 * <p>
 * Represents a (sub) division of a {@link OldCountry}. To KISS, here is an
 * example :
 * </p>
 * 
 * <p>
 * The U.S. Country is divided into States, and each state is divided into
 * Counties. Each state is going to be a {@link AdministrativeDivision} instance
 * that refers to the U.S. {@link OldCountry} as its
 * {@link AdministrativeDivision#parentEntity}, and each Country results in a
 * {@link AdministrativeDivision} that refers to its parent State ({@link AdministrativeDivision})
 * as its {@link AdministrativeDivision#parentEntity}.
 * </p>
 * 
 * <p>
 * In France, it is the same with Régions, Départements, Cantons, Communes...
 * </p>
 * 
 * <p>
 * For now, All Administrative Divisions come from Geonames, so there is no
 * feature Source.
 * </p>
 * 
 * @author Sami Dalouche (sami.dalouche@gmail.com)
 */
public class AdministrativeDivision extends AbstractAdministrativeEntity
	implements Serializable {
    private static final long serialVersionUID = 1L;

    private String asciiName;

    private String code;

    private String name;

    /**
     * 
     */
    public AdministrativeDivision() {
	super();
    }

    public AdministrativeDivision(AbstractAdministrativeEntity parentEntity,
	    String code, String name) {
	super();
	this.parentEntity = parentEntity;
	this.code = code;
	this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	final AdministrativeDivision other = (AdministrativeDivision) obj;
	if (code == null) {
	    if (other.code != null)
		return false;
	} else if (!code.equals(other.code))
	    return false;
	if (getCountryIso3166Alpha3Code() == null) {
	    if (other.getCountryIso3166Alpha3Code() != null)
		return false;
	} else if (!getCountryIso3166Alpha3Code().equals(
		other.getCountryIso3166Alpha3Code()))
	    return false;
	return true;
    }

    @Override
    public int getAdminitrativeDivisionLevel() {
	int r = 0;
	if (getParentEntity() != null) {
	    r = getParentEntity().getAdminitrativeDivisionLevel() + 1;
	}
	return r;
    }

    public String getAsciiName() {
	return asciiName;
    }

    /**
     * The Second Order geonamesCode. It is relative (and unique among) to the
     * feature Source ({@link OldGisFeature#getFeatureSource()})
     * 
     * For the US, it is the FIPS State/County geonamesCode
     * http://en.wikipedia.org/wiki/List_of_FIPS_region_codes
     * 
     * @return Returns the geonamesCode.
     */
    public String getCode() {
	return this.code;
    }

    @Override
    public String getDisplayableCode() {
	return code;
    }

    @Override
    public String getDisplayableName() {
	return getName();
    }

    /**
     * http://en.wikipedia.org/wiki/List_of_FIPS_region_codes
     * 
     * For the US: represents the state/county geonamesName
     * 
     * @return Returns the geonamesName.
     */
    public String getName() {
	return this.name;
    }

    @Override
    public int hashCode() {
	final int PRIME = 31;
	int result = 1;
	result = PRIME * result + ((code == null) ? 0 : code.hashCode());
	result = PRIME
		* result
		+ ((getCountryIso3166Alpha3Code() == null) ? 0
			: getCountryIso3166Alpha3Code().hashCode());
	return result;
    }

    public void setAsciiName(String asciiName) {
	this.asciiName = asciiName;
    }

    /**
     * @param code
     *                The geonamesCode to set.
     */
    public void setCode(String fipsCode) {
	this.code = fipsCode;
    }

    /**
     * @param name
     *                The geonamesName to set.
     */
    public void setName(String fipsName) {
	this.name = fipsName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return (this.parentEntity.toString() + "," + this.code).toString();
    }

    /**
     * Returns the AdministrativeDivision's country ISO Alpha3 Code
     * 
     * @return
     */
    private String getCountryIso3166Alpha3Code() {
	return null;
	//return getCountry().getIso3166Alpha3Code();
    }

    @Override
    public AbstractAdministrativeEntity getParentAdm(int level) {
	if (this.getAdminitrativeDivisionLevel() == level) return this;
	return this.parentEntity.getParentAdm(level);
    }
}
