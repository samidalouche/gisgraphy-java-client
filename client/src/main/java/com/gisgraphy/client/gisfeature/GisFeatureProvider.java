package com.gisgraphy.client.gisfeature;

import com.gisgraphy.client.commons.DistanceCalculator;

public interface GisFeatureProvider {
    GisFeature getGisFeature();
    DistanceCalculator<GisFeature> getGisFeatureDistanceCalculator();
}
