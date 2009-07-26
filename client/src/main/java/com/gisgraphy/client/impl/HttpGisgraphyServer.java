
package com.gisgraphy.client.impl;

import static com.sirika.httpclienthelpers.DefaultHttpClientFactory.defaultHttpClient;

import org.apache.commons.lang.Validate;
import org.apache.http.client.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamSource;

import com.gisgraphy.client.GisgraphyQuery;
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
		logger.info("Creating Gisgraphy Server using , HttpClient [{}], URLGenerator [{}]", httpClient, urlGenerator);
		Validate.notNull(urlGenerator);
		Validate.notNull(httpClient);
		this.urlGenerator = urlGenerator;
		this.httpClient = httpClient;
	}

	public InputStreamSource executeSearch(GisgraphyQuery searchQuery) {
		return new GisgraphyQueryCommand(httpClient, urlGenerator, searchQuery).execute();
	}

	public String generateFullTextSearchQuery(FullTextQuery searchQuery) {
		String url = urlGenerator.generateUrl(searchQuery);
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

	public String generateGeolocalisationQuery(GeolocalisationQuery geolocalisationQuery) {
		String url = urlGenerator.generateUrl(geolocalisationQuery);
		logger.debug("generateGeolocalisationQuery: generated URL : {}", url);
		return url;
	}

	@Override
	public String generateUrl(GisgraphyQuery query) {
		return urlGenerator.generateUrl(query);
	}

	@Override
	public String visit(FullTextQuery fullTextQuery) {
		return fullTextQuery.accept(urlGenerator);
	}

	@Override
	public String visit(GeolocalisationQuery geolocalisationQuery) {
		return geolocalisationQuery.accept(urlGenerator);
	}
}
