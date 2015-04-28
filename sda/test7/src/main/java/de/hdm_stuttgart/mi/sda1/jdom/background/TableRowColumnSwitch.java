package de.hdm_stuttgart.mi.sda1.jdom.background;

import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;

import de.hdm_stuttgart.mi.exam.DomFilter;

/**
 * Address book data.
 *
 */
public class TableRowColumnSwitch implements DomFilter {
  /**
   * Reading XML input an create corresponding HTML output
   * @param xmlFilename XML file input data
   * @throws JDOMException Internal errors
   * @throws IOException IO related errors.
   */
   @Override
   public Document process(Document addressbook) {
	   
	   final Element table = new Element("table");
	   
	   final Element docRoot = addressbook.getRootElement();
	   
	   //alle kinder holen - hier: <person>
	   List<Element> persons = docRoot.getChildren();
	   
	   
	   
	   final Element personTR = new Element("tr");
	   //erste <th> der ersten tr
	   final Element th1 = new Element("th");
	   th1.addContent("Name");
	   personTR.addContent(th1);
	   
	   table.addContent(personTR);
	   
	   
	   // neue tr erstellen
	   final Element birthTR = new Element("tr");
	   final Element th2 = new Element("th");
	   th2.addContent("Birthday");
	   birthTR.addContent(th2);
	   
	   table.addContent(birthTR);
	   
	   for(Element person : persons) {
		   
		   final Element td = new Element("td");
		   td.setText(person.getChildText("name"));
		   personTR.addContent(td);
		   
		   final Element td2 = new Element("td");
		   td2.setText(person.getChildText("birthday"));
		   birthTR.addContent(td2);
	   }
	   

	   
	   
	   return new  Document(table);
   }
}