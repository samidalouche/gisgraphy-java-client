package com.gisgraphy.client.administrativedivision;

import static com.gisgraphy.client.administrativedivision.IsoCountryCode.alpha2Code;

import com.gisgraphy.client.administrativedivision.IsoCountryCode;

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
