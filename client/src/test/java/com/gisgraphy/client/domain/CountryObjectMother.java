package com.gisgraphy.client.domain;

import static com.gisgraphy.client.domain.AdministrativeCountryInformationObjectMother.franceAdministrativeCountryInformation;
import static com.gisgraphy.client.domain.ContinentObjectMother.europe;
import static com.gisgraphy.client.domain.FipsCountryCodeObjectMother.franceFipsCountryCode;
import static com.gisgraphy.client.domain.GeographicCountryInformationObjectMother.franceGeographicCountryInformation;
import static com.gisgraphy.client.domain.GisFeatureObjectMother.franceGisFeature;
import static com.gisgraphy.client.domain.IsoCountryCodeObjectMother.franceCountryCode;

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
}
