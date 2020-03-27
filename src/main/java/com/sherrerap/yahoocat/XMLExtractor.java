package com.sherrerap.yahoocat;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

import com.sherrerap.yahoocat.model.Document;

public class XMLExtractor {

	private static final String TAG_DOCUMENT = "document";
	private static final String TAG_URI = "uri";
	private static final String TAG_SUBJECT = "subject";
	private static final String TAG_CONTENT = "content";
	private static final String TAG_BESTANSWER = "bestanswer";
	private static final String TAG_NBESTANSWERS = "nbestanswers";
	private static final String TAG_ANSWER_ITEM = "answer_item";
	private static final String TAG_CAT = "cat";
	private static final String TAG_MAINCAT = "maincat";
	private static final String TAG_SUBCAT = "subcat";
	private static final String TAG_DATE = "date";
	private static final String TAG_RES_DATE = "res_date";
	private static final String TAG_VOT_DATE = "vot_date";
	private static final String TAG_LASTANSWERTS = "lastanswerts";
	private static final String TAG_QLANG = "qlang";
	private static final String TAG_QINTL = "qintl";
	private static final String TAG_LANGUAGE = "language";
	private static final String TAG_ID = "id";
	private static final String TAG_BEST_ID = "best_id";

	public static <E> void main(String[] args)
			throws FileNotFoundException, XMLStreamException, FactoryConfigurationError {

		// Creamos el flujo
		XMLInputFactory xmlif = XMLInputFactory.newInstance();

		// Cuando se crea una instancia de XMLStreamReader el evento inicial y actual es
		// el START_DOCUMENT
		XMLStreamReader xmlsr = xmlif
				.createXMLStreamReader(new FileReader("C:\\Users\\Sergio\\UCLM\\FullOct2007.xml\\FullOct2007.xml"));
		ArrayList<String> nombres = new ArrayList<String>();
		String tag = null;
		String uri = null;
		String subject = null;
		String content = null;
		String bestanswer = null;
		List<String> nbestanswers = new ArrayList<String>();
		String cat = null;
		String maincat = null;
		String subcat = null;
		String date = null;
		String res_date = null;
		String vot_date = null;
		String lastanswerts = null;
		String qlang = null;
		String qintl = null;
		String language = null;
		String id = null;
		String best_id = null;

		int eventType;

		System.out.println("Iniciando el documento");

		// iteramos con el cursor a lo largo del documento
		while (xmlsr.hasNext()) {

			// obtenemos el tipo de evento
			eventType = xmlsr.next();

			// Al tener que manejar varios eventos el bloque switch resulta una solución
			// elegante
			// para ir añadiendo case de eventos
			switch (eventType) {

			case XMLEvent.START_ELEMENT:

				// obtenemos la etiqueta
				tag = xmlsr.getLocalName();

				if (tag.equals(TAG_URI)) {
					uri = xmlsr.getElementText();

				}
				if (tag.equals(TAG_SUBJECT)) {
					subject = xmlsr.getElementText();

				}
				if (tag.equals(TAG_CONTENT)) {
					content = xmlsr.getElementText();

				}
				if (tag.equals(TAG_BESTANSWER)) {
					bestanswer = xmlsr.getElementText();

				}
//				if (tag.equals(TAG_NBESTANSWERS)) {
//
//				}
				if (tag.equals(TAG_ANSWER_ITEM)) {
					nbestanswers.add(xmlsr.getElementText());
				}
				if (tag.equals(TAG_CAT)) {
					cat = xmlsr.getElementText();

				}
				if (tag.equals(TAG_MAINCAT)) {
					maincat = xmlsr.getElementText();

				}
				if (tag.equals(TAG_SUBCAT)) {
					subcat = xmlsr.getElementText();

				}
				if (tag.equals(TAG_DATE)) {
					date = xmlsr.getElementText();

				}
				if (tag.equals(TAG_RES_DATE)) {
					res_date = xmlsr.getElementText();

				}
				if (tag.equals(TAG_VOT_DATE)) {
					vot_date = xmlsr.getElementText();

				}
				if (tag.equals(TAG_LASTANSWERTS)) {
					lastanswerts = xmlsr.getElementText();

				}
				if (tag.equals(TAG_QLANG)) {
					qlang = xmlsr.getElementText();

				}
				if (tag.equals(TAG_QINTL)) {
					qintl = xmlsr.getElementText();

				}
				if (tag.equals(TAG_LANGUAGE)) {
					language = xmlsr.getElementText();

				}
				if (tag.equals(TAG_ID)) {
					id = xmlsr.getElementText();

				}

				else if (tag.equals(TAG_BEST_ID)) {
					best_id = xmlsr.getElementText();
				}

				Document document = new Document(uri, subject, content, bestanswer, nbestanswers, cat, maincat, subcat,
						date, res_date, vot_date, lastanswerts, qlang, qintl, language, id, best_id);

				break;

			case XMLEvent.END_DOCUMENT:
				System.out.println("Fin del documento");
				break;

			}
		}

		System.out.println("Empleados con salario mayor a 30000: " + nombres);

	}
}
