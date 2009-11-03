package com.gisgraphy.client.administrativedivision;

import com.gisgraphy.client.gisfeature.GisFeatureObjectMother;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.franceGisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.rambouilletAdm4GisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.gazeranAdm4GisFeature;
import org.junit.Assert;
import org.junit.Test;

public class CityTest {

    @Test(expected=IllegalArgumentException.class) public void shouldNotCreateCityWithNullGisFeature() {
	City.forFeature(null);
    }
    
    @Test(expected=IllegalArgumentException.class) public void shouldNotCreateCityWithGisFeatureThatHasNotParentEntity() {
	City.forFeature(franceGisFeature());
    }
    
    @Test public void shouldCompareCitiesByName() {
    Assert.assertTrue(City.forFeature(rambouilletAdm4GisFeature()).compareTo(City.forFeature(gazeranAdm4GisFeature())) > 0);
    Assert.assertTrue(City.forFeature(gazeranAdm4GisFeature()).compareTo(City.forFeature(rambouilletAdm4GisFeature())) < 0);
    }
    
    @Test public void twoCitiesWithSameGisFeatureShouldBeEqual() {
	Assert.assertEquals(City.forFeature(rambouilletAdm4GisFeature()), City.forFeature(rambouilletAdm4GisFeature()));
    }
    
    @Test public void twoCitiesWithDifferentGisFeaturesShouldNotBeEqual() {
	Assert.assertNotSame(City.forFeature(rambouilletAdm4GisFeature()), City.forFeature(gazeranAdm4GisFeature()));
    }
    
    @Test public void getAdministrativeEntityShouldNotAcceptLevelHigherThanCurrentLevel() {
	
    }
    
    @Test public void getAdministrativeEntityShouldDelegateToParentAdministrativeEntity() {
	
    }
    
    @Test public void shouldReturnAdministrativeDivisionLevel() {
	
    }
    
    @Test public void shouldReturnCountry() {
	
    }
    
    @Test public void shouldReturnCurrency() {
	
    }
    
    @Test public void shouldFormatNameUsingSpecifiedFormatter() {
	
    }
}
