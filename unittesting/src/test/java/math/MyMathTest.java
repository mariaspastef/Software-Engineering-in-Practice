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
	
	@Test (expected = IllegalArgumentException.class)
	public void test_prime_number_exception() {
		mm.isPrime(1);
	}
	
	@Test
	public void test_prime_number_is_prime() {
		Assert.assertEquals(true, mm.isPrime(11));
	}
	
	@Test
	public void test_prime_number_is_not_prime() {
		Assert.assertEquals(false, mm.isPrime(30));
	}
}
