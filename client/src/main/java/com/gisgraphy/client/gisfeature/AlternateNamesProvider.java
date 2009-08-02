package com.gisgraphy.client.gisfeature;

import com.google.common.collect.ImmutableSet;

public interface AlternateNamesProvider {
    ImmutableSet<AlternateGisFeatureName> getAlternateNames();
}
