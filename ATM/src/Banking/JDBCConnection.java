package Banking;
import java.sql.*;
public class JDBCConnection {

	private static Connection con=null;
	
	public static Connection connection() {
			try {
				Driver d=new com.mysql.jdbc.Driver();
				DriverManager.registerDriver(d);
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking1","root","Maheshyash@18");
				//st=con.createStatement();
				return con;
				}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
	}
}
