import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {
	
	public static void main(String[] args) throws SQLException {
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRes = null;
		
		try {
			//Get the connection to database
			myConn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "Saurabh@15");
			System.out.println("Database connection successful!\n");
			
			//create statement 
			myStmt = myConn.createStatement();
			
			//execute sql query
			myRes = myStmt.executeQuery("select * from food");
			
			//process the result set
			while(myRes.next()) {
				System.out.println(myRes.getString("firstname") + ", " + myRes.getString("lastname"));
			}
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}

}
