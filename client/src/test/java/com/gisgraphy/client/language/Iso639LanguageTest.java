package com.gisgraphy.client.language;

import static com.gisgraphy.client.language.IsoLanguageObjectMother.frenchIsoLanguage;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class Iso639LanguageTest {

    @Test
    public void shouldCreateFrenchLanguage() {
	assertEquals("Iso639Language[name=Français,alpha2=fr,alpha3=fra]", frenchIsoLanguage().toString());
    }
    
    @Test
    public void shouldCreateLanguageThatDoesNotHaveAnyAlpha2Code() {
	assertEquals("Iso639Language[name=Ghotuo,alpha2=<null>,alpha3=aaa]", IsoLanguageObjectMother.ghotuo().toString());
    }
}
