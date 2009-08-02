package com.gisgraphy.client.administrativedivision;

import static com.gisgraphy.client.administrativedivision.AdministrativeDivision.administrativeDivision;
import static com.gisgraphy.client.administrativedivision.CountryObjectMother.france;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.arrondissementDeRambouilletAdm3GisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.ileDeFranceAdm1GisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.rambouilletAdm4GisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.yvelinesAdm2GisFeature;

import com.gisgraphy.client.administrativedivision.AdministrativeDivision;

public class AdministrativeDivisionObjectMother {

    public static AdministrativeDivision rambouilletAdm4() {
	return administrativeDivision("Rambouillet")
		.withCode("78517")
		.withGisFeature(rambouilletAdm4GisFeature())
		.andParentEntity(arrondissementDeRambouilletAdm3());
    }
    
    public static AdministrativeDivision arrondissementDeRambouilletAdm3() {
	return administrativeDivision("Arrondissement de Rambouillet")
		.withCode("782")
		.withGisFeature(arrondissementDeRambouilletAdm3GisFeature())
		.andParentEntity(yvelinesAdm2());
    }
    
    public static AdministrativeDivision yvelinesAdm2() {
	return administrativeDivision("Département des Yvelines")
		.withCode("78")
		.withGisFeature(yvelinesAdm2GisFeature())
		.andParentEntity(ileDeFranceAdm1());
    }
    
    public static AdministrativeDivision ileDeFranceAdm1() {
	return administrativeDivision("Région Île-de-France")
		.withCode("A8")
		.withGisFeature(ileDeFranceAdm1GisFeature())
		.andParentEntity(france());
    }
    
}
