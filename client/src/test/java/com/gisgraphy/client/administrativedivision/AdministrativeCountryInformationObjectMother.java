package com.gisgraphy.client.administrativedivision;

import static com.gisgraphy.client.language.IsoLanguageObjectMother.englishIsoLanguage;
import static com.gisgraphy.client.language.IsoLanguageObjectMother.hawaiianIsoLanguage;
import static com.gisgraphy.client.language.IsoLanguageObjectMother.spanishIsoLanguage;

import com.gisgraphy.client.administrativedivision.GeonamesAdministrativeCountryInformation;
import com.gisgraphy.client.language.IsoLanguageObjectMother;
import com.google.common.collect.ImmutableList;

public class AdministrativeCountryInformationObjectMother {

    public static AdministrativeCountryInformation unitedStatesAdministrativeCountryInformation() {
	return GeonamesAdministrativeCountryInformation
		.administrativeCountryInformation()
		.withTopLevelDomain(".us")
		.withPhonePrefix("1")
		.withPostalCodeMask("#####-####")
		.withPostalCodeRegex("^(\\d{9})$")
		.withSpokenLanguages(ImmutableList.of(englishIsoLanguage(), spanishIsoLanguage(), hawaiianIsoLanguage()));
    }
    
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
