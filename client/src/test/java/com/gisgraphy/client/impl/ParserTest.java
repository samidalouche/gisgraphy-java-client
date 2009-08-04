package com.gisgraphy.client.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.core.io.InputStreamSource;

import com.gisgraphy.client.impl.FullTextQueryResult;
import com.gisgraphy.client.impl.GeolocalisationResult;
import com.gisgraphy.client.impl.StaxParser;

import javax.xml.stream.XMLStreamException;

public class ParserTest {
    private StaxParser staxParser = new StaxParser();
    
    @Test
    public void shouldParseFullTextSearchForIrvineCorrectly() {
	InputStreamSource iss = FullTextSearchResultsObjectMother.irvine();
	try {
	    Iterable<FullTextQueryResult> results = staxParser.parseFullTextSearchResult(iss);
	    Iterator<FullTextQueryResult> iterator = results.iterator();
	    assertThat(iterator.hasNext(), equalTo(true));
	    FullTextQueryResult firstResult = iterator.next();
	    assertThat(firstResult.getAsciiName(), equalTo("Irvine"));
	    assertThat(firstResult.getPlaceType(), equalTo("City"));
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
	    assertThat(firstResult.getGoogleMapUrl(), equalTo("http://maps.google.com/maps?f=q&amp;ie=UTF-8&amp;iwloc=addr&amp;om=1&amp;z=12&amp;q=Irvine&amp;ll=33.699464111328126,-117.82311248779297"));
	    assertThat(firstResult.getGTopo30(), equalTo(17));
	    assertThat(firstResult.getLatitude(), equalTo(33.669464111328125));
	    assertThat(firstResult.getLongitude(), equalTo(-117.82311248779297));
	    assertThat(firstResult.getPopulation(), equalTo(189297));
	    assertThat(firstResult.getTimezone(), equalTo("America/Los_Angeles"));
	    assertThat(firstResult.getYahooMapUrl(), equalTo("http://maps.yahoo.com/broadband?mag=6&amp;mvt=m&amp;lon=-117.82311248779297&amp;lat=33.669464111328125"));

	    // skip through 8 results, then test the last
	    for (int i = 0; i < 8; i++) {
	    	iterator.next();
	    }
	    
	    FullTextQueryResult lastResult = iterator.next();
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
	} catch (XMLStreamException e) {
            Assert.fail();
            e.printStackTrace();
        }
    }
    
    
    @Test
    public void shouldParseParisCorrectly() {
	InputStreamSource iss = FullTextSearchResultsObjectMother.paris();
	try {
	    Iterable<FullTextQueryResult> results = staxParser.parseFullTextSearchResult(iss);
	    Iterator<FullTextQueryResult> iterator = results.iterator();
	    assertThat(iterator.hasNext(), equalTo(true));
	    FullTextQueryResult firstResult = iterator.next();
	    assertThat(firstResult.getAsciiName(), equalTo("Paris"));
	    assertThat(firstResult.getScore(), equalTo(202211.78));
	    assertThat(firstResult.getName(), equalTo("Paris"));
	    assertThat(firstResult.getCountryCode(), equalTo("FR"));
	    assertThat(firstResult.getCountryFlagUrl(), equalTo("/images/flags/FR.png"));
	    assertThat(firstResult.getCountryName(), equalTo("France"));
	    assertThat(firstResult.getElevation(), equalTo(0));
	    assertThat(firstResult.getFeatureClass(), equalTo("P"));
	    assertThat(firstResult.getFeatureCode(), equalTo("PPLC"));
	    assertThat(firstResult.getFeatureId(), equalTo(2988507L));
	    assertThat(firstResult.getFullyQualifiedName(), equalTo("Paris (75000), Département de Ville-de-Paris, Région Île-de-France"));
	    assertThat(firstResult.getGoogleMapUrl(), equalTo("http://maps.google.com/maps?f=q&amp;ie=UTF-8&amp;iwloc=addr&amp;om=1&amp;z=12&amp;q=Paris&amp;ll=48.883408813476564,2.34879994392395"));
	    assertThat(firstResult.getGTopo30(), equalTo(30));
	    assertThat(firstResult.getLatitude(), equalTo(48.85340881347656));
	    assertThat(firstResult.getLongitude(), equalTo(2.34879994392395));
	    assertThat(firstResult.getPopulation(), equalTo(2138551));
	    assertThat(firstResult.getTimezone(), equalTo("Europe/Paris"));
	    assertThat(firstResult.getYahooMapUrl(), equalTo("http://maps.yahoo.com/broadband?mag=6&amp;mvt=m&amp;lon=2.34879994392395&amp;lat=48.85340881347656"));

	    // skip through 8 results, then test the last
	    for (int i = 0; i < 8; i++) {
	    	iterator.next();
	    }
	    
	    FullTextQueryResult lastResult = iterator.next();
	    assertThat(lastResult.getAsciiName(), equalTo("Paris"));
	    
	    try {
	    	iterator.next();
	    	Assert.fail();
	    }
	    catch (NoSuchElementException e) {
	    	
	    }
	    
	
	} catch (IOException e) {
	    Assert.fail();
	    e.printStackTrace();
	} catch (XMLStreamException e) {
            Assert.fail();
            e.printStackTrace();
        }


    }

