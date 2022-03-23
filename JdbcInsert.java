import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcInsert {
	public static void main(String[] args) throws SQLException {
		Connection Conn = null;
		Statement Stmt = null;
		ResultSet Rs = null;
		
		try {
			//Get the connection to database
			Conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "Saurabh@15");
			System.out.println("Database connection successful!\n");
			
			//create statement 
			Stmt = Conn.createStatement();
			
			//insert a new empoyee
			System.out.println("Inserting a new employee to database");
			
			int rowsAffected =Stmt.executeUpdate("insert into help " + "(Issue, description) " + "values" + "('login user dadus', 'I am new user')");
			
			//verify this by getting list of employees
			Rs = Stmt.executeQuery("select * from help");
			
			//process the result set
			while(Rs.next()) {
				
				System.out.println(Rs.getString("TicketId") + ", "+ Rs.getString("Issue") + ", " + Rs.getString("description"));
				rowsAffected++;
			}
			System.out.println(rowsAffected);
		}catch(Exception exc) {
			exc.printStackTrace();
		}finally{
			if(Rs!=null) {
				Rs.close();
			}
		}
		
	}

}
