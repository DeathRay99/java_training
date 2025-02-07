package MultithreadingSer;

public class AssignDA extends Thread {
	public void run() {
		System.out.println("Assigning delivery partner: ");
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("delivery partner assigned. ");
	}

}
