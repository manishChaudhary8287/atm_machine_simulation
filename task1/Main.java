package task1;

import java.util.*;

// main class of the ATM Machine Simulation
public class Main {
	
	// PIN of the card.
	private int pinNum;
	
	// current balance of the account.
	private double currentBalance;
	
	// storing transaction history.
	private ArrayList<String> transHistory=new ArrayList<String>();
	
	public Main(int pinNum,double currentBalance) {
		// assigning the user input pin number to the PIN of the account
		this.pinNum=pinNum;
		
		// assigning the current balance 
		this.currentBalance=currentBalance;
	}

	// Account balance inquiry method
	public void accountBalance(int pinNum) {
		
		// checking if the user entered the correct pin or not.
		if(this.pinNum==pinNum) {
			System.out.println("Current Account Balance : "+currentBalance);
		}
		// if PIN is wrong then...
		else {
			System.out.println("Incorrect PIN... Try again and enter new PIN");
			Scanner sc = new Scanner(System.in);
			int newPIN=sc.nextInt();
			accountBalance(newPIN);
			sc.close();
		}
	}
	
	// Cash Withdrawal method
	public void accountCashWithdrawal(int pinNum,double amount) {
		// checking if the user entered the correct pin or not.
				if(this.pinNum==pinNum) {
					// performing the withdrawal operation.
					if(currentBalance>=amount) {
					currentBalance=currentBalance-amount;
					String temp="Amount withdrawal : "+amount+ " Current Balance : "+currentBalance;
					transHistory.add(temp);
					System.out.println(temp);
					}else {
						System.out.println("amount is too high to withdrawn and current balance is low");
						System.out.println("Enter small amount");
						Scanner s = new Scanner(System.in);
						Double amount1=s.nextDouble();
						accountCashWithdrawal(pinNum, amount1);
					}
				}
				// if PIN is wrong then...
				else {
					System.out.println("Incorrect PIN... Try again and enter new PIN");
					Scanner sc = new Scanner(System.in);
					int newPIN=sc.nextInt();
					accountCashWithdrawal(newPIN,amount);
				}
	}
	
	// Cash deposit method
	public void accountCashDeposit(int pinNum,double amount) {
		// checking if the user entered the correct pin or not.
		if(this.pinNum==pinNum) {
			// performing the amount deposit operation.
			currentBalance=currentBalance+amount;
			String temp="Amount deposit : "+amount+ " Current Balance : "+currentBalance;
			transHistory.add(temp);
			System.out.println(temp);
		}
		// if PIN is wrong then...
		else {
			System.out.println("Incorrect PIN... Try again and enter new PIN");
			Scanner sc = new Scanner(System.in);
			int newPIN=sc.nextInt();
			accountCashDeposit(newPIN,amount);
		}
	}
	
	// PIN Change method
	public void changePIN(int pinNumber) {
		// checking if the user entered the correct old pin or not.
				if(this.pinNum==pinNumber) {
					// if the old pin matches then changing of the pin method starts in action.
					Scanner sc = new Scanner(System.in);
					System.out.print("Enter the new PIN : ");
					int newPIN=sc.nextInt();
					this.pinNum=newPIN;
					System.out.println("PIN Change Successfully");
				}
				// if old PIN is wrong then...
				else {
					System.out.println("Incorrect PIN... Try again and enter new PIN");
					Scanner sc = new Scanner(System.in);
					int newPIN=sc.nextInt();
					changePIN(newPIN);
				}
	}
	
	// Transaction history method
	public void transactionHistory(int pinNum) {
		// checking if the user entered the correct pin or not.
		if(this.pinNum==pinNum) {
			// showing transaction history.
			System.out.println("**********\t Your Transaction History \t**********");
			for(String item:transHistory) {
				System.out.println(item);
			}
			System.out.println("**********\t Transaction History Ended \t**********");
		}
		// if PIN is wrong then...
		else {
			System.out.println("Incorrect PIN... Try again and enter new PIN");
			Scanner sc = new Scanner(System.in);
			int newPIN=sc.nextInt();
			transactionHistory(newPIN);
		}
	}
	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the four digit PIN number : ");
		int pin=sc.nextInt();
		System.out.print("Enter the current account balance : ");
		double balance=sc.nextDouble();
		
		// creating object of the main class
		// assigning the pin and current balance of the class
		
		Main ATM=new Main(pin,balance);
		
		do {
			System.out.println("**********\t WELCOME TO THE ATM MACHINE SIMULATION \t**********");
			System.out.println("Choose the operation :");
			System.out.println("1.Accout Balance Inquiry");
			System.out.println("2.Cash Withdrawal");
			System.out.println("3.Cash Deposit");
			System.out.println("4.PIN Change");
			System.out.println("5.Transaction History");
			System.out.println("6.Exit");
			System.out.print("Your Choice : ");
			int choice=sc.nextInt();
			switch(choice) {
			
			// if we enter 1 then account balance inquiry method is called.
			case 1:
				System.out.print("Enter the PIN : ");
				int pinNumber1=sc.nextInt();
				ATM.accountBalance(pinNumber1);
				break;
				
			// if we enter 2 then cash withdrawal method is called.
			case 2:
				System.out.print("Enter the PIN : ");
				int pinNumber2=sc.nextInt();
				System.out.println("Enter the amount to be withdrawn");
				int amount1=sc.nextInt();
				ATM.accountCashWithdrawal(pinNumber2, amount1);
				break;
				
			// if we enter 3 then cash deposit method is called.
			case 3:
				System.out.print("Enter the PIN : ");
				int pinNumber3=sc.nextInt();
				System.out.println("Enter the amount to be withdrawn");
				int amount2=sc.nextInt();
				ATM.accountCashDeposit(pinNumber3, amount2);
				break;
				
			// if we enter 4 then PIN change method is called.
			case 4:
				System.out.print("Enter the old PIN : ");
				int pinNumber4=sc.nextInt();
				ATM.changePIN(pinNumber4);
				break;
				
			// if we enter 5 then transaction history method is called.
			case 5:
				System.out.print("Enter the PIN : ");
				int pinNumber5=sc.nextInt();
				ATM.transactionHistory(pinNumber5);
				break;
				
			// if we enter 6 then we exit from the program.
			case 6:
				System.out.println("**********\t Exit \t**********");
				System.exit(0);
				
			// default method is called if input is out of the range.
				default:
					System.out.println("Wrong input... try again with new choice.");
			}
		}while(true);
	}

}
