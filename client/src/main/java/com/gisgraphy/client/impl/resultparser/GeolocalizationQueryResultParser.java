package com.gisgraphy.client.impl.resultparser;

import org.springframework.core.io.InputStreamSource;

import com.gisgraphy.client.impl.FullTextQueryResult;
import com.gisgraphy.client.impl.GeolocalisationResult;

public interface GeolocalizationQueryResultParser {
    public Iterable<GeolocalisationResult> parse(InputStreamSource iss) throws ParsingException;

}
