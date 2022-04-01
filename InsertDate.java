package com.date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InsertDate {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection Conn = null;
	    PreparedStatement Stmt = null;
		ResultSet Rs = null;

		try {

			// set connection
			Conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "Saurabh@15");	
		    Scanner scn = new Scanner(System.in);
		    System.out.println("Enter Persons Name ");
		    String name = scn.next();
		    System.out.println("Enter DOB(yyyy-MM-dd): ");
		    String DOB = scn.next();
		    
		    java.sql.Date sdate = java.sql.Date.valueOf(DOB);
		    
//		    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//		    java.util.Date udate = sdf.parse(DOB);
//		    long l = udate.getTime();
//		    java.sql.Date sdate = new java.sql.Date(l);
		    String sql = "insert into Date values(?,?)";
		    Stmt = Conn.prepareStatement(sql);
		    Stmt.setString(1,name);
		    Stmt.setDate(2, sdate);
		    int rc = Stmt.executeUpdate();
		    if(rc == 0) {
		    	System.out.println("Record not inserted");
		    }else {
		    	System.out.println("Record  inserted");

		    }
		    
		  
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}