    @Test
    public void shouldParseSeattleCorrectly() {
	InputStreamSource iss = FullTextSearchResultsObjectMother.seattle();
	try {
	    Iterable<FullTextQueryResult> results = staxParser.parseFullTextSearchResult(iss);
	    Iterator<FullTextQueryResult> iterator = results.iterator();
	    assertThat(iterator.hasNext(), equalTo(true));
	    FullTextQueryResult firstResult = iterator.next();
	    assertThat(firstResult.getAsciiName(), equalTo("Seattle"));
	    assertThat(firstResult.getScore(), equalTo(50085.02));
	    assertThat(firstResult.getName(), equalTo("Seattle"));
	    assertThat(firstResult.getCountryCode(), equalTo("US"));
	    assertThat(firstResult.getCountryFlagUrl(), equalTo("/images/flags/US.png"));
	    assertThat(firstResult.getCountryName(), equalTo("United States"));
	    assertThat(firstResult.getElevation(), equalTo(56));
	    assertThat(firstResult.getFeatureClass(), equalTo("P"));
	    assertThat(firstResult.getFeatureCode(), equalTo("PPL"));
	    assertThat(firstResult.getFeatureId(), equalTo(5809844L));
	    assertThat(firstResult.getFullyQualifiedName(), equalTo("Seattle, King County, Washington"));
	    assertThat(firstResult.getGoogleMapUrl(), equalTo("http://maps.google.com/maps?f=q&amp;ie=UTF-8&amp;iwloc=addr&amp;om=1&amp;z=12&amp;q=Seattle&amp;ll=47.63620880126953,-122.33206939697266"));
	    assertThat(firstResult.getGTopo30(), equalTo(60));
	    assertThat(firstResult.getLatitude(), equalTo(47.60620880126953));
	    assertThat(firstResult.getLongitude(), equalTo(-122.33206939697266));
	    assertThat(firstResult.getPopulation(), equalTo(569369));
	    assertThat(firstResult.getTimezone(), equalTo("America/Los_Angeles"));
	    assertThat(firstResult.getYahooMapUrl(), equalTo("http://maps.yahoo.com/broadband?mag=6&amp;mvt=m&amp;lon=-122.33206939697266&amp;lat=47.60620880126953"));
        
	    assertThat(firstResult.getAdm1AlternateNames().size(), equalTo(3));
        assertThat(firstResult.getAdm1AlternateNames().get("ES").get(0), equalTo("Estado de Washington"));
        assertThat(firstResult.getAdm1AlternateNames().get("RU").get(0), equalTo("Вашингтон"));

        assertThat(firstResult.getCountryAlternateNames().get("AZ").size(), equalTo(1));
	    assertThat(firstResult.getCountryAlternateNames().get("AZ").get(0), equalTo("Amerika Birləşmiş Ştatları"));
	    
	    assertThat(firstResult.getCountryAlternateNames().get("BE").size(), equalTo(2));
	    assertThat(firstResult.getCountryAlternateNames().get("BE").get(0), equalTo("Злучаныя Штаты"));
	    assertThat(firstResult.getCountryAlternateNames().get("BE").get(1), equalTo("Злучаныя Штаты Амерыкі"));
	    
	    // skip through 8 results, then test the last
	    for (int i = 0; i < 8; i++) {
	    	iterator.next();
	    }

	    FullTextQueryResult lastResult = iterator.next();
	    assertThat(lastResult.getAsciiName(), equalTo("Seattle Bar Recreation Site"));

	    try {
	    	iterator.next();
	    	Assert.fail();
	    }
	    catch (NoSuchElementException e) {

	    }


	} catch (IOException e) {
	    Assert.fail();
	    e.printStackTrace();
	}  catch (XMLStreamException e) {
            Assert.fail();
            e.printStackTrace();
        }


    }
    
    

