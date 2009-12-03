package com.gisgraphy.client.impl.parser;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.core.io.InputStreamSource;

import com.gisgraphy.client.impl.FullTextSearchResultsObjectMother;
import com.gisgraphy.client.impl.resultparser.FullTextQueryResult;
import com.gisgraphy.client.impl.resultparser.FullTextQueryResultParser;
import com.gisgraphy.client.impl.resultparser.StaxFullTextQueryResultParser;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;

public class StaxFullTextQueryResultParserTest {
    private FullTextQueryResultParser staxParser = new StaxFullTextQueryResultParser();

    @Test
    public void shouldParseFullTextSearchForIrvineCorrectly() {
	InputStreamSource iss = FullTextSearchResultsObjectMother.irvine();
	shouldBeIrvineInCalifornia(getFirstParsedResult(iss));
    }

    @Test
    public void irvineSearchShouldReturnTenResults() {
	InputStreamSource iss = FullTextSearchResultsObjectMother.irvine();
	Assert.assertEquals(10, Iterables.size(staxParser.parse(iss)));
    }

    @Test
    public void searchByParisIdShouldReturnParisAsFirstResult() {
	InputStreamSource iss = FullTextSearchResultsObjectMother.parisUsingFeatureId();
	shouldBeParisInFrance(getFirstParsedResult(iss));
    }

    @Test
    public void searchByParisIdShouldReturnOnlyOneResult() {
	InputStreamSource iss = FullTextSearchResultsObjectMother.parisUsingFeatureId();
	Assert.assertEquals(1, Iterables.size(staxParser.parse(iss)));
    }
    
    @Test
    public void shouldParseParisCityFirstResultCorrectly() {
	InputStreamSource iss = FullTextSearchResultsObjectMother.tenFirstResultsMatchingParis();
	shouldBeParisInFrance(getFirstParsedResult(iss));
    }
    
    @Test
    public void shouldReturn10ParisResults() {
	InputStreamSource iss = FullTextSearchResultsObjectMother.tenFirstResultsMatchingParis();
	Assert.assertEquals(10, Iterables.size(staxParser.parse(iss)));
    }


    @Test @Ignore
    public void shouldParseSeattleCorrectly()  {
	InputStreamSource iss = FullTextSearchResultsObjectMother.seattle();
	Iterable<FullTextQueryResult> results = staxParser.parse(iss);
	Iterator<FullTextQueryResult> iterator = results.iterator();
	assertThat(iterator.hasNext(), equalTo(true));
	FullTextQueryResult firstResult = iterator.next();
	assertThat(firstResult.getAsciiName(), equalTo("Seattle"));
	assertThat(firstResult.getScore(), equalTo(50085.02));
	assertThat(firstResult.getName(), equalTo("Seattle"));
	assertThat(firstResult.getCountryCode(), equalTo("US"));
	assertThat(firstResult.getCountryFlagUrl(), equalTo("/images/flags/US.png"));
	assertThat(firstResult.getElevation(), equalTo(56L));
	assertThat(firstResult.getFeatureClass(), equalTo("P"));
	assertThat(firstResult.getFeatureCode(), equalTo("PPL"));
	assertThat(firstResult.getFeatureId(), equalTo(5809844L));
	assertThat(firstResult.getGoogleMapUrl(), equalTo("http://maps.google.com/maps?f=q&amp;ie=UTF-8&amp;iwloc=addr&amp;om=1&amp;z=12&amp;q=Seattle&amp;ll=47.63620880126953,-122.33206939697266"));
	assertThat(firstResult.getGTopo30(), equalTo(60));
	assertThat(firstResult.getLatitude(), equalTo(47.60620880126953));
	assertThat(firstResult.getLongitude(), equalTo(-122.33206939697266));
	assertThat(firstResult.getPopulation(), equalTo(569369));
	assertThat(firstResult.getTimezone(), equalTo("America/Los_Angeles"));
	assertThat(firstResult.getYahooMapUrl(), equalTo("http://maps.yahoo.com/broadband?mag=6&amp;mvt=m&amp;lon=-122.33206939697266&amp;lat=47.60620880126953"));

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

    }

    @Test @Ignore
    public void shouldParseFranceCorrectly() {
	InputStreamSource iss = FullTextSearchResultsObjectMother.france();
	Iterable<FullTextQueryResult> results = staxParser.parse(iss);
	Iterator<FullTextQueryResult> iterator = results.iterator();
	assertThat(iterator.hasNext(), equalTo(true));
	FullTextQueryResult firstResult = iterator.next();
	assertThat(firstResult.getAsciiName(), equalTo("Republic of France"));
	assertThat(firstResult.getScore(), equalTo(5798653.5));
	assertThat(firstResult.getName(), equalTo("France"));
	assertThat(firstResult.getCountryCode(), equalTo("FR"));
	assertThat(firstResult.getCountryFlagUrl(), equalTo("/images/flags/FR.png"));
	assertThat(firstResult.getElevation(), equalTo(0L));
	assertThat(firstResult.getFeatureClass(), equalTo("A"));
	assertThat(firstResult.getFeatureCode(), equalTo("PCLI"));
	assertThat(firstResult.getFeatureId(), equalTo(3017382L));
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

	assertThat(firstResult.getAlternateNames().get("BE").size(), equalTo(1));
	assertThat(firstResult.getAlternateNames().get("BE").get(0), equalTo("Францыя"));

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

    }
    
