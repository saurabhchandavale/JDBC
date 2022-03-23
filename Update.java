package com.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
	public static void main(String[] args) throws SQLException {
		Connection Conn = null;
		Statement Stmt = null;
		ResultSet Rs = null;

		try {

			// set connection
			Conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "Saurabh@15");	
			
			//create statement
			Stmt = Conn.createStatement();
			System .out.println("Executing update for TicketId 13\n ");
			
			int rowsAffected = Stmt.executeUpdate(
					"Update help " + "set Issue = 'As a user...'" + "where TicketId = '13'");
			 System.out.println("Updated Sucessfully");
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
