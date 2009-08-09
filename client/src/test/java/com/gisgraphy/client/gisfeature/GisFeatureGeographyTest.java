package com.gisgraphy.client.gisfeature;

import static com.gisgraphy.client.gisfeature.GisFeatureGeographyObjectMother.losAngelesCityGisFeatureGeography;
import static com.gisgraphy.client.gisfeature.GisFeatureGeographyObjectMother.marinaDelReyCityGisFeatureGeography;

import javax.measure.unit.NonSI;
import javax.measure.unit.SI;

import org.junit.Assert;

import com.gisgraphy.client.gisfeature.GisFeature;
import com.gisgraphy.client.gisfeature.GisFeatureGeography;
import com.vividsolutions.jts.geom.Coordinate;
import org.junit.Test;

public class GisFeatureGeographyTest {


    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureGeographyWithNullGeometry() {
	GisFeatureGeography.gisFeatureGeography(null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureGeographyWithInvalidGeometryLongitude() {
	GisFeatureGeography.gisFeatureGeography(GisFeature.GEOMETRY_FACTORY.createPoint(new Coordinate(-181.0, 0.0)));
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureGeographyWithInvalidGeometryLatitude() {
	GisFeatureGeography.gisFeatureGeography(GisFeature.GEOMETRY_FACTORY.createPoint(new Coordinate(0.0, 91.0)));
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureGeographyWithInvalidLongitude() {
	GisFeatureGeography.gisFeatureGeography(-181.0, 0.0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureGeographyWithInvalidLatitude() {
	GisFeatureGeography.gisFeatureGeography(0.0, 91.0);
    }

    @Test
    public void shouldCreateGisFeatureGeographyWithValidGeometry() {
	GisFeatureGeography gfg = GisFeatureGeography.gisFeatureGeography(GisFeature.GEOMETRY_FACTORY.createPoint(new Coordinate(-170.0, 89.0)));
	Assert.assertNotNull(gfg);
	Assert.assertEquals(1, gfg.getLocation().getNumPoints());
	Assert.assertEquals(-170.0d, gfg.getLocation().getCentroid().getCoordinate().x, 0.0001);
	Assert.assertEquals(89.0d, gfg.getLocation().getCentroid().getCoordinate().y, 0.0001);
    }

    @Test
    public void shouldCreateGisFeatureGeographyWithValidGeometry2() {
	GisFeatureGeography gfg = GisFeatureGeography.gisFeatureGeography(GisFeature.GEOMETRY_FACTORY.createPoint(new Coordinate(170.0, -89.0)));
	Assert.assertNotNull(gfg);
	Assert.assertEquals(1, gfg.getLocation().getNumPoints());
	Assert.assertEquals(170.0, gfg.getLocation().getCentroid().getCoordinate().x, 0.0001);
	Assert.assertEquals(-89.0, gfg.getLocation().getCentroid().getCoordinate().y, 0.0001);
    }

    @Test
    public void shouldCreateGisFeatureGeographyWithValidCoordinates() {
	GisFeatureGeography gfg = GisFeatureGeography.gisFeatureGeography(-170.0, 89.0);
	Assert.assertNotNull(gfg);
	Assert.assertEquals(1, gfg.getLocation().getNumPoints());
	Assert.assertEquals(-170.0, gfg.getLocation().getCentroid().getCoordinate().x, 0.0001);
	Assert.assertEquals(89.0, gfg.getLocation().getCentroid().getCoordinate().y, 0.0001);
    }

    @Test
    public void shouldCreateGisFeatureGeographyWithValidCoordinates2() {
	GisFeatureGeography gfg = GisFeatureGeography.gisFeatureGeography(170.0, -89.0);
	Assert.assertNotNull(gfg);
	Assert.assertEquals(1, gfg.getLocation().getNumPoints());
	Assert.assertEquals(170.0, gfg.getLocation().getCentroid().getCoordinate().x, 0.0001);
	Assert.assertEquals(-89.0, gfg.getLocation().getCentroid().getCoordinate().y, 0.0001);
    }

    @Test
    public void shouldReturnLatitude() {
	Assert.assertEquals(34.05222d, losAngelesCityGisFeatureGeography().getLatitude(), 0.0001); 
    }
    
    @Test
    public void shouldReturnLongitude() {
	Assert.assertEquals(-118.24278d, losAngelesCityGisFeatureGeography().getLongitude(), 0.0001);
    }
    
    @Test
    public void shouldCalculateDistanceInMile() {
	Assert.assertTrue(losAngelesCityGisFeatureGeography().distance(marinaDelReyCityGisFeatureGeography(), NonSI.MILE) > 12d 
		&& marinaDelReyCityGisFeatureGeography().distance(losAngelesCityGisFeatureGeography(), NonSI.MILE) < 14d);
    }

    @Test
    public void shouldCalculateDistanceInDefaultUnit() {
	Assert.assertTrue(losAngelesCityGisFeatureGeography().distance(marinaDelReyCityGisFeatureGeography(), null) > 20000d 
		&& marinaDelReyCityGisFeatureGeography().distance(losAngelesCityGisFeatureGeography(), null) < 22000d);
    }

    @Test
    public void shouldCalculateDistanceInMeter() {
	Assert.assertTrue(losAngelesCityGisFeatureGeography().distance(marinaDelReyCityGisFeatureGeography(), SI.METER) > 20000d 
		&& marinaDelReyCityGisFeatureGeography().distance(losAngelesCityGisFeatureGeography(), SI.METER) < 22000d);
    }

}
