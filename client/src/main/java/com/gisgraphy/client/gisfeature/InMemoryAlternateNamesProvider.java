package com.gisgraphy.client.gisfeature;

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
