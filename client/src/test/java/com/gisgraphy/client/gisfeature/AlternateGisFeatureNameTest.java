package com.gisgraphy.client.gisfeature;

import static com.gisgraphy.client.gisfeature.AlternateGisFeatureName.alternateName;
import static com.gisgraphy.client.gisfeature.AlternateGisFeatureNameObjectMother.panameInFrench;
import static com.gisgraphy.client.gisfeature.AlternateGisFeatureNameObjectMother.parisInEnglish;
import static com.gisgraphy.client.gisfeature.AlternateGisFeatureNameObjectMother.parisInFrench;
import static com.gisgraphy.client.language.IsoLanguageObjectMother.frenchIsoLanguage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Assert;
import org.junit.Test;

import com.gisgraphy.client.gisfeature.AlternateGisFeatureName;

public class AlternateGisFeatureNameTest {
    
    @Test public void shouldBeCompareable() {
	Assert.assertTrue(parisInEnglish().compareTo(panameInFrench()) >= 1);
    }
    
    @Test public void shouldCreateAlternateName() {
	AlternateGisFeatureName alternateName = parisInFrench();
	assertEquals("Paris", alternateName.getName());
	assertEquals(frenchIsoLanguage(), alternateName.getLanguage());
	assertEquals(true, alternateName.isPreferred());
	assertEquals(false, alternateName.isShort());
    }
    
    @Test public void shouldCreateNewAlternateNameWithNewName() {
	assertEquals("Paris2", parisInFrench().withName("Paris2").getName());
    }
    
    @Test public void alternateNamesWithSameNameAndLanguageshouldBeEqual() {
	assertEquals(parisInFrench().preferred(true).shortName(true), parisInFrench().preferred(false).shortName(false));
    }
    
    @Test public void shouldNotBeEqualBecauseOfLanguage() {
	assertFalse(parisInFrench().equals(parisInEnglish()));
	assertFalse(parisInFrench().hashCode() == parisInEnglish().hashCode());
    }
    
    @Test public void shouldNotBeEqualBecauseOfName() {
	assertFalse(parisInFrench().equals(panameInFrench()));
	assertFalse(parisInFrench().hashCode() == panameInFrench().hashCode());
    }
    
    @Test public void toStringShouldNotBePathetic() {
	AlternateGisFeatureName alternateName = parisInFrench();
	Assert.assertEquals("AlternateGisFeatureName[name=Paris,language=Iso639Language[name=Français,alpha2=fr,alpha3=fra],preferred=true,short=false]", alternateName.toString());
    }
    
    @Test(expected=IllegalArgumentException.class) public void shouldNotCreateAlternateGisFeatureNameWithNullName() {
	alternateName(null);
    }
    
    @Test(expected=IllegalArgumentException.class) public void shouldNotCreateAlternateGisFeatureNameWithEmptyName() {
	alternateName("");
    }
}
