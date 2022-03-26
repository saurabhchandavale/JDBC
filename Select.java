package com.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Select {
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
		

			
			String sql = String.format("select * from demoEmployee order by esal desc");
			Rs = Stmt.executeQuery(sql);
			boolean flag = false;
			System.out.println("ENO\tENAME\tESAL\tEADD");
			System.out.println("-----------------------------------");
			while(Rs.next()) {
				flag = true;
				System.out.println(Rs.getInt(1)+"\t"+Rs.getString(2)+"\t"+Rs.getInt(3)+"\t"+Rs.getString(4));
			}
			if(flag == false) {
				System.out.println("No records found");
			}

		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}
