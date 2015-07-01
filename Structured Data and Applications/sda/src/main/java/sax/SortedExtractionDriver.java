package sax;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class SortedExtractionDriver {

	public static void main(String[] args) throws ParserConfigurationException, SAXException {
		// create instance of SortedExtraction()
		SortedExtraction extractor = new SortedExtraction();
		
		extractor.parse("input/memo.xml");
		System.out.println("this file contains the following elements: ");
		for (String elementName : extractor.getTagNames()) {
			System.out.println(elementName + " ");
		}

	}

}
