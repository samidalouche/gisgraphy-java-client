package com.gisgraphy.client.gisfeature;

import static com.gisgraphy.client.gisfeature.AlternateGisFeatureNameObjectMother.allParisAlternateNames;

import com.gisgraphy.client.gisfeature.GisFeatureNames;

public class GisFeatureNamesObjectMother {
    public static GisFeatureNames parisGisFeatureName() {
	return GisFeatureNames
		.gisFeatureName("Paris")
		.withAsciiName("Paris")
		.withAlternateNames(allParisAlternateNames());
    }
    
    public static GisFeatureNames rambouilletGisFeatureNameWithoutAlternateNames() {
	return GisFeatureNames
		.gisFeatureName("Rambouillet")
		.withAsciiName("Rambouillet");
	}
}
