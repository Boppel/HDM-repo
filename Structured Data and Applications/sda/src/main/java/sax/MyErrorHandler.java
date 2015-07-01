package sax;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class MyErrorHandler implements ErrorHandler {

	@Override
	public void error(SAXParseException exception) throws SAXException {
		// TODO Auto-generated method stub
		System.err.println("Error: " + getLocationString(exception));
	}


	@Override
	public void fatalError(SAXParseException exception) throws SAXException {
		// TODO Auto-generated method stub
		System.err.println("Fatal Error: " + getLocationString(exception));
	}

	@Override
	public void warning(SAXParseException exception) throws SAXException {
		// TODO Auto-generated method stub
		System.err.println("Warning: " + getLocationString(exception));
	}
	

	private String getLocationString(SAXParseException exception) {
		// TODO Auto-generated method stub
		return "line " + exception.getLineNumber() + ", column " + exception.getColumnNumber() + ": " + exception.getMessage();
	}

}
