package com.gisgraphy.client.gisfeature;

import com.gisgraphy.client.commons.DistanceCalculator;

public interface GisFeatureProvider {
    
    /**
     * Might involve network requests
     * @return
     */
    GisFeature getGisFeature();
    
    /**
     * Might involve network requests
     * @return
     */
    DistanceCalculator<GisFeature> getGisFeatureDistanceCalculator();
    
    /**
     * Efficient (in memory) access to the GisFeature ID
     * @return
     */
    GisFeatureId getGisFeatureId();
    
    /**
     * Efficient (in memory) hashCode() that does not force to retrieve the actual GisFeature
     * @return
     */
    int gisFeatureHashCode();
    
    /**
     * Efficient (in memory) equals() that does not force to retrieve the actual GisFeature
     * @param gisFeatureProvider
     * @return
     */
    boolean gisFeatureEquals(GisFeatureProvider gisFeatureProvider);
}
