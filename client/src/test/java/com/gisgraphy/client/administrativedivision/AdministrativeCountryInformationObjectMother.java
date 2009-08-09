package com.gisgraphy.client.administrativedivision;

import com.gisgraphy.client.administrativedivision.GeonamesAdministrativeCountryInformation;
import com.gisgraphy.client.language.IsoLanguageObjectMother;
import com.google.common.collect.ImmutableList;

public class AdministrativeCountryInformationObjectMother {

    public static AdministrativeCountryInformation franceAdministrativeCountryInformation() {
	return GeonamesAdministrativeCountryInformation
		.administrativeCountryInformation()
		.withTopLevelDomain(".fr")
		.withPhonePrefix("33")
		.withPostalCodeMask("#####")
		.withPostalCodeRegex("^(\\d{5})$")
		.withSpokenLanguages(ImmutableList.of(IsoLanguageObjectMother.frenchIsoLanguage()));
    }
    
    public static AdministrativeCountryInformation antarcticaAdministrativeCountryInformation() {
	return GeonamesAdministrativeCountryInformation
		.administrativeCountryInformation()
		.withTopLevelDomain(".aq");
    }
    
    public static AdministrativeCountryInformation usOutlyingIslandsAdministrativeCountryInformation() {
	return GeonamesAdministrativeCountryInformation
		.administrativeCountryInformation()
		.withTopLevelDomain(".am");
    }
}
