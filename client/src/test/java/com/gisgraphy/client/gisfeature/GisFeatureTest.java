package com.gisgraphy.client.gisfeature;

import org.joda.time.DateTime;
import org.junit.Assert;

import static com.gisgraphy.client.gisfeature.GisFeatureType.geonamesFeatureClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.gisgraphy.client.gisfeature.GeonamesGisFeature;
import com.gisgraphy.client.gisfeature.GisFeatureGeography;
import com.gisgraphy.client.gisfeature.GisFeatureName;

public class GisFeatureTest {
    
    @Test
    public void shouldCreateFranceGisFeature() {
	GeonamesGisFeature france = GisFeatureObjectMother.franceGisFeature();
	assertEquals(france.getGeonamesFeatureClass(), GisFeatureObjectMother.FRANCE_FEATURE_CLASS);
	assertEquals(france.getGeonamesFeatureCode(), GisFeatureObjectMother.ANTARCTICA_FEATURE_CODE);
	assertEquals(france.getGeonamesId().longValue(), GisFeatureObjectMother.FRANCE_FEATURE_ID);
	assertEquals(france.getName().getName(), GisFeatureObjectMother.FRANCE_FEATURE_NAME);
	assertNotNull(france.getGeography());
	assertEquals(france.getGeography().getLocation().getCoordinate().x, GisFeatureObjectMother.FRANCE_LONGITUDE, 0.0001);
	assertEquals(france.getGeography().getLocation().getCoordinate().y, GisFeatureObjectMother.FRANCE_LATITUDE, 0.0001);
	assertNotNull(france.getLastModificationDate());
    }

    public void shouldCreateGisFeature() {
	GeonamesGisFeature.gisFeature()
            .geonamesId(1L)
            .name(GisFeatureName.gisFeatureName("France"))
            .type(geonamesFeatureClass("A").geonamesFeatureCode("PLCI"))
            .geography(GisFeatureGeography.gisFeatureGeography(GisFeatureObjectMother.FRANCE_LONGITUDE, GisFeatureObjectMother.FRANCE_LATITUDE))
            .build();
    }

    public void shouldCreateGisFeatureWithModificationDate() {
	GeonamesGisFeature.gisFeature()
            .geonamesId(1L)
            .name(GisFeatureName.gisFeatureName("France"))
            .type(geonamesFeatureClass("A").geonamesFeatureCode("PLCI"))
            .geography(GisFeatureGeography.gisFeatureGeography(GisFeatureObjectMother.FRANCE_LONGITUDE, GisFeatureObjectMother.FRANCE_LATITUDE))
            .lastModificationDate(new DateTime())
            .build();
    }

    public void shouldCreateGisFeatureWithNullParentEntity() {
	GeonamesGisFeature.gisFeature()
            .geonamesId(1L)
            .name(GisFeatureName.gisFeatureName("France"))
            .type(geonamesFeatureClass("A").geonamesFeatureCode("PLCI"))
            .geography(GisFeatureGeography.gisFeatureGeography(GisFeatureObjectMother.FRANCE_LONGITUDE, GisFeatureObjectMother.FRANCE_LATITUDE))
            .lastModificationDate(new DateTime())
            .parentAdministrativeEntity(null)
            .build();
    }

    public void shouldCreateGisFeatureWithNullModificationDate() {
	final GeonamesGisFeature gisFeature = GeonamesGisFeature.gisFeature()
            .geonamesId(1L)
            .name(GisFeatureName.gisFeatureName("France"))
            .type(geonamesFeatureClass("A").geonamesFeatureCode("PLCI"))
            .geography(GisFeatureGeography.gisFeatureGeography(GisFeatureObjectMother.FRANCE_LONGITUDE, GisFeatureObjectMother.FRANCE_LATITUDE))
            .lastModificationDate(null)
            .build();
    Assert.assertNotNull(gisFeature.getLastModificationDate());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureWithNullFeatureId() {
	GeonamesGisFeature.gisFeature()
            .geonamesId(null)
            .name(GisFeatureName.gisFeatureName("France"))
            .type(geonamesFeatureClass("A").geonamesFeatureCode("PLCI"))
            .geography(GisFeatureGeography.gisFeatureGeography(GisFeatureObjectMother.FRANCE_LONGITUDE, GisFeatureObjectMother.FRANCE_LATITUDE))
            .build();
    }
    
    

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureWithNullFeatureType() {
	GeonamesGisFeature.gisFeature()
            .geonamesId(1L)
            .name(GisFeatureName.gisFeatureName("France"))
            .type(null)
            .geography(GisFeatureGeography.gisFeatureGeography(GisFeatureObjectMother.FRANCE_LONGITUDE, GisFeatureObjectMother.FRANCE_LATITUDE))
            .build();
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureWithNullGeography() {
	GeonamesGisFeature.gisFeature()
            .geonamesId(1L)
            .name(GisFeatureName.gisFeatureName("France"))
            .type(geonamesFeatureClass("A").geonamesFeatureCode("PLCI"))
            .build();
    }
    
}
