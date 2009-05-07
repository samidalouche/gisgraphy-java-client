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
package com.gisgraphy.client.httpclienthelpers;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.client.CookieStore;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

public class DefaultHttpClientFactory {
    public static DefaultHttpClient defaultHttpClient() {
	return new DefaultHttpClient(threadSafeClientConnManager(defaultHttpParams()), defaultHttpParams());
    }
    
    public static DefaultHttpClient httpClient(Map<AuthScope, Credentials> credentials, Map<String,Object> params, CookieStore cookieStore, boolean shouldUseGzipCompression) {
	DefaultHttpClient httpClient = new DefaultHttpClient(threadSafeClientConnManager(httpParams(params)), httpParams(params));
	for(Entry<AuthScope, Credentials> e : credentials.entrySet()) {
	    httpClient.getCredentialsProvider().setCredentials(e.getKey(), e.getValue());    
	}
	
	if(cookieStore != null) {
	    httpClient.setCookieStore(cookieStore);
	}
	
	if(shouldUseGzipCompression) {
	    handleGzipContentCompression(httpClient);

	}
	return httpClient;
    }
    
    private static void handleGzipContentCompression(DefaultHttpClient httpClient) {
	httpClient.addRequestInterceptor(new HttpRequestInterceptor() {
	    public void process(HttpRequest request, HttpContext context)
		    throws HttpException, IOException {
		if (!request.containsHeader("Accept-Encoding")) {
	                request.addHeader("Accept-Encoding", "gzip");
	            }
	    }

	    });
	    
	httpClient.addResponseInterceptor(new HttpResponseInterceptor() {
	public void process(final HttpResponse response, final HttpContext context) throws HttpException, IOException {
	    HttpEntity entity = response.getEntity();
	    Header ceheader = entity.getContentEncoding();
	    if (ceheader != null) {
		HeaderElement[] codecs = ceheader.getElements();
		for (int i = 0; i < codecs.length; i++) {
		    if (codecs[i].getName().equalsIgnoreCase("gzip")) {
			response.setEntity(new GzipDecompressingEntity(response.getEntity())); 
			return;
		    }
		}
	    }
	}
	});
    }

    public static ThreadSafeClientConnManager threadSafeClientConnManager(HttpParams httpParams) {
	return new ThreadSafeClientConnManager(httpParams, defaultSchemeRegistry());
    }

    public static SchemeRegistry defaultSchemeRegistry() {
	SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(
                new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(
                new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        return schemeRegistry;
    }

    public static BasicHttpParams httpParams(Map<String,Object> params) {
	BasicHttpParams httpParams =  new BasicHttpParams();
	for(Entry<String, Object> e : params.entrySet()) {
	    httpParams.setParameter(e.getKey(), e.getValue());
	}
	return httpParams;
    }
    
    public static BasicHttpParams defaultHttpParams() {
	return new BasicHttpParams();
    }
}
