package com.gisgraphy.client.domain;

public class IsoLanguageObjectMother {

    public static IsoLanguage frenchIsoLanguage() {
	return IsoLanguage.isoLanguage("Français").alpha3("fra").alpha2("fr");
    }
    
    public static IsoLanguage englishIsoLanguage() {
	return IsoLanguage.isoLanguage("English").alpha3("eng").alpha2("en");
    }
    
    public static IsoLanguage ghotuo() {
	return IsoLanguage.isoLanguage("Ghotuo").alpha3("aaa");
    }
}
