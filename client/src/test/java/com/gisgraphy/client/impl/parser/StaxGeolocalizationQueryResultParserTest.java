package com.gisgraphy.client.impl.parser;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.xml.stream.XMLStreamException;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.core.io.InputStreamSource;

import com.gisgraphy.client.impl.FullTextSearchResultsObjectMother;
import com.gisgraphy.client.impl.GeolocalisationQueryResultsObjectMother;
import com.gisgraphy.client.impl.resultparser.FullTextQueryResult;
import com.gisgraphy.client.impl.resultparser.FullTextQueryResultParser;
import com.gisgraphy.client.impl.resultparser.GeolocalisationResult;
import com.gisgraphy.client.impl.resultparser.GeolocalizationQueryResultParser;
import com.gisgraphy.client.impl.resultparser.StaxFullTextQueryResultParser;
import com.gisgraphy.client.impl.resultparser.StaxGeolocalizationQueryResultParser;
import com.google.common.collect.Iterables;

public class StaxGeolocalizationQueryResultParserTest {
    private GeolocalizationQueryResultParser staxParser = new StaxGeolocalizationQueryResultParser();


    @Test
    public void shouldParseGeolocalisationQueryForParis() throws IOException, XMLStreamException {
	InputStreamSource iss = GeolocalisationQueryResultsObjectMother.paris();
	Iterable<GeolocalisationResult> results = staxParser.parse(iss);
	GeolocalisationResult firstResult = Iterables.get(results, 0);
	assertThat(firstResult.getDistance(), equalTo(0.0));
	assertThat(firstResult.getAdm1Code(), equalTo("A8"));
	assertThat(firstResult.getAdm2Code(), equalTo("75"));
	assertThat(firstResult.getAdm3Code(), equalTo("751"));
	assertThat(firstResult.getAdm4Code(), equalTo("75056"));
	assertThat(firstResult.getAdm1Name(), equalTo("Région Île-de-France"));
	assertThat(firstResult.getAdm2Name(), equalTo("Département de Ville-de-Paris"));
	assertThat(firstResult.getAdm3Name(), equalTo("Arrondissement de Paris"));
	assertThat(firstResult.getAdm4Name(), equalTo("Paris"));
	assertThat(firstResult.getAsciiName(), equalTo("Paris"));
	assertThat(firstResult.getName(), equalTo("Paris"));
	assertThat(firstResult.getCountryCode(), equalTo("FR"));
	assertThat(firstResult.getCountryFlagUrl(), equalTo("/images/flags/FR.png"));
	assertThat(firstResult.getFeatureClass(), equalTo("P"));
	assertThat(firstResult.getFeatureCode(), equalTo("PPLC"));
	assertThat(firstResult.getPlaceType(), equalTo("City"));
	assertThat(firstResult.getZipCode(), equalTo("75000"));
	assertThat(firstResult.getFeatureId(), equalTo(2988507L));
	assertThat(firstResult.getGoogleMapUrl(), equalTo("http://maps.google.com/maps?f=q&amp;ie=UTF-8&amp;iwloc=addr&amp;om=1&amp;z=12&amp;q=Paris&amp;ll=48.883408813476564,2.34879994392395"));
	assertThat(firstResult.getGTopo30(), equalTo(30));
	assertThat(firstResult.getLatitude(), equalTo(48.85340881347656));
	assertThat(firstResult.getLongitude(), equalTo(2.34879994392395));
	assertThat(firstResult.getPopulation(), equalTo(2138551));
	assertThat(firstResult.getTimezone(), equalTo("Europe/Paris"));
	assertThat(firstResult.getYahooMapUrl(), equalTo("http://maps.yahoo.com/broadband?mag=6&amp;mvt=m&amp;lon=2.34879994392395&amp;lat=48.85340881347656"));

    }

    @Test
    public void sixthResultShouldBeIvry() throws IOException, XMLStreamException {
	InputStreamSource iss = GeolocalisationQueryResultsObjectMother.paris();
	Iterable<GeolocalisationResult> results = staxParser.parse(iss);
	Iterator<GeolocalisationResult> iterator = results.iterator();
	assertThat(iterator.hasNext(), equalTo(true));

	for (int i = 0; i < 5; i++) {
	    iterator.next();
	}

	GeolocalisationResult ivry = iterator.next();
	assertThat(ivry.getAsciiName(), equalTo("Ivry-sur-Seine"));
    }

    @Test
    public void thereShouldBe10Results() throws IOException, XMLStreamException {
	InputStreamSource iss = GeolocalisationQueryResultsObjectMother.paris();
	Iterable<GeolocalisationResult> results = staxParser.parse(iss);
	Assert.assertEquals(10, Iterables.size(results));
    }

}
