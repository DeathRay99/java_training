package OOPConcepts;
import java.util.Scanner;

public class BankApplication {
	public static void main(String[] args) {
//		BankAccount account1 =  new BankAccount();
//		account1.setAccountHolderName("temp");
//		account1.setAccountNumber("IHYi7868");
//		account1.setBalance(-1000);
//		account1.displayDetails();
		
//		String name;
//		String accNo;
//		int balance;
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Name: ");
//		name=sc.nextLine();
//		sc.nextLine();
//		System.out.println("Account No: ");
//		accNo=sc.nextLine();
//		sc.nextLine();
//		System.out.println("Balance: ");
//	    balance=sc.nextInt();
//		sc.nextLine();
//		
//		
//		
//		BankAccount account2=new BankAccount(name,accNo,balance);
//		
//		account2.checkBalance();
//		
//		account2.deposit(5000);
//		account2.checkBalance();
//		
//		account2.withdraw(8000);
//		account2.withdraw(2000);
//		
//		sc.close();
		
//		SavingsBankAccount c1= new SavingsBankAccount("temp","SBIN999000",5000,0.9);
//		c1.calInterest();
//		
//		SavingsBankAccount c1= new SavingsBankAccount("temp","SBIN999000",5000,0.9);
//		c1.displayDetails();
//		c1.deposit(100);
//		c1.displayDetails();
//		c1.calInterest();
//		
//	    BankAccount c2= new SavingsBankAccount("temp1","SBIN998900",2000,0.8);
//		c2.displayDetails();
//		c2.deposit(200);
//		c2.displayDetails();
//		((SavingsBankAccount) c2).calInterest();
		
//		BankAccount c3= new BankAccount("temp3","SBIN998900",2000);
//		c3.deposit(100,400,700,-7);
//		System.out.println();
//		
//		SavingsBankAccount c1= new SavingsBankAccount("temp","SBIN999002",5000,0.9);
//		c1.deposit(100,400,700,-7,-8);
		
//		SavingsBankAccount p3= new SavingsBankAccount("temp","SBIN999002",5000,0.9);
//		BankAccount p1= new BankAccount("p1","SBIN998900",1000);
//		BankAccount p2= new BankAccount("p2","SBIN998901",1000);
//		p1.transfer(500, p2);
//		p1.transfer(500, p3);
//		p1.checkBalance();
//		p1.transfer(500, p3);
		
//		PremiuimSavingsAccount p4= new PremiuimSavingsAccount("temp","SBIN999002",5000,0.9,0.2);
//	    p4.displayDetails();
//		p4.deposit(1000);
//		p4.displayDetails();
//		
//		SavingsBankAccount p5= new PremiuimSavingsAccount("temp2","SBIN999002",5000,0.9,0.2);
//	    p5.displayDetails();
//		p5.deposit(1000);
//		p5.displayDetails();
		
		DematAccount d1=new DematAccount("temp","SBIN999002",5000,50);
		d1.buyStocks(10, 20);
		d1.displayDetails();
		d1.sellStocks(12, 40);
		d1.displayDetails();
		
		
		
	}

}
