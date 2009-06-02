package com.gisgraphy.client.domain;

import static com.gisgraphy.client.domain.IsoCountryCode.alpha2Code;

public class IsoCountryCodeObjectMother {
    public static IsoCountryCode franceCountryCode() {
	return alpha2Code("FR").alpha3Code("FRA").andNumericCode(250);
    }
    
    public static IsoCountryCode antarcticaCountryCode() {
	return alpha2Code("AQ").alpha3Code("ATA").andNumericCode(10);
    }
    
    public static IsoCountryCode usOutlyingIslandsCountryCode() {
	return alpha2Code("UM").alpha3Code("UMI").andNumericCode(581);
    }
    
}
