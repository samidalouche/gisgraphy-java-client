package com.gisgraphy.client.domain;

import com.vividsolutions.jts.geom.Coordinate;
import org.junit.Test;

public class GisFeatureGeographyTest {


    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureGeographyWithNullGeometry() {
	GisFeatureGeography.gisFeatureGeography(null).build();
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureGeographyWithInvalidGeometryLongitude() {
	GisFeatureGeography.gisFeatureGeography(GisFeature.GEOMETRY_FACTORY.createPoint(new Coordinate(-181.0, 0.0))).build();
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureGeographyWithInvalidGeometryLatitude() {
	GisFeatureGeography.gisFeatureGeography(GisFeature.GEOMETRY_FACTORY.createPoint(new Coordinate(0.0, 91.0))).build();
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureGeographyWithInvalidLongitude() {
	GisFeatureGeography.gisFeatureGeography(-181.0, 0.0).build();
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureGeographyWithInvalidLatitude() {
	GisFeatureGeography.gisFeatureGeography(0.0, 91.0).build();
    }

    public void shouldCreateGisFeatureGeographyWithValidGeometry() {
	GisFeatureGeography.gisFeatureGeography(GisFeature.GEOMETRY_FACTORY.createPoint(new Coordinate(-170.0, 89.0))).build();
    }

    public void shouldCreateGisFeatureGeographyWithValidGeometry2() {
	GisFeatureGeography.gisFeatureGeography(GisFeature.GEOMETRY_FACTORY.createPoint(new Coordinate(170.0, -89.0))).build();
    }

    public void shouldCreateGisFeatureGeographyWithValidCoordinates() {
	GisFeatureGeography.gisFeatureGeography(-170.0, 89.0).build();
    }

    public void shouldCreateGisFeatureGeographyWithValidCoordinates2() {
	GisFeatureGeography.gisFeatureGeography(170.0, -89.0).build();
    }

}
