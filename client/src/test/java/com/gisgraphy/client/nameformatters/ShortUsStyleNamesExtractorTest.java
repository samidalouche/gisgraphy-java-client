package com.gisgraphy.client.nameformatters;

import static com.gisgraphy.client.commons.NameProviderObjectMother.losAngelesNameProvider;
import static com.gisgraphy.client.commons.NameProviderObjectMother.twoPartsNameProvider;

import org.junit.Assert;
import org.junit.Test;

public class ShortUsStyleNamesExtractorTest {

    @Test(expected=IllegalArgumentException.class) public void shouldNotAllowExtractingNamesWithLessThanThreeParts() {
		new ShortQualifiedNamesExtractor().extractNames(
			twoPartsNameProvider().getFullyQualifiedNameParts()).toString();
    }
    
    @Test public void shouldExtractAdm1CodeAndCity() {
	Assert.assertEquals("[CA, Los Angeles]", 
		new ShortUsStyleNamesExtractor().extractNames(
			losAngelesNameProvider().getFullyQualifiedNameParts()).toString());
    }
}
