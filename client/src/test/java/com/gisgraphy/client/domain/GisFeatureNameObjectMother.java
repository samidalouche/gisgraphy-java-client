package com.gisgraphy.client.domain;

import static com.gisgraphy.client.domain.AlternateGisFeatureNameObjectMother.allParisAlternateNames;

public class GisFeatureNameObjectMother {
    public static GisFeatureName parisGisFeatureName() {
	return GisFeatureName
		.name("Paris")
		.withAsciiName("Paris")
		.withAlternateNames(allParisAlternateNames());
    }
    
    public static GisFeatureName rambouilletGisFeatureNameWithoutAlternateNames() {
	return GisFeatureName
		.name("Rambouillet")
		.withAsciiName("Rambouillet");
	}
}
