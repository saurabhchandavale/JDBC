package com.selectandnonselectquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectNonselect {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection Conn = null;
		Statement Stmt = null;
		ResultSet Rs = null;

		try {

			// set connection
			Conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "Saurabh@15");	

			//create statement
			Stmt = Conn.createStatement();
			Scanner scn = new Scanner(System.in);
			System.out.println("Enter the query");
			String sql = scn.nextLine();
			boolean b = Stmt.execute(sql);
			//select query
			if(b ==  true) {
				Rs = Stmt.getResultSet();
				while(Rs.next()) {
					System.out.println(Rs.getInt(1)+"\t"+Rs.getString(2)+"\t"+Rs.getInt(3)+"\t"+Rs.getString(4));		

				}
			}
			else {
				//non - select query
				int rowCount = Stmt.getUpdateCount();
				System.out.println("The number of records effected is : " +rowCount);
			}
			Conn.close();

		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}
