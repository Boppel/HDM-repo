package sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class SenderExtraction {

	private final SenderExtractionHandler eventHandler = new SenderExtractionHandler();
	private final MyErrorHandler errorHander = new MyErrorHandler();
	private final XMLReader xmlReader;
	
	public SenderExtraction() throws ParserConfigurationException, SAXException {
		SAXParserFactory saxPf = SAXParserFactory.newInstance();
		SAXParser saxParser = saxPf.newSAXParser();
		xmlReader = saxParser.getXMLReader();
		xmlReader.setContentHandler(eventHandler);
		xmlReader.setErrorHandler(errorHander);
	}
	
	
	public void parse(final String uri) {
		try {
			xmlReader.parse(uri);
		} catch (IOException e) {
			e.printStackTrace(System.err);
		} catch (org.xml.sax.SAXException e) {
			e.printStackTrace(System.err);
		}
	}
	
}
