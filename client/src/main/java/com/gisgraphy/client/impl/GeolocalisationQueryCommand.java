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

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gisgraphy.client.UnknownGisgraphyQueryException;
import com.gisgraphy.client.UrlGenerator;

public class GeolocalisationQueryCommand {
    private static final Logger logger = LoggerFactory
	    .getLogger(GeolocalisationQueryCommand.class);

    private HttpClient httpClient;
    private UrlGenerator urlGenerator;
    private GeolocalisationQuery geolocalisationQuery;

    public GeolocalisationQueryCommand(HttpClient httpClient,
	    UrlGenerator urlGenerator, GeolocalisationQuery geolocalisationQuery) {
	super();
	this.httpClient = httpClient;
	this.urlGenerator = urlGenerator;
	this.geolocalisationQuery = geolocalisationQuery;
    }

    /**
     * 
     * @return the XML resulting from the gisgraphy call
     * @throws UnknownGisgraphyQueryException
     * @throws UnknownGisgraphyQueryException
     */
    public InputStream execute() throws UnknownGisgraphyQueryException {
	try {
	    HttpGet httpGet = createHttpGetFor(geolocalisationQuery);
	    HttpResponse response = httpClient.execute(httpGet);
	    HttpEntity entity = response.getEntity();
	    logger
		    .debug("Gisgraphy search query done successfully for searchQuery: "
			    + geolocalisationQuery);
	    return entity.getContent();

	} catch (IOException e) {
	    throw new UnknownGisgraphyQueryException(geolocalisationQuery, e);
	}
    }

    private HttpGet createHttpGetFor(GeolocalisationQuery geolocalisationQuery) {
	HttpGet httpGet = new HttpGet(urlGenerator
		.generateGeolocalisationQuery(geolocalisationQuery));
	return httpGet;
    }

}
