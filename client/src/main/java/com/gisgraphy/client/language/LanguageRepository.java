package com.gisgraphy.client.language;

public interface LanguageRepository {
    Iso639Language findByAlpha2Code(String code);
    Iso639Language findByAlpha3Code(String code);
}
