/**
 * Gisgraphy Java REST Client
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

import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;

/**
 * We need to refactor this, so that it's in one common project, since it's exactly the same code as for the imgserver-java-client
 * @author christophe
 *
 */
public class DefaultHttpClientFactory {
    public static DefaultHttpClient defaultHttpClient() {
	return new DefaultHttpClient(threadSafeClientConnManager(), defaultHttpParams());
    }

    public static ThreadSafeClientConnManager threadSafeClientConnManager() {
	return new ThreadSafeClientConnManager(defaultHttpParams(), defaultSchemeRegistry());
    }

    public static SchemeRegistry defaultSchemeRegistry() {
	SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(
                new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(
                new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        return schemeRegistry;
    }

    public static BasicHttpParams defaultHttpParams() {
	return new BasicHttpParams();
    }
}
