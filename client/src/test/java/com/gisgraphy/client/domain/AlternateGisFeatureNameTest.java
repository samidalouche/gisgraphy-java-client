package com.gisgraphy.client.domain;

import static com.gisgraphy.client.domain.AlternateGisFeatureName.alternateName;
import static com.gisgraphy.client.domain.IsoLanguageObjectMother.frenchIsoLanguage;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class AlternateGisFeatureNameTest {
    
    @Test
    public void shouldCreateAlternateName() {
	AlternateGisFeatureName alternateName = AlternateGisFeatureNameObjectMother.parisInFrench();
	assertEquals("Paris", alternateName.getName());
	assertEquals(frenchIsoLanguage(), alternateName.getLanguage());
	assertEquals(true, alternateName.isPreferred());
	assertEquals(false, alternateName.isShort());
    }
    
    @Test
    public void toStringShouldNotBePathetic() {
	AlternateGisFeatureName alternateName = AlternateGisFeatureNameObjectMother.parisInFrench();
	Assert.assertEquals("AlternateGisFeatureName[name=Paris,language=IsoLanguage[name=Français,alpha2=fr,alpha3=fra],preferred=true,short=false]", alternateName.toString());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateAlternateGisFeatureNameWithNullName() {
	alternateName(null);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldNotCreateAlternateGisFeatureNameWithEmptyName() {
	alternateName("");
    }
}
