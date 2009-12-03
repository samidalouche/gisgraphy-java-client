package com.gisgraphy.client.impl;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;

public class GeolocalisationQueryResultsObjectMother {

    public static InputStreamSource paris() {
	return new ClassPathResource("/com/gisgraphy/client/sampleGeolocalisationQueries/geolocalisationQueryResultsNearParis.xml");
    }
}
