package com.dynamicinput;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SQLWithDynamicQuery {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Connection Conn = null;
		Statement Stmt = null;
		ResultSet Rs = null;

		try {

			// set connection
			Conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "Saurabh@15");	

			//create statement
			Stmt = Conn.createStatement();

			//Here we are writhing input with keyboard(Dynamic Input)
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

				//String sql = "insert into demoEmployee values("+eno+", '"+ename+"', "+esal+", '"+eadd+"')";
				
				//we can use this query like this as well
				String sql = String.format("insert into demoEmployee values (%d,'%s',%d,'%s')",eno,ename,esal,eadd);

				int updateCount = Stmt.executeUpdate(sql);
				System.out.println("Record inserted Sucessfully");
				System.out.println("Do you want to insert one more record (yes/no)");
				String option = scn.next();
				if(option.equalsIgnoreCase("no")) {
					break;

				}
			}
			Conn.close();


		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
