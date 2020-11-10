package Banking;
import java.util.*;
import java.sql.*;
public class BankingMethods {
	static Scanner sc=new Scanner(System.in);
	static int balance=Home.balance;
	Home h=new Home();
public static int debit(int amount) {
	
	int updated_balance=balance-amount;
	return updated_balance;
}
public static int updateBalance(int upBalance,int acc) {
	int updated_Balance=0;
	
	try(Connection con= JDBCConnection.connection();) {
	  Statement st = con.createStatement();
	st.executeUpdate("Update customerdetails set amount="+upBalance+" where account_number="+acc);
		
	  ResultSet rs = st.executeQuery("select * from customerdetails where account_number="+acc);
		while(rs.next()==true)
		{
			//System.out.println("After Updated your account Balance is :"+rs.getInt(5));
			updated_Balance=rs.getInt(5);
		}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return updated_Balance;
}
public static void deposit(int depo_Amt,int acc) {
	
	int ava_Bal=balance;
	try(Connection con= JDBCConnection.connection();) {
		  Statement st = con.createStatement();
		int upd_Bal=ava_Bal+depo_Amt;
		st.executeUpdate("Update customerdetails set amount="+upd_Bal+" where account_number="+acc);
		System.out.println("YOUR ACCOUNT BALANCE  UPDATED");
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public static void transfer(int acc_Own) {
	//System.out.println("your bal is"+balance);
	System.out.println("Transfer amount per transaction limit is 25000");
	int MAX_AMT=25000;
	System.out.println("Enter the account number you want to tranfer the money");
	int acc_Num=sc.nextInt();
	Long account=new Long(acc_Num);
	if(Home.hs.contains(account)&& acc_Own!=acc_Num ) {
	System.out.println("Enter the amount you want to transfer from your account");
	int amt=sc.nextInt();
	if(amt<=MAX_AMT && amt<balance) {
	int update_Bal = debit(amt);
	int upbal = updateBalance(update_Bal, acc_Own);
	deposit(amt,acc_Num);
	}
	else {
		System.out.println("Your Account Balance is insufficient \n Check your Account Balance then enter correct amount you want to transfer");
		System.exit(0);
	}
}
	else {
		System.out.println("YOUR ENTERED ACCOUNT NUMBER IS WRONG OR SAME CHECK IT ONCE AND TRY AGAIN");
	}
}
}
