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
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.entity.mime.MIME;
import org.apache.http.entity.mime.content.AbstractContentBody;
import org.apache.james.mime4j.message.BinaryBody;
import org.springframework.core.io.InputStreamSource;

public class InputStreamSourceBody extends AbstractContentBody implements BinaryBody {
    private final InputStreamSource inputStreamSource;
    private final String filename;
    
    public InputStreamSourceBody(final InputStreamSource inputStreamSource, final String mimeType, final String filename) {
        super(mimeType);
        if (inputStreamSource == null) {
            throw new IllegalArgumentException("Input stream source may not be null");
        }
        this.inputStreamSource = inputStreamSource;
        this.filename = filename;
    }
    
    public InputStreamSourceBody(final InputStreamSource inputStreamSource, final String filename) {
        this(inputStreamSource, "application/octet-stream", filename);
    }
    
    public InputStream getInputStream() throws IOException {
        return this.inputStreamSource.getInputStream();
    }
    
    public void writeTo(final OutputStream out, int mode) throws IOException {
        if (out == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        InputStream in = null;
        try {
            in = this.inputStreamSource.getInputStream();
            IOUtils.copy(in, out);
            out.flush();
        } finally {
            in.close();
        }
    }
    
    public String getTransferEncoding() {
        return MIME.ENC_BINARY;
    }

    public String getCharset() {
        return null;
    }

    public long getContentLength() {
        return -1;
    }
    
    public String getFilename() {
        return this.filename;
    }
}
