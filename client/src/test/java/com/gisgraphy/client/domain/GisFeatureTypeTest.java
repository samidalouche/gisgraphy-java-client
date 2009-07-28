package com.gisgraphy.client.domain;

import org.junit.Test;

public class GisFeatureTypeTest {
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureTypeWithNullFeatureClass() {
	new GisFeatureType(null, "PLCI");
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureTypeWithEmptyFeatureClass() {
	new GisFeatureType("", "PLCI");
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureTypeWithNullFeatureCode() {
	new GisFeatureType("A", null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureTypeWithEmptyFeatureCode() {
	new GisFeatureType("A", "");
    }
}
