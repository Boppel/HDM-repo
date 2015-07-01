package de.hdm_stuttgart.mi.sda1.saxhtml.v1;

import java.io.PrintStream;

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
      out.println("<head>");
      out.print("<title>Memo message</title>");
      out.print("</head>");
      out.println("<body>");
	}

	@Override
	public void startElement(String uri, String localName, String tagName,
			Attributes attributes) throws SAXException {
      // TODO: implement me!
		switch (tagName) {
		case "from":
			out.print("<h2>Message from <strong>");
			break;
		case "to":
			out.print("<li>");
			break;
		case "subject":
			out.println("</ul>");
			out.println("<!-- -->");
			out.println("<h2>Subject:");
			break;
		case "content":
			out.print("<p>");
			break;

		default:
			break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		out.print(new String(ch, start, length));
	}

	@Override
	public void endElement(String uri, String localName, String tagName)
			throws SAXException {
      // TODO: implement me!
		switch (tagName) {
		case "from":
			out.println("</strong></h2>");
			out.println("<h2>Recipients:</h2>");
			out.print("<ul>");
			break;
		case "to":
			out.println("</li>");
			break;
		case "subject":
			out.print("</h2>");
			break;
		case "content":
			out.println("</p>");
			break;
		default:
			break;
		}
	}

	@Override
	public void endDocument() throws SAXException {
      // TODO: complete my implementation!
		out.println("</body>");
		out.println("</html>");
	}
}