    @Test
    public void shouldParseGeolocalisationQueryForParisCorrectly() {
	InputStreamSource iss = GeolocalisationQueryResultsObjectMother.paris();
	try {
	    Iterable<GeolocalisationResult> results = staxParser.parseGeolocalisationResult(iss);
	    Iterator<GeolocalisationResult> iterator = results.iterator();
	    assertThat(iterator.hasNext(), equalTo(true));
	    GeolocalisationResult firstResult = iterator.next();
	    assertThat(firstResult.getDistance(), equalTo(45.3866297045854));
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

	    // skip through 8 results, then test the last
	    for (int i = 0; i < 4; i++) {
	    	iterator.next();
	    }
	    
	    GeolocalisationResult lastResult = iterator.next();
	    assertThat(lastResult.getAsciiName(), equalTo("Ivry-sur-Seine"));
	    
	    try {
	    	iterator.next();
	    	Assert.fail();
	    }
	    catch (NoSuchElementException e) {
	    	
	    }
	    
	
	} catch (IOException e) {
	    Assert.fail();
	    e.printStackTrace();
	} catch (XMLStreamException e) {
            Assert.fail();
            e.printStackTrace();
        }
    }

    @Test
    public void shouldParseFranceCorrectly() {
	InputStreamSource iss = FullTextSearchResultsObjectMother.france();
	try {
	    Iterable<FullTextQueryResult> results = staxParser.parseFullTextSearchResult(iss);
	    Iterator<FullTextQueryResult> iterator = results.iterator();
	    assertThat(iterator.hasNext(), equalTo(true));
	    FullTextQueryResult firstResult = iterator.next();
	    assertThat(firstResult.getAsciiName(), equalTo("Republic of France"));
	    assertThat(firstResult.getScore(), equalTo(5798653.5));
	    assertThat(firstResult.getName(), equalTo("France"));
	    assertThat(firstResult.getCountryCode(), equalTo("FR"));
	    assertThat(firstResult.getCountryFlagUrl(), equalTo("/images/flags/FR.png"));
	    assertThat(firstResult.getCountryName(), equalTo("France"));
	    assertThat(firstResult.getElevation(), equalTo(0));
	    assertThat(firstResult.getFeatureClass(), equalTo("A"));
	    assertThat(firstResult.getFeatureCode(), equalTo("PCLI"));
	    assertThat(firstResult.getFeatureId(), equalTo(3017382L));
	    assertThat(firstResult.getFullyQualifiedName(), equalTo("France"));
	    assertThat(firstResult.getGoogleMapUrl(), equalTo("http://maps.google.com/maps?f=q&amp;ie=UTF-8&amp;iwloc=addr&amp;om=1&amp;z=12&amp;q=France&amp;ll=46.03,2.0"));
	    assertThat(firstResult.getGTopo30(), equalTo(560));
	    assertThat(firstResult.getLatitude(), equalTo(46.0));
	    assertThat(firstResult.getLongitude(), equalTo(2.0));
	    assertThat(firstResult.getPopulation(), equalTo(64094000));
	    assertThat(firstResult.getTimezone(), equalTo("Europe/Paris"));
	    assertThat(firstResult.getYahooMapUrl(), equalTo("http://maps.yahoo.com/broadband?mag=6&amp;mvt=m&amp;lon=2.0&amp;lat=46.0"));
	    assertThat(firstResult.getAlternateNames().get("DE").size(), equalTo(1));
	    assertThat(firstResult.getAlternateNames().get("DE").get(0), equalTo("Frankreich"));

	    assertThat(firstResult.getAlternateNames().get("EL").size(), equalTo(1));
        assertThat(firstResult.getAlternateNames().get("EL").get(0), equalTo("Γαλλία"));

        assertThat(firstResult.getCountryAlternateNames().get("EL").size(), equalTo(1));
	    assertThat(firstResult.getCountryAlternateNames().get("EL").get(0), equalTo("Γαλλία"));

        assertThat(firstResult.getAlternateNames().get("BE").size(), equalTo(1));
        assertThat(firstResult.getAlternateNames().get("BE").get(0), equalTo("Францыя"));

	    assertThat(firstResult.getCountryAlternateNames().get("BE").get(0), equalTo("Францыя"));
        assertThat(firstResult.getCountryAlternateNames().get("BE").get(0), equalTo("Францыя"));

	    // skip through 8 results, then test the last
	    for (int i = 0; i < 8; i++) {
	    	iterator.next();
	    }

	    FullTextQueryResult lastResult = iterator.next();
	    assertThat(lastResult.getAsciiName(), equalTo("Region Centre"));

	    try {
	    	iterator.next();
	    	Assert.fail();
	    }
	    catch (NoSuchElementException e) {

	    }


	} catch (IOException e) {
	    Assert.fail();
	    e.printStackTrace();
	}  catch (XMLStreamException e) {
            Assert.fail();
            e.printStackTrace();
        }


    }
}
