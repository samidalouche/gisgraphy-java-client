package com.gisgraphy.client.administrativedivision;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.gisgraphy.client.domain.crap.OldGisFeature;
import com.gisgraphy.client.gisfeature.AdministrativeEntity;
import com.gisgraphy.client.gisfeature.AlternateGisFeatureName;
import com.gisgraphy.client.gisfeature.GisFeature;
import com.gisgraphy.client.gisfeature.GisFeatureAware;
import com.gisgraphy.client.language.IsoLanguage;
import com.google.common.collect.ImmutableSet;

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
public final class AdministrativeDivision implements AdministrativeEntity,GisFeatureAware {
    
    public static class AdministrativeDivisionBuilder {
	private String name;
	private String code;
	private GisFeature gisFeature;
	private AdministrativeEntity parentEntity;
	public AdministrativeDivisionBuilder(String name) {
	    this.name = name;
	}
	
	public AdministrativeDivisionBuilder withCode(String code) {
	    this.code = code;
	    return this;
	}
	
	public AdministrativeDivisionBuilder withGisFeature(GisFeature gisFeature) {
	    this.gisFeature = gisFeature;
	    return this;
	}
	
	public AdministrativeDivision andParentEntity(AdministrativeEntity administrativeEntity) {
	    this.parentEntity = administrativeEntity;
	    return new AdministrativeDivision(this.name, this.code, this.gisFeature, this.parentEntity);
	}
	
    }
    
    public static AdministrativeDivisionBuilder administrativeDivision(String name) {
	return new AdministrativeDivisionBuilder(name);
    }
    
    private String name;
    private String code;
    private GisFeature gisFeature;
    private AdministrativeEntity parentEntity;
    
    
    private AdministrativeDivision(String name, String code, GisFeature gisFeature, AdministrativeEntity parentEntity) {
	super();
	Validate.notEmpty(name);
	Validate.notEmpty(code);
	Validate.notNull(gisFeature);
	Validate.notNull(parentEntity);
	
	this.name = name;
	this.code = code;
	this.gisFeature = gisFeature;
	this.parentEntity = parentEntity;
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
        return parentEntity;
    }

    @Override
    public String toString() {
	return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("code", code)
		.append("name", name)
		.append("gisFeature", gisFeature)
		.append("parentEntity", parentEntity).toString();
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
	return parentEntity.getAdminitrativeDivisionLevel()+1;
    }

    public AdministrativeEntity getParentAdminitrativeEntity() {
	return parentEntity;
    }
    

    public ImmutableSet<AlternateGisFeatureName> getGisFeatureAlternateNames() {
	return gisFeature.getGisFeatureAlternateNames();
    }

    public String getGisFeatureAsciiName() {
	return gisFeature.getGisFeatureAsciiName();
    }

    public String getGisFeatureOriginalName() {
	return gisFeature.getGisFeatureOriginalName();
    }

    public String getGisFeaturePreferredName(IsoLanguage language) {
	return gisFeature.getGisFeaturePreferredName(language);
    }

    public String getGisFeatureShortName(IsoLanguage language) {
	return gisFeature.getGisFeatureShortName(language);
    }
    

}
