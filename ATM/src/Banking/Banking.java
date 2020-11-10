package Banking;
import java.util.*;
import java.sql.*;
public class Banking  extends Home{
   static Scanner sc=new Scanner(System.in);
   static long balance=Home.balance;
   static int acc=Home.acc;
	public static void choose() {

		System.out.println("Wellcome to BANKING OPTION");
		System.out.println("Press 1 for FAST CASH");
		System.out.println("Press 2 for WITHDRAWAL");
		System.out.println("Press 3 for BALANCE ENQUIRY");
		System.out.println("Press 4 for DEPOSIT");
		System.out.println("Press 5 for TRANSFER");
		System.out.println("Press 6 for PIN CHANGE");
			int j=sc.nextInt();
		//Switch case of banking application
			switch(j)
			{
			case 1:
				if(pin!=0) {
					System.out.println("Enter your Pin Number");
				int PIN=sc.nextInt();
				if(pin==PIN) {
					fastCash();
					System.out.println("Plz collect Your cash before you leaving");
				}
				else {
					System.out.println("Entered pin number is wrong Plz try again");
					System.exit(0);
				}
				}
				else {
					System.out.println("Your Not generate Your Pin \n Please generate your pin");
					System.exit(0);
				}
				break;
			case 2:
				if(pin!=0) {
				System.out.println("Enter your Pin Number");
			int PIN=sc.nextInt();
			if(pin==PIN) {
				withdrawal();
				System.out.println("Plz collect Your cash before you leaving");
			}
			else {
				System.out.println("Entered pin number is wrong Plz try again");
				System.exit(0);
			}
			}
			else {
				System.out.println("Your Not generate Your Pin \n Please generate your pin");
				System.exit(0);
			}
				break;
			case 3:
				if(pin!=0) {
				System.out.println("Enter your Pin Number");
			int PIN=sc.nextInt();
			if(pin==PIN) {
				System.out.println("Your Balance is:"+balance);
			} else {
				System.out.println("Entered pin number is wrong Plz try again");
				System.exit(0);
			}
			}
			else {
				System.out.println("Your Not generate Your Pin \n Please generate your pin");
				System.exit(0);
			}
				break;
			case 4:
				if(pin!=0) {
					System.out.println("Enter your Pin Number");
				int PIN=sc.nextInt();
				if(pin==PIN)
					deposit();
				else {
					System.out.println("Entered pin number is wrong Plz try again");
					System.exit(0);
				}
				}
				else {
					System.out.println("Your Not yet generate Your Pin \n Please generate your pin");
					System.exit(0);
				}
				
				break;
			case 5:
				if(pin!=0) {
					System.out.println("Enter your Pin Number");
				int PIN=sc.nextInt();
				if(pin==PIN) 
					BankingMethods.transfer(acc);
				else {
					System.out.println("Entered pin number is wrong Plz try again");
					System.exit(0);
				}
				}
				else {
					System.out.println("Your Not generate Your Pin \n Please generate your pin");
					System.exit(0);
				}
				break;
			case 6:
				if(pin!=0) {
					System.out.println("Enter your Pin Number");
				int PIN=sc.nextInt();
				if(pin==PIN) 
					pinChange();
				else {
					System.out.println("Entered pin number is wrong Plz try again");
					System.exit(0);
				}
				}
				else {
					System.out.println("Your Not generate Your Pin \n Please generate your pin");
					System.exit(0);
				}
				break;
				default:
					System.exit(0);
			}
		}
	public static void fastCash() {
		int acc=Home.acc;
		System.out.println("\t\tSelect the amount among the Shown Below ");
		System.out.print("100");
		System.out.println("\t\t\t2000");
		System.out.print("200");
		System.out.println("\t\t\t3000");
		System.out.print("500");
		System.out.println("\t\t\t5000");
		System.out.print("1000");
		System.out.println("\t\t\t10000");
		System.out.println("Enter the Amount you want to Draw as Shown in Above List");
		int amount=sc.nextInt();
		if(amount==100 ||amount==200||amount==500||amount==1000 ||amount==2000||amount==3000||amount==5000||amount==10000)
		{
			if(amount<balance)
			{
				System.out.println("Your Transaction being processed");
				int updated_Bal = BankingMethods.debit(amount);
				BankingMethods.updateBalance(updated_Bal,acc);
			}
			else {
				System.out.println("Insufficient Balance plz check your Balance and try again");
				System.exit(0);
			}
		}
	}
	public static void withdrawal() {
		System.out.println("Please Enter the Amount");
		int amount=sc.nextInt();
		System.out.println("Press yes to Continue");
		System.out.println("Press no to ReEnter the amount");
		String str=sc.next();
		if(str.equals("yes")!=true)
		{
			System.out.println("Please Enter the Amount");
			amount=sc.nextInt();
		}
		if(balance>amount)
		{
			System.out.println("Your transaction being processed");
			System.out.println("please collect your "+amount+" cash");
		}
		int updatebalance = BankingMethods.debit(amount);
		BankingMethods.updateBalance(updatebalance,Home.acc);
		
	}
	public static void deposit() {
		System.out.println(acc);
		System.out.println("Deposit per transaction limit\n 200000");
		int MAX_AMT=200000;
		System.out.println("Enter the Deposited Amount");
		int depo_Amt=sc.nextInt();
		if(depo_Amt<=MAX_AMT) {
		BankingMethods.deposit(depo_Amt,acc);}
		else {
			System.out.println("YOU ENTERED AMOUNT IS GREATER THAN THE TRANSACTION LIMIT");
		}
	}
	public static void transfer() {
		BankingMethods.transfer(acc);
	}
	public static void pinChange() {
		
	}	

}