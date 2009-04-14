package com.gisgraphy.client;

import org.springframework.core.io.InputStreamSource;

import com.gisgraphy.client.impl.SearchQuery;

public interface GisgraphyServer extends UrlGenerator{
    public InputStreamSource fullTextSearch(SearchQuery searchQuery);
    public void destroy() throws Exception;
}