    private void shouldBeParisInFrance(FullTextQueryResult result) {
	assertThat(result.getFeatureId(), equalTo(2988507L));
	assertThat(result.getAsciiName(), equalTo("Paris"));
	assertThat(result.getName(), equalTo("Paris"));
	assertThat(result.getPlaceType(), equalTo("City"));
	assertThat(result.getCountryCode(), equalTo("FR"));
	assertThat(result.getAdm1Code(), equalTo("A8"));
	assertThat(result.getAdm2Code(), equalTo("75"));
	assertThat(result.getAdm3Code(), equalTo("751"));
	assertThat(result.getAdm4Code(), equalTo("75056"));
	assertThat(result.getGoogleMapUrl(), equalTo("http://maps.google.com/maps?f=q&amp;ie=UTF-8&amp;iwloc=addr&amp;om=1&amp;z=12&amp;q=Paris&amp;ll=48.883408813476564,2.34879994392395"));
	assertThat(result.getYahooMapUrl(), equalTo("http://maps.yahoo.com/broadband?mag=6&amp;mvt=m&amp;lon=2.34879994392395&amp;lat=48.85340881347656"));	
	assertThat(result.getCountryFlagUrl(), equalTo("/images/flags/FR.png"));
	assertThat(result.getFeatureClass(), equalTo("P"));
	assertThat(result.getFeatureCode(), equalTo("PPLC"));
	assertThat(result.getPopulation(), equalTo(2138551));
	assertThat(result.getElevation(), nullValue());
	assertThat(result.getTimezone(), equalTo("Europe/Paris"));
	assertThat(result.getGTopo30(), equalTo(30));
	assertThat(result.getLatitude(), equalTo(48.85340881347656));
	assertThat(result.getLongitude(), equalTo(2.34879994392395));

	Assert.assertEquals(parisAlternateNames(), result.getAlternateNames());
    }

    private void shouldBeIrvineInCalifornia(FullTextQueryResult firstResult) {
	assertThat(firstResult.getAsciiName(), equalTo("Irvine"));
	assertThat(firstResult.getPlaceType(), equalTo("City"));
	assertThat(firstResult.getScore(), equalTo(16920.297));
	assertThat(firstResult.getName(), equalTo("Irvine"));
	assertThat(firstResult.getCountryCode(), equalTo("US"));
	assertThat(firstResult.getCountryFlagUrl(), equalTo("/images/flags/US.png"));
	assertThat(firstResult.getElevation(), equalTo(17L));
	assertThat(firstResult.getFeatureClass(), equalTo("P"));
	assertThat(firstResult.getFeatureCode(), equalTo("PPL"));
	assertThat(firstResult.getFeatureId(), equalTo(5359777L));
	assertThat(firstResult.getGoogleMapUrl(), equalTo("http://maps.google.com/maps?f=q&amp;ie=UTF-8&amp;iwloc=addr&amp;om=1&amp;z=12&amp;q=Irvine&amp;ll=33.699464111328126,-117.82311248779297"));
	assertThat(firstResult.getGTopo30(), equalTo(17));
	assertThat(firstResult.getLatitude(), equalTo(33.669464111328125));
	assertThat(firstResult.getLongitude(), equalTo(-117.82311248779297));
	assertThat(firstResult.getPopulation(), equalTo(189297));
	assertThat(firstResult.getTimezone(), equalTo("America/Los_Angeles"));
	assertThat(firstResult.getYahooMapUrl(), equalTo("http://maps.yahoo.com/broadband?mag=6&amp;mvt=m&amp;lon=-117.82311248779297&amp;lat=33.669464111328125"));
    }
    
    private FullTextQueryResult getFirstParsedResult(InputStreamSource iss) {
	Iterable<FullTextQueryResult> results = staxParser.parse(iss);
	return Iterables.get(results, 0);
    }
    
