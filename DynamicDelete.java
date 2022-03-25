package dynamicdelete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DynamicDelete {
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
			while(true) {
			System.out.println("Selete employee number who you want to delete");
			int num = scn.nextInt();
			
			String sql = String.format("delete from demoEmployee where eno = %d",num);
			int updateCount = Stmt.executeUpdate(sql);
			System.out.println("Data deleted successfully...." + updateCount);
			System.out.println("Do you want to delete one more record (yes/no)");
			String option = scn.next();
			if(option.equalsIgnoreCase("no")) {
				break;

			}
			}

		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
