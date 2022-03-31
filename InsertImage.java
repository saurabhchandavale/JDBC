package com.blob;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InsertImage {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection Conn = null;
		PreparedStatement Stmt = null;
		ResultSet Rs = null;

		try {

			// set connection
			Conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "Saurabh@15");	

			File f = new File("Anushka3.jpg");
			FileInputStream fis = new FileInputStream(f);
			
			String sql = "insert into persons values(?,?)";
			Stmt = Conn.prepareStatement(sql);
			Stmt.setString(1, "Anushka Sharma");
			Stmt.setBinaryStream(2, fis);
			
			System.out.println("Inserting record : " + f.getAbsolutePath());
			int updateCount = Stmt.executeUpdate();
			if(updateCount == 0) {
				System.out.println("Record Not Inserted");
			}else {
				System.out.println("Record  Inserted");
			}
			

		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}
