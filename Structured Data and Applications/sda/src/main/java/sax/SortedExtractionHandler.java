package sax;

import java.util.SortedSet;
import java.util.TreeSet;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SortedExtractionHandler extends DefaultHandler{
	
	private SortedSet<String> extractedItems = new TreeSet<String>();

	@Override
	public void startDocument() {
		// clear just in case
		extractedItems.clear();
	}
	
	@Override
	public void startElement(String namespaceUri, String localName, String rawName, Attributes attrs) {
		// add the item to the SortedSet
		extractedItems.add(rawName);
	}
	
	public String[] getTagNames() {
		return extractedItems.toArray(new String[0]);
	}
}
