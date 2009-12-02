package com.gisgraphy.client.impl.resultparser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.InputStreamSource;

import com.google.common.collect.ImmutableList;

public class StaxGeolocalizationQueryResultParser implements GeolocalizationQueryResultParser {

    public Iterable<GeolocalisationResult> parse(InputStreamSource iss)
	    throws ParsingException {
	try {
	    return parseGeolocalisationResult(iss);
	} catch (IOException e) {
	    throw new ParsingException(e);
	} catch (XMLStreamException e) {
	    throw new ParsingException(e);
	}
    }

    public Iterable<GeolocalisationResult> parseGeolocalisationResult(InputStreamSource iss) throws IOException, XMLStreamException {

        List<GeolocalisationResult> searchResults = new ArrayList<GeolocalisationResult>();
        XMLEventReader eventReader = null;
        InputStream is = null;
        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            is = iss.getInputStream();
            eventReader = inputFactory.createXMLEventReader(is);
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                if (event.isStartElement()) {
                    if (event.asStartElement().getName().getLocalPart().equals("result")) {
                        Double distance = null;
                        String name = null;
                        String adm1Code = null;
                        String adm2Code = null;
                        String adm3Code = null;
                        String adm4Code = null;
                        String adm1Name = null;
                        String adm2Name = null;
                        String adm3Name = null;
                        String adm4Name = null;
                        String asciiName = null;
                        String countryCode = null;
                        String featureClass = null;
                        String featureCode = null;
                        Long featureId = null;
                        Integer gTopo30 = null;
                        Integer population = null;
                        String timezone = null;
                        Double latitude = null;
                        Double longitude = null;
                        String placeType = null;
                        String zipCode = null;
                        String googleMapUrl = null;
                        String yahooMapUrl = null;
                        String countryFlagUrl = null;

                        // We have a new CityResult
                        while (eventReader.hasNext()) {
                            XMLEvent innerEvent = eventReader.nextEvent();
                            if (innerEvent.isStartElement()) {
                                StartElement startElement = innerEvent.asStartElement();
                                final String tagName = startElement.getName().getLocalPart();
                                if ("distance".equals(tagName)) {
                                    distance = Double.parseDouble(eventReader.getElementText());
                                } else if ("name".equals(tagName)) {
                                    name = eventReader.getElementText();
                                } else if ("adm1Code".equals(tagName)) {
                                    adm1Code = eventReader.getElementText();
                                } else if ("adm2Code".equals(tagName)) {
                                    adm2Code = eventReader.getElementText();
                                } else if ("adm3Code".equals(tagName)) {
                                    adm3Code = eventReader.getElementText();
                                } else if ("adm4Code".equals(tagName)) {
                                    adm4Code = eventReader.getElementText();
                                } else if ("adm1Name".equals(tagName)) {
                                    adm1Name = eventReader.getElementText();
                                } else if ("adm2Name".equals(tagName)) {
                                    adm2Name = eventReader.getElementText();
                                } else if ("adm3Name".equals(tagName)) {
                                    adm3Name = eventReader.getElementText();
                                } else if ("adm4Name".equals(tagName)) {
                                    adm4Name = eventReader.getElementText();
                                } else if ("asciiName".equals(tagName)) {
                                    asciiName = eventReader.getElementText();
                                } else if ("countryCode".equals(tagName)) {
                                    countryCode = eventReader.getElementText();
                                } else if ("featureClass".equals(tagName)) {
                                    featureClass = eventReader.getElementText();
                                } else if ("featureCode".equals(tagName)) {
                                    featureCode = eventReader.getElementText();
                                } else if ("featureId".equals(tagName)) {
                                    featureId = Long.parseLong(eventReader.getElementText());
                                } else if ("gtopo30".equals(tagName)) {
                                    gTopo30 = Integer.parseInt(eventReader.getElementText());
                                } else if ("population".equals(tagName)) {
                                    population = Integer.parseInt(eventReader.getElementText());
                                } else if ("timezone".equals(tagName)) {
                                    timezone = eventReader.getElementText();
                                } else if ("lat".equals(tagName)) {
                                    latitude = Double.parseDouble(eventReader.getElementText());
                                } else if ("lng".equals(tagName)) {
                                    longitude = Double.parseDouble(eventReader.getElementText());
                                } else if ("placeType".equals(tagName)) {
                                    placeType = eventReader.getElementText();
                                } else if ("zipCode".equals(tagName)) {
                                    zipCode = eventReader.getElementText();
                                } else if ("google_map_url".equals(tagName)) {
                                    googleMapUrl = eventReader.getElementText();
                                } else if ("yahoo_map_url".equals(tagName)) {
                                    yahooMapUrl = eventReader.getElementText();
                                } else if ("country_flag_url".equals(tagName)) {
                                    countryFlagUrl = eventReader.getElementText();
                                }

                            } else {
                                if (innerEvent.isEndElement() && innerEvent.asEndElement().getName().getLocalPart().equals("result")) {
                                    // Create a new CityResult and add it to the
                                    // output
                                    // output.add(cityResult);
                                    final GeolocalisationResult geolocalisationResult = GeolocalisationResult.newGeolocalisationResult().withDistance(distance).withAdm1Code(adm1Code).withAdm2Code(adm2Code).withAdm3Code(adm3Code).withAdm4Code(adm4Code).withAdm1Name(adm1Name).withAdm2Name(adm2Name).withAdm3Name(adm3Name).withAdm4Name(adm4Name).withCountryCode(countryCode).withAsciiName(
                                            asciiName).withCountryFlagUrl(countryFlagUrl).withFeatureClass(
                                            featureClass).withFeatureCode(featureCode).withFeatureId(featureId).withGoogleMapUrl(googleMapUrl).withGTopo30(gTopo30).withLatitude(latitude).withLongitude(longitude).withName(name).withPopulation(population).withTimezone(timezone).withYahooMapUrl(yahooMapUrl).withPlaceType(
                                            placeType).withZipCode(zipCode).build();

                                    searchResults.add(geolocalisationResult);
                                    break;
                                }
                            }
                        }
                    }

                }
            }
        } 
        finally {
            eventReader.close();
            IOUtils.closeQuietly(is);
        }

        return ImmutableList.copyOf(searchResults);
    }
}
