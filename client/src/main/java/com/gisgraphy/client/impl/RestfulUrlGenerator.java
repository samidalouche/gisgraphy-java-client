package com.gisgraphy.client.impl;


/**
 * FIXME: should UrlEncode the URLs
 * @author Sami Dalouche (sami.dalouche@gmail.com)
 *
 */
public class RestfulUrlGenerator implements UrlGenerator {

    private String baseUrl;

    public RestfulUrlGenerator(String baseUrl) {
	super();
	this.baseUrl = baseUrl;
    }

    public String fullTextQueryUrl(FullTextQuery fullTextQuery) {
	return String.format("%s/fulltext/fulltextsearch?q=%s&from=%s&to=%s&format=%s&lang=%s&placetype=%s&country=%s&style=%s",
		baseUrl, 
		fullTextQuery.getQueryString(), 
		fullTextQuery.getPagination().getOffset(), 
		fullTextQuery.getPagination().getEndOffset(), 
		fullTextQuery.getOutputFormat(), 
		fullTextQuery.getLanguageCode(),
		fullTextQuery.getPlaceType(),
		fullTextQuery.getCountryCode(),
		fullTextQuery.getOutputStyle());
    }

    public String geolocalizationQueryUrl(GeolocalisationQuery geolocalisationQuery) {
	return String.format(
		"%s/geoloc/findnearbylocation?lat=%s&lng=%s&radius=%s&from=%s&to=%s&format=xml&placetype=%s", baseUrl,
		geolocalisationQuery.getLatitude(), 
		geolocalisationQuery.getLongitude(), 
		geolocalisationQuery.getRadius(), 
		geolocalisationQuery.getPagination().getOffset(), 
		geolocalisationQuery.getPagination().getEndOffset(), 
		geolocalisationQuery.getOutputFormat(), 
		geolocalisationQuery.getPlaceType());
    }

    public String generateUrl(GisgraphyQuery query) {
	return query.accept(this);
    }

}
