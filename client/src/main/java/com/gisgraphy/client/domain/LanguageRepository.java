package com.gisgraphy.client.domain;

public interface LanguageRepository {
    IsoLanguage findByAlpha2Code(String code);
    IsoLanguage findByAlpha3Code(String code);
}
