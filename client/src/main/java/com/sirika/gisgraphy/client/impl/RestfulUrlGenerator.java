package com.sirika.gisgraphy.client.impl;

import com.sirika.gisgraphy.client.UrlGenerator;

public class RestfulUrlGenerator implements UrlGenerator {

    private String baseUrl;

    public RestfulUrlGenerator(String baseUrl) {
	super();
	this.baseUrl = baseUrl;
    }

    public String generateFullTextSearchQuery(SearchQuery searchQuery) {
	return String
		.format(
			"%s/fulltext/fulltextsearch/?q=%s&from=%s&to=%s&format=%s&lang=%s&placetype=%s&country=%s",
			baseUrl, searchQuery.getQueryString(), searchQuery
				.getPaginationStartIndex(), searchQuery
				.getPaginationEndIndex(), searchQuery
				.getOutputFormat(), searchQuery
				.getLanguageCode(), searchQuery.getPlaceType(),
			searchQuery.getCountryCode());
    }

}
