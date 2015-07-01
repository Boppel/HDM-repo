package de.hdm_stuttgart.mi.sda1.jdom.background;

import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;

import de.hdm_stuttgart.mi.exam.DomFilter;


/**
 * Handling address book data.
 *
 */
public class RowHighlighting implements DomFilter {

   /**
    * Read XML file data and create corresponding HTML output.
    * 
    * @param xmlFilename The XML input file containing address book data.
    * @throws JDOMException Internal error.
    * @throws IOException IO related errors.
    */
   @Override
   public Document process(Document addressbook) {
	   
	   int count = 0;
	   
       // erzeuge das root Element im ouput
	   final Element table = new Element("table");
	   
	   // baue die erste spalte, die immer angezeigt wird
	   final Element tableRow = new Element("tr");
	   final Element tableHead1 = new Element("th");
	   final Element tableHead2 = new Element("th");
	   tableHead1.addContent("Name");
	   tableHead2.addContent("Birthday");
	   tableRow.addContent(tableHead1);
	   tableRow.addContent(tableHead2);
	   
	   table.addContent(tableRow);
	   
	   // besorg dir das Root Element des Dokuments (hier: <addressbook>
	   final Element docRoot = addressbook.getRootElement();
	   
	   // hol dir eine Liste von allen Kinderelementen (hier: <person>)
	   final List<Element> persons = docRoot.getChildren();
	   
	   // für jede person in der Liste persons
	   for(Element person : persons){
		   
		   count++;
		   Element tr = new Element("tr");
		    // erzeuge ein <tr> für jede Person, und highlighte das 1, 3, 5, ...
		   if(count %2 == 1){
			   tr.setAttribute("style", "background-color: #FFFF88;");
		   }
		    
		   	// hol dir eine Liste von allen Kinderelementen (hier: <name>, <birthday> )
		    final List<Element> personChildren = person.getChildren();
		    
		    // für jedes attribut einer Person
		    for (Element attr : personChildren){
		    	
		    	// erstelle ein neues td, fülle es und füge es tr hinzu
		    	Element td = new Element("td");
		    	td.addContent(attr.getText());
		    	tr.addContent(td);
		    }
		    
		    //füge für jede person das element tr der table hinzu
		    table.addContent(tr);
		    
	   }
	  
	   // erstelle ein neues Document mit <table> als root
       return new Document(table);
   }
}