package com.sherrerap.yahoocat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.sherrerap.yahoocat.model.Document;

public class XMLExtractor {
	public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
		File file = new File("documents.xml");

		// Instance of the class which helps on reading tags
		XMLInputFactory factory = XMLInputFactory.newInstance();

		// Initializing the handler to access the tags in the XML file
		XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(file));

		// All read documents objects will be added to this list
		List<Document> documentList = new ArrayList<Document>();

		// Create Document object. It will get all the data using setter methods.
		// And at last, it will stored in above 'documentList'
		Document document = null;

		// Checking the availability of the next tag
		while (eventReader.hasNext()) {
			XMLEvent xmlEvent = eventReader.nextEvent();

			if (xmlEvent.isStartElement()) {
				StartElement startElement = xmlEvent.asStartElement();

				// As soo as document tag is opened, create new Document object
				if ("document".equalsIgnoreCase(startElement.getName().getLocalPart())) {
					document = new Document();
				}

				// Read all attributes when start tag is being read
				@SuppressWarnings("unchecked")
				Iterator<Attribute> iterator = startElement.getAttributes();

				while (iterator.hasNext()) {
					Attribute attribute = iterator.next();
					QName name = attribute.getName();
					if ("id".equalsIgnoreCase(name.getLocalPart())) {
						document.setId(Integer.valueOf(attribute.getValue()));
					}
				}

				// Now everytime content tags are found;
				// Move the iterator and read data
				switch (startElement.getName().getLocalPart()) {
				case "name":
					Characters nameDataEvent = (Characters) eventReader.nextEvent();
					document.setName(nameDataEvent.getData());
					break;

				case "title":
					Characters titleDataEvent = (Characters) eventReader.nextEvent();
					document.setTitle(titleDataEvent.getData());
					break;
				}
			}

			if (xmlEvent.isEndElement()) {
				EndElement endElement = xmlEvent.asEndElement();

				// If document tag is closed then add the document object to list;
				// and be ready to read next document data
				if ("document".equalsIgnoreCase(endElement.getName().getLocalPart())) {
					documentList.add(document);
				}
			}
		}

		System.out.println(documentList); // Verify read data

	}
}
