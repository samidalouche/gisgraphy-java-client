package com.gisgraphy.client.domain;

public class IsoLanguageObjectMother {

    public static IsoLanguage frenchIsoLanguage() {
	return IsoLanguage.isoLanguage("Francais").alpha3("fra").alpha2("fr");
    }
    
    public static IsoLanguage ghotuo() {
	return IsoLanguage.isoLanguage("Ghotuo").alpha3("aaa");
    }
}
