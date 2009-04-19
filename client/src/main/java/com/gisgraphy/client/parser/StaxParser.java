package com.gisgraphy.client.parser;

import java.io.InputStream;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.gisgraphy.client.domain.GisFeature;

public class StaxParser {
	public Iterable<GisFeature> parse(InputStream is) {
		String placeName = null;

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
						// We have a new GisFeature
						XMLEvent innerEvent = null;
						while (eventReader.hasNext()) {
							innerEvent = eventReader.nextEvent();
							if (innerEvent.isStartElement()) {
								StartElement startElement = innerEvent.asStartElement();
								if (startElement.getName().getLocalPart().equals("str")
										&& "name".equals(startElement.getAttributeByName(new QName("name")).getValue())) {
									innerEvent = eventReader.nextEvent();
									placeName = innerEvent.asCharacters().getData();
								}
							} else {
								if (innerEvent.isEndElement()
										&& innerEvent.asEndElement().getName().getLocalPart().equals("doc")) {
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

		//TODO: Finish implementing this
		return null;
	}
}
