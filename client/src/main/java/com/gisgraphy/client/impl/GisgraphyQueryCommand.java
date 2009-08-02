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

import org.apache.http.client.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamSource;


public class GisgraphyQueryCommand {
	private static final Logger logger = LoggerFactory.getLogger(GisgraphyQueryCommand.class);

	private final HttpClient httpClient;
	private final UrlGenerator urlGenerator;
	private final GisgraphyQuery searchQuery;

	public GisgraphyQueryCommand(HttpClient httpClient, UrlGenerator urlGenerator, GisgraphyQuery searchQuery) {
		super();
		this.httpClient = httpClient;
		this.urlGenerator = urlGenerator;
		this.searchQuery = searchQuery;
	}

	/**
	 * 
	 * @return the XML resulting from the gisgraphy call
	 * @throws UnknownGisgraphyQueryException
	 * @throws UnknownGisgraphyQueryException
	 */
	public InputStreamSource execute() throws UnknownGisgraphyQueryException {
		return new HttpGisgraphyQueryInputStreamSource(this.httpClient, this.urlGenerator, this.searchQuery);	
	}

}
