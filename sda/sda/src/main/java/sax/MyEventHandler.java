package sax;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class MyEventHandler extends DefaultHandler {
	
	private int elementCount = 0;

	public void startDocument() {
		System.out.println("Opening Document");
	}
	
	public void endDocument() {
		System.out.println("Closing Document");
	}
	
	public void startElement(String namespaceUri, String localName, String rawName, Attributes attrs) {
		System.out.println("Opening \"" + rawName + "\"");
		/* read the value of an attribute within an xml element
		 * For Example:
		 * <catalog>
    	 *   	<item orderNo="3218">Swinging headset</item>
    	 *   	<item orderNo="9921">200W Stereo Amplifier</item>
		 * </catalog>
		 * 
		 * --> read orderNo 
		 */
		for(int i = 0; i < attrs.getLength(); i++) {
			System.out.println("Element has attribute " + attrs.getQName(i) + " = " + attrs.getValue(i) + "\n");
		}
		elementCount++;
	}
	
	public void endElement(String namespaceUri, String localName, String rawName) {
		System.out.println("Closing Document");
	}
	
	public void characters(char[] ch, int start, int length) {
		System.out.println("Conent \"" + new String(ch, start, length) + '"');
	}
	
	public int getElementCount() {
		return elementCount;
	}
}
