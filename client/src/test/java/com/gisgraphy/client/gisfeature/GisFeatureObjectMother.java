package com.gisgraphy.client.gisfeature;

import static com.gisgraphy.client.administrativedivision.AdministrativeDivisionObjectMother.ileDeFranceAdm1;
import static com.gisgraphy.client.administrativedivision.AdministrativeDivisionObjectMother.parisAdm2;
import static com.gisgraphy.client.administrativedivision.AdministrativeDivisionObjectMother.parisAdm3;
import static com.gisgraphy.client.administrativedivision.AdministrativeDivisionObjectMother.parisAdm4;
import static com.gisgraphy.client.administrativedivision.AdministrativeDivisionObjectMother.rambouilletAdm3;
import static com.gisgraphy.client.administrativedivision.AdministrativeDivisionObjectMother.yvelinesAdm2;
import static com.gisgraphy.client.administrativedivision.CountryObjectMother.france;
import static com.gisgraphy.client.gisfeature.GeonamesGisFeature.gisFeature;
import static com.gisgraphy.client.gisfeature.GisFeatureGeographyObjectMother.antarcticaCountryGisFeatureGeography;
import static com.gisgraphy.client.gisfeature.GisFeatureGeographyObjectMother.franceCountryGisFeatureGeography;
import static com.gisgraphy.client.gisfeature.GisFeatureGeographyObjectMother.ileDeFranceAdm1GisFeatureGeography;
import static com.gisgraphy.client.gisfeature.GisFeatureGeographyObjectMother.parisAdm2GisFeatureGeography;
import static com.gisgraphy.client.gisfeature.GisFeatureGeographyObjectMother.parisAdm3GisFeatureGeography;
import static com.gisgraphy.client.gisfeature.GisFeatureGeographyObjectMother.parisPplcGisFeatureGeography;
import static com.gisgraphy.client.gisfeature.GisFeatureGeographyObjectMother.rambouilletAdm3GisFeatureGeography;
import static com.gisgraphy.client.gisfeature.GisFeatureGeographyObjectMother.rambouilletAdm4GisFeatureGeography;
import static com.gisgraphy.client.gisfeature.GisFeatureGeographyObjectMother.rambouilletPPlGisFeatureGeography;
import static com.gisgraphy.client.gisfeature.GisFeatureGeographyObjectMother.unitedStatesCountryGisFeatureGeography;
import static com.gisgraphy.client.gisfeature.GisFeatureGeographyObjectMother.usOutlyingIslandsCountryGisFeatureGeography;
import static com.gisgraphy.client.gisfeature.GisFeatureGeographyObjectMother.yvelinesAdm2GisFeatureGeography;
import static com.gisgraphy.client.gisfeature.GisFeatureNames.gisFeatureName;
import static com.gisgraphy.client.gisfeature.GisFeatureType.geonamesFeatureClass;

import com.gisgraphy.client.administrativedivision.AdministrativeDivisionObjectMother;

/**
 *
 * @author christophe
 */
public class GisFeatureObjectMother {

    public static GeonamesGisFeature unitedStatesGisFeature() {
        return gisFeature()
                .geonamesId(6252001L)
                .names(gisFeatureName("United States"))
                .type(geonamesFeatureClass("A").geonamesFeatureCode("PCLI"))
                .geography(unitedStatesCountryGisFeatureGeography())
                .build();
    }

    
    public static GeonamesGisFeature franceGisFeature() {
        return gisFeature()
                .geonamesId(3017382L)
                .names(gisFeatureName("France"))
                .type(geonamesFeatureClass("A").geonamesFeatureCode("PCLI"))
                .geography(franceCountryGisFeatureGeography())
                .build();
    }

    public static GeonamesGisFeature antarcticaGisFeature() {
        return gisFeature()
                .geonamesId(6697173L)
                .names(gisFeatureName("Antarctica"))
                .type(geonamesFeatureClass("A").geonamesFeatureCode("PCLI"))
                .geography(antarcticaCountryGisFeatureGeography())
                .build();
    }

    public static GeonamesGisFeature usOutlyingIslandsGisFeature() {
        return gisFeature()
                .geonamesId(5854968L)
                .names(gisFeatureName("United States Minor Outlying Islands"))
                .type(geonamesFeatureClass("A").geonamesFeatureCode("ADMD"))
                .geography(usOutlyingIslandsCountryGisFeatureGeography())
                .build();
    }
    
    public static GeonamesGisFeature rambouilletPplGisFeature() {
	return gisFeature()
		.geonamesId(2984513L)
		.names(gisFeatureName("Rambouillet").withAsciiName("Rambouillet"))
		.type(geonamesFeatureClass("P").geonamesFeatureCode("PPL"))
		.parentAdministrativeEntity(AdministrativeDivisionObjectMother.rambouilletAdm4())
		.geography(rambouilletPPlGisFeatureGeography())
		.build();
    }
    
