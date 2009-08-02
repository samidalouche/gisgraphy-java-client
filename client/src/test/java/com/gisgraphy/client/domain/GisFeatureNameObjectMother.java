package com.gisgraphy.client.domain;

import static com.gisgraphy.client.domain.AlternateGisFeatureNameObjectMother.allParisAlternateNames;

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
