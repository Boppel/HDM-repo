package de.hdm_stuttgart.sda1.saxhtml.v1.test;

import org.junit.Test;

import de.hdm_stuttgart.de.mi.exam.test.sax.DomAssert;
import de.hdm_stuttgart.de.mi.exam.test.sax.SaxFilterTest;
import de.hdm_stuttgart.mi.sda1.saxhtml.v1.Memo2HtmlHandler;

/**
 * Unit testing memo to HTML output
 */
@SuppressWarnings("javadoc")
public class TestSimpleSaxTransform extends SaxFilterTest {
   
   static {
      init("src/main/resources/memo.xml", new Memo2HtmlHandler(), ".1.html");
   }
   
   @Test public void testSenderInHeader() {
      DomAssert.assertSingleNodeContent("'<title>Memo message</title>' must be the only child of <head>", htmlRootElement, "head/*", "title", "Memo message");
   }
   @Test public void testFrom() {
      DomAssert.assertSingleNodeContent("<strong>M. Goik</strong> must appear within first <h2> child of <body>",
            htmlRootElement, "body/h2[1]/strong", "strong", "M. Goik");
   }
   @Test public void testNumberfRecipients() {
      DomAssert.assertNumberOfNodes("Two <li> elements required matching two recipients", htmlRootElement, "body/ul/li", 2);
   }
   @Test public void testSecondRecipient() {
      DomAssert.assertSingleNodeContent("Second recipient must be <li>A. June</li>",
            htmlRootElement, "body/ul/li[2]", "li", "A. June");
   }
   @Test public void testSubject() {
      DomAssert.assertSingleNodeContent("<h2>Subject: Best wishes</h2> must appear as first child of <body>",
            htmlRootElement, "body/*[4]", "h2", "Subject: Best wishes");
   }
   @Test public void testContent() {
      DomAssert.assertSingleNodeContent("Last child of <body> must be content",
            htmlRootElement, "body/*[5]", "p", "Hi all, congratulations to your splendid party");
   }
}