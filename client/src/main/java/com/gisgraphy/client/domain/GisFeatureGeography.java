package com.gisgraphy.client.domain;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Coordinate;

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

    public static GisFeatureGeographyBuilder gisFeatureGeography(final Double x, final Double y) {
        return new GisFeatureGeographyBuilder(x, y);
    }

    public static class GisFeatureGeographyBuilder {

        private GisFeatureGeography geography;

        private GisFeatureGeographyBuilder() {
            geography = new GisFeatureGeography();
        }

        public GisFeatureGeographyBuilder(final Geometry location) {
            this();
            geography.location = location;
        }

        public GisFeatureGeographyBuilder(final Double x, final Double y) {
            this();
            geography.location = GisFeature.GEOMETRY_FACTORY.createPoint(new Coordinate(x, y));
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
