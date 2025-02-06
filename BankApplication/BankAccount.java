package OOPConcepts;

public class BankAccount {
	private String accountHolderName;
	private String accountNumber;
	private double balance;
	
	public BankAccount() {
		
	}
	public BankAccount(String name, String accNum, double amt) {
		this.accountHolderName=name;
		this.accountNumber=accNum;
		this.balance=amt;
	}
	
	public String getAccountHolderName() {
		return accountHolderName;
	}
	
	public void setAccountHolderName(String name) {
		this.accountHolderName=name;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(String accNum) {
		this.accountNumber=accNum;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double amt) {
		if(amt<0){
			System.out.println("Please enter a valid amount ");
			return;
			
		}
		this.balance=amt;
	}
	
	public void deposit(double amount) {
		balance+=amount;
		System.out.println("Updated balance : "+ balance);
		
	}
	
	public void deposit(double... amounts) {
		double totalDeposit=0.0;
		for(double amount:amounts) {
			if(amount>0) {
				totalDeposit+=amount;
			}
			else {
				System.out.println("Negative amount is not permissible");
			}
		}
		balance+=totalDeposit;
		System.out.println("Updated balance : "+ balance);
	}
	
	public void displayDetails() {
		System.out.println("Account Holder Name: "+ accountHolderName);
		System.out.println("Account Holder Account Number: "+ accountNumber);
		System.out.println("Account Holder Balance: "+ balance);
		
	}
	
	public void withdraw(double amount) {
		if(balance>=amount) {
			balance-=amount;
			System.out.println("Updated balance : "+balance);
			
		}
		else {
			System.out.println("Insufficient balance");
		}
		
	}
	public void transfer(double amount, BankAccount targetAccount) {
		if(amount<=0) {
			System.out.println("Please enter amount greater than 0");
			return;
			
		}
		if(amount>balance) {
			System.out.println("Sorry, insufficient balance");
			return;
			
		}
		
		balance-=amount;
		targetAccount.deposit(amount);
		System.out.println("Transferred amount: "+amount+" to account: "+targetAccount.getAccountNumber());
	}
	
	public void checkBalance() {
		System.out.println("Account Number: " + accountNumber);
		System.out.println("has Current balance: " + balance);
	}
	
	

}
