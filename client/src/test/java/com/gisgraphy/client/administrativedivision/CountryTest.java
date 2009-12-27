package com.gisgraphy.client.administrativedivision;

import static com.gisgraphy.client.administrativedivision.AdministrativeCountryInformationObjectMother.antarcticaAdministrativeCountryInformation;
import static com.gisgraphy.client.administrativedivision.AdministrativeCountryInformationObjectMother.franceAdministrativeCountryInformation;
import static com.gisgraphy.client.administrativedivision.CountryObjectMother.antarctica;
import static com.gisgraphy.client.administrativedivision.CountryObjectMother.france;
import static com.gisgraphy.client.administrativedivision.FipsCountryCodeObjectMother.antarcticaFipsCountryCode;
import static com.gisgraphy.client.administrativedivision.FipsCountryCodeObjectMother.franceFipsCountryCode;
import static com.gisgraphy.client.administrativedivision.GeographicCountryInformationObjectMother.antarcticaGeographicCountryInformation;
import static com.gisgraphy.client.administrativedivision.GeographicCountryInformationObjectMother.franceGeographicCountryInformation;
import static com.gisgraphy.client.administrativedivision.IsoCountryCodeObjectMother.antarcticaCountryCode;
import static com.gisgraphy.client.administrativedivision.IsoCountryCodeObjectMother.franceCountryCode;
import static com.gisgraphy.client.continent.ContinentObjectMother.antarcticaContinent;
import static com.gisgraphy.client.continent.ContinentObjectMother.europe;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.antarcticaGisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.franceGisFeature;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import com.gisgraphy.client.administrativedivision.Country;
import com.gisgraphy.client.gisfeature.InMemoryGeonamesGisFeatureProvider;
import com.ibm.icu.util.Currency;

public class CountryTest {

    @Test
    public void shouldCreateFrance() {
	Country france = france();
	assertFrance(france);
    }

    private void assertFrance(Country france) {
	assertEquals("France", france.getName());
	assertEquals(franceCountryCode(), france.getIsoCountryCode());
	assertEquals(europe(), france.getContinent());
	assertEquals(franceGisFeature(), france.getGisFeature());
	assertEquals(Currency.getInstance("EUR"), france.getCurrency());
	assertEquals(franceFipsCountryCode(), france.getFipsCountryCode());
	assertEquals(franceAdministrativeCountryInformation(), france.getAdministrativeCountryInformation());
	assertEquals(franceGeographicCountryInformation(), france.getGeographicCountryInformation());
    }
    
    @Test public void shouldCreateFranceUsingGisFeatureProvider() {
	Country france =  Country.countryName("France")
	.withIsoCountryCode(franceCountryCode())
	.withContinent(europe())
	.andGisFeatureProvider(new InMemoryGeonamesGisFeatureProvider(franceGisFeature()))
	.withCurrency(Currency.getInstance("EUR"))
	.withFipsCountryCode(franceFipsCountryCode())
	.withAdministrativeCountryInformation(franceAdministrativeCountryInformation())
	.withGeographicCountryInformation(franceGeographicCountryInformation());
	assertFrance(france);
    }
    
    @Test
    public void shouldCreateCountryWithoutCurrency() {
	Country antarctica = antarctica();
	Assert.assertNull(antarctica.getCurrency());
    }
    
