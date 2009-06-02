package com.gisgraphy.client.domain;

import static com.gisgraphy.client.domain.IsoCountryCode.alpha2Code;

public class IsoCountryCodeObjectMother {
    public static IsoCountryCode franceCountryCode() {
	return alpha2Code("FR").alpha3Code("FRA").andNumericCode(250);
    }
}
