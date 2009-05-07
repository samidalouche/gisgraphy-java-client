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

import java.util.HashMap;
import java.util.Map;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.params.AllClientPNames;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.impl.client.BasicCookieStore;
import org.springframework.beans.factory.FactoryBean;
/**
 * Spring {@link FactoryBean} helper that eases the creation and configuration of HttpComponents' {@link HttpClient}.
 * Configuring HttpClient authentication, number of connections, ... cannot be done declaratively using HttpClient's 
 * native mechanisms. {@link HttpClientFactoryBean}'s goal is to expose these settings so they can be changed declaratively 
 * using Spring.
 * 
 * 
 * @author Sami Dalouche (sami.dalouche@gmail.com)
 *
 */
public class HttpClientFactoryBean implements FactoryBean {
    private Map<AuthScope, Credentials> credentials = new HashMap<AuthScope, Credentials>();
    private Map<String,Object> params = new HashMap<String, Object>();
    private CookieStore cookieStore = null;
    private boolean shouldUseCookieStore = false;
    private boolean shouldUseGzipContentcompression = true;
    private Integer maxTotalConnections = null;
    private Integer defaultMaxConnectionsPerRoute = null;
    
    public Object getObject() throws Exception {
	if(maxTotalConnections != null) {
	    params.put(AllClientPNames.MAX_TOTAL_CONNECTIONS, maxTotalConnections);
	}
	if(defaultMaxConnectionsPerRoute != null) {
	    params.put(AllClientPNames.MAX_CONNECTIONS_PER_ROUTE, new ConnPerRouteBean(defaultMaxConnectionsPerRoute));
	}
	
	return DefaultHttpClientFactory.httpClient(credentials, params, cookieStore(), shouldUseGzipContentcompression);
    }

    private CookieStore cookieStore() {
	CookieStore cookieStoreToUse = null;
	if(shouldUseCookieStore == true) {
	    cookieStoreToUse = cookieStore == null? new BasicCookieStore() : cookieStore;
	}
	return cookieStoreToUse;
    }

  
    public Class getObjectType() {
	return HttpClient.class;
    }

    public boolean isSingleton() {
	return true;
    }

    public void setCredentials(Map<AuthScope, Credentials> credentials) {
        this.credentials = credentials;
    }

    public void setCookieStore(CookieStore cookieStore) {
	this.shouldUseCookieStore = true;
        this.cookieStore = cookieStore;
    }

    public void setShouldUseCookieStore(boolean shouldUseCookieStore) {
        this.shouldUseCookieStore = shouldUseCookieStore;
    }

    public void setShouldUseGzipContentcompression(boolean shouldUseGzipContentcompression) {
        this.shouldUseGzipContentcompression = shouldUseGzipContentcompression;
    }

    /**
     * See http://hc.apache.org/httpclient-3.x/preference-api.html
     * 
     * @param params
     */
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public void setMaxTotalConnections(Integer maxTotalConnections) {
        this.maxTotalConnections = maxTotalConnections;
    }

    public void setDefaultMaxConnectionsPerRoute(
    	Integer defaultMaxConnectionsPerRoute) {
        this.defaultMaxConnectionsPerRoute = defaultMaxConnectionsPerRoute;
    }

}
