package com.gisgraphy.client.gisfeature;

import static com.gisgraphy.client.gisfeature.GisFeatureGeography.gisFeatureGeography;

public class GisFeatureGeographyObjectMother {

    
    public static GisFeatureGeography californiaAdm1GisFeatureGeography() {
	return GisFeatureGeography.gisFeatureGeography(-119.75126647949219, 37.25022506713867)
		.withPopulation(36354327L)
		.withTimeZone("America/Los_Angeles")
		.withGtopo30AverageElevation(427l)
		.withElevation(469L);
    }
    
    public static GisFeatureGeography unitedStatesCountryGisFeatureGeography() {
	return GisFeatureGeography.gisFeatureGeography(-98.5, 39.7599983215332)
		.withPopulation(303824000L)
		.withTimeZone("America/North_Dakota/New_Salem")
		.withGtopo30AverageElevation(537l);
    }
    
    public static GisFeatureGeography franceCountryGisFeatureGeography() {
	return GisFeatureGeography.gisFeatureGeography(2.0, 46.0)
		.withPopulation(64094000L)
		.withTimeZone("Europe/Paris")
		.withGtopo30AverageElevation(560L);
    }
    
    public static GisFeatureGeography antarcticaCountryGisFeatureGeography() {
	return GisFeatureGeography.gisFeatureGeography(0.0,0.0)
		.withPopulation(0L)
		.withTimeZone("Antarctica/South_Pole")
		.withGtopo30AverageElevation(2481L);
    }
    
    public static GisFeatureGeography usOutlyingIslandsCountryGisFeatureGeography() {
	return GisFeatureGeography.gisFeatureGeography(-162.072494506836, 5.88111019134521)
		.withPopulation(0L)
		.withTimeZone("Pacific/Johnston")
		.withGtopo30AverageElevation(-9999L);
    }
    
    public static GisFeatureGeography ileDeFranceAdm1GisFeatureGeography() {
	return gisFeatureGeography(new Double("2.5"), new Double("48.5"))
		.withPopulation(11341257L)
		.withTimeZone("Europe/Paris")
		.withGtopo30AverageElevation(75L);
    }
    
    public static GisFeatureGeography rambouilletPPlGisFeatureGeography() {
	return gisFeatureGeography(new Double("1.8333332538604736"), new Double("48.650001525878906"))
		.withPopulation(0L)
		.withTimeZone("Europe/Paris")
		.withGtopo30AverageElevation(161L);
    }
   
    
    public static GisFeatureGeography rambouilletAdm4GisFeatureGeography() {
	return gisFeatureGeography(new Double("1.8333332538604736"), new Double("48.650001525878906"))
		.withPopulation(0L)
		.withTimeZone("Europe/Paris")
		.withGtopo30AverageElevation(161L);
    }
    
    public static GisFeatureGeography rambouilletAdm3GisFeatureGeography() {
	return gisFeatureGeography(new Double("1.9166667461395264"), new Double("48.58333206176758"))
		.withPopulation(0L)
		.withTimeZone("Europe/Paris")
		.withGtopo30AverageElevation(160L);
    }
    
    public static GisFeatureGeography yvelinesAdm2GisFeatureGeography() {
	return gisFeatureGeography(new Double("1.8666666746139526"), new Double("48.78333282470703"))
		.withPopulation(1411761L)
		.withTimeZone("Europe/Paris")
		.withGtopo30AverageElevation(104L);
    }
    
    public static GisFeatureGeography parisAdm2GisFeatureGeography() {
	return gisFeatureGeography(new Double("2.3485984802246094"), new Double("48.8534049987793"))
		.withPopulation(2138551L)
		.withTimeZone("Europe/Paris")
		.withGtopo30AverageElevation(30L);
    }
    
    public static GisFeatureGeography parisAdm3GisFeatureGeography() {
	return gisFeatureGeography(new Double("2.348644256591797"), new Double("48.85338592529297"))
		.withPopulation(0L)
		.withTimeZone("Europe/Paris")
		.withGtopo30AverageElevation(30L);
    }
    
    public static GisFeatureGeography parisAdm4GisFeatureGeography() {
	return gisFeatureGeography(new Double("2.3523616790771484"), new Double("48.8564567565918"))
		.withPopulation(0L)
		.withTimeZone("Europe/Paris")
		.withGtopo30AverageElevation(35L);
    }
    

    public static GisFeatureGeography losAngelesAdm2GisFeatureGeography() {
	return gisFeatureGeography(new Double("-118.2009048461914"), new Double("34.36666488647461"))
		.withPopulation(8863164L)
		.withTimeZone("America/Los_Angeles")
		.withGtopo30AverageElevation(1494L)
		.withElevation(1506L);
    }
    
    public static GisFeatureGeography losAngelesPplGisFeatureGeography() {
	return gisFeatureGeography(new Double("-118.24368286132812"), new Double("34.0522346496582"))
		.withPopulation(3694820L)
		.withTimeZone("America/Los_Angeles")
		.withGtopo30AverageElevation(115L)
		.withElevation(89L);
    }
    
    public static GisFeatureGeography marinaDelReyPplGisFeatureGeography() {
	return gisFeatureGeography(new Double("-118.45174407958984"), new Double("33.980289459228516"))
		.withPopulation(8680L)
		.withTimeZone("America/Los_Angeles")
		.withGtopo30AverageElevation(7L)
		.withElevation(5L);
    }
    
    public static GisFeatureGeography parisPplcGisFeatureGeography() {
	return gisFeatureGeography(new Double("2.333056"), new Double("48.866667"))
		.withPopulation(2138551L)
		.withTimeZone("Europe/Paris")
		.withGtopo30AverageElevation(30L);
    }
    

}
