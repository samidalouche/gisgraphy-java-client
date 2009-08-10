package com.gisgraphy.client.nameformatters;

import com.gisgraphy.client.commons.NamePart;
import com.gisgraphy.client.commons.NameProvider;
import com.gisgraphy.client.gisfeature.AlternateGisFeatureName;
import com.gisgraphy.client.language.Iso639Language;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

public class FakeFullyQualifiedNameProvider implements NameProvider {

    private ImmutableList<NamePart> fullyQualifiedNameParts;
    
    public FakeFullyQualifiedNameProvider(
	    ImmutableList<NamePart> fullyQualifiedNameParts) {
	super();
	this.fullyQualifiedNameParts = fullyQualifiedNameParts;
    }

    public String getFriendlyCode() {
	// TODO Auto-generated method stub
	return null;
    }

    public ImmutableList<NamePart> getFullyQualifiedNameParts() {
	return fullyQualifiedNameParts;
    }

    public ImmutableSet<AlternateGisFeatureName> getGisFeatureAlternateNames() {
	// TODO Auto-generated method stub
	return null;
    }

    public String getGisFeatureDefaultName() {
	// TODO Auto-generated method stub
	return null;
    }

    public String getGisFeaturePreferredName(Iso639Language language) {
	// TODO Auto-generated method stub
	return null;
    }

    public String getGisFeatureShortName(Iso639Language language) {
	// TODO Auto-generated method stub
	return null;
    }

    public String getName() {
	// TODO Auto-generated method stub
	return null;
    }

}
