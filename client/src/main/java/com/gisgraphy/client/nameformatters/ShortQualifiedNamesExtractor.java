package com.gisgraphy.client.nameformatters;

import com.gisgraphy.client.commons.NamePart;
import com.google.common.collect.ImmutableList;

public class ShortQualifiedNamesExtractor implements NamesExtractor {

    public ImmutableList<String> extractNames(ImmutableList<NamePart> nameParts) {
	if(nameParts.size() < 3) {
	    throw new IllegalArgumentException("There should be 3 NameParts : a Country, a first-order administrative division, and a name");
	}
	
	return ImmutableList.of(
		countryName(nameParts), 
		adm1Name(nameParts), 
		featureName(nameParts));
    }

    private String featureName(ImmutableList<NamePart> nameParts) {
	return nameParts.get(nameParts.size()-1).getName();
    }

    private String adm1Name(ImmutableList<NamePart> nameParts) {
	return nameParts.get(1).getName();
    }

    private String countryName(ImmutableList<NamePart> nameParts) {
	return nameParts.get(0).getName();
    }
    

}
