package com.dlete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Delete {

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
			System .out.println("Delete ticket number 18\n ");
			
			int rowsAffected = Stmt.executeUpdate(
					"delete from help " +  "where TicketId = '18'");
			 System.out.println("Deleted Sucessfully");
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
