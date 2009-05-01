package com.gisgraphy.client.parser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.gisgraphy.client.domain.CityResult;
import com.gisgraphy.client.domain.GeolocalisationResult;

public class StaxParser {
	public Iterable<CityResult> parseFullTextSearchResult(InputStream is) {

		List<CityResult> output = new ArrayList<CityResult>();

		try {
			// First create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			// Setup a new eventReader
			XMLEventReader eventReader = inputFactory.createXMLEventReader(is);
			// Read the XML document
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();

				if (event.isStartElement()) {
					if (event.asStartElement().getName().getLocalPart().equals("doc")) {
						double score = 0;
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

						// We have a new CityResult
						XMLEvent innerEvent = null;
						while (eventReader.hasNext()) {
							innerEvent = eventReader.nextEvent();
							if (innerEvent.isStartElement()) {
								StartElement startElement = innerEvent.asStartElement();
								final String tagName = startElement.getName().getLocalPart();
								final String nameAttributeValue = startElement.getAttributeByName(new QName("name"))
										.getValue();
								if (tagName.equals("str")) {
									if ("name".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										name = innerEvent.asCharacters().getData();
									} else if ("country_code".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										countryCode = innerEvent.asCharacters().getData();
									} else if ("country_flag_url".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										countryFlagUrl = innerEvent.asCharacters().getData();
									} else if ("country_name".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										countryName = innerEvent.asCharacters().getData();
									} else if ("feature_class".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										featureClass = innerEvent.asCharacters().getData();
									} else if ("feature_code".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										featureCode = innerEvent.asCharacters().getData();
									} else if ("fully_qualified_name".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										fullyQualifiedName = innerEvent.asCharacters().getData();
									} else if ("google_map_url".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										googleMapUrl = innerEvent.asCharacters().getData();
									} else if ("name".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										name = innerEvent.asCharacters().getData();
									} else if ("name_ascii".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										asciiName = innerEvent.asCharacters().getData();
									} else if ("timezone".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										timezone = innerEvent.asCharacters().getData();
									} else if ("yahoo_map_url".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										yahooMapUrl = innerEvent.asCharacters().getData();
									}
								} else if (tagName.equals("float")) {
									if ("score".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										score = Double.parseDouble(innerEvent.asCharacters().getData());
									}
								} else if (tagName.equals("long")) {
									if ("feature_id".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										featureId = Long.parseLong(innerEvent.asCharacters().getData());
									}
								} else if (tagName.equals("int")) {
									if ("elevation".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										elevation = Integer.parseInt(innerEvent.asCharacters().getData());
									} else if ("gtopo30".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										gTopo30 = Integer.parseInt(innerEvent.asCharacters().getData());
									} else if ("population".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										population = Integer.parseInt(innerEvent.asCharacters().getData());
									}
								} else if (tagName.equals("double")) {
									if ("lat".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										latitude = Double.parseDouble(innerEvent.asCharacters().getData());
									} else if ("lng".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										longitude = Double.parseDouble(innerEvent.asCharacters().getData());
									}
								}
							} else {
								if (innerEvent.isEndElement()
										&& innerEvent.asEndElement().getName().getLocalPart().equals("doc")) {
									// Create a new CityResult and add it to the
									// output
									// output.add(cityResult);
									final CityResult cityResult = CityResult.newCityResult().withAsciiName(asciiName)
											.withCountryCode(countryCode).withCountryFlagUrl(countryFlagUrl)
											.withCountryName(countryName).withElevation(elevation).withFeatureClass(
													featureClass).withFeatureCode(featureCode).withFeatureId(featureId)
											.withFullyQualifiedName(fullyQualifiedName).withGoogleMapUrl(googleMapUrl)
											.withGTopo30(gTopo30).withLatitude(latitude).withLongitude(longitude)
											.withName(name).withPopulation(population).withScore(score).withTimezone(
													timezone).withYahooMapUrl(yahooMapUrl).build();

									output.add(cityResult);
									break;
								}
							}
						}
					}

				}
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}

		return output;
	}

