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
package com.gisgraphy.client.impl;

import static com.gisgraphy.client.httpclienthelpers.DefaultHttpClientFactory.defaultHttpClient;

import org.apache.commons.lang.Validate;
import org.apache.http.client.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamSource;

import com.gisgraphy.client.GisgraphyServer;
import com.gisgraphy.client.UrlGenerator;

public class HttpGisgraphyServer implements GisgraphyServer {
	private static final Logger logger = LoggerFactory.getLogger(HttpGisgraphyServer.class);
	private UrlGenerator urlGenerator;
	private HttpClient httpClient;

	public HttpGisgraphyServer(String baseImageServiceUrl) {
		this(defaultHttpClient(), defaultUrlGeneratorFor(baseImageServiceUrl));
	}

	public HttpGisgraphyServer(UrlGenerator urlGenerator) {
		this(defaultHttpClient(), urlGenerator);
	}

	public HttpGisgraphyServer(HttpClient httpClient, String baseImageServiceUrl) {
		this(httpClient, defaultUrlGeneratorFor(baseImageServiceUrl));
	}

	public HttpGisgraphyServer(HttpClient httpClient, UrlGenerator urlGenerator) {
		logger.info("Creating Image Server using , HttpClient [{}], URLGenerator [{}]", httpClient, urlGenerator);
		Validate.notNull(urlGenerator);
		Validate.notNull(httpClient);
		this.urlGenerator = urlGenerator;
		this.httpClient = httpClient;
	}

	public InputStreamSource fullTextSearch(SearchQuery searchQuery) {
		return new FullTextQueryInputStreamSource(httpClient, urlGenerator, searchQuery);
	}

	public String generateFullTextSearchQuery(SearchQuery searchQuery) {
		String url = urlGenerator.generateFullTextSearchQuery(searchQuery);
		logger.debug("getFullTextSearchQueryUrl: generated URL : {}", url);
		return url;
	}

	public void destroy() throws Exception {
		this.httpClient.getConnectionManager().shutdown();
	}

	private static RestfulUrlGenerator defaultUrlGeneratorFor(String baseImageServiceUrl) {
		Validate.notNull(baseImageServiceUrl);
		return new RestfulUrlGenerator(baseImageServiceUrl);
	}

	public InputStreamSource geolocalisationSearch(GeolocalisationQuery geolocalisationQuery) {
		return new GeolocalisationQueryInputStreamSource(httpClient, urlGenerator, geolocalisationQuery);
	}

	public String generateGeolocalisationQuery(GeolocalisationQuery geolocalisationQuery) {
		String url = urlGenerator.generateGeolocalisationQuery(geolocalisationQuery);
		logger.debug("generateGeolocalisationQuery: generated URL : {}", url);
		return url;
	}
}
