package com.sherrerap.yahoocat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.sherrerap.yahoocat.model.Document;

public class XMLExtractor {
	public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
		// All read employees objects will be added to this list
		List<Document> docList = new ArrayList<>();

		// Create Employee object. It will get all the data using setter methods.
		// And at last, it will stored in above 'employeeList'
		Document answer = null;
		List<String> answer_items = new ArrayList<>();

		File file = new File("C:/Users/rubri/Desktop/FullOct2007.xml");
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader streamReader = factory.createXMLStreamReader(new FileReader(file));

		int i = 0;

		while (streamReader.hasNext() && i < 10) {
			// Move to next event
			streamReader.next();

			// Check if its 'START_ELEMENT'
			if (streamReader.getEventType() == XMLStreamReader.START_ELEMENT) {
				// employee tag - opened
				if (streamReader.getLocalName().equalsIgnoreCase("document")) {

					// Create new employee object asap tag is open
					answer = new Document();

					i++;

				}

				if (streamReader.getLocalName().equalsIgnoreCase("uri")) {
					answer.setUri(streamReader.getElementText());
				}

				if (streamReader.getLocalName().equalsIgnoreCase("subject")) {
					answer.setSubject(streamReader.getElementText());
				}

				if (streamReader.getLocalName().equalsIgnoreCase("content")) {
					answer.setContent(streamReader.getElementText());
				}

				if (streamReader.getLocalName().equalsIgnoreCase("bestanswer")) {
					answer.setBestanswer(streamReader.getElementText());
				}

				if (streamReader.getLocalName().equalsIgnoreCase("nbestanswers")) {
					answer_items = new ArrayList<>();
				}

				if (streamReader.getLocalName().equalsIgnoreCase("answer_item")) {
					answer_items.add(streamReader.getElementText());
				}

				if (streamReader.getLocalName().equalsIgnoreCase("cat")) {
					answer.setCat(streamReader.getElementText());
					answer.setNbestanswers(answer_items);
					answer_items = null;
				}

				if (streamReader.getLocalName().equalsIgnoreCase("maincat")) {
					answer.setMaincat(streamReader.getElementText());
				}

				if (streamReader.getLocalName().equalsIgnoreCase("subcat")) {
					answer.setSubcat(streamReader.getElementText());
				}

				if (streamReader.getLocalName().equalsIgnoreCase("date")) {
					answer.setDate(streamReader.getElementText());
				}

				if (streamReader.getLocalName().equalsIgnoreCase("res_date")) {
					answer.setRes_date(streamReader.getElementText());
				}

				if (streamReader.getLocalName().equalsIgnoreCase("vot_date")) {
					answer.setVot_date(streamReader.getElementText());
				}

				if (streamReader.getLocalName().equalsIgnoreCase("lastanswerts")) {
					answer.setLastanswerts(streamReader.getElementText());
				}

				if (streamReader.getLocalName().equalsIgnoreCase("qlang")) {
					answer.setQlang(streamReader.getElementText());
				}

				if (streamReader.getLocalName().equalsIgnoreCase("qintl")) {
					answer.setQintl(streamReader.getElementText());
				}

				if (streamReader.getLocalName().equalsIgnoreCase("language")) {
					answer.setLanguage(streamReader.getElementText());
				}

				if (streamReader.getLocalName().equalsIgnoreCase("id")) {
					answer.setId(streamReader.getElementText());
				}

				if (streamReader.getLocalName().equalsIgnoreCase("best_id")) {
					answer.setBest_id(streamReader.getElementText());
				}

			}

			// If employee tag is closed then add the employee object to list
			if (streamReader.getEventType() == XMLStreamReader.END_ELEMENT) {
				if (streamReader.getLocalName().equalsIgnoreCase("document")) {
					docList.add(answer);
				}
			}
		}
		// Verify read data

	}
}