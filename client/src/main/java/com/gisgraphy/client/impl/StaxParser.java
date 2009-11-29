package com.gisgraphy.client.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.InputStreamSource;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class StaxParser {

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
                        String adm1Name = null;
                        String adm1Code = null;
                        String adm2Name = null;
                        String adm2Code = null;
                        String adm3Name = null;
                        String adm3Code = null;
                        String adm4Name = null;
                        String adm4Code = null;
                        String countryCode = null;
                        String countryFlagUrl = null;
                        String countryName = null;
                        int elevation = 0;
                        String featureClass = null;
                        String featureCode = null;
                        long featureId = 0;
                        String fullyQualifiedName = null;
                        String googleMapUrl = null;
                        int gTopo30 = 0;
                        double latitude = 0;
                        double longitude = 0;
                        String name = null;
                        String asciiName = null;
                        int population = 0;
                        String timezone = null;
                        String yahooMapUrl = null;
                        String placeType = null;
                        // This will map 2 or 3 letter language codes to their
                        // alternate country name
                        // We need an ImmutableMap.Builder while parsing
                        ImmutableMap.Builder<String, List<String>> alternateCountryNamesBuilder = ImmutableMap.builder();
                        ImmutableMap.Builder<String, List<String>> alternateNamesBuilder = ImmutableMap.builder();
                        ImmutableMap.Builder<String, List<String>> alternateAdm1NamesBuilder = ImmutableMap.builder();
                        ImmutableMap.Builder<String, List<String>> alternateAdm2NamesBuilder = ImmutableMap.builder();
                        ImmutableMap.Builder<String, List<String>> alternateAdm3NamesBuilder = ImmutableMap.builder();
                        ImmutableMap.Builder<String, List<String>> alternateAdm4NamesBuilder = ImmutableMap.builder();

                        // We have a new CityResult
                        XMLEvent innerEvent = null;
                        while (eventReader.hasNext()) {
                            innerEvent = eventReader.nextEvent();
                            if (innerEvent.isStartElement()) {
                                StartElement startElement = innerEvent.asStartElement();
                                final String tagName = startElement.getName().getLocalPart();
                                final String nameAttributeValue = startElement.getAttributeByName(new QName("name")).getValue();
                                if (tagName.equals("str")) {
                                    if ("name".equals(nameAttributeValue)) {
                                        name = eventReader.getElementText();
                                    } else if ("adm1_code".equals(nameAttributeValue)) {
                                        adm1Code = eventReader.getElementText();
                                    } else if ("adm1_name".equals(nameAttributeValue)) {
                                        adm1Name = eventReader.getElementText();
                                    } else if ("adm2_code".equals(nameAttributeValue)) {
                                        adm2Code = eventReader.getElementText();
                                    } else if ("adm2_name".equals(nameAttributeValue)) {
                                        adm2Name = eventReader.getElementText();
                                    } else if ("adm3_name".equals(nameAttributeValue)) {
                                        adm3Name = eventReader.getElementText();
                                    } else if ("adm3_code".equals(nameAttributeValue)) {
                                        adm3Code = eventReader.getElementText();
                                    } else if ("adm4_name".equals(nameAttributeValue)) {
                                        adm4Name = eventReader.getElementText();
                                    } else if ("adm4_code".equals(nameAttributeValue)) {
                                        adm4Code = eventReader.getElementText();
                                    } else if ("country_code".equals(nameAttributeValue)) {
                                        countryCode = eventReader.getElementText();
                                    } else if ("placetype".equals(nameAttributeValue)) {
                                        placeType = eventReader.getElementText();
                                    } else if ("country_flag_url".equals(nameAttributeValue)) {
                                        countryFlagUrl = eventReader.getElementText();
                                    } else if ("country_name".equals(nameAttributeValue)) {
                                        countryName = eventReader.getElementText();
                                    } else if ("feature_class".equals(nameAttributeValue)) {
                                        featureClass = eventReader.getElementText();
                                    } else if ("feature_code".equals(nameAttributeValue)) {
                                        featureCode = eventReader.getElementText();
                                    } else if ("fully_qualified_name".equals(nameAttributeValue)) {
                                        fullyQualifiedName = eventReader.getElementText();
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
                                    if (nameAttributeValue.startsWith("country_name_alternate")) {
                                        this.parseAlternateNameArray(nameAttributeValue.substring(nameAttributeValue.lastIndexOf("_") + 1)
                                                , alternateCountryNamesBuilder, eventReader, innerEvent);
                                    } else if (nameAttributeValue.startsWith("name_alternate")) {
                                        this.parseAlternateNameArray(nameAttributeValue.substring(nameAttributeValue.lastIndexOf("_") + 1)
                                                , alternateNamesBuilder, eventReader, innerEvent);
                                    } else if (nameAttributeValue.startsWith("adm1_name_alternate")) {
                                        this.parseAlternateNameArray(nameAttributeValue.substring(nameAttributeValue.lastIndexOf("_") + 1)
                                                , alternateAdm1NamesBuilder, eventReader, innerEvent);
                                    } else if (nameAttributeValue.startsWith("adm2_name_alternate")) {
                                       this.parseAlternateNameArray(nameAttributeValue.substring(nameAttributeValue.lastIndexOf("_") + 1)
                                                , alternateAdm2NamesBuilder, eventReader, innerEvent);
                                    } else if (nameAttributeValue.startsWith("adm3_name_alternate")) {
                                        this.parseAlternateNameArray(nameAttributeValue.substring(nameAttributeValue.lastIndexOf("_") + 1)
                                                , alternateAdm3NamesBuilder, eventReader, innerEvent);
                                    } else if (nameAttributeValue.startsWith("adm4_name_alternate")) {
                                        this.parseAlternateNameArray(nameAttributeValue.substring(nameAttributeValue.lastIndexOf("_") + 1)
                                                , alternateAdm4NamesBuilder, eventReader, innerEvent);
                                    }
                                } else if (tagName.equals("float")) {
                                    if ("score".equals(nameAttributeValue)) {
                                        score = Double.parseDouble(eventReader.getElementText());
                                    }
                                } else if (tagName.equals("long")) {
                                    if ("feature_id".equals(nameAttributeValue)) {
                                        featureId = Long.parseLong(eventReader.getElementText());
                                    }
                                } else if (tagName.equals("int")) {
                                    if ("elevation".equals(nameAttributeValue)) {
                                        elevation = Integer.parseInt(eventReader.getElementText());
                                    } else if ("gtopo30".equals(nameAttributeValue)) {
                                        gTopo30 = Integer.parseInt(eventReader.getElementText());
                                    } else if ("population".equals(nameAttributeValue)) {
                                        population = Integer.parseInt(eventReader.getElementText());
                                    }
                                } else if (tagName.equals("double")) {
                                    if ("lat".equals(nameAttributeValue)) {
                                        latitude = Double.parseDouble(eventReader.getElementText());
                                    } else if ("lng".equals(nameAttributeValue)) {
                                        longitude = Double.parseDouble(eventReader.getElementText());
                                    }
                                }
                            } else {
                                if (innerEvent.isEndElement() && innerEvent.asEndElement().getName().getLocalPart().equals("doc")) {
                                    // Create a new CityResult and add it to the
                                    // output
                                    // output.add(cityResult);
                                    final FullTextQueryResult cityResult = FullTextQueryResult.newFullTextQueryResult().withAsciiName(asciiName).withAdm1Code(adm1Code).withAdm1Name(adm1Name).withAdm2Code(adm2Code).withAdm2Name(adm2Name).withAdm3Code(adm3Code).withAdm3Name(adm3Name).withAdm4Code(adm4Code).withAdm4Name(adm4Name).withCountryCode(countryCode).withPlaceType(placeType).withCountryFlagUrl(
                                            countryFlagUrl).withCountryName(countryName).withElevation(
                                            elevation).withFeatureClass(featureClass).withFeatureCode(
                                            featureCode).withFeatureId(featureId).withFullyQualifiedName(
                                            fullyQualifiedName).withGoogleMapUrl(googleMapUrl).withGTopo30(
                                            gTopo30).withLatitude(latitude).withLongitude(longitude).withName(
                                            name).withPopulation(population).withScore(score).withTimezone(
                                            timezone).withYahooMapUrl(yahooMapUrl)
                                            .withAlternateNames(alternateNamesBuilder.build())
                                            .withCountryAlternateNames(alternateCountryNamesBuilder.build())
                                            .withAdm1AlternateNames(alternateAdm1NamesBuilder.build())
                                            .withAdm2AlternateNames(alternateAdm2NamesBuilder.build())
                                            .withAdm3AlternateNames(alternateAdm3NamesBuilder.build())
                                            .withAdm4AlternateNames(alternateAdm4NamesBuilder.build())
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
