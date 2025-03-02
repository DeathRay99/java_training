package OOPConcepts;

public class PremiuimSavingsAccount extends SavingsBankAccount {
	
	private double bonusInterest;
	
	public PremiuimSavingsAccount(String name, String accNum, double amt, double intRate, double preRate) {
		super(name,accNum,amt,intRate);
		this.bonusInterest=preRate;
		
	}

	public double getBonusInterest() {
		return bonusInterest;
	}

	public void setBonusInterest(double bonusInterest) {
		this.bonusInterest = bonusInterest;
	}
	
	@Override
	public void deposit(double amount) {
		super.deposit(amount);
		double extraInterest=amount*bonusInterest;
		setBalance(getBalance()+extraInterest);
		System.out.println("Extra Interest added: "+extraInterest);
	}
	
	@Override
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Interest rate is: "+(super.getInterestRate())*100+"%");
		System.out.println("Extra Interest rate is: "+(bonusInterest*100)+"%");
		System.out.println("-----------------");
	}
	

}
