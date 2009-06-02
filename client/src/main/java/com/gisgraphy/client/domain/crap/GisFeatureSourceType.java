/**
 *
 */
package com.gisgraphy.client.domain.crap;

/**
 * @author Sami Dalouche (sami.dalouche@gmail.com) THe source of a Feature. A
 *         FeatureID is relative to a Feature Source
 */
public enum GisFeatureSourceType {
    /**
     * Home-made feature source
     */
    FUNALA,
    /**
     * GeoNames.org
     */
    GEONAMES;
    
    public static GisFeatureSourceType defaultFeatureSourceType() {
	return GEONAMES;
    }
}
