package de.hdm_stuttgart.mi.sda1.sql2catalog;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Reading study course and student data
 *
 */
public class RdbmsAccess {
	
	/**
	 * @param conn Destination RDBMS
	 */
	
	Statement studentStatement;
	Statement courseStatement;
	
	ResultSet studentsList;
	ResultSet courseList;
	
	public RdbmsAccess(final Connection conn) throws SQLException {
		
		//
		studentStatement = conn.createStatement();
		studentsList = studentStatement.executeQuery("SELECT * FROM Student");
		
		//
		courseStatement = conn.createStatement();
		courseList = studentStatement.executeQuery("SELECT * FROM StudyCourse");
		
		// jetzt liegt in studentsList / courseList die Daten der DB drin.
	}
	
	// wir müssen jetzt aus dem Resultset studentsList eine einzelne Zeile (1 Student) zurückgeben
	public ArrayList<String> getStudent () throws SQLException {
		
		ArrayList<String> result = new ArrayList<String>();
		
		// if, da nur eine Zeile zurückgegeben wird. soll alles rauskommen -> while
		if(studentsList.next()){
			// setze die anzahl der Spalten der Tabelle (siehe .sql) mit indizies in das result
			result.add(studentsList.getInt(0) + "");
			result.add(studentsList.getString(1));
			result.add(studentsList.getString(2));
			result.add(studentsList.getInt(3) + "");
			
			return result;
		}
		return result;
	}
	
	public ArrayList<String> getCourse () throws SQLException {
		
		ArrayList<String> result = new ArrayList<String>();
		
		// if, da nur eine Zeile zurückgegeben wird. soll alles rauskommen -> while
		if(courseList.next()){
			// setze die anzahl der Spalten der Tabelle (siehe .sql) mit indizies in das result
			result.add(courseList.getInt(0) + "");
			result.add(courseList.getString(1));
			result.add(courseList.getString(2));
			result.add(courseList.getString(3));
			
			return result;
		}
		return result;
	}

}
