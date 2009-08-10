package com.gisgraphy.client.gisfeature;

import static com.gisgraphy.client.gisfeature.AlternateGisFeatureNameObjectMother.panameInFrench;
import static com.gisgraphy.client.gisfeature.AlternateGisFeatureNameObjectMother.parisInEnglish;
import static com.gisgraphy.client.gisfeature.AlternateGisFeatureNameObjectMother.parisInFrench;
import static com.gisgraphy.client.gisfeature.GisFeatureNamesObjectMother.parisGisFeatureName;
import static com.gisgraphy.client.language.IsoLanguageObjectMother.frenchIsoLanguage;
import static com.gisgraphy.client.language.IsoLanguageObjectMother.ghotuo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import com.gisgraphy.client.gisfeature.GisFeatureNames;
import com.google.common.collect.Iterables;

public class GisFeatureNamesTest {
    
    @Test
    public void shouldCreateParisGisFeatureName() {
	GisFeatureNames parisGisFeatureName = parisGisFeatureName();
	assertEquals("Paris", parisGisFeatureName.getName());
	assertEquals("Paris", parisGisFeatureName.getAsciiName());
	assertNotNull(parisGisFeatureName.getAlternateNames());
	assertEquals(4, Iterables.size(parisGisFeatureName.getAlternateNames()));
	assertTrue(parisGisFeatureName.getAlternateNames().contains(parisInFrench()));
	assertTrue(parisGisFeatureName.getAlternateNames().contains(parisInEnglish()));
	assertTrue(parisGisFeatureName.getAlternateNames().contains(panameInFrench()));
    }
    
    @Test
    public void shouldNotHaveAlternateNamesByDefault() {
	GisFeatureNames rambouillet = GisFeatureNamesObjectMother.rambouilletGisFeatureNameWithoutAlternateNames();
	assertEquals(0, Iterables.size(rambouillet.getAlternateNames()));
    }
    
    @Test
    public void shouldCreateGisFeatureNameWithGivenName() {
	assertEquals("Paris2", parisGisFeatureName().withName("Paris2").getName());
    }
    
//    @Test
//    public void toStringShouldExpressValueObjectContent() {
//	// FIXME: well, actually, it IS pathetic...
//	Assert.assertEquals("GisFeatureName[name=Paris,asciiName=Paris,alternateNames=[AlternateGisFeatureName[name=Paris,language=IsoLanguage[name=Français,alpha2=fr,alpha3=fra],preferred=true,short=false], AlternateGisFeatureName[name=Paname,language=IsoLanguage[name=Français,alpha2=fr,alpha3=fra],preferred=false,short=false], AlternateGisFeatureName[name=Paris,language=IsoLanguage[name=English,alpha2=en,alpha3=eng],preferred=true,short=false]]]", parisGisFeatureName().toString());
//    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureNameWithNullName() {
	GisFeatureNames.gisFeatureName(null);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureNameWithEmptyName() {
	GisFeatureNames.gisFeatureName("");
    }
    
    @Test
    public void shouldReturnPreferredNameWhenItExistsForGivenLanguage() {
	assertEquals("Paris", parisGisFeatureName().withName("paris2").getPreferredName(frenchIsoLanguage()));
    }
    
    @Test
    public void shouldReturnDefaultNameWhenPreferredNameDoesNotExistsForGivenLanguage() {
	assertEquals("default paris name", parisGisFeatureName().withName("default paris name").getPreferredName(ghotuo()));
    }
    
    @Test
    public void shouldReturnDefaultNameWhenShortNameDoesNotExistsForGivenLanguage() {
	assertEquals("default paris name", parisGisFeatureName().withName("default paris name").getShortName(ghotuo()));
    }
    
    @Test
    public void shouldReturnShortNameWhenItExistsForGivenLanguage() {
	assertEquals("ps", parisGisFeatureName().withName("default paris name").getShortName(frenchIsoLanguage()));
    }
    
}
