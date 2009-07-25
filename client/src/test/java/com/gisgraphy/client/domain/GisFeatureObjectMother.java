package com.gisgraphy.client.domain;

/**
 *
 * @author christophe
 */
public class GisFeatureObjectMother {
    public static final String FRANCE_FEATURE_CODE = "PCLI";
    public static final long FRANCE_FEATURE_ID = 3017382L;
    public static final String FRANCE_FEATURE_NAME = "France";
    public static final String FRANCE_FEATURE_CLASS = "A";

    public static final double FRANCE_LONGITUDE = 2.0;
    public static final double FRANCE_LATITUDE = 46.0;

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
                    .population(64094000L)
                    .build())
                .build();
    }

    public static GisFeature antarcticaGisFeature() {
        return GisFeature.gisFeature()
                .featureId(661485L)
                .featureName(GisFeatureName.name("Antarctica"))
                .featureType(new GisFeatureType("A", "PCLI"))
                .featureGeography(
                    GisFeatureGeography.gisFeatureGeography(0.0, 0.0)
                    .population(0L)
                    .build())
                .build();
    }

    /**
     *
     * @return
     */
    public static GisFeature usOutlyingIslandsGisFeature() {
        throw new UnsupportedOperationException();
    }
}
