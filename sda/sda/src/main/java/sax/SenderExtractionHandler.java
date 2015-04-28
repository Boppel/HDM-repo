package sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SenderExtractionHandler extends DefaultHandler {
	
	boolean inFrom = false;
	boolean inSubject = false;

	public void startDocument() {
		System.out.println("Extracting Sender and Subject....");
	}
	
	public void startElement(String namespaceUri, String localName, String rawName, Attributes attrs) {
		switch(rawName) {
		case "from":
		      inFrom = true;
		      System.out.print("Sender: ");
		      break;
		    case "subject": 
		      inSubject = true;
		      System.out.print("Subject: ");
		      break;
		    case "surname":
		      if (inFrom) {
		        System.out.print(" "); // Adding additional space between <name> and <surname>  content.
		      }
		      break;
		}
	}
	
	@Override
	public void endElement(String namespaceUri, String localName, String rawName) {
		switch(rawName) {
	    case "from": 
	      inFrom = false;
	      System.out.println();
	      break;
	    case "subject": 
	      inSubject = false;
	      System.out.println();
	      break;
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (inFrom || inSubject) {
	      System.out.print(new String(ch, start, length));
	    }
	}
	
}
