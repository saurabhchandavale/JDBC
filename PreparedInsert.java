package com.prepard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PreparedInsert {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection Conn = null;
		PreparedStatement Stmt = null;
		ResultSet Rs = null;

		try {

			// set connection
			Conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "Saurabh@15");	

			//create statement
			String sql ="insert into demoEmployee values(?,?,?,?)";

			Stmt = Conn.prepareStatement(sql);
			Scanner scn = new Scanner(System.in);

			while(true) {
				System.out.println("Employee Number: ");
				int eno = scn.nextInt();
				System.out.println("Employee Name: ");
				String ename = scn.next();
				System.out.println("Employee Salary: ");
				int esal = scn.nextInt();
				System.out.println("Employee Address: ");
				String eadd = scn.next();
				Stmt.setInt(1, eno);
				Stmt.setString(2, ename);
				Stmt.setInt(3, esal);
				Stmt.setString(4, eadd);
				Stmt.executeUpdate();
				System.out.println("Record inserted successfully...");
				System.out.println("Do you want to insert one more record[yes/no]");
				String option = scn.next();
				if(option.equalsIgnoreCase("No")) {
					break;
				}

			}


		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}
