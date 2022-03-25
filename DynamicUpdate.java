package com.dynamic.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DynamicUpdate {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	

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
					System.out.println("Enter amount by which you wan to increase salary");
					int increase = scn.nextInt();
					System.out.println("Enter your condition for increase employee salary ");
					int con = scn.nextInt();
					
					

					String sql = String.format("update demoEmployee set esal=esal+%d where esal > %d ",increase,con);
					int updateCount = Stmt.executeUpdate(sql);
					System.out.println("Record updated sucessfully...." + updateCount);

				}catch(Exception exc) {
					exc.printStackTrace();
				}
			}
}
