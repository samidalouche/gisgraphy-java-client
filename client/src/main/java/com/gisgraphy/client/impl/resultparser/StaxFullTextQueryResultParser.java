package com.gisgraphy.client.impl.resultparser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.InputStreamSource;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class StaxFullTextQueryResultParser implements FullTextQueryResultParser {

    public Iterable<FullTextQueryResult> parse(InputStreamSource iss) throws ParsingException {
	try {
	    return parseFullTextSearchResult(iss);
	} catch (IOException e) {
	    throw new ParsingException(e);
	} catch (XMLStreamException e) {
	    throw new ParsingException(e);
	}
    }
    
    public Iterable<FullTextQueryResult> parseFullTextSearchResult(InputStreamSource iss) throws IOException, XMLStreamException {

        List<FullTextQueryResult> searchResults = new ArrayList<FullTextQueryResult>();
        XMLEventReader eventReader = null;
        InputStream is = null;
        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            is = iss.getInputStream();
            eventReader = inputFactory.createXMLEventReader(is);
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                
                if (event.isStartElement()) {
                    if (event.asStartElement().getName().getLocalPart().equals("doc")) {
                        double score = 0;
                        String adm1Code = null;
                        String adm2Code = null;
                        String adm3Code = null;
                        String adm4Code = null;
                        String countryCode = null;
                        String countryFlagUrl = null;
                        Long elevation = null;
                        String featureClass = null;
                        String featureCode = null;
                        long featureId = 0;
                        String googleMapUrl = null;
                        Integer gTopo30 = null;
                        double latitude = 0;
                        double longitude = 0;
                        String name = null;
                        String asciiName = null;
                        Integer population = null;
                        String timezone = null;
                        String yahooMapUrl = null;
                        String placeType = null;
                        // This will map 2 or 3 letter language codes to their
                        // alternate country name
                        // We need an ImmutableMap.Builder while parsing
                        ImmutableMap.Builder<String, List<String>> alternateNamesBuilder = ImmutableMap.builder();

                        // We have a new CityResult
                        XMLEvent innerEvent = null;
                        while (eventReader.hasNext()) {
                            innerEvent = eventReader.nextEvent();
                            if (innerEvent.isStartElement()) {
                                StartElement startElement = innerEvent.asStartElement();
                                final String tagName = startElement.getName().getLocalPart();
                                if (tagName.equals("str")) {
                                    final String nameAttributeValue = nameAttributeValue(startElement);
                                    if ("name".equals(nameAttributeValue)) {
                                        name = eventReader.getElementText();
                                    } else if ("adm1_code".equals(nameAttributeValue)) {
                                        adm1Code = eventReader.getElementText();
                                    } else if ("adm2_code".equals(nameAttributeValue)) {
                                        adm2Code = eventReader.getElementText();
                                    } else if ("adm3_code".equals(nameAttributeValue)) {
                                        adm3Code = eventReader.getElementText();
                                    } else if ("adm4_code".equals(nameAttributeValue)) {
                                        adm4Code = eventReader.getElementText();
                                    } else if ("country_code".equals(nameAttributeValue)) {
                                        countryCode = eventReader.getElementText();
                                    } else if ("placetype".equals(nameAttributeValue)) {
                                        placeType = eventReader.getElementText();
                                    } else if ("country_flag_url".equals(nameAttributeValue)) {
                                        countryFlagUrl = eventReader.getElementText();
                                    } else if ("feature_class".equals(nameAttributeValue)) {
                                        featureClass = eventReader.getElementText();
                                    } else if ("feature_code".equals(nameAttributeValue)) {
                                        featureCode = eventReader.getElementText();
                                    } else if ("google_map_url".equals(nameAttributeValue)) {
                                        googleMapUrl = eventReader.getElementText();
                                    } else if ("name".equals(nameAttributeValue)) {
                                        name = eventReader.getElementText();
                                    } else if ("name_ascii".equals(nameAttributeValue)) {
                                        asciiName = eventReader.getElementText();
                                    } else if ("timezone".equals(nameAttributeValue)) {
                                        timezone = eventReader.getElementText();
                                    } else if ("yahoo_map_url".equals(nameAttributeValue)) {
                                        yahooMapUrl = eventReader.getElementText();
                                    }
                                } else if (tagName.equals("arr")) {
                                    if (nameAttributeValue(startElement).startsWith("name_alternate")) {
                                        this.parseAlternateNameArray(nameAttributeValue(startElement).substring(nameAttributeValue(startElement).lastIndexOf("_") + 1)
                                                , alternateNamesBuilder, eventReader, innerEvent);
                                    } 
                                } else if (tagName.equals("float")) {
                                    
                                    if ("score".equals(nameAttributeValue(startElement))) {
                                        score = Double.parseDouble(eventReader.getElementText());
                                    }
                                } else if (tagName.equals("long")) {
                                    if ("feature_id".equals(nameAttributeValue(startElement))) {
                                        featureId = Long.parseLong(eventReader.getElementText());
                                    }
                                } else if (tagName.equals("int")) {
                                    if ("elevation".equals(nameAttributeValue(startElement))) {
                                        elevation = Long.parseLong(eventReader.getElementText());
                                    } else if ("gtopo30".equals(nameAttributeValue(startElement))) {
                                        gTopo30 = Integer.parseInt(eventReader.getElementText());
                                    } else if ("population".equals(nameAttributeValue(startElement))) {
                                        population = Integer.parseInt(eventReader.getElementText());
                                    }
                                } else if (tagName.equals("double")) {
                                    if ("lat".equals(nameAttributeValue(startElement))) {
                                        latitude = Double.parseDouble(eventReader.getElementText());
                                    } else if ("lng".equals(nameAttributeValue(startElement))) {
                                        longitude = Double.parseDouble(eventReader.getElementText());
                                    }
                                }
                            } else {
                                if (innerEvent.isEndElement() && innerEvent.asEndElement().getName().getLocalPart().equals("doc")) {
                                    // Create a new CityResult and add it to the
                                    // output
                                    // output.add(cityResult);
                                    final FullTextQueryResult cityResult = FullTextQueryResult.newFullTextQueryResult().withAsciiName(asciiName).withAdm1Code(adm1Code).withAdm2Code(adm2Code).withAdm3Code(adm3Code).withAdm4Code(adm4Code).withCountryCode(countryCode).withPlaceType(placeType).withCountryFlagUrl(
                                            countryFlagUrl).withElevation(
                                            elevation).withFeatureClass(featureClass).withFeatureCode(
                                            featureCode).withFeatureId(featureId).withGoogleMapUrl(googleMapUrl).withGTopo30(
                                            gTopo30).withLatitude(latitude).withLongitude(longitude).withName(
                                            name).withPopulation(population).withScore(score).withTimezone(
                                            timezone).withYahooMapUrl(yahooMapUrl)
                                            .withAlternateNames(alternateNamesBuilder.build())
                                            .build();

                                    searchResults.add(cityResult);
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
    
    private String nameAttributeValue(StartElement startElement) {
	Attribute att = startElement.getAttributeByName(new QName("name"));
	if(att != null) {
	    return att.getValue();
	} else {
	    return null;
	}
    }

    private void parseAlternateNameArray(String languageCode, ImmutableMap.Builder mapBuilder, XMLEventReader eventReader, XMLEvent arrEvent) throws XMLStreamException {
        ImmutableList.Builder<String> alternateNamesListBuilder = ImmutableList.builder();

        while (!arrEvent.isEndElement() || !arrEvent.asEndElement().getName().getLocalPart().equals("arr")) {
            arrEvent = eventReader.nextEvent(); // this should be a <str>aleternateNameHere</str>
            if (arrEvent.isStartElement() && arrEvent.asStartElement().getName().getLocalPart().equals("str")) {
                arrEvent = eventReader.nextEvent(); // the alternate name
                String alternateName = arrEvent.asCharacters().getData();
                alternateNamesListBuilder.add(alternateName);
            }
        }
        mapBuilder.put(languageCode, alternateNamesListBuilder.build());
    }


}
