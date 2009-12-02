package com.gisgraphy.client.impl.gisgraphyserver;



public interface UrlGenerator {
	
	public String generateUrl(GisgraphyQuery query);
	public String fullTextQueryUrl(FullTextQuery fullTextQuery);
	public String geolocalizationQueryUrl(GeolocalisationQuery geolocalisationQuery);
}
