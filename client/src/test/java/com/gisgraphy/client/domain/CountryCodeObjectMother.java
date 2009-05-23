package com.gisgraphy.client.domain;

import static com.gisgraphy.client.domain.CountryCode.alpha2Code;

public class CountryCodeObjectMother {
    public static CountryCode franceCountryCode() {
	return alpha2Code("FR").alpha3Code("FRA").andNumericCode(250);
    }
}
