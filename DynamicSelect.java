package com.dynamicdelete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DynamicSelect {
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
//			System.out.println("Enter addreass of employee who you want to select");
//			String eadd = scn.next();
			System.out.println("Enter starting salry");
			int startSal = scn.nextInt();
			System.out.println("Enter end salry");
			int endSal = scn.nextInt();
			
		
			String sql = String.format("select * from demoEmployee where esal between %d and %d order by esal",startSal,endSal);
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
