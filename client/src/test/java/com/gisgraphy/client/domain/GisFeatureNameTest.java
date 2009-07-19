package com.gisgraphy.client.domain;

import static com.gisgraphy.client.domain.AlternateGisFeatureNameObjectMother.panameInFrench;
import static com.gisgraphy.client.domain.AlternateGisFeatureNameObjectMother.parisInEnglish;
import static com.gisgraphy.client.domain.AlternateGisFeatureNameObjectMother.parisInFrench;
import static com.gisgraphy.client.domain.GisFeatureNameObjectMother.parisGisFeatureName;
import static com.gisgraphy.client.domain.IsoLanguageObjectMother.frenchIsoLanguage;
import static com.gisgraphy.client.domain.IsoLanguageObjectMother.ghotuo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterables;

public class GisFeatureNameTest {
    
    @Test
    public void shouldCreateParisGisFeatureName() {
	GisFeatureName parisGisFeatureName = parisGisFeatureName();
	assertEquals("Paris", parisGisFeatureName.getName());
	assertEquals("Paris", parisGisFeatureName.getAsciiName());
	assertNotNull(parisGisFeatureName.getAlternateNames());
	assertEquals(4, Iterables.size(parisGisFeatureName.getAlternateNames()));
	assertTrue(parisGisFeatureName.getAlternateNames().contains(parisInFrench()));
	assertTrue(parisGisFeatureName.getAlternateNames().contains(parisInEnglish()));
	assertTrue(parisGisFeatureName.getAlternateNames().contains(panameInFrench()));
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
	GisFeatureName.name(null);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateGisFeatureNameWithEmptyName() {
	GisFeatureName.name("");
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
