package com.gisgraphy.client.gisfeature;

import static com.gisgraphy.client.gisfeature.GisFeatureType.featureClass;

import org.junit.Test;

public class GisFeatureTypeTest {
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureTypeWithNullFeatureClass() {
	featureClass(null).geonamesFeatureCode("ADM2");
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureTypeWithEmptyFeatureClass() {
	featureClass("").geonamesFeatureCode("ADM2");
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureTypeWithNullFeatureCode() {
	featureClass("A").geonamesFeatureCode(null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureTypeWithEmptyFeatureCode() {
	featureClass("A").geonamesFeatureCode("");
    }
}
