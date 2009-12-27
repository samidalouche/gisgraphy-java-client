package com.gisgraphy.client.gisfeature;

import org.springframework.util.Assert;

import com.google.common.collect.ImmutableSet;

public class InMemoryAlternateNamesProvider implements AlternateNamesProvider {

    private ImmutableSet<AlternateGisFeatureName> alternateNames;
    
    public InMemoryAlternateNamesProvider(Iterable<AlternateGisFeatureName> alternateNames) {
	Assert.notNull(alternateNames);
	this.alternateNames = ImmutableSet.copyOf(alternateNames);
    }
    
    public ImmutableSet<AlternateGisFeatureName> getAlternateNames() {
	return this.alternateNames;
    }

}
