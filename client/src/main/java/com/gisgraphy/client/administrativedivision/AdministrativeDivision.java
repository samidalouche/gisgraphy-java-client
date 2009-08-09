package com.gisgraphy.client.administrativedivision;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.joda.time.DateTime;

import com.gisgraphy.client.gisfeature.AdministrativeEntity;
import com.gisgraphy.client.gisfeature.AlternateGisFeatureName;
import com.gisgraphy.client.gisfeature.GisFeature;
import com.gisgraphy.client.gisfeature.GisFeatureType;
import com.gisgraphy.client.language.Iso639Language;
import com.google.common.collect.ImmutableSet;
import com.ibm.icu.util.Currency;
import com.vividsolutions.jts.geom.Point;

/**
 * <p>
 * Represents a (sub) division of a {@link Country}. To KISS, here is an
 * example :
 * </p>
 * 
 * <p>
 * The U.S. Country is divided into States, and each state is divided into
 * Counties. Each state is going to be a {@link AdministrativeDivision} instance
 * that refers to the U.S. {@link Country} as its
 * {@link AdministrativeDivision#parentEntity}, and each state results in a
 * {@link AdministrativeDivision} (county) that refers to its parent State ({@link AdministrativeDivision})
 * as its {@link AdministrativeDivision#parentEntity}.
 * </p>
 * 
 * <p>
 * In France, it is the same with Régions, Départements, Cantons, Communes...
 * </p>
 * 
 * @author Sami Dalouche (sami.dalouche@gmail.com)
 */
public final class AdministrativeDivision implements AdministrativeEntity,GisFeature, CurrencyProvider {
    
    public static class AdministrativeDivisionBuilder {
	private String name;
	private String code;
	private GisFeature gisFeature;
	public AdministrativeDivisionBuilder(String name) {
	    this.name = name;
	}
	
	public AdministrativeDivisionBuilder withCode(String code) {
	    this.code = code;
	    return this;
	}
	
	public AdministrativeDivision andGisFeature(GisFeature gisFeature) {
	    this.gisFeature = gisFeature;
	    return new AdministrativeDivision(this.name, this.code, this.gisFeature);
	}
	
    }
    
    public static AdministrativeDivisionBuilder administrativeDivision(String name) {
	return new AdministrativeDivisionBuilder(name);
    }
    
    private String name;
    private String code;
    private GisFeature gisFeature;
    
    
    private AdministrativeDivision(String name, String code, GisFeature gisFeature) {
	super();
	Validate.notEmpty(name);
	Validate.notEmpty(code);
	Validate.notNull(gisFeature);
	Validate.notNull(gisFeature.getParentAdministrativeEntity());
	
	this.name = name;
	this.code = code;
	this.gisFeature = gisFeature;
    }

    public String getName() {
        return name;
    }
    
    /**
     * Geonames ADM code. 
     * 
     * For the US, it is the FIPS State/County geonamesCode
     * http://en.wikipedia.org/wiki/List_of_FIPS_region_codes
     * 
     * @return Returns the geonamesCode.
     */
    public String getCode() {
        return code;
    }
    public GisFeature getGisFeature() {
        return gisFeature;
    }
    public AdministrativeEntity getParentEntity() {
        return gisFeature.getParentAdministrativeEntity();
    }

    @Override
    public String toString() {
	return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("code", code)
		.append("name", name)
		.append("gisFeature", gisFeature)
		.toString();
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((gisFeature == null) ? 0 : gisFeature.hashCode());
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
	AdministrativeDivision other = (AdministrativeDivision) obj;
	if (gisFeature == null) {
	    if (other.gisFeature != null)
		return false;
	} else if (!gisFeature.equals(other.gisFeature))
	    return false;
	return true;
    }

    public int getAdminitrativeDivisionLevel() {
	return getParentAdministrativeEntity().getAdminitrativeDivisionLevel()+1;
    }

    public AdministrativeEntity getParentAdministrativeEntity() {
	return gisFeature.getParentAdministrativeEntity();
    }
    
    public AdministrativeEntity getAdministrativeEntity(int level) {
	int currentLevel = getAdminitrativeDivisionLevel();
	if(level > currentLevel) {
	    throw new IllegalArgumentException(String.format("Current Level (%s) is lower than requested Level (%s)", currentLevel, level));
	} else if(level == currentLevel) {
	    return this;
	} else {
	    return getParentAdministrativeEntity().getAdministrativeEntity(level);
	}
    } 
    
    public Long getGeonamesId() {
	return gisFeature.getGeonamesId();
    }
    
    public ImmutableSet<AlternateGisFeatureName> getGisFeatureAlternateNames() {
	return gisFeature.getGisFeatureAlternateNames();
    }

    public String getGisFeatureDefaultName() {
	return gisFeature.getGisFeatureDefaultName();
    }

    public String getGisFeaturePreferredName(Iso639Language language) {
	return gisFeature.getGisFeaturePreferredName(language);
    }

    public String getGisFeatureShortName(Iso639Language language) {
	return gisFeature.getGisFeatureShortName(language);
    }

    public Country getCountry() {
	return getParentAdministrativeEntity().getCountry();
    }
    public Long getElevation() {
	return gisFeature.getElevation();
    }

    public GisFeatureType getGisFeatureType() {
	return gisFeature.getGisFeatureType();
    }

    public Long getGtopo30AverageElevation() {
	return gisFeature.getGtopo30AverageElevation();
    }

    public DateTime getLastModificationDate() {
	return gisFeature.getLastModificationDate();
    }

    public double getLatitude() {
	return gisFeature.getLatitude();
    }

    public Point getLocation() {
	return gisFeature.getLocation();
    }

    public double getLongitude() {
	return gisFeature.getLongitude();
    }

    public Long getPopulation() {
	return gisFeature.getPopulation();
    }

    public String getTimeZone() {
	return gisFeature.getTimeZone();
    }

    public Currency getCurrency() {
	return getCountry().getCurrency();
    }
    
    

}
