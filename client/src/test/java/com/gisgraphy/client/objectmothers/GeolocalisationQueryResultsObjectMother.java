package com.gisgraphy.client.objectmothers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;

public class GeolocalisationQueryResultsObjectMother {

	public static InputStreamSource paris() {
		return new ClassPathResource("/com/gisgraphy/client/sampleGeolocalisationQueries/geolocalisationQueryResultsNearParis.xml");
	}
}
