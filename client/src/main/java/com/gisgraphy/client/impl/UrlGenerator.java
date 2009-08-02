package com.gisgraphy.client.impl;


public interface UrlGenerator {
	
	public String generateUrl(GisgraphyQuery query);
	public String visit(FullTextQuery fullTextQuery);
	public String visit(GeolocalisationQuery geolocalisationQuery);
}
