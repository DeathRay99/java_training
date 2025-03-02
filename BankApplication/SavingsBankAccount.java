package OOPConcepts;

public class SavingsBankAccount extends BankAccount {
	
	private double interestRate;

	public SavingsBankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SavingsBankAccount(String name, String accNum, double amt, double intRate) {
		super(name, accNum, amt);
		this.interestRate=intRate;
		// TODO Auto-generated constructor stub
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void calInterest() {
		System.out.println("you will be getting " + (interestRate*100) + "% interest");
		double amt=super.getBalance();
		System.out.println("your interest will be " + (interestRate*amt));
		amt+=(interestRate*amt);
		
		System.out.println("your total amount will be " + amt);
		
	}
	
	@Override
	public void deposit(double amount) {
		super.deposit(amount);
		double interest=amount*interestRate;
		setBalance(getBalance()+interest);
		System.out.println("Interest added: "+interest);
	}
	
	@Override
	public void deposit(double... amounts) {
//		super.deposit(amount);
//		double interest=amount*interestRate;
//		setBalance(getBalance()+interest);
//		System.out.println("Interest added: "+interest);
		double totalDeposit=0.0;
		for(double amount:amounts) {
			if(amount>0) {
				totalDeposit+=amount;
			}
			else {
				System.out.println("Negative amount is not permissible");
			}
		}
		super.deposit(totalDeposit);
		double interest=totalDeposit*interestRate;
		setBalance(getBalance()+interest);
		System.out.println("Balance is: "+getBalance());
		System.out.println("Interest added: "+interest);
	}
	
//	public void displaySbAcct() {
//		super.displayDetails();
//	}
//	
	@Override
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Interest rate is: "+interestRate);
		System.out.println("-----------------");
	}
	
	

}
