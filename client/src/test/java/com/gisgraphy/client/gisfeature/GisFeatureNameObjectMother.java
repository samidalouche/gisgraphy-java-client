package com.gisgraphy.client.gisfeature;

import static com.gisgraphy.client.gisfeature.AlternateGisFeatureNameObjectMother.allParisAlternateNames;

import com.gisgraphy.client.gisfeature.GisFeatureName;

public class GisFeatureNameObjectMother {
    public static GisFeatureName parisGisFeatureName() {
	return GisFeatureName
		.gisFeatureName("Paris")
		.withAsciiName("Paris")
		.withAlternateNames(allParisAlternateNames());
    }
    
    public static GisFeatureName rambouilletGisFeatureNameWithoutAlternateNames() {
	return GisFeatureName
		.gisFeatureName("Rambouillet")
		.withAsciiName("Rambouillet");
	}
}
