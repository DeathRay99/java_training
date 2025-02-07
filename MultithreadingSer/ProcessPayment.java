package MultithreadingSer;

public class ProcessPayment extends Thread {
	
	public void run() {
		System.out.println("Processing your payment: ");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("payment done ");
	}

}
