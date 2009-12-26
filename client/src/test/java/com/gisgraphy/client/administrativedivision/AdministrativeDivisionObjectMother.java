package com.gisgraphy.client.administrativedivision;

import static com.gisgraphy.client.administrativedivision.AdministrativeDivision.administrativeDivision;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.californiaAdm1GisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.ileDeFranceAdm1GisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.parisAdm2GisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.parisAdm3GisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.parisAdm4GisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.rambouilletAdm3GisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.rambouilletAdm4GisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureObjectMother.yvelinesAdm2GisFeature;

public class AdministrativeDivisionObjectMother {

    public static AdministrativeDivision californiaAdm1() {
	return administrativeDivision("California")
		.withCode("CA")
		.andGisFeature(californiaAdm1GisFeature());
    }
    
    public static AdministrativeDivision losAngelesAdm2() {
	return administrativeDivision("Los Angeles County")
		.withCode("037")
		.andGisFeature(californiaAdm1GisFeature());
    }
    
    public static AdministrativeDivision rambouilletAdm4() {
	return administrativeDivision("Rambouillet")
		.withCode("78517")
		.andGisFeature(rambouilletAdm4GisFeature());
    }
    
    public static AdministrativeDivision rambouilletAdm3() {
	return administrativeDivision("Arrondissement de Rambouillet")
		.withCode("782")
		.andGisFeature(rambouilletAdm3GisFeature());
    }
    
    public static AdministrativeDivision yvelinesAdm2() {
	return administrativeDivision("Département des Yvelines")
		.withCode("78")
		.andGisFeature(yvelinesAdm2GisFeature());
    }
    
    public static AdministrativeDivision parisAdm3() {
	return administrativeDivision("Arrondissement de Paris")
		.withCode("751")
		.andGisFeature(parisAdm3GisFeature());
    }
    
    public static AdministrativeDivision parisAdm4() {
	return administrativeDivision("Paris")
		.withCode("75056")
		.andGisFeature(parisAdm4GisFeature());
    }
    
    public static AdministrativeDivision parisAdm2() {
	return administrativeDivision("Département de Ville-de-Paris")
		.withCode("75")
		.andGisFeature(parisAdm2GisFeature());
    }
    
    public static AdministrativeDivision ileDeFranceAdm1() {
	return administrativeDivision("Région Île-de-France")
		.withCode("A8")
		.andGisFeature(ileDeFranceAdm1GisFeature());
    }
    
}
