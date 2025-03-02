package Junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderService2MultiThreadTest {

private OrderService2 os2;
	
	@BeforeEach
	public void setup() {
		os2 = new OrderService2();
	}
	
	@Test
	public void testPlaceOrderMultiThread() throws InterruptedException {
		int threadCount=10;
		ExecutorService executor=Executors.newFixedThreadPool(threadCount);
		CountDownLatch latch = new CountDownLatch(threadCount);
		
		for(int i=0;i<threadCount;i++) {
			executor.execute(()->{
				try {
					os2.placeOrder(1);
				} catch(Exception Ignored) {}
				latch.countDown();
				
			});
			
		}
		latch.await(); // wait for all threads to finish
		executor.shutdown();
		
		assertEquals(0,os2.getStock());
	}

}
