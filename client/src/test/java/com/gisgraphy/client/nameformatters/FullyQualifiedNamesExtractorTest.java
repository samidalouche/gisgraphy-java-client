package com.gisgraphy.client.nameformatters;

import static com.gisgraphy.client.commons.NameProviderObjectMother.losAngelesNameProvider;

import org.junit.Assert;
import org.junit.Test;

public class FullyQualifiedNamesExtractorTest {

    @Test public void shouldExtractAllNames() {
	Assert.assertEquals("[United States, California, Los Angeles county, Los Angeles]", 
		new FullyQualifiedNamesExtractor().extractNames(
			losAngelesNameProvider().getFullyQualifiedNameParts()).toString());
    }
}
