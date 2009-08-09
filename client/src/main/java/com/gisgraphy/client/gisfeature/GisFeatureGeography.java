package com.gisgraphy.client.gisfeature;

import javax.measure.quantity.Length;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.Point;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.opengis.referencing.operation.TransformException;

/**
 *
 * @author christophe
 */
public final class GisFeatureGeography implements DistanceAware<GisFeatureGeography>{

    public static class GisFeatureGeographyBuilder {

        public static final Geometry VALID_COORDINATE_BOUNDS = GisFeature.GEOMETRY_FACTORY.toGeometry(new Envelope(-180.0, 180.0, -90.0, 90.0));
        private GisFeatureGeography geography;

        private GisFeatureGeographyBuilder() {
            geography = new GisFeatureGeography();
        }
        
        private GisFeatureGeographyBuilder(GisFeatureGeography template) {
            geography = new GisFeatureGeography();
            geography.elevation = template.elevation;
            geography.gtopo30AverageElevation = template.gtopo30AverageElevation;
            geography.location = template.location;
            geography.population = template.population;
            geography.timeZone = template.timeZone;
        }

        public GisFeatureGeographyBuilder(final Double longitude, final Double latitude) {
            //this();
            //Validate.isTrue(-180.0 <= longitude && longitude <= 180.0);
            //Validate.isTrue(-90.0 <= latitude && latitude <= 90.0);
            this(GisFeature.GEOMETRY_FACTORY.createPoint(new Coordinate(longitude, latitude)));
        }

        public GisFeatureGeographyBuilder(final Point location) {
            this();
            Validate.notNull(location);
            Validate.isTrue(location.isValid());
            Validate.isTrue(location.coveredBy(VALID_COORDINATE_BOUNDS));
            geography.location = location;
        }

        public GisFeatureGeography build() {
            return geography;
        }

        public GisFeatureGeographyBuilder location(final Point location) {
            geography.location = location;
            return this;
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
    }
    public static GisFeatureGeography gisFeatureGeography(final Double longitude, final Double latitude) {
        return new GisFeatureGeographyBuilder(longitude, latitude).build();
    }
    public static GisFeatureGeography gisFeatureGeography(final Point location) {
        return new GisFeatureGeographyBuilder(location).build();
    }
    private Long elevation;
    private Long gtopo30AverageElevation;
    private Point location;
    private Long population;
    private String timeZone;

    private GisFeatureGeography() {
    }

    public GisFeatureGeography withLocation(final Point location) {
	return new GisFeatureGeographyBuilder(this).location(location).build();
    }
    
    public GisFeatureGeography withElevation(final Long elevation) {
	return new GisFeatureGeographyBuilder(this).elevation(elevation).build();
    }

    public GisFeatureGeography withGtopo30AverageElevation(final Long gtopo30AverageElevation) {
	return new GisFeatureGeographyBuilder(this).gtopo30AverageElevation(gtopo30AverageElevation).build();
    }

    public GisFeatureGeography withPopulation(final Long population) {
	return new GisFeatureGeographyBuilder(this).population(population).build();
    }

    public GisFeatureGeography withTimeZone(final String timeZone) {
	return new GisFeatureGeographyBuilder(this).timeZone(timeZone).build();
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

    public Long getElevation() {
        return elevation;
    }

    public Long getGtopo30AverageElevation() {
        return gtopo30AverageElevation;
    }

    public Point getLocation() {
        return location;
    }
    
    public double getLatitude() {
	return location.getY();
    }
    
    public double getLongitude() {
	return location.getX();
    }

    public Long getPopulation() {
        return population;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public double distance(GisFeatureGeography o, Unit<Length> unit) {
	Unit<Length> targetUnit = (unit != null) ? unit : SI.METER;
	com.vividsolutions.jts.geom.Geometry me = location;
	com.vividsolutions.jts.geom.Geometry other = o.getLocation();
	try {
	    return SI.METER.getConverterTo(targetUnit).convert(JTS.orthodromicDistance(me.getCoordinate(), other.getCoordinate(), DefaultGeographicCRS.WGS84));
	} catch (TransformException e) {
	    throw new RuntimeException(e);
	}
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
