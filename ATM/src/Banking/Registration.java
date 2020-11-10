package Banking;
import java.util.*;
import java.sql.*;
public class Registration  {
	static int acc=Home.acc;
	static String phone_Number=Home.phone_Number;
	static String aadhar=Home.aadhar;
	static Scanner sc=new Scanner(System.in);
	public static void choose() {
		System.out.println("PRESS 1 TO AADHAR REGISTRATION");
		System.out.println("PRESS 2 TO MOBLIE NUMBER REGISTRATION");
		int n=sc.nextInt();
		switch(n) {
		case 1:
			System.out.println("WELCOME TO AADHAR REGISTRATION");
			aadharRegistration();
		break;
		case 2:
			System.out.println("WELOCME TO MOBILE NUMBER REGISTRATION");
			mobileNumRegistration();
		break;
		default:
			System.out.println("INVALID CREDENTIALS PLEASE TRY AGAIN");
			
		}
	}
	
	public static void aadharRegistration() {
		if(phone_Number!=null && aadhar==null)
		{
			String result = SendOtp.sendSms1(phone_Number);
			System.out.println(result);
			int otp_Number=Integer.parseInt(SendOtp.otp);
			System.out.println(otp_Number);
			System.out.println("ENTER YOUR 5 DIGIT OTP NUMBER");
			int ent_OTP=sc.nextInt();
			if(otp_Number==ent_OTP)
			{
				System.out.println("ENTER YOUR AADHAR NUMBER TO UPDATE");
				Long aadhar=sc.nextLong();
				try (Connection con= JDBCConnection.connection();) {
					  Statement st = con.createStatement();
				st.executeUpdate("Update customerdetails set aadhar_number="+aadhar+" where account_number="+acc);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			else {
				System.out.println("YOU ENTERED OTP IS WRONG PLEASE TRY AGAIN");
				System.exit(0);
			}	
		}
		else {
			System.out.println("YOUR NOT YET REGISTER YOUR PHONE NUMBER OR YOU ALREADY ENROLLED YOUR AADHAR WITH YOUR ACCOUNT ");
			System.exit(0);
		}
	}
	public static void mobileNumRegistration() {
		if(phone_Number!=null)
		{
			System.out.println("ENTER YOUR PHONE NUMBER LINK WITH ACCOUNT NUMBER");
			String number=sc.next();
			if(phone_Number.equals(number))
			{
				String result = SendOtp.sendSms1(phone_Number);
				System.out.println(result);
				int otp_Number=Integer.parseInt(SendOtp.otp);
				System.out.println("ENTER YOUR 5 DIGIT OTP NUMBER");
				int ent_OTP=sc.nextInt();
				if(otp_Number==ent_OTP) {
					System.out.println("ENTER YOUR PHONE NUMBER TO UPDATE");
					Long update_Num=sc.nextLong();
					try(Connection con= JDBCConnection.connection();) {
						  Statement st = con.createStatement();
					st.executeUpdate("Update customerdetails set phone_number="+update_Num+" where account_number="+acc);
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			else {
				System.out.println("ENTERED PHONE NUMBER IS WRONG CHECK IT ONCE");
				System.exit(0);
			}
		}
		 
	}
}
