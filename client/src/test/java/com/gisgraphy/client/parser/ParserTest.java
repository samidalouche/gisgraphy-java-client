package com.gisgraphy.client.parser;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.core.io.InputStreamSource;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import static com.gisgraphy.client.objectmothers.FullTextSearchResultsObjectMother.*;

public class ParserTest {
    private StaxParser staxParser = new StaxParser();
    
    @Test
    public void shouldParseParisCorrectly() {
	InputStreamSource iss = irvine();
	try {
	    String placeName = staxParser.parse(iss.getInputStream());
	    assertThat(placeName, equalTo("Irvine"));
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    Assert.fail();
	    e.printStackTrace();
	}
    }
}
