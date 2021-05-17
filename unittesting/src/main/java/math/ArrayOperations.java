package math;

import java.util.Arrays;

import io.FileIO;

/**
 * The class uses the classes FileIO and MyMath and thus it serves as hands-on
 * practice on Unit Testing.
 *
 * @author mstefadourou
 * @version 1.0
 * @since 2021-05-06
 */
public class ArrayOperations {

	/**
	 * Finds the prime number in the given file.
	 * 
	 * @param a   FileIO object to read a file with numbers
	 * @param the path where the file is located
	 * @param a   MyMath object to determine if a number is prime or not
	 * @return an array of prime numbers
	 */

	public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {
		int[] integernumbers = fileIo.readFile(filepath);
		int[] primenumbers = new int[integernumbers.length];
		int x = 0;
		for (int i = 0; i < integernumbers.length; i++) {
			if (myMath.isPrime(integernumbers[i]) == true) {
				primenumbers[x] = integernumbers[i];
				x++;
			}
		}
		//remove null elements from int array that contains the primal numbers
		primenumbers = Arrays.stream(primenumbers).filter(y -> y != 0).toArray();
		return primenumbers;
	}
}
