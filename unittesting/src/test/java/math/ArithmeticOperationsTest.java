package math;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ArithmeticOperationsTest {
	
	ArithmeticOperations ao = new ArithmeticOperations();

	@Test (expected = ArithmeticException.class)
	public void test_division_zero_exception() {
		ao.divide(2.0, 0.0);
	}

	@Test
	public void test_division_normal() {
		Assert.assertEquals(5.0, ao.divide(10.0, 2.0), 0);
	}
	
	@Test
	public void test_division_zero() {
		Assert.assertEquals(0.0, ao.divide(0.0, 2.0), 0);
	}
	
	@Test
	public void test_multiplication_no_exception() {
		Assert.assertEquals(6, ao.multiply(2, 3));
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void test_multiplication_negative_exception_x() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		ao.multiply(3, -5);
	}
	
	@Test
	public void test_multiplication_negative_exception_y() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		ao.multiply(-3, 5);
	}
	
	@Test
	public void test_multiplication_negative_exception_both() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		ao.multiply(-3, -5);
	}
	
	@Test
	public void test_multiplication_negative_x_zero() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		ao.multiply(-3, 0);
	}
	
	@Test
	public void test_multiplication_negative_y_zero() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		ao.multiply(0, -3);
	}
	
	@Test
	public void test_multiplication_zero_x() {
		Assert.assertEquals(0, ao.multiply(0, 3));
	}
	
	@Test
	public void test_multiplication_zero_y() {
		Assert.assertEquals(0, ao.multiply(4, 0));
	}

	@Test
	public void test_multiplication_zero_both() {
		Assert.assertEquals(0, ao.multiply(0, 0));
	}
	
	@Test
	public void test_multiplication_final_exception() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The product does not fit in an Integer variable");
		ao.multiply(2147483646, 2);
	}
}
