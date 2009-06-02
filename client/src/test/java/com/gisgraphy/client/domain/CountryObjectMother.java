package com.gisgraphy.client.domain;

import static com.gisgraphy.client.domain.ContinentObjectMother.europe;
import static com.gisgraphy.client.domain.GisFeatureObjectMother.franceGisFeature;
import static com.gisgraphy.client.domain.IsoCountryCodeObjectMother.franceCountryCode;

public class CountryObjectMother {

    public static Country france() {
	return Country.countryName("France")
		.withIsoCountryCode(franceCountryCode())
		.withContinent(europe())
		.andGisFeature(franceGisFeature());
    }
}
