package com.gisgraphy.client.administrativedivision;

import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.gazeranAdm4GisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.rambouilletAdm4GisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.rambouilletPplGisFeature;

import com.gisgraphy.client.gisfeature.GisFeatureGeographyObjectMother;
import com.gisgraphy.client.gisfeature.GisFeatureObjectMother;

public class CityObjectMother {
    public static City gazeranCity() {
	return City.forFeature(gazeranAdm4GisFeature());
    }

    public static City rambouilletCity() {
	return City.forFeature(rambouilletPplGisFeature());
    }
}
