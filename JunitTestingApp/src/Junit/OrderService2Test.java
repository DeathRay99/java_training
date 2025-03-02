package Junit;
 
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
 
public class OrderService2Test {
	private OrderService2 os2;
	
	@BeforeEach
	public void setup() {
		os2 = new OrderService2();
	}
 
	@Test
	public void testCalPrice_ValidInputs() {
		double price = 100.00;
		int quantity = 2;
		double expected = price * quantity * (1 - os2.getDiscount());
		assertEquals(expected, os2.calPrice(price, quantity));
	}
	@Test
    void testPlaceOrderSufficientStock() {
        boolean result = os2.placeOrder(5);
        assertTrue(result);
        assertEquals(5, os2.getStock());
    }
	// test with quantity 0
	@Test
	public void testCalPrice_InvalidInputs() {
		double price = 100.00;
		int quantity = 0;
		double expected = price * quantity * (1 - os2.getDiscount());
		assertEquals(expected, os2.calPrice(price, quantity));
	}
	// test with price 0
	@Test
	public void testCalPrice_InvalidInputs2() {
		double price = 100.00;
		int quantity = 0;
		double expected = price * quantity * (1 - os2.getDiscount());
		assertEquals(expected, os2.calPrice(price, quantity));
	}
	// test with price negative
//	@Test
//	public void testCalPrice_InvalidInputs3() {
//		double price = -100.00;
//		int quantity = 0;
//		double expected = price * quantity * (1 - os2.getDiscount());
//		assertEquals(expected, os2.calPrice(price, quantity));
//	}
//	// test with quantity negative
//	@Test
//	public void testCalPrice_InvalidInputs4() {
//		double price = 100.00;
//		int quantity = -9;
//		double expected = price * quantity * (1 - os2.getDiscount());
//		assertEquals(expected, os2.calPrice(price, quantity));
//	}
	// edge case - quantity same as stock
	@Test
	public void testCalPrice_InvalidInputs5() {
		double price = 100.00;
		int quantity = os2.getStock();
		double expected = price * quantity * (1 - os2.getDiscount());
		assertEquals(expected, os2.calPrice(price, quantity));
	}
	// edge case - quantity just below stock
	@Test
	public void testCalPrice_InvalidInputs6() {
		double price = 100.00;
		int quantity = os2.getStock() - 1;
		double expected = price * quantity * (1 - os2.getDiscount());
		assertEquals(expected, os2.calPrice(price, quantity));
	}
	// -------------------------
	// exceptional cases
 
 
    @Test
    public void placeOrderBeyondStock() {
        int quantity = os2.getStock() + 1;
        assertThrows(IllegalArgumentException.class, () -> {
            os2.placeOrder(quantity);
        });
    }
	@Test
    public void setStockNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            os2.setStock(-5);
        });
	}
	@Test
    public void setDiscountInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            os2.setDiscount(1.5);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            os2.setDiscount(-0.5);
        });
	}
	@Test
    public void TestCalPrice_NegativePrice() {
        double price = -100.00;
        int quantity = 2;
        assertThrows(IllegalArgumentException.class, () -> {
            os2.calPrice(price, quantity);
        });
    }
	@Test
    public void TestCalQuant_NegativePrice() {
        double price = 100.00;
        int quantity = -2;
        assertThrows(IllegalArgumentException.class, () -> {
            os2.calPrice(price, quantity);
        });
    }
	
	@ParameterizedTest
    @CsvSource({
        "100, 1, 90.0",
        "200, 2, 360.0",
        "50, 5, 225.0"
    })
    void testCalPrice(double price, int quantity, double expected) {
        assertEquals(expected, os2.calPrice(price, quantity));
    }
	
	@ParameterizedTest
	@ValueSource(ints= {1,4,7,10})
	void testOrderplace(int number) {
		assertTrue(os2.placeOrder(number));
	}
	
	@ParameterizedTest
	@ValueSource(ints= {11,13,15})
	void testBoundaryOrderplace(int number) {
		assertThrows(IllegalArgumentException.class, () -> {
			os2.placeOrder(number);
        });
	}
	
//	@ParameterizedTest
//	@ValueSource(doubles= {-0.5,1.5,2.0})
//	void testInvalidDiscounts(double number) {
//		assertThrows(IllegalArgumentException.class, () -> {
//            os2.setDiscount(number);
//        });
//	}
//	
//	@ParameterizedTest
//	@ValueSource(ints= {-5,-10,-15})
//	void testInvalidStocks(int number) {
//		assertThrows(IllegalArgumentException.class, () -> {
//            os2.setStock(number);
//        });
//	}
	
//	@ParameterizedTest
//    @CsvSource({
//        "100.0, -5",
//        "100.0, 5",
//        "-50.0, -2"
//    })
//    void testNegPriceNegQuan(double price, int quantity) {
//		assertThrows(IllegalArgumentException.class, () -> {
//            os2.calPrice(price,quantity);
//        });
//    }
	
	static Stream<Integer> validStockValues(){
		return Stream.of(0,10,20,30);
	}
	
	@ParameterizedTest
	@MethodSource("validStockValues")
	public void testValidStockValues(int stock) {
		os2.setStock(stock);
		assertEquals(stock,os2.getStock());
	}
	
	// valuesource -> replace with methodsorce
	
	@ParameterizedTest
	@MethodSource("boundaryOrderValues")
	void testBoundaryOrderPlace(int number) {
	    assertThrows(IllegalArgumentException.class, () -> {
	        os2.placeOrder(number);
	    });
	}

	@ParameterizedTest
	@MethodSource("invalidDiscountValues")
	void testInvalidDiscounts(double number) {
	    assertThrows(IllegalArgumentException.class, () -> {
	        os2.setDiscount(number);
	    });
	}

	static Stream<Integer> boundaryOrderValues() {
	    return Stream.of(11, 13, 15);
	}

	static Stream<Double> invalidDiscountValues() {
	    return Stream.of(-0.5, 1.5, 2.0);
	}
	
	@ParameterizedTest
	@MethodSource("negativePriceAndQuantity")
	void testNegPriceNegQuan(double price, int quantity) {
	    assertThrows(IllegalArgumentException.class, () -> {
	        os2.calPrice(price, quantity);
	    });
	}

	static Stream<Arguments> negativePriceAndQuantity() {
	    return Stream.of(
	        Arguments.of(100.0, -5),
	        Arguments.of(100.0, 5),
	        Arguments.of(-50.0, -2)
	    );
	}
 
}