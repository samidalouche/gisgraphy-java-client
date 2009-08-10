package com.gisgraphy.client.gisfeature;

import static com.gisgraphy.client.administrativedivision.AdministrativeDivisionObjectMother.arrondissementDeRambouilletAdm3;
import static com.gisgraphy.client.administrativedivision.AdministrativeDivisionObjectMother.ileDeFranceAdm1;
import static com.gisgraphy.client.administrativedivision.AdministrativeDivisionObjectMother.yvelinesAdm2;
import static com.gisgraphy.client.administrativedivision.CountryObjectMother.france;
import static com.gisgraphy.client.gisfeature.GeonamesGisFeature.gisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureGeography.gisFeatureGeography;
import static com.gisgraphy.client.gisfeature.GisFeatureGeographyObjectMother.arrondissementDeRambouilletAdm3GisFeatureGeography;
import static com.gisgraphy.client.gisfeature.GisFeatureGeographyObjectMother.ileDeFranceAdm1GisFeatureGeography;
import static com.gisgraphy.client.gisfeature.GisFeatureGeographyObjectMother.rambouilletAdm4GisFeatureGeography;
import static com.gisgraphy.client.gisfeature.GisFeatureGeographyObjectMother.yvelinesAdm2GisFeatureGeography;
import static com.gisgraphy.client.gisfeature.GisFeatureNames.gisFeatureName;
import static com.gisgraphy.client.gisfeature.GisFeatureType.geonamesFeatureClass;

import com.gisgraphy.client.administrativedivision.AdministrativeDivisionObjectMother;
import com.gisgraphy.client.administrativedivision.CountryObjectMother;
import com.gisgraphy.client.gisfeature.GeonamesGisFeature;
import com.gisgraphy.client.gisfeature.GisFeatureGeography;

/**
 *
 * @author christophe
 */
public class GisFeatureObjectMother {
    public static final String ANTARCTICA_FEATURE_CLASS = "A";
    public static final String ANTARCTICA_FEATURE_CODE = "PCLI";
    public static final long ANTARCTICA_FEATURE_ID = 661485L;
    public static final String ANTARCTICA_FEATURE_NAME = "Antarctica";
    public static final double ANTARCTICA_LATITUDE = 0.0;
    public static final double ANTARCTICA_LONGITUDE = 0.0;
    public static final long ANTARCTICA_POPULATION = 0L;
    
    public static final String FRANCE_FEATURE_CODE = "PCLI";
    public static final long FRANCE_FEATURE_ID = 3017382L;
    public static final String FRANCE_FEATURE_NAME = "France";
    public static final String FRANCE_FEATURE_CLASS = "A";
    public static final double FRANCE_LONGITUDE = 2.0;
    public static final double FRANCE_LATITUDE = 46.0;
    public static final long FRANCE_POPULATION = 64094000L;

    public static final String US_OUTLYING_ISLANDS_FEATURE_CLASS = "A";
    public static final String US_OUTLYING_ISLANDS_FEATURE_CODE = "ADMD";
    public static final long US_OUTLYING_ISLANDS_FEATURE_ID = 5854968L;
    public static final String US_OUTLYING_ISLANDS_FEATURE_NAME = "United States Minor Outlying Islands";
    public static final long US_OUTLYING_ISLANDS_GTOPO30 = -9999L;
    public static final double US_OUTLYING_ISLANDS_LONGITUDE = -162.072494506836;
    public static final double US_OUTLYING_ISLANDS_LATITUDE = 5.88111019134521;
    public static final long US_OUTLYING_ISLANDS_POPULATION = 0L;

    /**
     *
     * @return
     */
    public static GeonamesGisFeature franceGisFeature() {
        return gisFeature()
                .geonamesId(FRANCE_FEATURE_ID)
                .names(gisFeatureName(FRANCE_FEATURE_NAME))
                .type(geonamesFeatureClass(FRANCE_FEATURE_CLASS).geonamesFeatureCode(FRANCE_FEATURE_CODE))
                .geography(
                    GisFeatureGeography.gisFeatureGeography(FRANCE_LONGITUDE, FRANCE_LATITUDE)
                    .withPopulation(FRANCE_POPULATION))
                .build();
    }

    public static GeonamesGisFeature antarcticaGisFeature() {
        return gisFeature()
                .geonamesId(ANTARCTICA_FEATURE_ID)
                .names(gisFeatureName(ANTARCTICA_FEATURE_NAME))
                .type(geonamesFeatureClass(ANTARCTICA_FEATURE_CLASS).geonamesFeatureCode(ANTARCTICA_FEATURE_CODE))
                .geography(
                    GisFeatureGeography.gisFeatureGeography(ANTARCTICA_LONGITUDE,ANTARCTICA_LATITUDE)
                    .withPopulation(ANTARCTICA_POPULATION))
                .build();
    }

    /**
     *
     * @return
     */
    public static GeonamesGisFeature usOutlyingIslandsGisFeature() {
        return gisFeature()
                .geonamesId(US_OUTLYING_ISLANDS_FEATURE_ID)
                .names(gisFeatureName(US_OUTLYING_ISLANDS_FEATURE_NAME))
                .type(geonamesFeatureClass(US_OUTLYING_ISLANDS_FEATURE_CLASS).geonamesFeatureCode(US_OUTLYING_ISLANDS_FEATURE_CODE))
                .geography(
                    GisFeatureGeography.gisFeatureGeography(US_OUTLYING_ISLANDS_LONGITUDE, US_OUTLYING_ISLANDS_LATITUDE)
                    .withPopulation(US_OUTLYING_ISLANDS_POPULATION)
                    .withGtopo30AverageElevation(US_OUTLYING_ISLANDS_GTOPO30))
                .build();
    }
    
    public static GeonamesGisFeature rambouilletAdm4GisFeature() {
	return gisFeature()
		.geonamesId(6444057L)
		.names(gisFeatureName("Rambouillet").withAsciiName("Rambouillet"))
		.type(geonamesFeatureClass("A").geonamesFeatureCode("ADM4"))
		.parentAdministrativeEntity(arrondissementDeRambouilletAdm3())
		.geography(rambouilletAdm4GisFeatureGeography())
		.build();
    }
    
    public static GeonamesGisFeature arrondissementDeRambouilletAdm3GisFeature() {
	return gisFeature()
		.geonamesId(2984512L)
		.names(gisFeatureName("Rambouillet").withAsciiName("Rambouillet"))
		.type(geonamesFeatureClass("A").geonamesFeatureCode("ADM3"))
		.parentAdministrativeEntity(yvelinesAdm2())
		.geography(arrondissementDeRambouilletAdm3GisFeatureGeography())
		.build();
    }
    
    public static GeonamesGisFeature yvelinesAdm2GisFeature() {
	return gisFeature()
		.geonamesId(2967196L)
		.names(gisFeatureName("Département des Yvelines").withAsciiName("Departement des Yvelines"))
		.type(geonamesFeatureClass("A").geonamesFeatureCode("ADM2"))
		.parentAdministrativeEntity(ileDeFranceAdm1())
		.geography(yvelinesAdm2GisFeatureGeography())
		.build();
    }
    
    public static GeonamesGisFeature ileDeFranceAdm1GisFeature() {
	return gisFeature()
		.geonamesId(3012874L)
		.names(gisFeatureName("Région Île-de-France").withAsciiName("Region Ile-de-France"))
		.type(geonamesFeatureClass("A").geonamesFeatureCode("ADM1"))
		.parentAdministrativeEntity(france())
		.geography(ileDeFranceAdm1GisFeatureGeography())
		.build();
    }
    
    
}
