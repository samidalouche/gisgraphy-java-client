package com.gisgraphy.client.continent;

import static com.gisgraphy.client.continent.Continent.continent;

import com.gisgraphy.client.continent.Continent;

public class ContinentObjectMother {
    public static Continent europe() {
	return continent("EU").withName("Europe");
    }
    
    public static Continent northAmericaContinent() {
	return continent("NA").withName("North America");
    }
    
    public static Continent antarcticaContinent() {
	return continent("AN").withName("Antarctica");
    }
    
    public static Continent oceania() {
	return continent("OC").withName("Oceania");
    }
}
