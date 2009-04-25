package com.gisgraphy.client.parser;

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.core.io.InputStreamSource;

import com.gisgraphy.client.domain.CityResult;

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
	    Iterable<CityResult> results = staxParser.parse(iss.getInputStream());
	    Iterator<CityResult> iterator = results.iterator();
	    assertThat(iterator.hasNext(), equalTo(true));
	    CityResult firstResult = iterator.next();
	    assertThat(firstResult.getAsciiName(), equalTo("Irvine"));
	    assertThat(firstResult.getScore(), equalTo(16920.297));
	    assertThat(firstResult.getName(), equalTo("Irvine"));
	    assertThat(firstResult.getCountryCode(), equalTo("US"));
	    assertThat(firstResult.getCountryFlagUrl(), equalTo("/images/flags/US.png"));
	    assertThat(firstResult.getCountryName(), equalTo("United States"));
	    assertThat(firstResult.getElevation(), equalTo(17));
	    assertThat(firstResult.getFeatureClass(), equalTo("P"));
	    assertThat(firstResult.getFeatureCode(), equalTo("PPL"));
	    assertThat(firstResult.getFeatureId(), equalTo(5359777L));
	    assertThat(firstResult.getFullyQualifiedName(), equalTo("Irvine, Orange County, California"));
	    assertThat(firstResult.getGoogleMapUrl(), equalTo("http://maps.google.com/maps?f=q&ie=UTF-8&iwloc=addr&om=1&z=12&q=Irvine&ll=33.699464111328126,-117.82311248779297"));
	    assertThat(firstResult.getGTopo30(), equalTo(17));
	    assertThat(firstResult.getLatitude(), equalTo(33.669464111328125));
	    assertThat(firstResult.getLongitude(), equalTo(-117.82311248779297));
	    assertThat(firstResult.getPopulation(), equalTo(189297));
	    assertThat(firstResult.getTimezone(), equalTo("America/Los_Angeles"));
	    assertThat(firstResult.getYahooMapUrl(), equalTo("http://maps.yahoo.com/broadband?mag=6&mvt=m&lon=-117.82311248779297&lat=33.669464111328125"));

	    // skip through 8 results, then test the last
	    for (int i = 0; i < 8; i++) {
	    	iterator.next();
	    }
	    
	    CityResult lastResult = iterator.next();
	    assertThat(lastResult.getAsciiName(), equalTo("North Irvine"));
	    
	    try {
	    	iterator.next();
	    	Assert.fail();
	    }
	    catch (NoSuchElementException e) {
	    	
	    }
	    
	
	} catch (IOException e) {
	    Assert.fail();
	    e.printStackTrace();
	}
    }
}
