package com.gisgraphy.client.impl;

import org.springframework.util.Assert;

import com.gisgraphy.client.GisgraphyQuery;

public class FullTextQuery implements GisgraphyQuery {
    private String queryString;
    private Integer paginationStartIndex;
    private Integer paginationEndIndex;
    private OutputFormat outputFormat;
    private OutputStyle outputStyle;
    private String languageCode;
    private String placeType;
    private String countryCode;

    public static FullTextQueryBuilder newSearchQuery() {
	return new FullTextQueryBuilder();
    }

    public static class FullTextQueryBuilder {
	private FullTextQuery fullTextQuery;

	public FullTextQueryBuilder() {
	    fullTextQuery = new FullTextQuery();
	}

	public FullTextQueryBuilder withQueryString(String queryString) {
	    fullTextQuery.queryString = queryString;
	    return this;
	}

	public FullTextQueryBuilder withPaginationStartIndex(Integer startIndex) {
	    fullTextQuery.paginationStartIndex = startIndex;
	    return this;
	}

	public FullTextQueryBuilder withPaginationEndIndex(Integer endIndex) {
	    fullTextQuery.paginationEndIndex = endIndex;
	    return this;
	}

	public FullTextQueryBuilder withOutputFormat(OutputFormat outputFormat) {
	    fullTextQuery.outputFormat = outputFormat;
	    return this;
	}

	public FullTextQueryBuilder withLanguageCode(String languageCode) {
	    fullTextQuery.languageCode = languageCode;
	    return this;
	}

	public FullTextQueryBuilder withPlaceType(String placeType) {
	    fullTextQuery.placeType = placeType;
	    return this;
	}

	public FullTextQueryBuilder withCountryCode(String countryCode) {
	    fullTextQuery.countryCode = countryCode;
	    return this;
	}
	
	public FullTextQueryBuilder withOutputStyle(OutputStyle outputStyle) {
		fullTextQuery.outputStyle = outputStyle;
		return this;
	}

	public FullTextQuery build() {
	    check();
	    return fullTextQuery;
	}

	private void check() {
	    Assert.hasText(fullTextQuery.queryString);
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

	public OutputStyle getOutputStyle() {
		return outputStyle;
	}

}
