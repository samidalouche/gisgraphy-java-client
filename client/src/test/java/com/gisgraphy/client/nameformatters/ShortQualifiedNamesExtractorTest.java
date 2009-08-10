package com.gisgraphy.client.nameformatters;

import static com.gisgraphy.client.commons.NameProviderObjectMother.losAngelesNameProvider;
import static com.gisgraphy.client.commons.NameProviderObjectMother.twoPartsNameProvider;

import org.junit.Assert;
import org.junit.Test;

public class ShortQualifiedNamesExtractorTest {

    @Test(expected=IllegalArgumentException.class) public void shouldNotAllowExtractingNamesWithLessThanThreeParts() {
		new ShortQualifiedNamesExtractor().extractNames(
			twoPartsNameProvider().getFullyQualifiedNameParts()).toString();
    }
    
    @Test public void shouldExtractCountryAdm1AndCity() {
	Assert.assertEquals("[United States, California, Los Angeles]", 
		new ShortQualifiedNamesExtractor().extractNames(
			losAngelesNameProvider().getFullyQualifiedNameParts()).toString());
    }
}
