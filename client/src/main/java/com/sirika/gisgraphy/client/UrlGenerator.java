package com.sirika.gisgraphy.client;

import com.sirika.gisgraphy.client.impl.SearchQuery;

public interface UrlGenerator {
    public String generateFullTextSearchQuery(SearchQuery searchQuery);
}
