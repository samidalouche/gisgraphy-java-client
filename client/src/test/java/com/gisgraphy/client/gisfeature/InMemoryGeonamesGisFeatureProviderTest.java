package com.gisgraphy.client.gisfeature;

import org.junit.Test;


public class InMemoryGeonamesGisFeatureProviderTest {

    @Test(expected=IllegalArgumentException.class) public void shouldThrowExceptionWhenGisFeatureIsNull() {
	new InMemoryGeonamesGisFeatureProvider(null);
    }
}
