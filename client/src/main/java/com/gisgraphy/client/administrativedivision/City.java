package com.gisgraphy.client.administrativedivision;

import javax.measure.quantity.Length;
import javax.measure.unit.Unit;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.gisgraphy.client.commons.DistanceCalculator;
import com.gisgraphy.client.commons.NameFormatter;
import com.gisgraphy.client.commons.NamePart;
import com.gisgraphy.client.gisfeature.AdministrativeEntity;
import com.gisgraphy.client.gisfeature.AlternateGisFeatureName;
import com.gisgraphy.client.gisfeature.GeonamesGisFeature;
import com.gisgraphy.client.gisfeature.GisFeature;
import com.gisgraphy.client.gisfeature.GisFeatureType;
import com.gisgraphy.client.language.Iso639Language;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.ibm.icu.util.Currency;
import com.vividsolutions.jts.geom.Point;

public final class City implements Comparable<City>, GisFeature, DistanceCalculator<City>, AdministrativeEntity, CurrencyProvider {

    public static City forFeature(GeonamesGisFeature gisFeature) {
	return new City(gisFeature);
    }

    private GisFeature gisFeature;
    private DistanceCalculator<GisFeature> gisFeatureDistanceCalculator;

    private City(GeonamesGisFeature gisFeature) {
	super();
	Validate.notNull(gisFeature);
	shouldHaveParentAdministrativeEntity(gisFeature);
	this.gisFeature = gisFeature;
	this.gisFeatureDistanceCalculator = gisFeature;
    }


    /**
     * There are several cases where GISFeature's do not have any parent administrative entity :
     * <ul>
     * 	<li>Top-Level GISFeature (Country)</li>
     * <li>Features in the middle of international waters</li>
     * </ul>
     * 
     * In any case, it does not make sense to create a City out of these GIS Features
     * @param gisFeature
     */
    private void shouldHaveParentAdministrativeEntity(GeonamesGisFeature gisFeature) {
	Validate.notNull(gisFeature.getParentAdministrativeEntity());
    }

    public int compareTo(City o) {
	if (o == null) {
	    return 1;
	} else {
	    return this.getName().compareTo(o.getName());
	}
    }

    public String getName() {
	return getGisFeatureDefaultName();
    }


    @Override
    public int hashCode() {
	return new HashCodeBuilder()
		.append(gisFeature)
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
	City other = (City) obj;
	
	return new EqualsBuilder()
		.append(gisFeature, other.getGisFeature())
		.isEquals();
    }

    //// GisFeatureAware implementation ////
    public ImmutableSet<AlternateGisFeatureName> getGisFeatureAlternateNames() {
	return gisFeature.getGisFeatureAlternateNames();
    }

    public GisFeature getGisFeature() {
	return gisFeature;
    }
    public Long getGeonamesId() {
	return gisFeature.getGeonamesId();
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

    public AdministrativeEntity getParentAdministrativeEntity() {
	return gisFeature.getParentAdministrativeEntity();
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

    public DateTimeZone getTimeZone() {
	return gisFeature.getTimeZone();
    }


    //// DistanceAware ////
    public double distance(City o, Unit<Length> unit) {
	return gisFeatureDistanceCalculator.distance(o.getGisFeature(), unit);
    }

    //// AdministrativeEntity ////
    
    private AdministrativeEntityHierarchy administrativeEntityLevelProvider() {
	return new AdministrativeEntityHierarchy(new AdministrativeEntityHierarchy.AdministrativeEntityProvider() {
	    
	    public AdministrativeEntity getParentAdministrativeEntity() {
		return City.this.getParentAdministrativeEntity();
	    }
	    
	    public AdministrativeEntity getCurrentAdministrativeEntity() {
		return City.this;
	    }
	});
    }
    
    public AdministrativeEntity getAdministrativeEntity(int level) {
	return administrativeEntityLevelProvider().getAdministrativeEntity(level);
    }

    public int getAdminitrativeDivisionLevel() {
	return administrativeEntityLevelProvider().getAdminitrativeDivisionLevel();
    }

    public Country getCountry() {
	return gisFeature.getParentAdministrativeEntity().getCountry();
    }

    public Currency getCurrency() {
	return getCountry().getCurrency();
    }

    public ImmutableList<NamePart> getFullyQualifiedNameParts() {
	return gisFeature.getFullyQualifiedNameParts();
    }

    public String getFriendlyCode() {
	return null;
    }

    public String formatName(NameFormatter nameFormatter) {
	return nameFormatter.format(this);
    }

}
