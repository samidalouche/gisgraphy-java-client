package com.gisgraphy.client.domain;

import static com.gisgraphy.client.domain.AlternateGisFeatureName.alternateName;
import static com.gisgraphy.client.domain.AlternateGisFeatureNameObjectMother.panameInFrench;
import static com.gisgraphy.client.domain.AlternateGisFeatureNameObjectMother.parisInEnglish;
import static com.gisgraphy.client.domain.AlternateGisFeatureNameObjectMother.parisInFrench;
import static com.gisgraphy.client.domain.AlternateGisFeatureNameObjectMother.parisShortNameInFrench;
import static com.gisgraphy.client.domain.IsoLanguageObjectMother.frenchIsoLanguage;

import com.google.common.collect.ImmutableSet;

public class AlternateGisFeatureNameObjectMother {

    public static AlternateGisFeatureName parisInFrench() {
	return alternateName("Paris").withLanguage(frenchIsoLanguage()).preferred(true);
    }
    
    public static AlternateGisFeatureName parisShortNameInFrench() {
	return alternateName("ps").withLanguage(frenchIsoLanguage()).preferred(false).shortName(true);
    }
    
    public static AlternateGisFeatureName panameInFrench() {
	return alternateName("Paname").withLanguage(frenchIsoLanguage()).preferred(false);
    }
    
    public static  AlternateGisFeatureName parisInEnglish() {
	return alternateName("Paris").withLanguage(IsoLanguageObjectMother.englishIsoLanguage()).preferred(true);
    }
    
    public static ImmutableSet<AlternateGisFeatureName> allParisAlternateNames() {
	return ImmutableSet.of(
		parisInFrench(), 
		panameInFrench(), 
		parisInEnglish(),
		parisShortNameInFrench());
    }
}
