package com.gisgraphy.client.administrativedivision;

import static com.gisgraphy.client.administrativedivision.AdministrativeCountryInformationObjectMother.antarcticaAdministrativeCountryInformation;
import static com.gisgraphy.client.administrativedivision.AdministrativeCountryInformationObjectMother.franceAdministrativeCountryInformation;
import static com.gisgraphy.client.administrativedivision.AdministrativeCountryInformationObjectMother.usOutlyingIslandsAdministrativeCountryInformation;
import static com.gisgraphy.client.administrativedivision.FipsCountryCodeObjectMother.antarcticaFipsCountryCode;
import static com.gisgraphy.client.administrativedivision.FipsCountryCodeObjectMother.franceFipsCountryCode;
import static com.gisgraphy.client.administrativedivision.GeographicCountryInformationObjectMother.antarcticaGeographicCountryInformation;
import static com.gisgraphy.client.administrativedivision.GeographicCountryInformationObjectMother.franceGeographicCountryInformation;
import static com.gisgraphy.client.administrativedivision.GeographicCountryInformationObjectMother.usOutlyingIslandsGeographicCountryInformation;
import static com.gisgraphy.client.administrativedivision.IsoCountryCodeObjectMother.antarcticaCountryCode;
import static com.gisgraphy.client.administrativedivision.IsoCountryCodeObjectMother.franceCountryCode;
import static com.gisgraphy.client.administrativedivision.IsoCountryCodeObjectMother.usOutlyingIslandsCountryCode;
import static com.gisgraphy.client.continent.ContinentObjectMother.antarcticaContinent;
import static com.gisgraphy.client.continent.ContinentObjectMother.europe;
import static com.gisgraphy.client.continent.ContinentObjectMother.oceania;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.antarcticaGisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.franceGisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.usOutlyingIslandsGisFeature;

import com.gisgraphy.client.administrativedivision.Country;
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
