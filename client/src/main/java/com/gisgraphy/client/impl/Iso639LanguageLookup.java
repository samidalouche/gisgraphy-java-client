package com.gisgraphy.client.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import com.gisgraphy.client.domain.IsoLanguage;
import com.gisgraphy.client.domain.LanguageRepository;
import com.google.common.collect.ImmutableMap;

public class Iso639LanguageLookup implements LanguageRepository {
	
	private final ImmutableMap<String, IsoLanguage> ISO639ALPHA3MAP;
	private final ImmutableMap<String, IsoLanguage> ISO639ALPHA2MAP;

	public Iso639LanguageLookup() throws UnsupportedEncodingException, IOException {
		
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("iso-languagecodes.txt"), "UTF8"));
			    
			final ImmutableMap.Builder<String, IsoLanguage> iso639Alpha3LanguageBuilder = ImmutableMap.builder();
			final ImmutableMap.Builder<String, IsoLanguage> iso639Alpha2LanguageBuilder = ImmutableMap.builder();
			String line;
			while ((line = in.readLine()) != null) {
				String[] res = line.split("\t");
				int i = 0;

				String iso639Alpha3 = res[i++];
				@SuppressWarnings("unused")
				String isoAlphaFucked = res[i++]; // contains ISO 639-2 codes,
				// which are fucked by nature
				String iso639Alpha2 = res[i++];
				String languageName = res[i++];
				IsoLanguage iso = IsoLanguage.isoLanguage(languageName).alpha3(iso639Alpha3);
				
				if (!iso639Alpha2.equals("")) {
					iso = iso.alpha2(iso639Alpha2);
					iso639Alpha2LanguageBuilder.put(iso639Alpha2, iso);
				}
				
				iso639Alpha3LanguageBuilder.put(iso639Alpha3, iso);
			}
			ISO639ALPHA3MAP = iso639Alpha3LanguageBuilder.build();
			ISO639ALPHA2MAP = iso639Alpha2LanguageBuilder.build();
		} finally {
			if (in != null)
				in.close();
		}
	}
	
	public IsoLanguage findByAlpha3Code(String code) {
		return ISO639ALPHA3MAP.get(code);
	}
	
	public IsoLanguage findByAlpha2Code(String code) {
		return ISO639ALPHA2MAP.get(code);
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		Iso639LanguageLookup isoLookup = new Iso639LanguageLookup();
		System.out.println("abd is: " + isoLookup.findByAlpha3Code("abd"));

	}

}
