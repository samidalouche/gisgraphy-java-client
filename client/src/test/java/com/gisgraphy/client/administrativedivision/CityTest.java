package com.gisgraphy.client.administrativedivision;

import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.*;
import org.junit.Assert;
import org.junit.Test;

import com.gisgraphy.client.gisfeature.GeonamesGisFeature;

public class CityTest {

    @Test(expected=IllegalArgumentException.class) public void shouldNotCreateCityWithNullGisFeature() {
	City.forFeature(null);
    }
    
    @Test(expected=IllegalArgumentException.class) public void shouldNotCreateCityWithGisFeatureThatHasNotParentEntity() {
	City.forFeature(gisfeatureThatDoesNotHaveAnyParentEntity());
    }

    private GeonamesGisFeature gisfeatureThatDoesNotHaveAnyParentEntity() {
	return franceGisFeature();
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
    
    @Test(expected=IllegalArgumentException.class) public void getAdministrativeEntityShouldNotAcceptLevelHigherThanCurrentLevel() {
	City.forFeature(rambouilletAdm4GisFeature()).getAdministrativeEntity(5);
    }

    @Test(expected=IllegalArgumentException.class) public void getAdministrativeEntityShouldNotAcceptLevelLowerThan1() {
	City.forFeature(rambouilletAdm4GisFeature()).getAdministrativeEntity(0);
    }

    @Test public void getAdministrativeEntityShouldAcceptLevelsLessThanOrEqualToCurrentLevel() {
    for (int i = 1; i < 5; i++) {
        City.forFeature(rambouilletAdm4GisFeature()).getAdministrativeEntity(i);
    }
    }
    
    @Test public void getAdministrativeEntityShouldDelegateToParentAdministrativeEntity() {
	Assert.assertEquals(City.forFeature(rambouilletAdm4GisFeature()).getAdministrativeEntity(2), City.forFeature(rambouilletAdm4GisFeature()).getParentAdministrativeEntity().getAdministrativeEntity(2));
    }
    
    @Test public void shouldReturnAdministrativeDivisionLevel() {
	Assert.assertEquals(4, City.forFeature(rambouilletAdm4GisFeature()).getAdminitrativeDivisionLevel());
    }
    
    @Test public void shouldReturnCountry() {
	Assert.assertEquals(City.forFeature(rambouilletAdm4GisFeature()).getCountry(), CountryObjectMother.france());
    }
    
    @Test public void shouldReturnCurrency() {
	Assert.assertEquals("EUR", City.forFeature(rambouilletAdm4GisFeature()).getCurrency().getCurrencyCode());
    }
    
    @Test public void shouldFormatNameUsingSpecifiedFormatter() {
	
    }
}
