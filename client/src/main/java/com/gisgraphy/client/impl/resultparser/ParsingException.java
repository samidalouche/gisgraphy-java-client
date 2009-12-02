package com.gisgraphy.client.impl.resultparser;

public class ParsingException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ParsingException(String message, Throwable cause) {
	super(message, cause);
    }

    public ParsingException(Throwable cause) {
	super(cause);
    }

}
