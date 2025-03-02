package MultithreadingSer;

public class OrderApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TakeOrder t1=new TakeOrder(); 
		ProcessPayment t2=new ProcessPayment(); 
		AssignDA t3=new AssignDA();
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
