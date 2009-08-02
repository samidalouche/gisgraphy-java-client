package com.gisgraphy.client.copy;

import static com.gisgraphy.client.gisfeature.GisFeatureType.featureClass;

import org.junit.Test;

public class GisFeatureTypeTest {
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureTypeWithNullFeatureClass() {
	featureClass(null).featureCode("ADM2");
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureTypeWithEmptyFeatureClass() {
	featureClass("").featureCode("ADM2");
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureTypeWithNullFeatureCode() {
	featureClass("A").featureCode(null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureTypeWithEmptyFeatureCode() {
	featureClass("A").featureCode("");
    }
}
