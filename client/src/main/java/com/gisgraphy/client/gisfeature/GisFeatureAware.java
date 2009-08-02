package com.gisgraphy.client.gisfeature;

import com.gisgraphy.client.language.Iso639Language;
import com.google.common.collect.ImmutableSet;

public interface GisFeatureAware {

    Long getGeonamesId();
    
    String getGisFeatureOriginalName();

    ImmutableSet<AlternateGisFeatureName> getGisFeatureAlternateNames();

    /**
     * 
     * @param language
     * @return the preferred name if it exists, otherwise the default name
     */
    String getGisFeaturePreferredName(final Iso639Language language);

    /**
     * 
     * @param language
     * @return the short name if it exists, otherwise the default name 
     */
    String getGisFeatureShortName(final Iso639Language language);
    GisFeature getGisFeature();
    AdministrativeEntity getParentAdministrativeEntity();

}