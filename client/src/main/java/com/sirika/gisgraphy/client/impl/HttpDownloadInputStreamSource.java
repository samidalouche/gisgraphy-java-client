/**
 * ImgServer Java REST Client
 * Copyright (C) 2008 Sami Dalouche
 *
 * This file is part of ImgServer Java REST Client.
 *
 * ImgServer Java REST Client is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ImgServer Java REST Client is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with ImgServer.  If not, see <http://www.gnu.org/licenses/>.
 */
/**
 * 
 */
package com.sirika.gisgraphy.client.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamSource;

import com.sirika.gisgraphy.client.ResourceNotExistingException;
import com.sirika.gisgraphy.client.UnknownGisgraphyQueryException;
import com.sirika.gisgraphy.client.UrlGenerator;

class HttpDownloadInputStreamSource implements InputStreamSource{
    private final static Logger logger = LoggerFactory.getLogger(HttpDownloadInputStreamSource.class);
    private HttpClient httpClient;
    private com.sirika.gisgraphy.client.UrlGenerator urlGenerator;
    private HttpGet httpGet;
    private SearchQuery searchQuery;
    
    public HttpDownloadInputStreamSource(HttpClient httpClient, UrlGenerator urlGenerator, SearchQuery searchQuery) {
	super();
	this.urlGenerator = urlGenerator;
	this.httpClient = httpClient;
	this.searchQuery = searchQuery;
	
	this.httpGet = new HttpGet(urlGenerator.generateFullTextSearchQuery(searchQuery));
    }

    public InputStream getInputStream() throws IOException {
	logger.debug("Generating InputStream for {}", searchQuery);
	HttpResponse response = httpClient.execute(httpGet);
	
	logger.debug("Received Status: {}", response.getStatusLine());
	handleErrors(response);

        return generateInputStream(response.getEntity());
    }

    private InputStream generateInputStream(HttpEntity entity) throws IOException {
	if(entity != null) {
	    return entity.getContent();
	} else {
	    return null;
	}
    }

    private void handleErrors(HttpResponse response) {
	handle404NotFound(response);
	handleNon2xx(response);
    }

    private void handleNon2xx(HttpResponse response) throws UnknownGisgraphyQueryException {
	if(response.getStatusLine().getStatusCode() >= 300) {
	    httpGet.abort();
	    throw new UnknownGisgraphyQueryException(searchQuery, new HttpResponseException(response.getStatusLine().getStatusCode(), "Error while downloading"));
	}
    }

    private void handle404NotFound(HttpResponse response) {
	if(HttpStatus.SC_NOT_FOUND == response.getStatusLine().getStatusCode()) {
	    throw new ResourceNotExistingException(searchQuery);
	}
    }
    
}