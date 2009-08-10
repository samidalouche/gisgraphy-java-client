package com.gisgraphy.client.nameformatters;

import com.gisgraphy.client.commons.NamePart;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

public class FullyQualifiedNamesExtractor implements NamesExtractor {

    public ImmutableList<String> extractNames(ImmutableList<NamePart> nameParts) {
	return ImmutableList.copyOf(Iterables.transform(nameParts,new Function<NamePart, String>() {
	    public String apply(NamePart namePart) {
		return namePart.getName();
	    }
	}));
    }
    

}
