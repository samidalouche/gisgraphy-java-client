package com.gisgraphy.client.domain;

import static com.gisgraphy.client.domain.Continent.continent;

public class ContinentObjectMother {
    public static Continent europe() {
	return continent("EU").withName("Europe");
    }
    
    public static Continent antarcticaContinent() {
	return continent("AN").withName("Antarctica");
    }
}
