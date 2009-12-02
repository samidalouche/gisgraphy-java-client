package com.gisgraphy.client.impl.gisgraphyserver;

import org.springframework.util.Assert;

import com.gisgraphy.client.impl.OutputFormat;
import com.gisgraphy.client.impl.OutputStyle;
import com.gisgraphy.client.impl.Paginable;
import com.gisgraphy.client.impl.Pagination;
import com.gisgraphy.client.impl.UrlGenerator;


public class FullTextQuery implements GisgraphyQuery, Paginable {
    public static class FullTextQueryBuilder {
	private FullTextQuery fullTextQuery;

	public FullTextQueryBuilder() {
	    fullTextQuery = new FullTextQuery();
	}

	public FullTextQuery build() {
	    check();
	    return fullTextQuery;
	}

	private void check() {
	    Assert.hasText(fullTextQuery.queryString);
	}

	public FullTextQueryBuilder withCountryCode(String countryCode) {
	    fullTextQuery.countryCode = countryCode;
	    return this;
	}

	public FullTextQueryBuilder withLanguageCode(String languageCode) {
	    fullTextQuery.languageCode = languageCode;
	    return this;
	}

	public FullTextQueryBuilder withOutputFormat(OutputFormat outputFormat) {
	    fullTextQuery.outputFormat = outputFormat;
	    return this;
	}

	public FullTextQueryBuilder withOutputStyle(OutputStyle outputStyle) {
	    fullTextQuery.outputStyle = outputStyle;
	    return this;
	}

	public FullTextQueryBuilder withPagination(Pagination pagination) {
	    fullTextQuery.pagination = pagination;
	    return this;
	}

	public FullTextQueryBuilder withPlaceType(String placeType) {
	    fullTextQuery.placeType = placeType;
	    return this;
	}

	public FullTextQueryBuilder withQueryString(String queryString) {
	    fullTextQuery.queryString = queryString;
	    return this;
	}
    }
    public static FullTextQueryBuilder newSearchQuery() {
	return new FullTextQueryBuilder();
    }
    private String countryCode;
    private String languageCode;
    private OutputFormat outputFormat;
    private OutputStyle outputStyle;
    private Pagination pagination;

    private String placeType;

    private String queryString;

    public String accept(UrlGenerator restfulUrlGenerator) {
	return restfulUrlGenerator.fullTextQueryUrl(this);
    }

    public String getCountryCode() {
	return countryCode;
    }

    public String getLanguageCode() {
	return languageCode;
    }

    public OutputFormat getOutputFormat() {
	return outputFormat;
    }

    public OutputStyle getOutputStyle() {
	return outputStyle;
    }

    public String getPlaceType() {
	return placeType;
    }

    public String getQueryString() {
	return queryString;
    }

    public Pagination getPagination() {
        return pagination;
    }

}
