package com.gisgraphy.client;

import com.gisgraphy.client.impl.GeolocalisationQuery;
import com.gisgraphy.client.impl.SearchQuery;

public interface UrlGenerator {
    public String generateFullTextSearchQuery(SearchQuery searchQuery);
    public String generateGeolocalisationQuery(GeolocalisationQuery geolocalisationQuery);
}
