package math;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ArithmeticOperationsTest {
	
	ArithmeticOperations ao = new ArithmeticOperations();

	@Test (expected = ArithmeticException.class)
	public void test_division_zero_exception() {
		ao.divide(2,0);
	}

	@Test
	public void test_division_no_zero_exception() {
		ao.divide(10,2);
	}
	
	@Test
	public void test_multiplication_no_exception() {
		Assert.assertEquals(6, ao.multiply(2, 3));
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void test_multiplication_negative_exception() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		ao.multiply(3, -5);
	}
	
	@Test
	public void test_multiplication_final_exception() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The product does not fit in an Integer variable");
		ao.multiply(2147483647, 2);
	}
	
}
