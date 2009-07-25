package com.gisgraphy.client.domain;

import com.google.common.collect.ImmutableSet;

public interface AlternateNamesProvider {
    ImmutableSet<AlternateGisFeatureName> getAlternateNames();
}
