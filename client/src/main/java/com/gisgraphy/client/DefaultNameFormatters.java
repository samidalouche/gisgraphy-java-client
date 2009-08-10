package com.gisgraphy.client;

import com.gisgraphy.client.commons.NameFormatter;
import com.gisgraphy.client.nameformatters.ConcatenatingNameFormatter;
import com.gisgraphy.client.nameformatters.FullyQualifiedNamesExtractor;
import com.gisgraphy.client.nameformatters.LongUsStyleNamesExtractor;
import com.gisgraphy.client.nameformatters.ShortQualifiedNamesExtractor;
import com.gisgraphy.client.nameformatters.ShortUsStyleNamesExtractor;
import com.gisgraphy.client.nameformatters.VeryShortQualifiedNamesExtractor;

public class DefaultNameFormatters {

    public static NameFormatter fullyQualifiedNameFormatter(String delimiter) {
	return new ConcatenatingNameFormatter(delimiter, true, new FullyQualifiedNamesExtractor());
    }
    
    public static NameFormatter shortQualifiedNameFormatter(String delimiter) {
	return new ConcatenatingNameFormatter(delimiter, true, new ShortQualifiedNamesExtractor());
    }
    
    public static NameFormatter veryShortQualifiedNameFormatter(String delimiter) {
	return new ConcatenatingNameFormatter(delimiter, true, new VeryShortQualifiedNamesExtractor());
    }
    
    public static NameFormatter shortUsStyleNameFormatter(String delimiter) {
	return new ConcatenatingNameFormatter(delimiter, true, new ShortUsStyleNamesExtractor());
    }
    
    public static NameFormatter longUsStyleNameFormatter(String delimiter) {
	return new ConcatenatingNameFormatter(delimiter, true, new LongUsStyleNamesExtractor());
    }
}
