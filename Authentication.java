package com.prepard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Authentication {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection Conn = null;
		PreparedStatement Stmt = null;
		ResultSet Rs = null;

		try {

			// set connection
			Conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "Saurabh@15");	

			//create statement

			Scanner scn = new Scanner(System.in);
			System.out.println("Enter Username");
			String uname = scn.next();
			System.out.println("Enter Password");
			String upass = scn.next();
			String sql ="select count(*) from usersd where uname=? and upass=?";
			Stmt = Conn.prepareStatement(sql);
			Stmt.setString(1, uname);
			Stmt.setString(2, upass);


			Rs = Stmt.executeQuery();
			int c = 0;
			if(Rs.next()) {
				c=Rs.getInt(1);
			}
			if(c==0) {
				System.out.println("Invalid Credentails");

			}else {
				System.out.println("Valid Credentails");

			}


		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}
