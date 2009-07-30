package com.gisgraphy.client.domain;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Coordinate;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GisFeatureGeography other = (GisFeatureGeography) obj;
        if (this.location != other.location && (this.location == null || !this.location.equals(other.location))) {
            return false;
        }
        if (this.elevation != other.elevation && (this.elevation == null || !this.elevation.equals(other.elevation))) {
            return false;
        }
        if (this.gtopo30AverageElevation != other.gtopo30AverageElevation && (this.gtopo30AverageElevation == null || !this.gtopo30AverageElevation.equals(other.gtopo30AverageElevation))) {
            return false;
        }
        if (this.population != other.population && (this.population == null || !this.population.equals(other.population))) {
            return false;
        }
        if ((this.timeZone == null) ? (other.timeZone != null) : !this.timeZone.equals(other.timeZone)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.location != null ? this.location.hashCode() : 0);
        hash = 59 * hash + (this.elevation != null ? this.elevation.hashCode() : 0);
        hash = 59 * hash + (this.gtopo30AverageElevation != null ? this.gtopo30AverageElevation.hashCode() : 0);
        hash = 59 * hash + (this.population != null ? this.population.hashCode() : 0);
        hash = 59 * hash + (this.timeZone != null ? this.timeZone.hashCode() : 0);
        return hash;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("location", this.location)
                .append("elevation", this.elevation)
                .append("gtopo30AverageElevation", this.gtopo30AverageElevation)
                .append("population", this.population)
                .append("timeZone", this.timeZone).toString();
    }
}
