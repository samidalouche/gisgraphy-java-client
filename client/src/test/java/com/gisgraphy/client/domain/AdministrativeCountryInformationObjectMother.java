package com.gisgraphy.client.domain;

import com.google.common.collect.ImmutableList;

public class AdministrativeCountryInformationObjectMother {

    public static AdministrativeCountryInformation franceAdministrativeCountryInformation() {
	return AdministrativeCountryInformation
		.administrativeCountryInformation()
		.withTopLevelDomain(".fr")
		.withPhonePrefix("33")
		.withPostalCodeMask("#####")
		.withPostalCodeRegex("^(\\d{5})$")
		.withSpokenLanguages(ImmutableList.of(IsoLanguageObjectMother.frenchIsoLanguage()));
    }
}
