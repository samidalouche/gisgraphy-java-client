package com.gisgraphy.client.domain;

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
        return GisFeature.gisFeature()
                .featureId(FRANCE_FEATURE_ID)
                .featureName(GisFeatureName.name(FRANCE_FEATURE_NAME))
                .featureType(new GisFeatureType(FRANCE_FEATURE_CLASS,FRANCE_FEATURE_CODE))
                .featureGeography(
                    GisFeatureGeography.gisFeatureGeography(FRANCE_LONGITUDE, FRANCE_LATITUDE)
                    .population(FRANCE_POPULATION)
                    .build())
                .build();
    }

    public static GisFeature antarcticaGisFeature() {
        return GisFeature.gisFeature()
                .featureId(ANTARCTICA_FEATURE_ID)
                .featureName(GisFeatureName.name(ANTARCTICA_FEATURE_NAME))
                .featureType(new GisFeatureType(ANTARCTICA_FEATURE_CLASS,ANTARCTICA_FEATURE_CODE))
                .featureGeography(
                    GisFeatureGeography.gisFeatureGeography(ANTARCTICA_LONGITUDE,ANTARCTICA_LATITUDE)
                    .population(ANTARCTICA_POPULATION)
                    .build())
                .build();
    }

    /**
     *
     * @return
     */
    public static GisFeature usOutlyingIslandsGisFeature() {
        return GisFeature.gisFeature()
                .featureId(US_OUTLYING_ISLANDS_FEATURE_ID)
                .featureName(GisFeatureName.name(US_OUTLYING_ISLANDS_FEATURE_NAME))
                .featureType(new GisFeatureType(US_OUTLYING_ISLANDS_FEATURE_CLASS,US_OUTLYING_ISLANDS_FEATURE_CODE))
                .featureGeography(
                    GisFeatureGeography.gisFeatureGeography(US_OUTLYING_ISLANDS_LONGITUDE, US_OUTLYING_ISLANDS_LATITUDE)
                    .population(US_OUTLYING_ISLANDS_POPULATION)
                    .gtopo30AverageElevation(US_OUTLYING_ISLANDS_GTOPO30)
                    .build())
                .build();
    }
}
