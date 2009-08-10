package com.gisgraphy.client.nameformatters;

import static com.gisgraphy.client.commons.NameProviderObjectMother.losAngelesNameProvider;
import static com.gisgraphy.client.commons.NameProviderObjectMother.onePartNameProvider;

import org.junit.Assert;
import org.junit.Test;

public class VeryShortQualifiedNamesExtractorTest {

    @Test(expected=IllegalArgumentException.class) public void shouldNotAllowExtractingNamesWithLessThanThreeParts() {
		new ShortQualifiedNamesExtractor().extractNames(
			onePartNameProvider().getFullyQualifiedNameParts()).toString();
    }
    
    @Test public void shouldExtractCountryAndCity() {
	Assert.assertEquals("[United States, Los Angeles]", 
		new VeryShortQualifiedNamesExtractor().extractNames(
			losAngelesNameProvider().getFullyQualifiedNameParts()).toString());
    }
}
