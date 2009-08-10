package com.gisgraphy.client.nameformatters;

import com.gisgraphy.client.commons.NamePart;
import com.google.common.collect.ImmutableList;

public class VeryShortQualifiedNamesExtractor implements NamesExtractor {

    public ImmutableList<String> extractNames(ImmutableList<NamePart> nameParts) {
	if(nameParts.size() < 2) {
	    throw new IllegalArgumentException("There should be at least 2 NameParts : a Country and a name");
	}
	
	return ImmutableList.of(
		countryName(nameParts), 
		featureName(nameParts));
    }

    private String featureName(ImmutableList<NamePart> nameParts) {
	return nameParts.get(nameParts.size()-1).getName();
    }

    private String countryName(ImmutableList<NamePart> nameParts) {
	return nameParts.get(0).getName();
    }
    

}
