package math;

import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;

import io.FileIO;

public class ArrayOperationsTest {
	ArrayOperations ao = new ArrayOperations();

	@Test
	public void test_findPrimesInFile_Mocking() {
		// Mock the FileIO dependency
		FileIO fileio = mock(FileIO.class);
		// Mock the MyMath dependency
		MyMath mm = mock(MyMath.class);

		int[] r1 = new int[] { 11, 566, 76, 44, 224, 29, 61 };
		when(fileio.readFile("src/test/resources/valid.txt")).thenReturn(r1);

		when(mm.isPrime(11)).thenReturn(true);
		when(mm.isPrime(566)).thenReturn(false);
		when(mm.isPrime(76)).thenReturn(false);
		when(mm.isPrime(44)).thenReturn(false);
		when(mm.isPrime(224)).thenReturn(false);
		when(mm.isPrime(29)).thenReturn(true);
		when(mm.isPrime(61)).thenReturn(true);

		int[] expected = { 11, 29, 61 };
		Assert.assertArrayEquals(expected, ao.findPrimesInFile(fileio, "src/test/resources/valid.txt", mm));
	}
}
