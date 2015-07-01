package de.hdm_stuttgart.mi.sda1.saxhtml.v2;

import java.io.PrintStream;
import java.util.ArrayList;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import de.hdm_stuttgart.mi.exam.SaxFilter;

/**
 * Turning &lt;memo&gt; documents to HTML
 *
 */
public class Memo2HtmlHandler extends DefaultHandler implements SaxFilter {

   private PrintStream out;
   
   String sender;
   ArrayList<String> recipiants = new ArrayList<String>();
   String subject;
   String content;
   
   TagState currentState;

   @Override
   public void setOutputStream(final PrintStream out) {
      this.out = out;
   }

   /**
    * 
    * Output will be written to standard output unless redefined by {@link #setOutputStream(PrintStream)}
    */
   public Memo2HtmlHandler() {
      setOutputStream(System.out);
   }

   @Override
   public void startDocument() throws SAXException {
      // TODO: complete my implementation!
      out.println("<html>");
   }

   @Override
   public void startElement(String uri, String localName, String tagName,
         Attributes attributes) throws SAXException {
      // TODO: implement me!
	  switch (tagName) {
	  	case "from":
	  		currentState = TagState.inFrom;
		break;
		
		case "to":
			currentState = TagState.inTo;	
		break;
		
		case "subject":
			currentState = TagState.inSubject;
		break;
		
		case "content":
			currentState = TagState.inContent;
		break;

	default:
			currentState = TagState.inMemo;
		break;
	}
   }

   @Override
   public void characters(char[] ch, int start, int length)
         throws SAXException {
      
	   if(currentState == TagState.inFrom) {
		   sender = (new String(ch, start, length));
	   }
	   
	   if(currentState == TagState.inTo) {
		   recipiants.add(new String(ch, start, length));
	   }
	   
	   if(currentState == TagState.inSubject) {
		   subject = (new String(ch, start, length));
	   }
	   
	   if(currentState == TagState.inContent) {
		   content = (new String(ch, start, length));
	   }
   }

   @Override
   public void endElement(String uri, String localName, String tagName)
         throws SAXException {
      // TODO: implement me!
	   currentState = TagState.inMemo;
   }

   @Override
   public void endDocument() throws SAXException {
      // TODO: complete my implementation!
	  out.println("<head><title>Memo from " + sender +"</title></head>");
	  out.println("<body>");
	  out.println("<h2>Subject:"+subject+"</h2>");
	  out.println("<dl>");
	  out.println("<dt>Sender:</dt>");
	  out.println("<dd>" + sender + "</dd>");
	  out.println("<dt>Recipients:</dt>");
	  out.println("<dd>");
	  out.println("<ul>");
	  
	  for (int i = 0; i<recipiants.size(); i++) {
		  out.println("<li>"+recipiants.get(i) + "</li>");
	  }
	  out.println("</ul>");
	  out.println("</dd>");
	  out.println("</dl>");
	  
	  out.println("<h2>Subject" + subject +"</h2>");
	  out.println("<p>" + content + "</p>");
	  out.println("<p>End of Message from <strong>" + sender + "</strong></p>");
	  
	  out.println("</body>"); 
      out.println("</html>");
      
      recipiants.clear();
   }
   
   enum TagState {
	   inFrom, inTo, inSubject, inContent, inMemo;
   }
}