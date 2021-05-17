package math;

/**
 * The class provides the simple arithmetic operation of factorial that serves
 * as hands-on practice on Unit Testing.
 *
 * @author mstefadourou
 * @version 1.0
 * @since 2021-05-05
 */
public class MyMath {

	/**
	 * Performs the basic arithmetic operation of factorial.
	 * 
	 * @param n the number whose factorial we want to compute
	 * @return factorial of the number n
	 * @exception IllegalArgumentException when n is negative or greater than 12
	 */
	public int factorial(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("the given number is negative");
		} else if (n > 12) {
			throw new IllegalArgumentException("the given number is greater than 12");
		} else {
			int factorial = 1;
			for (int i = 2; i <= n; i++) {
				factorial = factorial * i;
			}
			return factorial;
		}
	}

	/**
	 * Finds if the given number is a prime number or not.
	 * 
	 * @param n the number we want to find out if it's prime or not
	 * @return if the given number is a prime number
	 * @exception IllegalArgumentException when n is smaller than 2
	 */
	public boolean isPrime(int n) {
		int i;
		//the given number is a prime number
		boolean flag = true;
		int m = n / 2;
		if (n < 2) {
			throw new IllegalArgumentException("the given number is not greater than 2");
		} else {
			for (i = 2; i <= m; i++) {
				if (n % i == 0) {
					//the given number is not a prime number
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
}
