package com.gisgraphy.client.impl;

import org.springframework.core.io.InputStreamSource;


public interface GisgraphyServer extends UrlGenerator{
    public InputStreamSource executeSearch(GisgraphyQuery searchQuery);
    public void destroy() throws Exception;
}
