package OOPConcepts;

public class DematAccount extends BankAccount{
	private int stockHoldings;

	public DematAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DematAccount(String name, String accNum, double amt, int stocks) {
		super(name, accNum, amt);
		// TODO Auto-generated constructor stub
		this.stockHoldings=stocks;
	}
	
	public void buyStocks(int quantity, double pricePerStock) {
		double totalCost=quantity*pricePerStock;
		if(getBalance()>=totalCost) {
			setBalance(getBalance()-totalCost);
			stockHoldings+=quantity;
		}
		else {
			System.out.println("Insufficient balance to buy stocks. ");
		}
	}
	
	public void sellStocks(int quantity, double pricePerStock) {
		if(quantity<=0) {
			System.out.println("please enter qunatity atleast 1");
			return;
		}
		double sellCost=quantity*pricePerStock;
		setBalance(getBalance()+sellCost);
		stockHoldings-=quantity;
		
	}
	@Override
	public void displayDetails() {
		super.displayDetails();
		System.out.println("your stock holdings are: "+stockHoldings);
		
	}
	

	

}
