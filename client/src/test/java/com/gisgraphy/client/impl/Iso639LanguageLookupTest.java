package com.gisgraphy.client.impl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class Iso639LanguageLookupTest {

	private Iso639LanguageLookup isoLookup;

	public void setUp() throws UnsupportedEncodingException, IOException {
		isoLookup = new Iso639LanguageLookup();
	}
	
	@Test
	public void lookupFrenchLanguage() throws UnsupportedEncodingException, IOException {
		assertEquals("IsoLanguage[name=French,alpha2=fr,alpha3=fra]",
				new Iso639LanguageLookup().findByAlpha3Code("fra").toString());
	}

	@Test
	public void lookupLanguageThatDoesNotHaveAnyAlpha2Code() throws UnsupportedEncodingException, IOException {
		assertEquals("IsoLanguage[name=Ghotuo,alpha2=<null>,alpha3=aaa]",
				new Iso639LanguageLookup().findByAlpha3Code("aaa").toString());
	}
	
	@Test
	public void lookupLanguageThatHasAlpha2Code() throws UnsupportedEncodingException, IOException {
		assertEquals("IsoLanguage[name=Bislama,alpha2=bi,alpha3=bis]",
				new Iso639LanguageLookup().findByAlpha3Code("bis").toString());
	}

}
