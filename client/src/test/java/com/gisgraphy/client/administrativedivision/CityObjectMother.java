package com.gisgraphy.client.administrativedivision;

import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.gazeranPplGisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.losAngelesPplGisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.marinaDelReyPplGisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.parisPplcGisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.rambouilletPplGisFeature;

public class CityObjectMother {
    public static City gazeranCity() {
	return City.forFeature(gazeranPplGisFeature());
    }

    public static City rambouilletCity() {
	return City.forFeature(rambouilletPplGisFeature());
    }
    
    public static City losAngelesCity() {
	return City.forFeature(losAngelesPplGisFeature());
    }
    
    public static City marinaDelReyCity() {
	return City.forFeature(marinaDelReyPplGisFeature());
    }
    
    public static City parisCity() {
	return City.forFeature(parisPplcGisFeature());
    }
}
