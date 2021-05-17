package math;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MyMathTest {
	
	MyMath mm = new MyMath();
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test 
	public void test_factorial_negative() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("the given number is negative");
		mm.factorial(-5);
	}

	@Test 
	public void test_factorial_zero() {
		Assert.assertEquals(1, mm.factorial(0));
	}
	
	@Test 
	public void test_factorial_border() {
		Assert.assertEquals(479001600, mm.factorial(12));
	}
	
	@Test
	public void test_factorial_greater_than_12() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("the given number is greater than 12");
		mm.factorial(15);
	}
	
	@Test
	public void test_factorial_no_exception() {
		Assert.assertEquals(24, mm.factorial(4));
	}
	
	@Test
	public void test_prime_number_exception() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("the given number is not greater than 2");
		mm.isPrime(1);
	}
	
	@Test
	public void test_prime_number_zero() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("the given number is not greater than 2");
		mm.isPrime(0);
	}
	
	@Test
	public void test_prime_number_border() {
		Assert.assertEquals(true, mm.isPrime(2));
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
