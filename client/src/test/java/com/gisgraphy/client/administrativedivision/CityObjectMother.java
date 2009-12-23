package com.gisgraphy.client.administrativedivision;

import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.gazeranPplGisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.rambouilletPplGisFeature;

public class CityObjectMother {
    public static City gazeranCity() {
	return City.forFeature(gazeranPplGisFeature());
    }

    public static City rambouilletCity() {
	return City.forFeature(rambouilletPplGisFeature());
    }
}
