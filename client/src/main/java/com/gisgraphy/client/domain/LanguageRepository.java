package com.gisgraphy.client.domain;

public interface LanguageRepository {
    IsoLanguage findByAlpha3Code(String code);
}
