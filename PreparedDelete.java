package com.prepard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PreparedDelete {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection Conn = null;
		PreparedStatement Stmt = null;
		ResultSet Rs = null;

		try {

			// set connection
			Conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "Saurabh@15");	

			//create statement
			String sql ="delete from demoEmployee where eno =?";

			Stmt = Conn.prepareStatement(sql);

		
				Stmt.setInt(1, 1010);
				
				int updateCount = Stmt.executeUpdate();
				System.out.println("The number of rows deleted : " + updateCount);
				

		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}
