package com.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class batchUpdate {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection Conn = null;
		Statement Stmt = null;
		ResultSet Rs = null;

		try {

			// set connection
			Conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "Saurabh@15");	
			Stmt = Conn.createStatement();
			Stmt.addBatch("select * from demoEmployee");
//			Stmt.addBatch("insert into demoEmployee values(1009,'Umesh',75000,'Chopadi')");
//			Stmt.addBatch("update demoEmployee set esal = 60000 where eno = 1001");
//			Stmt.addBatch("delete from demoEmployee where eno = 1005");
			int[] count= Stmt.executeBatch();
			int updateCount = 0;
			for(int x : count) {
				updateCount = updateCount + x;
			}
			System.out.println("The number of rows updated :" + updateCount);
			Conn.close();
				
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}
