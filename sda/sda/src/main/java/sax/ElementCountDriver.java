package sax;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class ElementCountDriver {

	public static void main(String[] args) throws SAXException, ParserConfigurationException {
		// make instance of elementCounter
		ElementCount elementCounter = new ElementCount();
		
		// set fileURI to parse
		elementCounter.parse("input/catalog.xml");
		System.out.println("Document contains " + elementCounter.getElementCount() + " Elements.");
	
	}

}
