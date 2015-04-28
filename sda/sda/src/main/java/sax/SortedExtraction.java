package sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class SortedExtraction {

	private final SortedExtractionHandler handler = new SortedExtractionHandler();
	private final MyErrorHandler myErrorHandler = new MyErrorHandler();
	private final XMLReader xmlReader;
	
	public SortedExtraction() throws ParserConfigurationException, SAXException {
		SAXParserFactory saxPf = SAXParserFactory.newInstance();
		SAXParser saxParser = saxPf.newSAXParser();
		xmlReader = saxParser.getXMLReader();
		xmlReader.setContentHandler(handler);
		xmlReader.setErrorHandler(myErrorHandler);
	}
	
	public void parse(String uri) throws SAXException {
		try {
			xmlReader.parse(uri);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public String[] getTagNames() {
		return handler.getTagNames();
	}
}
