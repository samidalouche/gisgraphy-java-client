package com.gisgraphy.client.impl.resultparser;

import org.springframework.core.io.InputStreamSource;

import com.gisgraphy.client.impl.FullTextQueryResult;

public interface FullTextQueryResultParser {
    public Iterable<FullTextQueryResult> parse(InputStreamSource iss) throws ParsingException;

}