	public Iterable<GeolocalisationResult> parseGeolocalisationResult(InputStream is) {

		List<GeolocalisationResult> output = new ArrayList<GeolocalisationResult>();

		try {
			// First create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			// Setup a new eventReader
			XMLEventReader eventReader = inputFactory.createXMLEventReader(is);
			// Read the XML document
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
						XMLEvent innerEvent = null;
						while (eventReader.hasNext()) {
							innerEvent = eventReader.nextEvent();
							if (innerEvent.isStartElement()) {
								StartElement startElement = innerEvent.asStartElement();
								final String tagName = startElement.getName().getLocalPart();
								if ("distance".equals(tagName)) {
									innerEvent = eventReader.nextEvent();
									distance = Double.parseDouble(innerEvent.asCharacters().getData());
								} else if ("name".equals(tagName)) {
									innerEvent = eventReader.nextEvent();
									name = innerEvent.asCharacters().getData();
								} else if ("adm1Code".equals(tagName)) {
									innerEvent = eventReader.nextEvent();
									adm1Code = innerEvent.asCharacters().getData();
								} else if ("adm2Code".equals(tagName)) {
									innerEvent = eventReader.nextEvent();
									adm2Code = innerEvent.asCharacters().getData();
								} else if ("adm3Code".equals(tagName)) {
									innerEvent = eventReader.nextEvent();
									adm3Code = innerEvent.asCharacters().getData();
								} else if ("adm4Code".equals(tagName)) {
									innerEvent = eventReader.nextEvent();
									adm4Code = innerEvent.asCharacters().getData();
								} else if ("asciiName".equals(tagName)) {
									innerEvent = eventReader.nextEvent();
									asciiName = innerEvent.asCharacters().getData();
								} else if ("countryCode".equals(tagName)) {
									innerEvent = eventReader.nextEvent();
									countryCode = innerEvent.asCharacters().getData();
								} else if ("featureClass".equals(tagName)) {
									innerEvent = eventReader.nextEvent();
									featureClass = innerEvent.asCharacters().getData();
								} else if ("featureCode".equals(tagName)) {
									innerEvent = eventReader.nextEvent();
									featureCode = innerEvent.asCharacters().getData();
								} else if ("featureId".equals(tagName)) {
									innerEvent = eventReader.nextEvent();
									featureId = Long.parseLong(innerEvent.asCharacters().getData());
								} else if ("gtopo30".equals(tagName)) {
									innerEvent = eventReader.nextEvent();
									gTopo30 = Integer.parseInt(innerEvent.asCharacters().getData());
								} else if ("population".equals(tagName)) {
									innerEvent = eventReader.nextEvent();
									population = Integer.parseInt(innerEvent.asCharacters().getData());
								} else if ("timezone".equals(tagName)) {
									innerEvent = eventReader.nextEvent();
									timezone = innerEvent.asCharacters().getData();
								} else if ("lat".equals(tagName)) {
									innerEvent = eventReader.nextEvent();
									latitude = Double.parseDouble(innerEvent.asCharacters().getData());
								} else if ("lng".equals(tagName)) {
									innerEvent = eventReader.nextEvent();
									longitude = Double.parseDouble(innerEvent.asCharacters().getData());
								} else if ("placeType".equals(tagName)) {
									innerEvent = eventReader.nextEvent();
									placeType = innerEvent.asCharacters().getData();
								} else if ("zipCode".equals(tagName)) {
									innerEvent = eventReader.nextEvent();
									zipCode = innerEvent.asCharacters().getData();
								} else if ("google_map_url".equals(tagName)) {
									innerEvent = eventReader.nextEvent();
									googleMapUrl = innerEvent.asCharacters().getData();
								} else if ("yahoo_map_url".equals(tagName)) {
									innerEvent = eventReader.nextEvent();
									yahooMapUrl = innerEvent.asCharacters().getData();
								} else if ("country_flag_url".equals(tagName)) {
									innerEvent = eventReader.nextEvent();
									countryFlagUrl = innerEvent.asCharacters().getData();
								}

							} else {
								if (innerEvent.isEndElement()
										&& innerEvent.asEndElement().getName().getLocalPart().equals("result")) {
									// Create a new CityResult and add it to the
									// output
									// output.add(cityResult);
									final GeolocalisationResult geolocalisationResult = GeolocalisationResult.newGeolocalisationResult()
									.withDistance(distance)
									.withAdm1Code(adm1Code)
									.withAdm2Code(adm2Code)
									.withAdm3Code(adm3Code)
									.withAdm4Code(adm4Code)
									.withAdm1Name(adm1Name)
									.withAdm2Name(adm2Name)
									.withAdm3Name(adm3Name)
									.withAdm4Name(adm4Name)
									.withCountryCode(countryCode)
									.withAsciiName(asciiName)
									.withCountryFlagUrl(countryFlagUrl)
									.withFeatureClass(featureClass)
									.withFeatureCode(featureCode)
									.withFeatureId(featureId)
									.withGoogleMapUrl(googleMapUrl)
									.withGTopo30(gTopo30)
									.withLatitude(latitude)
									.withLongitude(longitude)
									.withName(name)
									.withPopulation(population)
									.withTimezone(timezone)
									.withYahooMapUrl(yahooMapUrl)
									.withPlaceType(placeType)
									.withZipCode(zipCode)
									.build();

									output.add(geolocalisationResult);
									break;
								}
							}
						}
					}

				}
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}

		return output;
	}
}
