package com.gisgraphy.client.gisfeature;

import org.joda.time.DateTime;
import org.junit.Assert;

import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.franceGisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.rambouilletAdm4GisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureType.geonamesFeatureClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.gisgraphy.client.gisfeature.GeonamesGisFeature;
import com.gisgraphy.client.gisfeature.GisFeatureGeography;
import com.gisgraphy.client.gisfeature.GisFeatureNames;

public class GeonamesGisFeatureTest {
    
    @Test
    public void shouldCreateFranceGisFeature() {
	GeonamesGisFeature france = GisFeatureObjectMother.franceGisFeature();
	assertEquals(france.getGeonamesFeatureClass(), "A");
	assertEquals(france.getGeonamesFeatureCode(), "PCLI");
	assertEquals(france.getGeonamesId().longValue(), 3017382L);
	assertEquals(france.getNames().getName(), "France");
	assertNotNull(france.getGeography());
	assertEquals(france.getGeography().getLocation().getCoordinate().x, 2.0, 0.0001);
	assertEquals(france.getGeography().getLocation().getCoordinate().y, 46.0, 0.0001);
	assertNotNull(france.getLastModificationDate());
    }

    @Test
    public void shouldCreateGisFeature() {
	GeonamesGisFeature.gisFeature()
            .geonamesId(1L)
            .names(GisFeatureNames.gisFeatureName("France"))
            .type(geonamesFeatureClass("A").geonamesFeatureCode("PLCI"))
            .geography(GisFeatureGeography.gisFeatureGeography(2.0, 46.0))
            .build();
    }

    @Test
    public void shouldCreateGisFeatureWithModificationDate() {
	GeonamesGisFeature.gisFeature()
            .geonamesId(1L)
            .names(GisFeatureNames.gisFeatureName("France"))
            .type(geonamesFeatureClass("A").geonamesFeatureCode("PLCI"))
            .geography(GisFeatureGeography.gisFeatureGeography(2.0, 46.0))
            .lastModificationDate(new DateTime())
            .build();
    }

    @Test
    public void shouldCreateGisFeatureWithNullParentEntity() {
	GeonamesGisFeature.gisFeature()
            .geonamesId(1L)
            .names(GisFeatureNames.gisFeatureName("France"))
            .type(geonamesFeatureClass("A").geonamesFeatureCode("PLCI"))
            .geography(GisFeatureGeography.gisFeatureGeography(2.0, 46.0))
            .lastModificationDate(new DateTime())
            .parentAdministrativeEntity(null)
            .build();
    }

    @Test
    public void shouldCreateGisFeatureWithNullModificationDate() {
	final GeonamesGisFeature gisFeature = GeonamesGisFeature.gisFeature()
            .geonamesId(1L)
            .names(GisFeatureNames.gisFeatureName("France"))
            .type(geonamesFeatureClass("A").geonamesFeatureCode("PLCI"))
            .geography(GisFeatureGeography.gisFeatureGeography(2.0, 46.0))
            .lastModificationDate(null)
            .build();
    Assert.assertNotNull(gisFeature.getLastModificationDate());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureWithNullFeatureId() {
	GeonamesGisFeature.gisFeature()
            .geonamesId(null)
            .names(GisFeatureNames.gisFeatureName("France"))
            .type(geonamesFeatureClass("A").geonamesFeatureCode("PLCI"))
            .geography(GisFeatureGeography.gisFeatureGeography(2.0, 46.0))
            .build();
    }
    
    

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureWithNullFeatureType() {
	GeonamesGisFeature.gisFeature()
            .geonamesId(1L)
            .names(GisFeatureNames.gisFeatureName("France"))
            .type(null)
            .geography(GisFeatureGeography.gisFeatureGeography(2.0, 46.0))
            .build();
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureWithNullGeography() {
	GeonamesGisFeature.gisFeature()
            .geonamesId(1L)
            .names(GisFeatureNames.gisFeatureName("France"))
            .type(geonamesFeatureClass("A").geonamesFeatureCode("PLCI"))
            .build();
    }
    
    @Test public void shouldReturnFullyQualifiedNamePartsForFeatureWithParentAdministrativeEntity() {
	Assert.assertEquals("[NamePart[name=France,friendlyCode=FR], NamePart[name=Région Île-de-France,friendlyCode=A8], NamePart[name=Département des Yvelines,friendlyCode=78], NamePart[name=Arrondissement de Rambouillet,friendlyCode=782], NamePart[name=Rambouillet,friendlyCode=<null>]]",rambouilletAdm4GisFeature().getFullyQualifiedNameParts().toString());
    }
    
    @Test public void shouldReturnFullyQualifiedNamePartsForFeatureWithoutParentAdministrativeEntity() {
	Assert.assertEquals("[NamePart[name=France,friendlyCode=<null>]]",franceGisFeature().getFullyQualifiedNameParts().toString());
    }
    
}