    private ImmutableMap<String, List<String>> parisAlternateNames() {
	return new ImmutableMap.Builder<String, List<String>>()
		.put("AF", ImmutableList.of("Parys"))
		.put("ALS", ImmutableList.of("Paris"))
		.put("AM", ImmutableList.of("ፓሪስ"))
		.put("AN", ImmutableList.of("París"))
		.put("AR", ImmutableList.of("باريس"))
		.put("ARC", ImmutableList.of("ܦܪܝܣ"))
		.put("AST", ImmutableList.of("París"))
		.put("BE", ImmutableList.of("Парыж"))
		.put("BG", ImmutableList.of("Париж"))
		.put("BR", ImmutableList.of("Pariz"))
		.put("CA", ImmutableList.of("París"))
		.put("CS", ImmutableList.of("Paříž"))
		.put("CY", ImmutableList.of("Paris"))
		.put("DA", ImmutableList.of("Paris"))
		.put("DE", ImmutableList.of("Paris"))
		.put("EL", ImmutableList.of("Παρίσι"))
		.put("EN", ImmutableList.of("Paris"))
		.put("EO", ImmutableList.of("Parizo"))
		.put("ES", ImmutableList.of("París"))
		.put("ET", ImmutableList.of("Pariis"))
		.put("EU", ImmutableList.of("Paris"))
		.put("FA", ImmutableList.of("پاریس"))
		.put("FI", ImmutableList.of("Pariisi"))
		.put("FR", ImmutableList.of("Lutece", "Paname", "Pantruche", "Paris", "Ville-Lumière"))
		.put("FY", ImmutableList.of("Parys"))
		.put("GA", ImmutableList.of("Páras"))
		.put("GD", ImmutableList.of("Paris"))
		.put("GL", ImmutableList.of("París - Paris"))
		.put("GV", ImmutableList.of("Paarys"))
		.put("HE", ImmutableList.of("פריז"))
		.put("HR", ImmutableList.of("Pariz"))
		.put("HU", ImmutableList.of("Párizs"))
		.put("HY", ImmutableList.of("Փարիզ"))
		.put("IA", ImmutableList.of("Paris"))
		.put("IATA", ImmutableList.of("PAR"))
		.put("ID", ImmutableList.of("Paris"))
		.put("IO", ImmutableList.of("Paris"))
		.put("IS", ImmutableList.of("París"))
		.put("IT", ImmutableList.of("Parigi"))
		.put("JA", ImmutableList.of("パリ"))
		.put("KA", ImmutableList.of("პარიზი"))
		.put("KN", ImmutableList.of("ಪ್ಯಾರಿಸ್"))
		.put("KO", ImmutableList.of("파리 시"))
		.put("KSH", ImmutableList.of("Paris"))
		.put("KU", ImmutableList.of("Parîs"))
		.put("KW", ImmutableList.of("Paris"))
		.put("LA", ImmutableList.of("Lutetia Parisorum"))
		.put("LAD", ImmutableList.of("Paris"))
		.put("LB", ImmutableList.of("Paräis"))
		.put("LI", ImmutableList.of("Paries"))
		.put("LMO", ImmutableList.of("Paris"))
		.put("LN", ImmutableList.of("Pari"))
		.put("LT", ImmutableList.of("Paryžius"))
		.put("LV", ImmutableList.of("Parīze"))
		.put("MG", ImmutableList.of("Paris"))
		.put("MK", ImmutableList.of("Париз"))
		.put("MR", ImmutableList.of("पॅरिस"))
		.put("MS", ImmutableList.of("Paris"))
		.put("NA", ImmutableList.of("Paris"))
		.put("NDS", ImmutableList.of("Paris"))
		.put("NL", ImmutableList.of("Parijs"))
		.put("NN", ImmutableList.of("Paris"))
		.put("NO", ImmutableList.of("Paris"))
		.put("OC", ImmutableList.of("París"))
		.put("OS", ImmutableList.of("Париж"))
		.put("PL", ImmutableList.of("Paryż"))
		.put("PMS", ImmutableList.of("Paris"))
		.put("PT", ImmutableList.of("Paris"))
		.put("RO", ImmutableList.of("Paris"))
		.put("RU", ImmutableList.of("Париж"))
		.put("SCN", ImmutableList.of("Pariggi"))
		.put("SCO", ImmutableList.of("Paris"))
		.put("SK", ImmutableList.of("Paríž"))
		.put("SL", ImmutableList.of("Pariz"))
		.put("SQ", ImmutableList.of("Paris", "Parisi"))
		.put("SR", ImmutableList.of("Париз"))
		.put("SV", ImmutableList.of("Paris"))
		.put("SW", ImmutableList.of("Paris"))
		.put("TA", ImmutableList.of("பாரிஸ்"))
		.put("TET", ImmutableList.of("París"))
		.put("TG", ImmutableList.of("Париж"))
		.put("TH", ImmutableList.of("ปารีส"))
		.put("TL", ImmutableList.of("Paris", "Lungsod ng Paris"))
		.put("TR", ImmutableList.of("Paris"))
		.put("TY", ImmutableList.of("Paris"))
		.put("UG", ImmutableList.of("پارىژ"))
		.put("UK", ImmutableList.of("Париж"))
		.put("UR", ImmutableList.of("پیرس"))
		.put("VI", ImmutableList.of("Paris", "Pa-ri"))
		.put("VLS", ImmutableList.of("Paris"))
		.put("ZH", ImmutableList.of("巴黎"))
		.build();
    }
}
