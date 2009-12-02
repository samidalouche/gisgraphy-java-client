/**
 * PyMager Java REST Client
 * Copyright (C) 2008 Sami Dalouche
 *
 * This file is part of PyMager Java REST Client.
 *
 * PyMager Java REST Client is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PyMager Java REST Client is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with PyMager Java REST Client.  If not, see <http://www.gnu.org/licenses/>.
 */
/**
 * 
 */
package com.gisgraphy.client.impl.gisgraphyserver;

import static com.sirika.httpclienthelpers.template.AbstractHttpErrorHandler.statusCodeEquals;
import static com.sirika.httpclienthelpers.template.AbstractHttpErrorHandler.statusCodeGreaterOrEquals;

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

import com.gisgraphy.client.impl.UrlGenerator;
import com.google.common.collect.ImmutableList;
import com.sirika.httpclienthelpers.template.AbstractHttpErrorHandler;
import com.sirika.httpclienthelpers.template.HttpClientTemplate;
import com.sirika.httpclienthelpers.template.HttpErrorHandler;
import com.sirika.httpclienthelpers.template.HttpResponseCallback;

class HttpGisgraphyQueryInputStreamSource implements InputStreamSource{
    private final static Logger logger = LoggerFactory.getLogger(HttpGisgraphyQueryInputStreamSource.class);
    private HttpClientTemplate httpClientTemplate;
    private HttpGet httpGet;
    private GisgraphyQuery query;
    
    public HttpGisgraphyQueryInputStreamSource(HttpClient httpClient, UrlGenerator urlGenerator, GisgraphyQuery query) {
	super();
	this.httpClientTemplate = new HttpClientTemplate(httpClient);
	this.query = query;
	this.httpGet = new HttpGet(urlGenerator.generateUrl(query));
    }

    public InputStream getInputStream() throws IOException, ResourceNotExistingException {
	logger.debug("Generating InputStream for {}", query);
	
	return (InputStream) this.httpClientTemplate.execute(this.httpGet, new HttpResponseCallback() {
	    public Object doWithHttpResponse(HttpResponse httpResponse) throws Exception {
		return generateInputStream(httpResponse.getEntity());
	    }    
	}, httpErrorHandlers());

    }

    private Iterable<HttpErrorHandler> httpErrorHandlers() {
	return ImmutableList.of(notFoundHandler(), defaultHandler());
    }
    
    private HttpErrorHandler notFoundHandler() {
	return new AbstractHttpErrorHandler(statusCodeEquals(HttpStatus.SC_NOT_FOUND)) {
	    public void handle(HttpResponse response) throws Exception {
		throw new ResourceNotExistingException(query);
	    }
	};
    }
    
    private HttpErrorHandler defaultHandler() {
	return new AbstractHttpErrorHandler(statusCodeGreaterOrEquals(300)) {
	    public void handle(HttpResponse response) throws Exception {
		throw new UnknownGisgraphyQueryException(query, new HttpResponseException(response.getStatusLine().getStatusCode(), response.getStatusLine().getReasonPhrase()));
		}
	};
    }

    private InputStream generateInputStream(HttpEntity entity) throws IOException {
	if(entity != null) {
	    return entity.getContent();
	} else {
	    return null;
	}
    }
    
}