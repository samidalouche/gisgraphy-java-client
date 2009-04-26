package com.gisgraphy.client.impl;

import org.springframework.util.Assert;

public class GeolocalisationQuery {
    private String queryString;
    private Integer paginationStartIndex;
    private Double latitude;
    private Double longitude;
    private Integer radius;
    private Integer paginationEndIndex;
    private OutputFormat outputFormat;
    private String placeType;

    public static GeolocalisationQueryBuilder newSearchQuery() {
	return new GeolocalisationQueryBuilder();
    }

    private static class GeolocalisationQueryBuilder {
	private GeolocalisationQuery searchQuery;

	public GeolocalisationQueryBuilder() {
	    searchQuery = new GeolocalisationQuery();
	}

	public GeolocalisationQueryBuilder withQueryString(String queryString) {
	    searchQuery.queryString = queryString;
	    return this;
	}

	public GeolocalisationQueryBuilder withPaginationStartIndex(Integer startIndex) {
	    searchQuery.paginationStartIndex = startIndex;
	    return this;
	}

	public GeolocalisationQueryBuilder withPaginationEndIndex(Integer endIndex) {
	    searchQuery.paginationEndIndex = endIndex;
	    return this;
	}

	public GeolocalisationQueryBuilder withOutputFormat(OutputFormat outputFormat) {
	    searchQuery.outputFormat = outputFormat;
	    return this;
	}

	public GeolocalisationQueryBuilder withPlaceType(String placeType) {
	    searchQuery.placeType = placeType;
	    return this;
	}
	
	public GeolocalisationQueryBuilder withLatitude(Double latitude) {
	    searchQuery.latitude = latitude;
	    return this;
	}
	
	public GeolocalisationQueryBuilder withLongitude(Double longitude) {
	    searchQuery.longitude = longitude;
	    return this;
	}
	
	public GeolocalisationQueryBuilder withRadius(Integer radius) {
	    searchQuery.radius = radius;
	    return this;
	}

	public GeolocalisationQuery build() {
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

    public String getPlaceType() {
	return placeType;
    }

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public Integer getRadius() {
		return radius;
	}

    

}
