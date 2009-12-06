package com.gisgraphy.client.gisfeature;

import static com.gisgraphy.client.gisfeature.GisFeatureGeography.gisFeatureGeography;

public class GisFeatureGeographyObjectMother {

    public static GisFeatureGeography ileDeFranceAdm1GisFeatureGeography() {
	return gisFeatureGeography(new Double("2.5"), new Double("48.5"))
		.withPopulation(11341257L);
    }
    
    public static GisFeatureGeography rambouilletPPlGisFeatureGeography() {
	return gisFeatureGeography(new Double("1.8333332538604736"), new Double("48.650001525878906"))
		.withPopulation(0L);
    }
   
    
    public static GisFeatureGeography rambouilletAdm4GisFeatureGeography() {
	return gisFeatureGeography(new Double("1.8333332538604736"), new Double("48.650001525878906"))
		.withPopulation(0L);
    }
    
    public static GisFeatureGeography arrondissementDeRambouilletAdm3GisFeatureGeography() {
	return gisFeatureGeography(new Double("1.9166667461395264"), new Double("48.58333206176758"))
		.withPopulation(0L);
    }
    
    public static GisFeatureGeography yvelinesAdm2GisFeatureGeography() {
	return gisFeatureGeography(new Double("1.8666666746139526"), new Double("48.78333282470703"))
		.withPopulation(1411761L)
		.withGtopo30AverageElevation(104L);
    }
    
    public static GisFeatureGeography losAngelesPplGisFeatureGeography() {
	return gisFeatureGeography(new Double("-118.24278"), new Double("34.05222"));
    }
    
    public static GisFeatureGeography marinaDelReyPplGisFeatureGeography() {
	return gisFeatureGeography(new Double("-118.452912"), new Double("33.979361"));
    }
    
    public static GisFeatureGeography parisPplGisFeatureGeography() {
	return gisFeatureGeography(new Double("2.333056"), new Double("48.866667"));
    }
    

}
