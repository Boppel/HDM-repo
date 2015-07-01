package sax;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class SenderExtractionDriver {

	public static void main(String[] args) throws ParserConfigurationException, SAXException {
		// TODO Auto-generated method stub
		SenderExtraction extractor = new SenderExtraction();
		extractor.parse("input/memo.xml");
	}

}
