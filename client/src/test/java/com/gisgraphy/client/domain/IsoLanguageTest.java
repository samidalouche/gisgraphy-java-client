package com.gisgraphy.client.domain;

import static com.gisgraphy.client.domain.IsoLanguageObjectMother.frenchIsoLanguage;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IsoLanguageTest {

    @Test
    public void shouldCreateFrenchLanguage() {
	assertEquals("IsoLanguage[name=Français,alpha2=fr,alpha3=fra]", frenchIsoLanguage().toString());
    }
    
    @Test
    public void shouldCreateLanguageThatDoesNotHaveAnyAlpha2Code() {
	assertEquals("IsoLanguage[name=Ghotuo,alpha2=<null>,alpha3=aaa]", IsoLanguageObjectMother.ghotuo().toString());
    }
}
