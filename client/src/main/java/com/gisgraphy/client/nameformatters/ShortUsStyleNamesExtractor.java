package com.gisgraphy.client.nameformatters;

import com.gisgraphy.client.commons.NamePart;
import com.google.common.collect.ImmutableList;

public class ShortUsStyleNamesExtractor implements NamesExtractor {

    public ImmutableList<String> extractNames(ImmutableList<NamePart> nameParts) {
	if(nameParts.size() < 3) {
	    throw new IllegalArgumentException("There should be at least 3 NameParts : a Country, a first-order administrative division, and a name");
	}
	
	return ImmutableList.of(
		adm1Code(nameParts), 
		featureName(nameParts));
    }

    private String featureName(ImmutableList<NamePart> nameParts) {
	return nameParts.get(nameParts.size()-1).getName();
    }

    private String adm1Code(ImmutableList<NamePart> nameParts) {
	return nameParts.get(1).getFriendlyCode();
    }    

}
