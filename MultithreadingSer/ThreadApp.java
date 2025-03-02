package MultithreadingSer;

public class ThreadApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestThread2 t1=new TestThread2(); //from thread class
		Counter obj=new Counter();
		// instance of runnable
		TestThread runnable=new TestThread();
		Thread t2=new Thread(runnable);
		
		Thread t3=new Thread(()->{
			for(int i=0;i<5;i++) {
				obj.incrementCount();
			}
		});
		Thread t4=new Thread(()->{
			for(int i=0;i<4;i++) {
				obj.incrementCount();
			}
		});
		// start the threads
//		t1.start();
//		t2.start();
		t3.start();
		t4.start();
		
		try {
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(obj.getCount());
		System.out.println("Process Completed. ");

	}

}
