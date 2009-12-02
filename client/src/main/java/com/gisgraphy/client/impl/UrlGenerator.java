package com.gisgraphy.client.impl;

import com.gisgraphy.client.impl.gisgraphyserver.FullTextQuery;
import com.gisgraphy.client.impl.gisgraphyserver.GeolocalisationQuery;
import com.gisgraphy.client.impl.gisgraphyserver.GisgraphyQuery;


public interface UrlGenerator {
	
	public String generateUrl(GisgraphyQuery query);
	public String fullTextQueryUrl(FullTextQuery fullTextQuery);
	public String geolocalizationQueryUrl(GeolocalisationQuery geolocalisationQuery);
}
