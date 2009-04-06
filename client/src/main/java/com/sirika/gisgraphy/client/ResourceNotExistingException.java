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
package com.sirika.gisgraphy.client;

import com.sirika.gisgraphy.client.impl.SearchQuery;


public class ResourceNotExistingException extends GisgraphyClientException {
    private static final long serialVersionUID = 1L;
    
    private SearchQuery searchQuery;
    
    public ResourceNotExistingException(SearchQuery searchQuery) {
	this.searchQuery = searchQuery;
    }

    public SearchQuery getSearchQuery() {
        return searchQuery;
    }
    
}
