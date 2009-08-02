package com.gisgraphy.client.gisfeature;

import com.gisgraphy.client.language.IsoLanguage;
import com.google.common.collect.ImmutableSet;

public interface GisFeatureAware {

    String getGisFeatureOriginalName();

    String getGisFeatureAsciiName();

    ImmutableSet<AlternateGisFeatureName> getGisFeatureAlternateNames();

    /**
     * 
     * @param language
     * @return the preferred name if it exists, otherwise the default name
     */
    String getGisFeaturePreferredName(final IsoLanguage language);

    /**
     * 
     * @param language
     * @return the short name if it exists, otherwise the default name 
     */
    String getGisFeatureShortName(final IsoLanguage language);
    
    AdministrativeEntity getParentAdministrativeEntity();

}