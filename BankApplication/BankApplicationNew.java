package OOPConcepts;
import java.util.*;

public class BankApplicationNew {
	
	private static BankAccount[] accounts;
	private static int totalAccounts=0;
	private static int maxAccounts=5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner=new Scanner(System.in);
		accounts = new BankAccount[5];
		
		while(true) {
			System.out.println("Bank application Menu");
			System.out.println("Press 1 : To create an account");
			System.out.println("Press 2 : Display All account");
			System.out.println("Press 3 : Deposit Money");
			System.out.println("Press 4 : Withdraw Money");
			System.out.println("Press 5 : Transfer Money");
			System.out.println("Press 6 : Buy Stocks");
			System.out.println("Press 7 : Sell Stocks");
			System.out.println("Press 8 : Exit");
			
			int choice=scanner.nextInt();
			
			switch(choice) {
			case 1:
				createAccount(scanner);
				break;
				
			case 2:
				displayAllAccounts();
				break;
				
			case 3:
				depositMoney(scanner);
				break;
				
			case 4:
				withdrawMoney(scanner);
				break;
				
			case 5:
				transferMoney(scanner);
				break;
				
			case 6:
				buyStocks(scanner);
				break;
				
			case 7:
				sellStocks(scanner);
				break;
				
			case 8:
				System.out.println("Thank you! Exiting from system");
				scanner.close();
				return;
				
			default:
				System.out.println("Invalid choice. Enter from 1-8");
				
			
		}
		

	}

}
	
	public static void createAccount(Scanner scanner) {
		if(totalAccounts>=maxAccounts) {
			System.out.println("Cannot create more accounts");
			return;
		}
		
		System.out.println("Enter account holder name");
		String accountName=scanner.next();
		System.out.println("Enter account number");
		String accountNumber=scanner.next();
		System.out.println("Enter initial balance");
		double accountBalance=scanner.nextDouble();
		System.out.println("which type of account you want to open ?");
		System.out.println("Press 1 : To create a Bank account");
		System.out.println("Press 2 : To create Savings bank account");
		System.out.println("Press 3 : To create premiuim Savings bank account");
		System.out.println("Press 4 : to Create a demat account");
		int accType=scanner.nextInt();
		
		switch(accType) {
		case 1:
			accounts[totalAccounts]=new BankAccount(accountName,accountNumber,accountBalance);
			break;
			
		case 2:
			System.out.println("Enter interest rate: ");
			double interestRate=scanner.nextDouble();
			accounts[totalAccounts]=new SavingsBankAccount(accountName,accountNumber,accountBalance,interestRate);
			break;
			
		case 3:
			System.out.println("Enter interest rate: ");
			double normalRate=scanner.nextDouble();
			System.out.println("Enter bonus rate: ");
			double extraRate=scanner.nextDouble();
			accounts[totalAccounts]=new PremiuimSavingsAccount(accountName,accountNumber,accountBalance,normalRate,extraRate);
			break;
			
		case 4:
			System.out.println("Enter stock holdings: ");
			int numStocks=scanner.nextInt();
			accounts[totalAccounts]=new DematAccount(accountName,accountNumber,accountBalance,numStocks);
			break;
			
		default:
			System.out.println("Invalid choice. Enter from 1-4");
			return;
		}
		
		System.out.println("Account created successfully!");
		totalAccounts++;
		
	}
	
	public static void displayAllAccounts() {
		if(totalAccounts==0) {
			System.out.println("No account to display. ");
			return;
		}
		System.out.println("Bank Account Details -----------------");
		for(int i=0;i<totalAccounts;i++) {
			accounts[i].displayDetails();
			System.out.print("--------------------------");
		}
	}
	
	public static void depositMoney(Scanner scanner) {
		System.out.print("Enter account number: ");
		String accNum=scanner.next();
		System.out.print("Single or multiple deposits? ");
		String choice=scanner.next();
		if(choice.equalsIgnoreCase("single")) {
			System.out.print("Enter amount to be deposited ");
			double amount = scanner.nextDouble();
			BankAccount account = findAccount(accNum); //if no account exist returns null
			if(account!=null) {
				account.deposit(amount);
				
			}
			else
				System.out.println("Account not found");
		}
		else {
			System.out.print("Enter number of deposits ");
			int num=scanner.nextInt();
			double temp[] = new double[num];
			for(int i=0;i<num;i++) {
				System.out.print("Enter deposit "+(i+1) +" ");
				temp[i]=scanner.nextDouble();
			}
			BankAccount account = findAccount(accNum); //if no account exist returns null
			if(account!=null) {
				account.deposit(temp);
				
			}
			else
				System.out.println("Account not found");
			
		}
		
		
	}
	
	public static BankAccount findAccount(String accountNumber) {
		for(int i=0;i<totalAccounts;i++) {
			if(accounts[i].getAccountNumber().equals(accountNumber)) {
				return accounts[i];
			}
		}
		return null;
		
	}
	
	public static void withdrawMoney(Scanner scanner) {
		System.out.print("Enter account number: ");
		String accNum=scanner.next();
		System.out.print("Enter amount to be depsoited");
		double amount = scanner.nextDouble();
		BankAccount account = findAccount(accNum); //if no account exist returns null
		if(account!=null) {
			account.withdraw(amount);
			
		}
		else
			System.out.println("Account not found");
		
	}
	
	public static void transferMoney(Scanner scanner) {
		System.out.print("Enter senders' account number: ");
		String senAccount=scanner.next();
		System.out.print("Enter amount to be transferred");
		double amount = scanner.nextDouble();
		System.out.print("Enter recipent's account number: ");
		String recAccount=scanner.next();
		BankAccount account1 = findAccount(senAccount);
		BankAccount account2 = findAccount(recAccount); //if no account exist returns null
		if(account1!=null&&account2!=null) {
			account1.transfer(amount, account2);
			return;
		}
		else if(account1!=null){
			System.out.println("sender's account not found");
			return;
			}
		
		else if(account2!=null) {
			System.out.println("recipent's account not found");
			return;
			
		}
	}
	public static void buyStocks(Scanner scanner) {
		System.out.print("Enter demat account number: ");
		String accNum=scanner.next();
		System.out.print("Enter no. of stocks u want to buy ");
		int stockNum = scanner.nextInt();
		System.out.print("Enter price per stock ");
		double price = scanner.nextDouble();
		BankAccount account = findAccount(accNum);
		if(account!=null) {
			((DematAccount) account).buyStocks(stockNum,price);
			
		}
		else
			System.out.println("Account not found");
		
	}
	public static void sellStocks(Scanner scanner) {
		System.out.print("Enter demat account number: ");
		String accNum=scanner.next();
		System.out.print("Enter no. of stocks u want to sell ");
		int stockNum = scanner.nextInt();
		System.out.print("Enter price per stock ");
		double price = scanner.nextDouble();
		BankAccount account = findAccount(accNum);
		if(account!=null) {
			((DematAccount) account).sellStocks(stockNum,price);
			
		}
		else
			System.out.println("Account not found");
		
	}
	
	
	}
	

