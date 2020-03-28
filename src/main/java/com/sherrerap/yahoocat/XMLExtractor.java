package com.sherrerap.yahoocat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.sherrerap.yahoocat.model.Document;

public class XMLExtractor {
	public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
		System.out.println("----- XMLExtractor -----");
		// All read employees objects will be added to this list
		List<Document> docList = new ArrayList<>();

		// Para el nombre del XML de salida
		String category = null;

		Scanner read = new Scanner(System.in);
		System.out.print("Inserte una categoría: ");
		category = read.nextLine();

		// Create Employee object. It will get all the data using setter methods.
		// And at last, it will stored in above 'employeeList'
		Document answer = null;
		List<String> answer_items = new ArrayList<>();

		File file = new File("C:/Users/Sergio/UCLM/BBDD Avanzadas/Trabajo XML/FullOct2007.xml");
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader streamReader = factory.createXMLStreamReader(new FileReader(file));

		int i = 0;

		while (streamReader.hasNext()) {
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
					try {
						if (answer.getMaincat().equals(category)) {
							docList.add(answer);
						}
					} catch (NullPointerException n) {
						// System.out.println("Pregunta ignorada por categoría errónea.");
					}
				}
			}
		}
		// Verify read data
		crearXML(docList, category);
		System.out.println("¡XML creado!");
	}

	public static void crearXML(List<Document> docList, String category) {
		JAXBContext contextObj = null;
		try {
			contextObj = JAXBContext.newInstance(Document.class);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		Marshaller marshallerObj = null;
		try {
			marshallerObj = contextObj.createMarshaller();
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		try {
			marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		} catch (PropertyException e) {
			e.printStackTrace();
		}

		try {
			FileOutputStream fo = new FileOutputStream(category + "_part.xml");
			for (int i = 0; i < docList.size(); i++) {
				marshallerObj.marshal(docList.get(i), fo);
			}
			reemplazarXML(category);
		} catch (IOException | JAXBException e) {
			e.printStackTrace();
		}

	}

	public static void reemplazarXML(String category) {
		File inputFile = new File(category + "_part.xml");
		File outputFile = new File(category + ".xml");
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

			String currentLine;

			while ((currentLine = reader.readLine()) != null) {
				if (currentLine.trim().equals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")) {
					continue;
				}
				writer.write(currentLine + System.getProperty("line.separator"));
			}

			File mFile = new File(category + ".xml");
			FileInputStream fis = new FileInputStream(mFile);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String result = "";
			String line = "";
			while ((line = br.readLine()) != null) {
				result = result + line;
			}

			result = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" + result;

			mFile.delete();
			FileOutputStream fos = new FileOutputStream(mFile);
			fos.write(result.getBytes());
			fos.flush();

			writer.close();
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}