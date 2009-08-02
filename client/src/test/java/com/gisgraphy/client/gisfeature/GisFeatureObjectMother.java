package com.gisgraphy.client.gisfeature;

import static com.gisgraphy.client.gisfeature.GisFeature.gisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureGeography.gisFeatureGeography;
import static com.gisgraphy.client.gisfeature.GisFeatureName.gisFeatureName;
import static com.gisgraphy.client.gisfeature.GisFeatureType.featureClass;

import com.gisgraphy.client.gisfeature.GisFeature;
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
    public static GisFeature franceGisFeature() {
        return gisFeature()
                .featureId(FRANCE_FEATURE_ID)
                .name(gisFeatureName(FRANCE_FEATURE_NAME))
                .type(featureClass(FRANCE_FEATURE_CLASS).featureCode(FRANCE_FEATURE_CODE))
                .geography(
                    GisFeatureGeography.gisFeatureGeography(FRANCE_LONGITUDE, FRANCE_LATITUDE)
                    .withPopulation(FRANCE_POPULATION))
                .build();
    }

    public static GisFeature antarcticaGisFeature() {
        return gisFeature()
                .featureId(ANTARCTICA_FEATURE_ID)
                .name(gisFeatureName(ANTARCTICA_FEATURE_NAME))
                .type(featureClass(ANTARCTICA_FEATURE_CLASS).featureCode(ANTARCTICA_FEATURE_CODE))
                .geography(
                    GisFeatureGeography.gisFeatureGeography(ANTARCTICA_LONGITUDE,ANTARCTICA_LATITUDE)
                    .withPopulation(ANTARCTICA_POPULATION))
                .build();
    }

    /**
     *
     * @return
     */
    public static GisFeature usOutlyingIslandsGisFeature() {
        return gisFeature()
                .featureId(US_OUTLYING_ISLANDS_FEATURE_ID)
                .name(gisFeatureName(US_OUTLYING_ISLANDS_FEATURE_NAME))
                .type(featureClass(US_OUTLYING_ISLANDS_FEATURE_CLASS).featureCode(US_OUTLYING_ISLANDS_FEATURE_CODE))
                .geography(
                    GisFeatureGeography.gisFeatureGeography(US_OUTLYING_ISLANDS_LONGITUDE, US_OUTLYING_ISLANDS_LATITUDE)
                    .withPopulation(US_OUTLYING_ISLANDS_POPULATION)
                    .withGtopo30AverageElevation(US_OUTLYING_ISLANDS_GTOPO30))
                .build();
    }
    
    public static GisFeature rambouilletAdm4GisFeature() {
	return gisFeature()
		.featureId(6444057L)
		.name(gisFeatureName("Rambouillet").withAsciiName("Rambouillet"))
		.type(featureClass("A").featureCode("ADM4"))
		.geography(
			gisFeatureGeography(new Double("1.8333332538604736"), new Double("48.650001525878906"))
			.withPopulation(0L))
		.build();
    }
    
    public static GisFeature arrondissementDeRambouilletAdm3GisFeature() {
	return gisFeature()
		.featureId(2984512L)
		.name(gisFeatureName("Rambouillet").withAsciiName("Rambouillet"))
		.type(featureClass("A").featureCode("ADM3"))
		.geography(
			gisFeatureGeography(new Double("1.9166667461395264"), new Double("48.58333206176758"))
			.withPopulation(0L))
		.build();
    }
    
    public static GisFeature yvelinesAdm2GisFeature() {
	return gisFeature()
		.featureId(2967196L)
		.name(gisFeatureName("Département des Yvelines").withAsciiName("Departement des Yvelines"))
		.type(featureClass("A").featureCode("ADM2"))
		.geography(
			gisFeatureGeography(new Double("1.8666666746139526"), new Double("48.78333282470703"))
			.withPopulation(1411761L)
			.withGtopo30AverageElevation(104L))
		.build();
    }
    
    public static GisFeature ileDeFranceAdm1GisFeature() {
	return gisFeature()
		.featureId(3012874L)
		.name(gisFeatureName("Région Île-de-France").withAsciiName("Region Ile-de-France"))
		.type(featureClass("A").featureCode("ADM1"))
		.geography(
			gisFeatureGeography(new Double("2.5"), new Double("48.5"))
			.withPopulation(11341257L))
		.build();
    }
}
