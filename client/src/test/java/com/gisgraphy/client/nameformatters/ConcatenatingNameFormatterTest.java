package com.gisgraphy.client.nameformatters;

import static com.gisgraphy.client.commons.NameProviderObjectMother.losAngelesNameProvider;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.gisgraphy.client.commons.NameFormatter;

public class ConcatenatingNameFormatterTest {

    private NameFormatter reverseNameFormatter;
    private NameFormatter forwardNameFormatter;
    
    @Before
    public void setup() {
	reverseNameFormatter = new ConcatenatingNameFormatter(",");
	forwardNameFormatter = new ConcatenatingNameFormatter(",", false, new AllNamesExtractor());
    }
    
    @Test public void shouldConcatenateAllNamesInReverseOrder() {
	Assert.assertEquals("Los Angeles,Los Angeles county,California,United States", 
		reverseNameFormatter.format(losAngelesNameProvider()).toString());
    }

    @Test public void shouldConcatenateAllNamesInForwardOrder() {
	Assert.assertEquals("United States,California,Los Angeles county,Los Angeles", 
		forwardNameFormatter.format(losAngelesNameProvider()).toString());
    }
    
    @Test(expected=IllegalArgumentException.class) public void shouldNotCreateNameFormatterWithoutDelimiter() {
	new ConcatenatingNameFormatter(null);
    }
    
}
