package com.gisgraphy.client;

import com.gisgraphy.client.impl.GeolocalisationQuery;
import com.gisgraphy.client.impl.FullTextQuery;

public interface UrlGenerator {
    public String generateFullTextSearchQuery(FullTextQuery searchQuery);
    public String generateGeolocalisationQuery(GeolocalisationQuery geolocalisationQuery);
}
