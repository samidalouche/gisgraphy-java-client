package com.gisgraphy.client.impl;

import com.gisgraphy.client.GisgraphyQuery;
import com.gisgraphy.client.UrlGenerator;

public class RestfulUrlGenerator implements UrlGenerator {

	private String baseUrl;

	public RestfulUrlGenerator(String baseUrl) {
		super();
		this.baseUrl = baseUrl;
	}

	public String visit(FullTextQuery fullTextQuery) {
		return String.format("%s/fulltext/fulltextsearch?q=%s&from=%s&to=%s&format=%s&lang=%s&placetype=%s&country=%s&style=%s",
				baseUrl, fullTextQuery.getQueryString(), fullTextQuery.getPaginationStartIndex(), fullTextQuery
						.getPaginationEndIndex(), fullTextQuery.getOutputFormat(), fullTextQuery.getLanguageCode(),
				fullTextQuery.getPlaceType(), fullTextQuery.getCountryCode(), fullTextQuery.getOutputStyle());
	}
	
	public String visit(GeolocalisationQuery geolocalisationQuery) {
		return String.format(
				"%s/geoloc/findnearbylocation?lat=%s&lng=%s&radius=%s&from=%s&to=%s&format=xml&placetype=%s", baseUrl,
				geolocalisationQuery.getLatitude(), geolocalisationQuery.getLongitude(), geolocalisationQuery
						.getRadius(), geolocalisationQuery.getPaginationStartIndex(), geolocalisationQuery
						.getPaginationEndIndex(), geolocalisationQuery.getOutputFormat(), geolocalisationQuery
						.getPlaceType());
	}

	@Override
	public String generateUrl(GisgraphyQuery query) {
		return query.accept(this);
	}

}
