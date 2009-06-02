package com.gisgraphy.client.domain;

import static com.gisgraphy.client.domain.AdministrativeCountryInformationObjectMother.antarcticaAdministrativeCountryInformation;
import static com.gisgraphy.client.domain.AdministrativeCountryInformationObjectMother.franceAdministrativeCountryInformation;
import static com.gisgraphy.client.domain.AdministrativeCountryInformationObjectMother.usOutlyingIslandsAdministrativeCountryInformation;
import static com.gisgraphy.client.domain.ContinentObjectMother.antarcticaContinent;
import static com.gisgraphy.client.domain.ContinentObjectMother.europe;
import static com.gisgraphy.client.domain.ContinentObjectMother.oceania;
import static com.gisgraphy.client.domain.FipsCountryCodeObjectMother.antarcticaFipsCountryCode;
import static com.gisgraphy.client.domain.FipsCountryCodeObjectMother.franceFipsCountryCode;
import static com.gisgraphy.client.domain.GeographicCountryInformationObjectMother.antarcticaGeographicCountryInformation;
import static com.gisgraphy.client.domain.GeographicCountryInformationObjectMother.franceGeographicCountryInformation;
import static com.gisgraphy.client.domain.GeographicCountryInformationObjectMother.usOutlyingIslandsGeographicCountryInformation;
import static com.gisgraphy.client.domain.GisFeatureObjectMother.antarcticaGisFeature;
import static com.gisgraphy.client.domain.GisFeatureObjectMother.franceGisFeature;
import static com.gisgraphy.client.domain.GisFeatureObjectMother.usOutlyingIslandsGisFeature;
import static com.gisgraphy.client.domain.IsoCountryCodeObjectMother.antarcticaCountryCode;
import static com.gisgraphy.client.domain.IsoCountryCodeObjectMother.franceCountryCode;
import static com.gisgraphy.client.domain.IsoCountryCodeObjectMother.usOutlyingIslandsCountryCode;

import com.ibm.icu.util.Currency;

public class CountryObjectMother {

    public static Country france() {
	return Country.countryName("France")
		.withIsoCountryCode(franceCountryCode())
		.withContinent(europe())
		.andGisFeature(franceGisFeature())
		.withCurrency(Currency.getInstance("EUR"))
		.withFipsCountryCode(franceFipsCountryCode())
		.withAdministrativeCountryInformation(franceAdministrativeCountryInformation())
		.withGeographicCountryInformation(franceGeographicCountryInformation());
    }
    
    public static Country antarctica() {
	return Country.countryName("Antarctica")
		.withIsoCountryCode(antarcticaCountryCode())
		.withContinent(antarcticaContinent())
		.andGisFeature(antarcticaGisFeature())
		.withCurrency(null)
		.withFipsCountryCode(antarcticaFipsCountryCode())
		.withAdministrativeCountryInformation(antarcticaAdministrativeCountryInformation())
		.withGeographicCountryInformation(antarcticaGeographicCountryInformation());
    }
    
    public static Country usOutlyingIslands() {
	return Country.countryName("United States Minor Outlying Islands")
		.withIsoCountryCode(usOutlyingIslandsCountryCode())
		.withContinent(oceania())
		.andGisFeature(usOutlyingIslandsGisFeature())
		.withCurrency(Currency.getInstance("USD"))
		.withFipsCountryCode(null)
		.withAdministrativeCountryInformation(usOutlyingIslandsAdministrativeCountryInformation())
		.withGeographicCountryInformation(usOutlyingIslandsGeographicCountryInformation());
    }
}
