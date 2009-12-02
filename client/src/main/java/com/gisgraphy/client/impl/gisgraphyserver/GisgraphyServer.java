package com.gisgraphy.client.impl.gisgraphyserver;

import org.springframework.core.io.InputStreamSource;

import com.gisgraphy.client.impl.UrlGenerator;


public interface GisgraphyServer extends UrlGenerator{
    public InputStreamSource executeSearch(GisgraphyQuery searchQuery);
    public void destroy() throws Exception;
}
