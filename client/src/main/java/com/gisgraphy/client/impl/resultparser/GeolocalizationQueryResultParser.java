package com.gisgraphy.client.impl.resultparser;

import org.springframework.core.io.InputStreamSource;


public interface GeolocalizationQueryResultParser {
    public Iterable<GeolocalisationResult> parse(InputStreamSource iss) throws ParsingException;

}
