package com.gisgraphy.client.impl;

import com.gisgraphy.client.gisfeature.AlternateGisFeatureName;
import com.gisgraphy.client.gisfeature.AlternateNamesProvider;
import com.google.common.collect.ImmutableSet;

public class InMemoryAlternateNamesProvider implements AlternateNamesProvider {

    private ImmutableSet<AlternateGisFeatureName> alternateNames;
    
    public InMemoryAlternateNamesProvider(Iterable<AlternateGisFeatureName> alternateNames) {
	this.alternateNames = ImmutableSet.copyOf(alternateNames);
    }
    
    public ImmutableSet<AlternateGisFeatureName> getAlternateNames() {
	return this.alternateNames;
    }

}
