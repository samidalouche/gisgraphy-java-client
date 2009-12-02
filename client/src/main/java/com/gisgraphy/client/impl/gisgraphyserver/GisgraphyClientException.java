package com.gisgraphy.client.impl.gisgraphyserver;

public class GisgraphyClientException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public GisgraphyClientException() {
	super();
    }
    
    public GisgraphyClientException(Throwable cause) {
	super(cause);
    }
    
    public GisgraphyClientException(String message, Throwable cause) {
	super(message, cause);
    }

    public GisgraphyClientException(String message) {
	super(message);
    }
}
