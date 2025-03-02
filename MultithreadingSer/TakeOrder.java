package MultithreadingSer;

public class TakeOrder extends Thread{
	@Override
	public void run() {
		System.out.println("Taking your order: ");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("order completed");
	}

}
