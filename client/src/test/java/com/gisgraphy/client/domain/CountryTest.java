package com.gisgraphy.client.domain;

import static com.gisgraphy.client.domain.AdministrativeCountryInformationObjectMother.franceAdministrativeCountryInformation;
import static com.gisgraphy.client.domain.ContinentObjectMother.europe;
import static com.gisgraphy.client.domain.CountryObjectMother.antarctica;
import static com.gisgraphy.client.domain.CountryObjectMother.france;
import static com.gisgraphy.client.domain.FipsCountryCodeObjectMother.franceFipsCountryCode;
import static com.gisgraphy.client.domain.GeographicCountryInformationObjectMother.franceGeographicCountryInformation;
import static com.gisgraphy.client.domain.GisFeatureObjectMother.franceGisFeature;
import static com.gisgraphy.client.domain.IsoCountryCodeObjectMother.franceCountryCode;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import com.ibm.icu.util.Currency;

public class CountryTest {

    @Test
    public void shouldCreateFrance() {
	Country france = france();
	assertEquals("France", france.getName());
	assertEquals(franceCountryCode(), france.getIsoCountryCode());
	assertEquals(europe(), france.getContinent());
	assertEquals(franceGisFeature(), france.getGisFeature());
	assertEquals(Currency.getInstance("EUR"), france.getCurrency());
	assertEquals(franceFipsCountryCode(), france.getFipsCountryCode());
	assertEquals(franceAdministrativeCountryInformation(), france.getAdministrativeCountryInformation());
	assertEquals(franceGeographicCountryInformation(), france.getGeographicCountryInformation());
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
    
    
}
