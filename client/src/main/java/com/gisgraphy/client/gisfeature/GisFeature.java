package com.gisgraphy.client.gisfeature;

import org.joda.time.DateTime;

import com.gisgraphy.client.language.Iso639Language;
import com.google.common.collect.ImmutableSet;
import com.vividsolutions.jts.geom.Point;

public interface GisFeature extends NameProvider {

    /**
     * @return the stable, geonames-provided ID for the given feature
     */
    Long getGeonamesId();    
    
    /**
     * @return the GIS Feature itself
     */
    GisFeature getGisFeature();
    
    Long getElevation();
    Long getGtopo30AverageElevation();
    Point getLocation();
    double getLatitude();
    double getLongitude();
    Long getPopulation();
    String getTimeZone();
    DateTime getLastModificationDate();
    
    GisFeatureType getGisFeatureType();

    /**
     * 
     * @return null if no parent administrative entity
     */
    AdministrativeEntity getParentAdministrativeEntity();
}