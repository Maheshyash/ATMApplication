package Banking;
import java.sql.*;
import java.util.*;
public class Home {
	static int acc;
	static int pin;
	static String phone_Number;
	static String aadhar;
	static int balance;
	static HashSet<Long> hs=new HashSet<Long>();
	public static void main(String[] args) throws SQLException {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to BANKING");
		System.out.println("Enter the Account Number");
		int accountNumber=sc.nextInt();
		try(Connection con= JDBCConnection.connection();) {
			  Statement st = con.createStatement();
		String sql="select *from customerdetails where account_number= "+accountNumber;
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()==true)
		{
			acc=rs.getInt(2);
			pin=rs.getInt(3);
			phone_Number=rs.getString(4);
			balance=rs.getInt(5);
			aadhar=rs.getString(6);
			
		}
		rs=st.executeQuery("select * from customerdetails");
		while(rs.next()==true)
		{
			hs.add(rs.getLong(2));	
		}
	}
	catch(Exception e) {
		e.printStackTrace();
		System.exit(0);
	}
		//checking entered account number correct or not
		if(accountNumber!=acc)
		{
			System.out.println("You Enter Account Number is Wrong plz try again");
 			System.exit(0);
		}
		//Selecting the option 
		//Choose
		Selections.Choose();
	Selections.selection();

	}
}
