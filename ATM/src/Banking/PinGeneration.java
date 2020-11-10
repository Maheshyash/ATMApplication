package Banking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class PinGeneration extends Home{
public static void pin() {
	Scanner sc=new Scanner(System.in);
	int account_Number=Home.acc;
	String phone_Number=Home.phone_Number;

	try (Connection con= JDBCConnection.connection();) {
		  Statement st = con.createStatement();
	if(phone_Number!=null)
	{
		String result=SendOtp.sendSms1(phone_Number);
		System.out.println(result);
		int otp_Number=Integer.parseInt(SendOtp.otp);
		System.out.println(otp_Number);
		int ent_OTP=sc.nextInt();
		if(otp_Number==ent_OTP)
		{
			System.out.println("Enter your Pin to Update");
			int pin=sc.nextInt();
			st.executeUpdate("Update customerdetails set pin="+pin+" where account_Number="+account_Number);
		}
	}
}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}
