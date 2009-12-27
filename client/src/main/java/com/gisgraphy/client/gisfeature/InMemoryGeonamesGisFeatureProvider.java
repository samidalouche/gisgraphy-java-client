package com.gisgraphy.client.gisfeature;

import org.springframework.util.Assert;

import com.gisgraphy.client.commons.DistanceCalculator;

public class InMemoryGeonamesGisFeatureProvider implements GisFeatureProvider {

    private GeonamesGisFeature geonamesGisFeature;
    
    public InMemoryGeonamesGisFeatureProvider(GeonamesGisFeature geonamesGisFeature) {
	super();
	Assert.notNull(geonamesGisFeature);
	this.geonamesGisFeature = geonamesGisFeature;
    }

    public GisFeature getGisFeature() {
	return geonamesGisFeature;
    }

    public DistanceCalculator<GisFeature> getGisFeatureDistanceCalculator() {
	return geonamesGisFeature;
    }

}
