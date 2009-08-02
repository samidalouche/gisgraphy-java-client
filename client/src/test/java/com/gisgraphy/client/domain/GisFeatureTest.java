package com.gisgraphy.client.domain;

import org.joda.time.DateTime;
import org.junit.Assert;

import static com.gisgraphy.client.domain.GisFeatureType.featureClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class GisFeatureTest {
    
    @Test
    public void shouldCreateFranceGisFeature() {
	GisFeature france = GisFeatureObjectMother.franceGisFeature();
	assertEquals(france.getFeatureClass(), GisFeatureObjectMother.FRANCE_FEATURE_CLASS);
	assertEquals(france.getFeatureCode(), GisFeatureObjectMother.ANTARCTICA_FEATURE_CODE);
	assertEquals(france.getFeatureId().longValue(), GisFeatureObjectMother.FRANCE_FEATURE_ID);
	assertEquals(france.getName().getName(), GisFeatureObjectMother.FRANCE_FEATURE_NAME);
	assertNotNull(france.getGeography());
	assertEquals(france.getGeography().getLocation().getCoordinate().x, GisFeatureObjectMother.FRANCE_LONGITUDE, 0.0001);
	assertEquals(france.getGeography().getLocation().getCoordinate().y, GisFeatureObjectMother.FRANCE_LATITUDE, 0.0001);
	assertNotNull(france.getLastModificationDate());
    }

    public void shouldCreateGisFeature() {
	GisFeature.gisFeature()
            .featureId(1L)
            .name(GisFeatureName.gisFeatureName("France"))
            .type(featureClass("A").featureCode("PLCI"))
            .geography(GisFeatureGeography.gisFeatureGeography(GisFeatureObjectMother.FRANCE_LONGITUDE, GisFeatureObjectMother.FRANCE_LATITUDE))
            .build();
    }

    public void shouldCreateGisFeatureWithModificationDate() {
	GisFeature.gisFeature()
            .featureId(1L)
            .name(GisFeatureName.gisFeatureName("France"))
            .type(featureClass("A").featureCode("PLCI"))
            .geography(GisFeatureGeography.gisFeatureGeography(GisFeatureObjectMother.FRANCE_LONGITUDE, GisFeatureObjectMother.FRANCE_LATITUDE))
            .lastModificationDate(new DateTime())
            .build();
    }

    public void shouldCreateGisFeatureWithNullParentEntity() {
	GisFeature.gisFeature()
            .featureId(1L)
            .name(GisFeatureName.gisFeatureName("France"))
            .type(featureClass("A").featureCode("PLCI"))
            .geography(GisFeatureGeography.gisFeatureGeography(GisFeatureObjectMother.FRANCE_LONGITUDE, GisFeatureObjectMother.FRANCE_LATITUDE))
            .lastModificationDate(new DateTime())
            .parentEntity(null)
            .build();
    }

    public void shouldCreateGisFeatureWithNullModificationDate() {
	final GisFeature gisFeature = GisFeature.gisFeature()
            .featureId(1L)
            .name(GisFeatureName.gisFeatureName("France"))
            .type(featureClass("A").featureCode("PLCI"))
            .geography(GisFeatureGeography.gisFeatureGeography(GisFeatureObjectMother.FRANCE_LONGITUDE, GisFeatureObjectMother.FRANCE_LATITUDE))
            .lastModificationDate(null)
            .build();
    Assert.assertNotNull(gisFeature.getLastModificationDate());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureWithNullFeatureId() {
	GisFeature.gisFeature()
            .featureId(null)
            .name(GisFeatureName.gisFeatureName("France"))
            .type(featureClass("A").featureCode("PLCI"))
            .geography(GisFeatureGeography.gisFeatureGeography(GisFeatureObjectMother.FRANCE_LONGITUDE, GisFeatureObjectMother.FRANCE_LATITUDE))
            .build();
    }
    
    

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureWithNullFeatureType() {
	GisFeature.gisFeature()
            .featureId(1L)
            .name(GisFeatureName.gisFeatureName("France"))
            .type(null)
            .geography(GisFeatureGeography.gisFeatureGeography(GisFeatureObjectMother.FRANCE_LONGITUDE, GisFeatureObjectMother.FRANCE_LATITUDE))
            .build();
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureWithNullGeography() {
	GisFeature.gisFeature()
            .featureId(1L)
            .name(GisFeatureName.gisFeatureName("France"))
            .type(featureClass("A").featureCode("PLCI"))
            .build();
    }
    
}
