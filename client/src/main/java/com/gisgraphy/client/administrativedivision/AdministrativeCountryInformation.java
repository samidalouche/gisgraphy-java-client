package com.gisgraphy.client.administrativedivision;

import com.gisgraphy.client.language.Iso639Language;
import com.google.common.collect.ImmutableList;

public interface AdministrativeCountryInformation {
    String getTopLevelDomain();
    String getPhonePrefix();
    String getPostalCodeMask();
    String getPostalCodeRegex();
    ImmutableList<Iso639Language> getSpokenLanguages();
}