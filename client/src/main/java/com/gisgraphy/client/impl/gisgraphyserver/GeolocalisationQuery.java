package com.gisgraphy.client.impl.gisgraphyserver;



public class GeolocalisationQuery implements GisgraphyQuery, Paginable  {
    private static class GeolocalisationQueryBuilder {
	private GeolocalisationQuery searchQuery;

	public GeolocalisationQueryBuilder() {
	    searchQuery = new GeolocalisationQuery();
	}

	public GeolocalisationQuery build() {
	    return searchQuery;
	}

	public GeolocalisationQueryBuilder withLatitude(Double latitude) {
	    searchQuery.latitude = latitude;
	    return this;
	}

	public GeolocalisationQueryBuilder withLongitude(Double longitude) {
	    searchQuery.longitude = longitude;
	    return this;
	}

	public GeolocalisationQueryBuilder withOutputFormat(OutputFormat outputFormat) {
	    searchQuery.outputFormat = outputFormat;
	    return this;
	}

	public GeolocalisationQueryBuilder withPagination(Pagination pagination) {
	    searchQuery.pagination = pagination;
	    return this;
	}

	public GeolocalisationQueryBuilder withPlaceType(String placeType) {
	    searchQuery.placeType = placeType;
	    return this;
	}

	public GeolocalisationQueryBuilder withRadius(Integer radius) {
	    searchQuery.radius = radius;
	    return this;
	}
    }
    public static GeolocalisationQueryBuilder newSearchQuery() {
	return new GeolocalisationQueryBuilder();
    }
    private Double latitude;
    private Double longitude;
    private OutputFormat outputFormat;
    private Pagination pagination;
    private String placeType;
    private Integer radius;

    public String accept(UrlGenerator restfulUrlGenerator) {
	return restfulUrlGenerator.geolocalizationQueryUrl(this);
    }

    public Double getLatitude() {
	return latitude;
    }

    public Double getLongitude() {
	return longitude;
    }

    public OutputFormat getOutputFormat() {
	return outputFormat;
    }

    public String getPlaceType() {
	return placeType;
    }

    public Integer getRadius() {
	return radius;
    }

    public Pagination getPagination() {
        return pagination;
    }

}
