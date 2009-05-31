package com.gisgraphy.client;

import com.gisgraphy.client.impl.FullTextQuery;
import com.gisgraphy.client.impl.GeolocalisationQuery;

public interface UrlGenerator {
	
	public String generateUrl(GisgraphyQuery query);
	public String visit(FullTextQuery fullTextQuery);
	public String visit(GeolocalisationQuery geolocalisationQuery);
}
