package com.gisgraphy.client.administrativedivision;

import static com.gisgraphy.client.administrativedivision.GeographicCountryInformation.geographicCountryInformation;

import com.gisgraphy.client.administrativedivision.GeographicCountryInformation;

public class GeographicCountryInformationObjectMother {

    public static GeographicCountryInformation franceGeographicCountryInformation() {
	return geographicCountryInformation().withPopulation(64094000L).withArea(new Double("547030"));
    }
    
    public static GeographicCountryInformation antarcticaGeographicCountryInformation() {
	return geographicCountryInformation().withPopulation(0L).withArea(new Double("14000000"));
    }
    
    public static GeographicCountryInformation usOutlyingIslandsGeographicCountryInformation() {
	return geographicCountryInformation();
    }
}
