package com.gisgraphy.client.gisfeature;

import static com.gisgraphy.client.gisfeature.GisFeatureType.geonamesFeatureClass;

import org.junit.Test;

public class GisFeatureTypeTest {
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureTypeWithNullFeatureClass() {
	geonamesFeatureClass(null).geonamesFeatureCode("ADM2");
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureTypeWithEmptyFeatureClass() {
	geonamesFeatureClass("").geonamesFeatureCode("ADM2");
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureTypeWithNullFeatureCode() {
	geonamesFeatureClass("A").geonamesFeatureCode(null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureTypeWithEmptyFeatureCode() {
	geonamesFeatureClass("A").geonamesFeatureCode("");
    }
}
