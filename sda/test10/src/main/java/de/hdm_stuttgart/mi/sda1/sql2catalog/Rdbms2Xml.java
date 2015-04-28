package de.hdm_stuttgart.mi.sda1.sql2catalog;

import java.io.IOException;
import java.security.AccessControlContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * A simple SAX parser demo
 * 
 */
public class Rdbms2Xml {

   /**
    * @param args Unused
 * @throws SQLException 
    */
   public static void main(String[] args) throws SQLException {
      
      // Register Driver
      final String sqlDriverClassName = "com.mysql.jdbc.Driver"; 
      try {
         Class.forName(sqlDriverClassName);
      } catch (ClassNotFoundException e) {
         Helper.exitWithErrorMessage("Unable to register driver class '" + sqlDriverClassName + "'", 1);
      }

      // Opening a JDBC connection
      // 
      Connection conn = null;
      
      final String jdbcConnectionUrl = "jdbc:mysql://localhost:3306/hdm"; 
      final String userName = "hdmuser"; 
      try {
         conn = DriverManager.getConnection(jdbcConnectionUrl, userName, "XYZ"); 
      } catch (SQLException e) {
         Helper.exitWithErrorMessage("Unable to connect as user '" + userName + "' to '" + 
               jdbcConnectionUrl + "'", 1); 
      }  
      
      // Access aufbauen und Daten holen (da im konstruktur)
      RdbmsAccess access = new RdbmsAccess(conn);
      

      // Jdom shizzle: root vom doc ist university
      final Element universityElement = new Element("university");
      final Element studyCoursesElement = new Element("studyCourses");
      
      // baue jetzt eine ArrayList für Student, und eine für einen Kurs
      ArrayList<String> student = new ArrayList<String>();
      ArrayList<String> course  = new ArrayList<String>();
      
      final Element studentsElement = new Element("students");
      
      // extrahiere einen student aus access, und baue füge diesen richtig in jdom hinzu
      while((student = access.getStudent()).size() > 0){
    	  
    	  // jdom element für <student>. da root, kommen hier die attribute rein
    	  Element studentElement = new Element("student");
    	  studentElement.setAttribute("id", student.get(0));	//0 weil id an pos[0]
    	  studentElement.setAttribute("studyCourse", student.get(3));
    	 
    	  // jdom element für <fullName>
    	  Element fullNameElement = new Element("fullName");
    	  fullNameElement.addContent(student.get(1));
    	  studentElement.addContent(fullNameElement);
    	  
    	  // jdom element für <email>
    	  Element emailElement = new Element("email");
    	  emailElement.addContent(student.get(2));
    	  studentElement.addContent(emailElement);
    	  
    	  // füge jetzt den einzelnen Studenten zum element "Students" hinzu
    	  studentsElement.addContent(studentElement);
      }
      
      // extrahiere einen kurs aus access, und baue diesen richtig in jdom hinzu
      while((course = access.getStudent()).size() > 0){
    	  
    	  // jdom element für <studyCourse>. Da root, kommen hier elemente rein
    	  Element studyCourseElement = new Element("studyCourse");
    	  studyCourseElement.setAttribute("id", course.get(0));
    	  studyCourseElement.setAttribute("program", course.get(3));
    	  
    	  // jdom element für <name>
    	  Element nameElement = new Element("name");
    	  nameElement.addContent(course.get(1));
    	  studyCourseElement.addContent(nameElement);
    	  
    	  // jdom element für <shortName>
    	  Element shortNameElement = new Element("shortName");
    	  shortNameElement.addContent(course.get(2));
    	  studyCourseElement.addContent(shortNameElement);
    	  
    	  // füge jetzt den einzelnen kurs zum element "courses" hinzu
    	  studyCoursesElement.addContent(studyCourseElement);
      }
      
      
      
      universityElement.addContent(studyCoursesElement);
      universityElement.addContent(studentsElement);
      
      // Write XML content to standard output
      XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
      try {
         outputter.output(universityElement, System.out);
      } catch (IOException e) {
         Helper.exitWithErrorMessage("Unable to write XML data:" + e.getLocalizedMessage(), 1);
      }
   }
}