    @Test
    public void shouldCreateCountryWithoutFipsCode() {
	Country usOutlyingIslands = CountryObjectMother.usOutlyingIslands();
	Assert.assertNull(usOutlyingIslands.getFipsCountryCode());
    }
    
    
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateCountryWhenNameIsNull() {
	Country.countryName(null)
		.withIsoCountryCode(franceCountryCode())
		.withContinent(europe())
		.andGisFeature(franceGisFeature())
		.withCurrency(Currency.getInstance("EUR"))
		.withFipsCountryCode(franceFipsCountryCode())
		.withAdministrativeCountryInformation(franceAdministrativeCountryInformation())
		.withGeographicCountryInformation(franceGeographicCountryInformation());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateCountryWhenNameIsEmpty() {
	Country.countryName("")
		.withIsoCountryCode(franceCountryCode())
		.withContinent(europe())
		.andGisFeature(franceGisFeature())
		.withCurrency(Currency.getInstance("EUR"))
		.withFipsCountryCode(franceFipsCountryCode())
		.withAdministrativeCountryInformation(franceAdministrativeCountryInformation())
		.withGeographicCountryInformation(franceGeographicCountryInformation());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateCountryWhenContinentIsNull() {
	Country.countryName("France")
		.withIsoCountryCode(franceCountryCode())
		.withContinent(null)
		.andGisFeature(franceGisFeature())
		.withCurrency(Currency.getInstance("EUR"))
		.withFipsCountryCode(franceFipsCountryCode())
		.withAdministrativeCountryInformation(franceAdministrativeCountryInformation())
		.withGeographicCountryInformation(franceGeographicCountryInformation());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateCountryWhenGisFeatureIsNull() {
	Country.countryName("France")
		.withIsoCountryCode(franceCountryCode())
		.withContinent(europe())
		.andGisFeature(null)
		.withCurrency(Currency.getInstance("EUR"))
		.withFipsCountryCode(franceFipsCountryCode())
		.withAdministrativeCountryInformation(franceAdministrativeCountryInformation())
		.withGeographicCountryInformation(franceGeographicCountryInformation());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateCountryWhenAdministrativeInformationIsNull() {
	Country.countryName("France")
		.withIsoCountryCode(franceCountryCode())
		.withContinent(europe())
		.andGisFeature(franceGisFeature())
		.withCurrency(Currency.getInstance("EUR"))
		.withFipsCountryCode(franceFipsCountryCode())
		.withAdministrativeCountryInformation(null)
		.withGeographicCountryInformation(franceGeographicCountryInformation());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateCountryWhenGeographicInformationIsNull() {
	Country.countryName("France")
		.withIsoCountryCode(franceCountryCode())
		.withContinent(europe())
		.andGisFeature(franceGisFeature())
		.withCurrency(Currency.getInstance("EUR"))
		.withFipsCountryCode(franceFipsCountryCode())
		.withAdministrativeCountryInformation(franceAdministrativeCountryInformation())
		.withGeographicCountryInformation(null);
    }
    
    @Test public void administrativeDivisionLevelShouldAlwaysBeZero() {
	Assert.assertEquals(0,france().getAdminitrativeDivisionLevel());
    }
    
    @Test public void parentAdministrativeEntityShouldBeNull() {
	Assert.assertNull(france().getParentAdministrativeEntity());
    }
    
    
    @Test public void twoCountriesWithSameGisFeatureShouldBeEqual() {
	Country country1 = Country.countryName("France")
		.withIsoCountryCode(franceCountryCode())
		.withContinent(europe())
		.andGisFeature(franceGisFeature())
		.withCurrency(Currency.getInstance("EUR"))
		.withFipsCountryCode(franceFipsCountryCode())
		.withAdministrativeCountryInformation(franceAdministrativeCountryInformation())
		.withGeographicCountryInformation(franceGeographicCountryInformation());
	
	Country country2 = Country.countryName("Antarctica")
		.withIsoCountryCode(antarcticaCountryCode())
		.withContinent(antarcticaContinent())
		.andGisFeature(franceGisFeature()) // france gis feature
		.withCurrency(null)
		.withFipsCountryCode(antarcticaFipsCountryCode())
		.withAdministrativeCountryInformation(antarcticaAdministrativeCountryInformation())
		.withGeographicCountryInformation(antarcticaGeographicCountryInformation());
	
	Assert.assertEquals(country1,country2);
	Assert.assertEquals(country1.hashCode(),country2.hashCode());
    }
    
    @Test public void twoCountriesWithDifferentGisFeatureShouldNotBeEqual() {
	Country country1 = Country.countryName("France")
		.withIsoCountryCode(franceCountryCode())
		.withContinent(europe())
		.andGisFeature(franceGisFeature())
		.withCurrency(Currency.getInstance("EUR"))
		.withFipsCountryCode(franceFipsCountryCode())
		.withAdministrativeCountryInformation(franceAdministrativeCountryInformation())
		.withGeographicCountryInformation(franceGeographicCountryInformation());
	
	Country country2 = Country.countryName("France")
		.withIsoCountryCode(franceCountryCode())
		.withContinent(europe())
		.andGisFeature(antarcticaGisFeature()) // different feature
		.withCurrency(Currency.getInstance("EUR"))
		.withFipsCountryCode(franceFipsCountryCode())
		.withAdministrativeCountryInformation(franceAdministrativeCountryInformation())
		.withGeographicCountryInformation(franceGeographicCountryInformation()); 
	
	Assert.assertFalse(country1.equals(country2));
	Assert.assertTrue(country1.hashCode() != country2.hashCode());
    }
    
    @Test(expected=IllegalArgumentException.class) public void getAdministrativeEntityShouldThrowExceptionWhenRequestedLevelIsHigherThanZero() {
	france().getAdministrativeEntity(1);
    }
    
    @Test public void shouldReturnFullyQualifiedName() {
	Assert.assertEquals("[NamePart[name=France,friendlyCode=FR]]",CountryObjectMother.france().getFullyQualifiedNameParts().toString());
    }
    
}
