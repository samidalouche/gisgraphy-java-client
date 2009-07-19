package com.gisgraphy.client.domain;

import static com.gisgraphy.client.domain.AlternateGisFeatureName.alternateName;
import static com.gisgraphy.client.domain.AlternateGisFeatureNameObjectMother.panameInFrench;
import static com.gisgraphy.client.domain.AlternateGisFeatureNameObjectMother.parisInEnglish;
import static com.gisgraphy.client.domain.AlternateGisFeatureNameObjectMother.parisInFrench;
import static com.gisgraphy.client.domain.IsoLanguageObjectMother.frenchIsoLanguage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Assert;
import org.junit.Test;

public class AlternateGisFeatureNameTest {
    
    @Test
    public void shouldCreateAlternateName() {
	AlternateGisFeatureName alternateName = parisInFrench();
	assertEquals("Paris", alternateName.getName());
	assertEquals(frenchIsoLanguage(), alternateName.getLanguage());
	assertEquals(true, alternateName.isPreferred());
	assertEquals(false, alternateName.isShort());
    }
    
    @Test
    public void shouldCreateNewAlternateNameWithNewName() {
	assertEquals("Paris2", parisInFrench().withName("Paris2").getName());
    }
    
    @Test
    public void alternateNamesWithSameNameAndLanguageshouldBeEqual() {
	assertEquals(parisInFrench().preferred(true).shortName(true), parisInFrench().preferred(false).shortName(false));
    }
    
    @Test
    public void shouldNotBeEqualBecauseOfLanguage() {
	assertFalse(parisInFrench().equals(parisInEnglish()));
	assertFalse(parisInFrench().hashCode() == parisInEnglish().hashCode());
    }
    
    @Test
    public void shouldNotBeEqualBecauseOfName() {
	assertFalse(parisInFrench().equals(panameInFrench()));
	assertFalse(parisInFrench().hashCode() == panameInFrench().hashCode());
    }
    
    @Test
    public void toStringShouldNotBePathetic() {
	AlternateGisFeatureName alternateName = parisInFrench();
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
