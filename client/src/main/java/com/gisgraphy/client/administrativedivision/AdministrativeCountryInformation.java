package com.gisgraphy.client.administrativedivision;

import com.gisgraphy.client.language.Iso639Language;
import com.google.common.collect.ImmutableList;

public interface AdministrativeCountryInformation {

    public abstract String getTopLevelDomain();

    public abstract String getPhonePrefix();

    public abstract String getPostalCodeMask();

    public abstract String getPostalCodeRegex();

    public abstract ImmutableList<Iso639Language> getSpokenLanguages();

}