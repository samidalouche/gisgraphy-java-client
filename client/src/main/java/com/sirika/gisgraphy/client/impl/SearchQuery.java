package com.sirika.gisgraphy.client.impl;

import org.springframework.util.Assert;

public class SearchQuery {
    private String queryString;
    private Integer paginationStartIndex;
    private Integer paginationEndIndex;
    private OutputFormat outputFormat;
    private String languageCode;
    private String placeType;
    private String countryCode;

    public static SearchQueryBuilder newSearchQuery() {
	return new SearchQueryBuilder();
    }

    private static class SearchQueryBuilder {
	private SearchQuery searchQuery;

	public SearchQueryBuilder() {
	    searchQuery = new SearchQuery();
	}

	public SearchQueryBuilder withQueryString(String queryString) {
	    searchQuery.queryString = queryString;
	    return this;
	}

	public SearchQueryBuilder withPaginationStartIndex(Integer startIndex) {
	    searchQuery.paginationStartIndex = startIndex;
	    return this;
	}

	public SearchQueryBuilder withPaginationEndIndex(Integer endIndex) {
	    searchQuery.paginationEndIndex = endIndex;
	    return this;
	}

	public SearchQueryBuilder withOutputFormat(OutputFormat outputFormat) {
	    searchQuery.outputFormat = outputFormat;
	    return this;
	}

	public SearchQueryBuilder withLanguageCode(String languageCode) {
	    searchQuery.languageCode = languageCode;
	    return this;
	}

	public SearchQueryBuilder withPlaceType(String placeType) {
	    searchQuery.placeType = placeType;
	    return this;
	}

	public SearchQueryBuilder withCountryCode(String countryCode) {
	    searchQuery.countryCode = countryCode;
	    return this;
	}

	public SearchQuery build() {
	    check();
	    return searchQuery;
	}

	private void check() {
	    Assert.hasText(searchQuery.queryString);
	}
    }

    public String getQueryString() {
	return queryString;
    }

    public Integer getPaginationStartIndex() {
	return paginationStartIndex;
    }

    public Integer getPaginationEndIndex() {
	return paginationEndIndex;
    }

    public OutputFormat getOutputFormat() {
	return outputFormat;
    }

    public String getLanguageCode() {
	return languageCode;
    }

    public String getPlaceType() {
	return placeType;
    }

    public String getCountryCode() {
	return countryCode;
    }

}
