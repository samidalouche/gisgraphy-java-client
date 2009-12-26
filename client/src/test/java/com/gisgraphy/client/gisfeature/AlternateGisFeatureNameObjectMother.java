package com.gisgraphy.client.gisfeature;

import static com.gisgraphy.client.gisfeature.AlternateGisFeatureName.alternateName;
import static com.gisgraphy.client.gisfeature.AlternateGisFeatureNameObjectMother.panameInFrench;
import static com.gisgraphy.client.gisfeature.AlternateGisFeatureNameObjectMother.parisInEnglish;
import static com.gisgraphy.client.gisfeature.AlternateGisFeatureNameObjectMother.parisInFrench;
import static com.gisgraphy.client.gisfeature.AlternateGisFeatureNameObjectMother.parisShortNameInFrench;
import static com.gisgraphy.client.language.IsoLanguageObjectMother.frenchIsoLanguage;

import java.util.List;

import com.gisgraphy.client.gisfeature.AlternateGisFeatureName;
import com.gisgraphy.client.language.IsoLanguageObjectMother;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;

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
