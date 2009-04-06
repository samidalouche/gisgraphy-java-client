package com.sirika.gisgraphy.client;

import org.springframework.core.io.InputStreamSource;

import com.sirika.gisgraphy.client.impl.SearchQuery;

public interface GisgraphyServer extends UrlGenerator{
    public InputStreamSource fullTextSearch(SearchQuery searchQuery);
    public void destroy() throws Exception;
}
