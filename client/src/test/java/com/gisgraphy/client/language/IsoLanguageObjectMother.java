package com.gisgraphy.client.language;

import com.gisgraphy.client.language.Iso639Language;

public class IsoLanguageObjectMother {

    public static Iso639Language frenchIsoLanguage() {
	return Iso639Language.isoLanguage("Français").withAlpha3("fra").withAlpha2("fr");
    }
    
    public static Iso639Language englishIsoLanguage() {
	return Iso639Language.isoLanguage("English").withAlpha3("eng").withAlpha2("en");
    }
    
    public static Iso639Language ghotuo() {
	return Iso639Language.isoLanguage("Ghotuo").withAlpha3("aaa");
    }
}
