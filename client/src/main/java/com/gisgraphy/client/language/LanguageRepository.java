package com.gisgraphy.client.language;

public interface LanguageRepository {
    IsoLanguage findByAlpha2Code(String code);
    IsoLanguage findByAlpha3Code(String code);
}
