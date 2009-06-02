package com.gisgraphy.client.domain;

import static com.gisgraphy.client.domain.GeographicCountryInformation.geographicCountryInformation;

public class GeographicCountryInformationObjectMother {

    public GeographicCountryInformation frenchGeographicCountryInformation() {
	return geographicCountryInformation().withPopulation(64094000L).withArea(new Double("547030"));
    }
}
