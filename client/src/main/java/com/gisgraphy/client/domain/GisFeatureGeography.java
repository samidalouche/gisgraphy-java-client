package com.gisgraphy.client.domain;

import com.vividsolutions.jts.geom.Geometry;

/**
 *
 * @author christophe
 */
class GisFeatureGeography {
    private Geometry location;
    private Long elevation;
    private Long gtopo30AverageElevation;
    private Long population;
    private String timeZone;
    
    private GisFeatureGeography() {
        
    }

    public static GisFeatureGeographyBuilder gisFeatureGeography(final Geometry location) {
        return new GisFeatureGeographyBuilder(location);
    }

    private static class GisFeatureGeographyBuilder {
        private GisFeatureGeography geography;

        public GisFeatureGeographyBuilder(final Geometry location) {
            geography = new GisFeatureGeography();
            geography.location = location;
        }

        public GisFeatureGeographyBuilder elevation(final Long elevation) {
            geography.elevation = elevation;
            return this;
        }

        public GisFeatureGeographyBuilder gtopo30AverageElevation(final Long gtopo30AverageElevation) {
            geography.gtopo30AverageElevation = gtopo30AverageElevation;
            return this;
        }

        public GisFeatureGeographyBuilder population(final Long population) {
            geography.population = population;
            return this;
        }

        public GisFeatureGeographyBuilder timeZone(final String timeZone) {
            geography.timeZone = timeZone;
            return this;
        }

        public GisFeatureGeography build() {
            return geography;
        }


    }

    public Long getElevation() {
        return elevation;
    }

    public Long getGtopo30AverageElevation() {
        return gtopo30AverageElevation;
    }

    public Geometry getLocation() {
        return location;
    }

    public Long getPopulation() {
        return population;
    }

    public String getTimeZone() {
        return timeZone;
    }

    
}
