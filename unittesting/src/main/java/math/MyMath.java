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
			throw new IllegalArgumentException("n is negative");
		} else if (n > 12) {
			throw new IllegalArgumentException("n is greater than 12");
		} else {
			int factorial = 1;
			for (int i = 2; i <= n; i++) {
				factorial = factorial * i;
			}
			return factorial;
		}
	}
}
