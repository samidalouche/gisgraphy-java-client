package com.gisgraphy.client;

import com.gisgraphy.client.commons.NameFormatter;
import com.gisgraphy.client.nameformatters.ConcatenatingNameFormatter;

public class DefaultNameFormatters {

    public static NameFormatter fullyQualifiedNameFormatter(String delimiter) {
	return new ConcatenatingNameFormatter(delimiter);
    }
}
