package com.gisgraphy.client.administrativedivision;

import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.franceGisFeature;

import org.junit.Assert;
import org.junit.Test;

import com.gisgraphy.client.gisfeature.GisFeatureObjectMother;

public class CityTest {

    @Test(expected=IllegalArgumentException.class) public void shouldNotCreateCityWithNullGisFeature() {
	City.forFeature(null);
    }
    
    @Test(expected=IllegalArgumentException.class) public void shouldNotCreateCityWithGisFeatureThatHasNotParentEntity() {
	City.forFeature(franceGisFeature());
    }
    
    @Test public void shouldCompareCitiesByName() {
//	Assert.assertTrue(CityO)
    }
    
    @Test public void twoCitiesWithSameGisFeatureShouldBeEqual() {
	
    }
    
    @Test public void twoCitiesWithDifferentGisFeaturesShouldNotBeEqual() {
	
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
