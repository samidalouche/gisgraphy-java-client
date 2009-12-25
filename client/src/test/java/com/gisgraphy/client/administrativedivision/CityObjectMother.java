package com.gisgraphy.client.administrativedivision;

import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.gazeranPplGisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.parisPplcGisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.rambouilletPplGisFeature;

import com.gisgraphy.client.gisfeature.GisFeatureObjectMother;

public class CityObjectMother {
    public static City gazeranCity() {
	return City.forFeature(gazeranPplGisFeature());
    }

    public static City rambouilletCity() {
	return City.forFeature(rambouilletPplGisFeature());
    }
    
    public static City losAngelesCity() {
	return null;
    }
    
    public static City marinaDelReyCity() {
	return null;
    }
    
    public static City parisCity() {
	return City.forFeature(parisPplcGisFeature());
    }
}