    public static GeonamesGisFeature parisPplcGisFeature() {
	return gisFeature()
		.geonamesId(2988507L)
		.names(gisFeatureName("Paris").withAsciiName("Paris"))
		.type(geonamesFeatureClass("P").geonamesFeatureCode("PPLC"))
		.parentAdministrativeEntity(parisAdm4())
		.geography(parisPplcGisFeatureGeography())
		.build();
    }
    
    public static GeonamesGisFeature gazeranPplGisFeature() {
	return gisFeature()
		.geonamesId(3016456L)
		.names(gisFeatureName("Gazeran").withAsciiName("Gazeran"))
		.type(geonamesFeatureClass("P").geonamesFeatureCode("PPL"))
		.parentAdministrativeEntity(AdministrativeDivisionObjectMother.rambouilletAdm4())
		.geography(rambouilletPPlGisFeatureGeography())
		.build();
    }
    
    public static GeonamesGisFeature rambouilletAdm4GisFeature() {
	return gisFeature()
		.geonamesId(6444057L)
		.names(gisFeatureName("Rambouillet").withAsciiName("Rambouillet"))
		.type(geonamesFeatureClass("A").geonamesFeatureCode("ADM4"))
		.parentAdministrativeEntity(rambouilletAdm3())
		.geography(rambouilletAdm4GisFeatureGeography())
		.build();
    }

    public static GeonamesGisFeature gazeranAdm4GisFeature() {
	return gisFeature()
		.geonamesId(3016456L)
		.names(gisFeatureName("Gazeran").withAsciiName("Gazeran"))
		.type(geonamesFeatureClass("A").geonamesFeatureCode("ADM4"))
		.parentAdministrativeEntity(rambouilletAdm3())
		.geography(rambouilletAdm4GisFeatureGeography())
		.build();
    }
    
    public static GeonamesGisFeature rambouilletAdm3GisFeature() {
	return gisFeature()
		.geonamesId(2984512L)
		.names(gisFeatureName("Rambouillet").withAsciiName("Rambouillet"))
		.type(geonamesFeatureClass("A").geonamesFeatureCode("ADM3"))
		.parentAdministrativeEntity(yvelinesAdm2())
		.geography(rambouilletAdm3GisFeatureGeography())
		.build();
    }
    
    public static GeonamesGisFeature yvelinesAdm2GisFeature() {
	return gisFeature()
		.geonamesId(2967196L)
		.names(gisFeatureName("Département des Yvelines").withAsciiName("Departement des Yvelines"))
		.type(geonamesFeatureClass("A").geonamesFeatureCode("ADM2"))
		.parentAdministrativeEntity(ileDeFranceAdm1())
		.geography(yvelinesAdm2GisFeatureGeography())
		.build();
    }
    
    public static GeonamesGisFeature parisAdm4GisFeature() {
	return gisFeature()
		.geonamesId(6455259L)
		.names(gisFeatureName("Paris").withAsciiName("Paris"))
		.type(geonamesFeatureClass("A").geonamesFeatureCode("ADM4"))
		.parentAdministrativeEntity(parisAdm3())
		.geography(parisAdm3GisFeatureGeography())
		.build();
    }
    
    public static GeonamesGisFeature parisAdm3GisFeature() {
	return gisFeature()
		.geonamesId(2988506L)
		.names(gisFeatureName("Arrondissement de Paris").withAsciiName("Arrondissement de Paris"))
		.type(geonamesFeatureClass("A").geonamesFeatureCode("ADM3"))
		.parentAdministrativeEntity(parisAdm2())
		.geography(parisAdm3GisFeatureGeography())
		.build();
    }
    
    public static GeonamesGisFeature parisAdm2GisFeature() {
	return gisFeature()
		.geonamesId(2968815L)
		.names(gisFeatureName("Département de Ville-de-Paris").withAsciiName("Departement de Ville-de-Paris"))
		.type(geonamesFeatureClass("A").geonamesFeatureCode("ADM2"))
		.parentAdministrativeEntity(ileDeFranceAdm1())
		.geography(parisAdm2GisFeatureGeography())
		.build();
    }
    
    public static GeonamesGisFeature ileDeFranceAdm1GisFeature() {
	return gisFeature()
		.geonamesId(3012874L)
		.names(gisFeatureName("Région Île-de-France").withAsciiName("Region Ile-de-France"))
		.type(geonamesFeatureClass("A").geonamesFeatureCode("ADM1"))
		.parentAdministrativeEntity(france())
		.geography(ileDeFranceAdm1GisFeatureGeography())
		.build();
    }
    
    
}
