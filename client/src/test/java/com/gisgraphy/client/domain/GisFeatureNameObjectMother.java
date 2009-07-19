package com.gisgraphy.client.domain;

import static com.gisgraphy.client.domain.AlternateGisFeatureNameObjectMother.panameInFrench;
import static com.gisgraphy.client.domain.AlternateGisFeatureNameObjectMother.parisInEnglish;
import static com.gisgraphy.client.domain.AlternateGisFeatureNameObjectMother.parisInFrench;
import static com.gisgraphy.client.domain.AlternateGisFeatureNameObjectMother.parisShortNameInFrench;

import com.google.common.collect.ImmutableSet;

public class GisFeatureNameObjectMother {
    public static GisFeatureName parisGisFeatureName() {
	return GisFeatureName
		.name("Paris")
		.withAsciiName("Paris")
		.withAlternateNames(
			ImmutableSet.of(
				parisInFrench(), 
				panameInFrench(), 
				parisInEnglish(),
				parisShortNameInFrench()));
		
    }
}
