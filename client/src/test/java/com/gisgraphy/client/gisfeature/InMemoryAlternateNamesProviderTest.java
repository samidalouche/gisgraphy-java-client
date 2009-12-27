package com.gisgraphy.client.gisfeature;

import org.junit.Test;


public class InMemoryAlternateNamesProviderTest {

    @Test(expected=IllegalArgumentException.class) public void shouldThrowExceptionWhenAlternateNamesIsNull() {
	new InMemoryAlternateNamesProvider(null);
    }
}
