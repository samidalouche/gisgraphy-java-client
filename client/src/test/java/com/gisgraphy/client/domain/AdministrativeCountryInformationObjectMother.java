package com.gisgraphy.client.domain;

public class AdministrativeCountryInformationObjectMother {

    public static AdministrativeCountryInformation franceCountryInformationObjectMother() {
	return AdministrativeCountryInformation
		.administrativeCountryInformation()
		.withTopLevelDomain(".fr")
		.withPhonePrefix("33")
		.withPostalCodeMask("#####")
		.withPostalCodeRegex("\\d{5}");
    }
}
