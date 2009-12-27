package com.gisgraphy.client.administrativedivision;

import static com.gisgraphy.client.administrativedivision.CityObjectMother.gazeranCity;
import static com.gisgraphy.client.administrativedivision.CityObjectMother.rambouilletCity;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.gisgraphy.client.commons.NameFormatter;
import com.gisgraphy.client.commons.NameProvider;
import com.gisgraphy.client.gisfeature.GeonamesGisFeature;
import com.gisgraphy.client.gisfeature.GisFeatureObjectMother;
import com.gisgraphy.client.gisfeature.InMemoryGeonamesGisFeatureProvider;

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
	Assert.assertTrue(rambouilletCity().compareTo(gazeranCity()) > 0);
	Assert.assertTrue(gazeranCity().compareTo(rambouilletCity()) < 0);
    }

   
    @Test public void twoCitiesWithSameGisFeatureShouldBeEqual() {
	Assert.assertEquals(rambouilletCity(), rambouilletCity());
    }

    @Test public void twoCitiesWithDifferentGisFeaturesShouldNotBeEqual() {
	Assert.assertNotSame(rambouilletCity(), gazeranCity());
    }

    @Test(expected=IllegalArgumentException.class) public void getAdministrativeEntityShouldNotAcceptLevelHigherThanCurrentLevel() {
	rambouilletCity().getAdministrativeEntity(typicalAdministrativeLevelOfACity()+1);
    }
    
    @Test(expected=IllegalArgumentException.class) public void getAdministrativeEntityShouldNotAcceptLevelLowerThanZero() {
	rambouilletCity().getAdministrativeEntity(-1);
    }

    @Test public void getAdministrativeEntityShouldAcceptLevelsLessThanOrEqualToCurrentLevel() {
	for (int i = 1; i <= typicalAdministrativeLevelOfACity(); i++) {
	    rambouilletCity().getAdministrativeEntity(i);
	}
    }
    
    @Test public void getAdministrativeEntityShouldReturnCityItselfWhenRequestedLevelIsTheCityLevel() {
	Assert.assertEquals(rambouilletCity(), rambouilletCity().getAdministrativeEntity(typicalAdministrativeLevelOfACity()));
    }

    @Test public void getAdministrativeEntityShouldDelegateToParentAdministrativeEntity() {
	Assert.assertEquals(rambouilletCity().getAdministrativeEntity(2), rambouilletCity().getParentAdministrativeEntity().getAdministrativeEntity(2));
    }

    @Test public void shouldReturnAdministrativeDivisionLevel() {
	Assert.assertEquals(typicalAdministrativeLevelOfACity(), rambouilletCity().getAdminitrativeDivisionLevel());
    }

    @Test public void citiesCreatedUsingGisFeatureProviderAndGisFeatureShouldBeEqual() {
	Assert.assertEquals(City.forFeature(rambouilletPplGisFeature()), City.forGisFeatureProvider(new InMemoryGeonamesGisFeatureProvider(rambouilletPplGisFeature())));
    }
    
    @Test public void shouldReturnCountry() {
	Assert.assertEquals(rambouilletCity().getCountry(), CountryObjectMother.france());
    }

    @Test public void shouldReturnCurrency() {
	Assert.assertEquals("EUR", rambouilletCity().getCurrency().getCurrencyCode());
    }

    @Test public void shouldDelegateGetFullyQualifiedNamePartsToGisFeature() {
	Assert.assertEquals(rambouilletPplGisFeature().getFullyQualifiedNameParts(), rambouilletCity().getFullyQualifiedNameParts());
    }
    
    
    @Test public void shouldDelegateDistanceCalculationToGisFeature() {
	Assert.assertEquals(distanceCalculatedUsingGisFeatures(), distanceCalculatedUsingCities(), 0);
    }

    private double distanceCalculatedUsingCities() {
	return rambouilletCity().distance(gazeranCity(), SI.METER);
    }

    private double distanceCalculatedUsingGisFeatures() {
	return rambouilletPplGisFeature().distance(gazeranPplGisFeature(), SI.METER);
    }
    
    @Test public void shouldFormatNameUsingSpecifiedFormatter() {
	City rambouillet = rambouilletCity();
	
	NameFormatter nameFormatter = mock(NameFormatter.class);
	when(nameFormatter.format(rambouillet)).thenReturn("this formatted string");
	
	Assert.assertEquals("this formatted string", rambouillet.formatName(nameFormatter));
	verify(nameFormatter).format(rambouillet);
	
    }
    
    
    private int typicalAdministrativeLevelOfACity() {
	return 5;
    }
}
