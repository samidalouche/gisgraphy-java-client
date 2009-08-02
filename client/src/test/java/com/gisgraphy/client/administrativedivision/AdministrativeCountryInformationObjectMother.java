package com.gisgraphy.client.administrativedivision;

import com.gisgraphy.client.administrativedivision.AdministrativeCountryInformation;
import com.gisgraphy.client.language.IsoLanguageObjectMother;
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
    
    public static AdministrativeCountryInformation antarcticaAdministrativeCountryInformation() {
	return AdministrativeCountryInformation
		.administrativeCountryInformation()
		.withTopLevelDomain(".aq");
    }
    
    public static AdministrativeCountryInformation usOutlyingIslandsAdministrativeCountryInformation() {
	return AdministrativeCountryInformation
		.administrativeCountryInformation()
		.withTopLevelDomain(".am");
    }
}
