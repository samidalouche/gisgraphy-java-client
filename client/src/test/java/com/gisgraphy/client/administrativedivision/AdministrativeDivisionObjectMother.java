package com.gisgraphy.client.administrativedivision;

import static com.gisgraphy.client.administrativedivision.AdministrativeDivision.administrativeDivision;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.arrondissementDeRambouilletAdm3GisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.ileDeFranceAdm1GisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.rambouilletAdm4GisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.yvelinesAdm2GisFeature;

public class AdministrativeDivisionObjectMother {

    public static AdministrativeDivision rambouilletAdm4() {
	return administrativeDivision("Rambouillet")
		.withCode("78517")
		.andGisFeature(rambouilletAdm4GisFeature());
	}
    
    public static AdministrativeDivision arrondissementDeRambouilletAdm3() {
	return administrativeDivision("Arrondissement de Rambouillet")
		.withCode("782")
		.andGisFeature(arrondissementDeRambouilletAdm3GisFeature());
    }
    
    public static AdministrativeDivision yvelinesAdm2() {
	return administrativeDivision("Département des Yvelines")
		.withCode("78")
		.andGisFeature(yvelinesAdm2GisFeature());
    }
    
    public static AdministrativeDivision ileDeFranceAdm1() {
	return administrativeDivision("Région Île-de-France")
		.withCode("A8")
		.andGisFeature(ileDeFranceAdm1GisFeature());
    }
    
}
