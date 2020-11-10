package Banking;
import java.util.*;
public class Selections extends Home{
	static Scanner sc=new Scanner(System.in);
	public static void Choose() {

		System.out.println("Wellcome to ATM Application");
		System.out.println("Press 1 to Banking");
		System.out.println("Press 2 to Balance Enquery");
		System.out.println("Press 3 to Transfer");
		System.out.println("Press 4 to Pin Generation");
		System.out.println("Press 5 to Regestration");
	}
	public static void selection() {
		int input=sc.nextInt();
		switch(input)
		{
		case 1:
			Banking bank=new Banking();
			bank.choose();
			break;
		case 2:
			if(pin!=0) {
			System.out.println("Enter your Pin Number");
		int PIN=sc.nextInt();
		if(pin==PIN) {
//			int availableBalance = BankingMethods.availableBalance(accountNumber);
			
			System.out.println("Your Balance is:"+balance);
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
				System.out.println("Transfer");
			Banking.transfer();
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
		case 4:
			System.out.println("PIN GENERATION");
			
			if(pin==0) {
			PinGeneration.pin();
			System.out.println("Your pin is setting is done");
			}
			else
			{
				System.out.println("For your account Pin generation is already done");
			}
			
			break;
		case 5:
			System.out.println("WELCOME TO REGISTRATION");
			if(pin!=0) {
				System.out.println("Enter your Pin Number");
			int PIN=sc.nextInt();
			if(pin==PIN) {	
			Registration.choose();
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
		default:
			System.out.println("YOUR SELECTION IS NOT IN LIST PLEASE TRY AGAIN");
			System.exit(0);
		}
	}
}
