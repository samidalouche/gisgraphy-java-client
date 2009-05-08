package com.gisgraphy.client;

import org.springframework.core.io.InputStreamSource;

import com.gisgraphy.client.impl.GeolocalisationQuery;
import com.gisgraphy.client.impl.FullTextQuery;

public interface GisgraphyServer extends UrlGenerator{
    public InputStreamSource fullTextSearch(FullTextQuery searchQuery);
    public InputStreamSource geolocalisationSearch(GeolocalisationQuery geolocalisationQuery);
    public void destroy() throws Exception;
}
