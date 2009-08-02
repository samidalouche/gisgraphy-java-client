package com.gisgraphy.client.administrativedivision;

import org.junit.Assert;
import org.junit.Test;

import com.gisgraphy.client.administrativedivision.AdministrativeCountryInformation;

public class AdministrativeCountryInformationTest {

    @Test
    public void shouldCreateAdministrativeCountryInformation() {
	AdministrativeCountryInformation franceAdministrativeCountryInformation = AdministrativeCountryInformationObjectMother.franceAdministrativeCountryInformation();
	Assert.assertEquals(".fr", franceAdministrativeCountryInformation.getTopLevelDomain());
	Assert.assertEquals("33", franceAdministrativeCountryInformation.getPhonePrefix());
	Assert.assertEquals("#####", franceAdministrativeCountryInformation.getPostalCodeMask());
	Assert.assertEquals("^(\\d{5})$", franceAdministrativeCountryInformation.getPostalCodeRegex());
	Assert.assertEquals("[IsoLanguage[name=Français,alpha2=fr,alpha3=fra]]", franceAdministrativeCountryInformation.getSpokenLanguages().toString());
    }
}
