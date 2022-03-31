package com.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedBatchUpdate {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection Conn = null;
	    PreparedStatement Stmt = null;
		ResultSet Rs = null;

		try {

			// set connection
			Conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "Saurabh@15");	
			Stmt = Conn.prepareStatement("insert into demoEmployee values(?,?,?,?)");
		    Scanner scn = new Scanner(System.in);
		    
		    while(true) {
		    	System.out.println("Enter Employee Number");
		    	int eno = scn.nextInt();
		    	System.out.println("Enter Employee Name");
		    	String ename = scn.next();
		    	System.out.println("Enter Employee Salary");
		    	int esal = scn.nextInt();
		    	System.out.println("Enter Employee Address");
		    	String eadd = scn.next();
		    	Stmt.setInt(1, eno);
		    	Stmt.setString(2,ename);
		    	Stmt.setInt(3, esal);
		    	Stmt.setString(4,eadd);
		    	Stmt.addBatch();
		    	System.out.println("Do you want to insert one more record [yes/no]");
		    	String option = scn.next();
		    	if(option.equalsIgnoreCase("no")) {
		    		break;
		    	}
		    	
		    }
		    Stmt.executeBatch();
		    System.out.println("Records inserted sucessfully");
		    Conn.close();
		    
				
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}
