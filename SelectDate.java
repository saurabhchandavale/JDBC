package com.date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class SelectDate {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection Conn = null;
	    PreparedStatement Stmt = null;
		ResultSet Rs = null;

		try {

			// set connection
			Conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "Saurabh@15");	
		   

		    String sql = "select * from Date";
		    Stmt = Conn.prepareStatement(sql);
		    Rs =Stmt.executeQuery();
		    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy"); 
		    while(Rs.next()) {
		    	String name = Rs.getString(1);
		    	java.sql.Date sdate = Rs.getDate(2);
		    	String s = sdf.format(sdate);
		    	System.out.println(name + " " + s);
		    }
		 
		   		  
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}
