package de.hdm_stuttgart.sda1.saxhtml.v2.test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import de.hdm_stuttgart.de.mi.exam.test.sax.DomAssert;
import de.hdm_stuttgart.de.mi.exam.test.sax.SaxFilterTest;
import de.hdm_stuttgart.mi.sda1.saxhtml.v2.Memo2HtmlHandler;

/**
 * Turning &lt;memo&gt; documents to HTML as being shown in sample document memo.xml.2.sample.html 

 */
@SuppressWarnings("javadoc")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestComplexSaxTransform extends SaxFilterTest {
   
   static {
      init("src/main/resources/memo.xml", new Memo2HtmlHandler(), ".2.html");
   }

	@Test public void testSenderInHeader() {
		DomAssert.assertSingleNodeContent("<title>Memo from M. Goik</title> must be child of <head>", htmlRootElement, "head/title", "title", "Memo from M. Goik");
	}
	@Test public void testNumberfRecipients() {
		DomAssert.assertNumberOfNodes("There should be two <li> elements matching two recipients", htmlRootElement, "body/dl/dd/ul/li", 2);
	}
	@Test public void testH1MemoSubjectMessage() {
		DomAssert.assertSingleNodeContent("<h2>Subject:Best wishes</h2> must appear as first child of <body>",
				htmlRootElement, "body/*[1]", "h2", "Subject:Best wishes");
	}
	@Test public void testSenderBeforeRecipientList() {
		DomAssert.assertSingleNodeContent("<dd>M. Goik</dd> must appear as second child  of the list of recipients",
				htmlRootElement, "body/dl/*[2]", "dd", "M. Goik");
	}
	@Test public void testMemoContent() {
		DomAssert.assertSingleNodeContent("content must appear as second <p> child after recipient list in <body>",
				htmlRootElement, "body/dl/following-sibling::*[2]", "p", "Hi all, congratulations to your splendid party");
	}
	@Test public void testLastParagraph() {
		DomAssert.assertNumberOfNodes("Expecting two <p> children of <body>",
				htmlRootElement, "body/*[name(.)='p']", 2);
	}
	@Test public void testSenderAtFoot() {
		DomAssert.assertSingleNodeContent("<strong>M. Goik</strong> must appear inside a <p> immediately following the list of recipients",
				htmlRootElement, "body/dl/following-sibling::*[1]", "h2", "Subject: Best wishes");
	}
   @Test public void testXduplicateHandlerInvocation() {
      SaxFilterTest.processAndParseResult();// Execute handler a second time.
      Assert.assertNull(SaxFilterTest.initializationErrorString, SaxFilterTest.initializationErrorString);
      DomAssert.assertNumberOfNodes("Invoking SAX handler two times in succession: There should be two <li> elements matching two recipients", htmlRootElement, "body/dl/dd/ul/li", 2);
   }
}