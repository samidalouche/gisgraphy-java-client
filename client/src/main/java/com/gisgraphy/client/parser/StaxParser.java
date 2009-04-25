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

public class StaxParser {
	public Iterable<CityResult> parse(InputStream is) {

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
								final String nameAttributeValue = startElement.getAttributeByName(new QName("name")).getValue();
								if (tagName.equals("str")) {
									if ("name".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										name = innerEvent.asCharacters().getData();
									}
									else if ("country_code".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										countryCode = innerEvent.asCharacters().getData();
									}
									else if ("country_flag_url".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										countryFlagUrl = innerEvent.asCharacters().getData();
									}
									else if ("country_name".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										countryName = innerEvent.asCharacters().getData();
									}
									else if ("feature_class".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										featureClass = innerEvent.asCharacters().getData();
									}
									else if ("feature_code".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										featureCode = innerEvent.asCharacters().getData();
									}
									else if ("fully_qualified_name".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										fullyQualifiedName = innerEvent.asCharacters().getData();
									}
									else if ("google_map_url".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										googleMapUrl = innerEvent.asCharacters().getData();
									}
									else if ("name".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										name = innerEvent.asCharacters().getData();
									}
									else if ("name_ascii".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										asciiName = innerEvent.asCharacters().getData();
									}
									else if ("timezone".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										timezone = innerEvent.asCharacters().getData();
									}
									else if ("yahoo_map_url".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										yahooMapUrl = innerEvent.asCharacters().getData();
									}
								}
								else if (tagName.equals("float")) {
									if ("score".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										score = Double.parseDouble(innerEvent.asCharacters().getData());
									} 
								}
								else if (tagName.equals("long")) {
									if ("feature_id".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										featureId = Long.parseLong(innerEvent.asCharacters().getData());
									} 
								}
								else if (tagName.equals("int")) {
									if ("elevation".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										elevation = Integer.parseInt(innerEvent.asCharacters().getData());
									}
									else if ("gtopo30".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										gTopo30 = Integer.parseInt(innerEvent.asCharacters().getData());
									}
									else if ("population".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										population = Integer.parseInt(innerEvent.asCharacters().getData());
									}
								}
								else if (tagName.equals("double")) {
									if ("lat".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										latitude = Double.parseDouble(innerEvent.asCharacters().getData());
									}
									else if ("lng".equals(nameAttributeValue)) {
										innerEvent = eventReader.nextEvent();
										longitude = Double.parseDouble(innerEvent.asCharacters().getData());
									}
								}
							} else {
								if (innerEvent.isEndElement()
										&& innerEvent.asEndElement().getName().getLocalPart().equals("doc")) {
									// Create a new CityResult and add it to the output
									//output.add(cityResult);
									final CityResult cityResult = CityResult.newCityResult()
									.withAsciiName(asciiName)
									.withCountryCode(countryCode)
									.withCountryFlagUrl(countryFlagUrl)
									.withCountryName(countryName)
									.withElevation(elevation)
									.withFeatureClass(featureClass)
									.withFeatureCode(featureCode)
									.withFeatureId(featureId)
									.withFullyQualifiedName(fullyQualifiedName)
									.withGoogleMapUrl(googleMapUrl)
									.withGTopo30(gTopo30)
									.withLatitude(latitude)
									.withLongitude(longitude)
									.withName(name)
									.withPopulation(population)
									.withScore(score)
									.withTimezone(timezone)
									.withYahooMapUrl(yahooMapUrl)
									.build();
									
									output.add(cityResult);
									break;
								}
							}
						}
						// event = eventReader.nextEvent();
						// System.out.println(event.asCharacters().getData());
						// continue;
					}
					/*
					 * if (event.asStartElement().getName().getLocalPart() ==
					 * ("baud")) { event = eventReader.nextEvent();
					 * System.out.println(event.asCharacters().getData());
					 * continue; }
					 * 
					 * if (event.asStartElement().getName().getLocalPart() ==
					 * ("bit")) { event = eventReader.nextEvent();
					 * System.out.println(event.asCharacters().getData());
					 * continue; }
					 * 
					 * if (event.asStartElement().getName().getLocalPart() ==
					 * ("parity")) { event = eventReader.nextEvent();
					 * System.out.println(event.asCharacters().getData());
					 * continue; }
					 */
				}
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}

		
		return output;
	}
}
