package com.gisgraphy.client.gisfeature;

import com.gisgraphy.client.language.Iso639Language;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

public interface NameProvider {
    String getName();
    /**
     * 
     * @return the feature default name, that may or may not contain non-ascii characters
     */
    String getGisFeatureDefaultName();

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
    /**
     * return the fully qualified name as a list, ordered by administrative division level
     * @return
     */
    ImmutableList<String> getFullyQualifiedNameParts();
}
