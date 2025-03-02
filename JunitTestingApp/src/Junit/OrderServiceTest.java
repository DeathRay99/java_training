package Junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OrderServiceTest {
	
	OrderService orderService = new OrderService();

	@Test
    void testPlaceOrderInsufficientStock() {
//        OrderService orderService = new OrderService();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            orderService.placeOrder(15);
        });
        assertEquals("Insufficient stock", exception.getMessage());
    }

    @Test
    void testCalPrice() {
        
        double price = 100.0;
        int quantity = 2;
        double expected = price * quantity * (1 - orderService.getDiscount());
        assertEquals(expected, orderService.calPrice(price, quantity));
    }
    
    @Test
    void testPlaceOrder() {

        assertTrue(orderService.placeOrder(5));
    }
    
    @ParameterizedTest
    @CsvSource({
        "100, 1, 90.0",
        "200, 2, 360.0",
        "50, 5, 225.0"
    })
    void testCalPrice(double price, int quantity, double expected) {
        assertEquals(expected, orderService.calPrice(price, quantity));
    }
    
    @Test
	void testTimeout() {
		assertTimeout(java.time.Duration.ofMillis(1000),()->{
			Thread.sleep(1500);
		});
	}
    
    @Test
    void testPlaceOrderMultithread() throws InterruptedException {
    	Thread thread1=new Thread(()->orderService.placeOrder(2));
    	Thread thread2=new Thread(()->orderService.placeOrder(1));
    	
    	thread1.start();
    	thread2.start();
    	
    	thread1.join();
    	thread2.join();
    	
    	assertEquals(7,orderService.getStock());
    }
    
    @BeforeAll
    static void initAll() {
        System.out.println("Starting OrderService Tests");
    }
 
//    @BeforeEach
//    void init() {
//        os = new OrderService();
//    }
 
    @AfterEach
    void tearDown() {
        System.out.println("Test completed");
    }
 
    @AfterAll
    static void tearDownAll() {
        System.out.println("All tests completed");
    }
    

}
