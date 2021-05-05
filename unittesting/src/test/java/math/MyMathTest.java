package math;

import org.junit.Assert;
import org.junit.Test;

public class MyMathTest {
	
	MyMath mm = new MyMath();

	@Test (expected = IllegalArgumentException.class)
	public void test_factorial_negative() {
		mm.factorial(-5);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_factorial_greater_than_12() {
		mm.factorial(15);
	}
	
	@Test
	public void test_factorial_no_exception() {
		Assert.assertEquals(24, mm.factorial(4));
	}
	
}
