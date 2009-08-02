package com.gisgraphy.client.administrativedivision;

import com.gisgraphy.client.administrativedivision.FipsCountryCode;

public class FipsCountryCodeObjectMother {

    public static FipsCountryCode franceFipsCountryCode() {
	return FipsCountryCode.fipsCountryCode("FR");
    }
    
    public static FipsCountryCode antarcticaFipsCountryCode() {
	return FipsCountryCode.fipsCountryCode("AY");
    }
}
