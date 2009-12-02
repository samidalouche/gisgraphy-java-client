package com.gisgraphy.client.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import com.gisgraphy.client.language.Iso639Language;
import com.gisgraphy.client.language.LanguageRepository;
import com.google.common.collect.ImmutableMap;

public class InMemoryIso639LanguageRepository implements LanguageRepository {
	
	private final ImmutableMap<String, Iso639Language> ISO639ALPHA3MAP;
	private final ImmutableMap<String, Iso639Language> ISO639ALPHA2MAP;

	public InMemoryIso639LanguageRepository() throws UnsupportedEncodingException, IOException {
		
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("iso-languagecodes.txt"), "UTF8"));
			    
			final ImmutableMap.Builder<String, Iso639Language> iso639Alpha3LanguageBuilder = ImmutableMap.builder();
			final ImmutableMap.Builder<String, Iso639Language> iso639Alpha2LanguageBuilder = ImmutableMap.builder();
			String line;
			// Skip the first line, which contains header informatiion
			in.readLine();
			while ((line = in.readLine()) != null) {
				String[] res = line.split("\t");
				int i = 0;

				String iso639Alpha3 = res[i++];
				@SuppressWarnings("unused")
				String isoAlphaFucked = res[i++]; // contains ISO 639-2 codes,
				// which are fucked by nature
				String iso639Alpha2 = res[i++];
				String languageName = res[i++];
				Iso639Language iso = Iso639Language.isoLanguage(languageName).withAlpha3(iso639Alpha3);
				
				if (!iso639Alpha2.equals("")) {
					iso = iso.withAlpha2Code(iso639Alpha2);
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
	
	public Iso639Language findByAlpha3Code(String code) {
		return ISO639ALPHA3MAP.get(code);
	}
	
	public Iso639Language findByAlpha2Code(String code) {
		return ISO639ALPHA2MAP.get(code);
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		InMemoryIso639LanguageRepository isoLookup = new InMemoryIso639LanguageRepository();
		System.out.println("abd is: " + isoLookup.findByAlpha3Code("abd"));

	}

}
