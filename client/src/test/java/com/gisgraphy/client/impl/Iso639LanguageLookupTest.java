package com.gisgraphy.client.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Iso639LanguageLookupTest {

	private Iso639LanguageLookup isoLookup;

	@Before
	public void setUp() throws UnsupportedEncodingException, IOException {
		isoLookup = new Iso639LanguageLookup();
	}
	
	@Test
	public void lookupFrenchLanguageUsingAlpha3Code(){
		assertEquals("Iso639Language[name=French,alpha2=fr,alpha3=fra]",
			isoLookup.findByAlpha3Code("fra").toString());
	}
	
	@Test
	public void lookupFrenchLanguageUsingAlpha2Code(){
		assertEquals("Iso639Language[name=French,alpha2=fr,alpha3=fra]",
			isoLookup.findByAlpha2Code("fr").toString());
	}

	@Test
	public void lookupLanguageThatDoesNotHaveAnyAlpha2Code() {
		assertEquals("Iso639Language[name=Ghotuo,alpha2=<null>,alpha3=aaa]",
			isoLookup.findByAlpha3Code("aaa").toString());
	}
	
	@Test
	public void lookupLanguageThatHasAlpha2Code() {
		assertEquals("Iso639Language[name=Bislama,alpha2=bi,alpha3=bis]",
			isoLookup.findByAlpha3Code("bis").toString());
	}
	
	@Test
	public void lookupUnkownLanguageUsingAlpha2CodeShouldReturnNull() {
		assertNull(isoLookup.findByAlpha2Code("yy"));
	}
	
	@Test
	public void lookupUnkownLanguageUsingAlpha3CodeShouldReturnNull() {
		assertNull(isoLookup.findByAlpha3Code("yyy"));
	}

}
