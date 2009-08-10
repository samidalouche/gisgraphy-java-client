package com.gisgraphy.client.nameformatters;

import org.apache.commons.lang.Validate;

import com.gisgraphy.client.commons.NameFormatter;
import com.gisgraphy.client.commons.NamePart;
import com.gisgraphy.client.commons.NameProvider;
import com.google.common.base.Join;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.base.Function;

public class ConcatenatingNameFormatter implements NameFormatter {

    private String delimiter;
    private boolean reverse;

    public ConcatenatingNameFormatter(String delimiter) {
	this(delimiter, true);
    }

    public ConcatenatingNameFormatter(String delimiter, boolean reverse) {
	super();
	Validate.notNull(delimiter);
	this.delimiter = delimiter;
	this.reverse = reverse;
    }

    public String format(NameProvider nameProvider) {
	return Join.join(delimiter,extractNames(reverse(nameProvider.getFullyQualifiedNameParts())));
    }

    private ImmutableList<NamePart> reverse(ImmutableList<NamePart> parts) {
	if(reverse) {
	    return ImmutableList.copyOf(Iterables.reverse(parts));
	} else {
	    return parts;
	}
    }
 
    private ImmutableList<String> extractNames(final ImmutableList<NamePart> parts) {
	return ImmutableList.copyOf(Iterables.transform(parts,
		new Function<NamePart, String>() {
		    public String apply(NamePart namePart) {
			return namePart.getName();
		    }
		}));
    }

}
