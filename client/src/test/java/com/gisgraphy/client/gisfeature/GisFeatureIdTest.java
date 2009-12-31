package com.gisgraphy.client.gisfeature;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;

import org.junit.Assert;
import org.junit.Test;

public class GisFeatureIdTest {

    @Test public void twoGisFeaturesIdsWithSameGeonamesIdShouldBeEqual() {
	GisFeatureId feature1 = new GisFeatureId(1L);
	GisFeatureId feature2 = new GisFeatureId(1L);
	Assert.assertEquals(feature1, feature2);
	Assert.assertEquals(feature1.hashCode(), feature2.hashCode());
    }
    
    @Test public void twoGisFeaturesIdsWithDifferentGeonamesIdShouldNotBeEqual() {
	GisFeatureId feature1 = new GisFeatureId(1L);
	GisFeatureId feature2 = new GisFeatureId(2L);
	Assert.assertThat(feature1, not(equalTo(feature2)));
	Assert.assertThat(feature1.hashCode(), not(equalTo(feature2.hashCode())));
    }
    
    @Test(expected=IllegalArgumentException.class) public void shouldNotCreateGisFeatureIdWithNullId() {
	new GisFeatureId(null);
    }
}
