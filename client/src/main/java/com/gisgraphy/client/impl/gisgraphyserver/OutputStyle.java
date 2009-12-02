package com.gisgraphy.client.impl.gisgraphyserver;

public enum OutputStyle {
	SHORT
	{
	    public String toString() {
	        return "short";
	    }
	}, 
	MEDIUM {
	    public String toString() {
	        return "medium";
	    }
	}, 
	LONG{
	    public String toString() {
	        return "long";
	    }
	}, 
	FULL
	{
	    public String toString() {
	        return "full";
	    }
	}
}
