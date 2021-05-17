package io;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FileIOTest {
	FileIO fileio = new FileIO();
	public static String resourcesPath = "src/test/resources/";
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testFileIsEmpty() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Given file is empty");
		
		String validInputFilepath = resourcesPath.concat("empty.txt");
		fileio.readFile(validInputFilepath);
	}
	
	@Test
	public void testFileDoesNotExist() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Input file does not exist");
		
		String validInputFilepath = resourcesPath.concat("somefile.txt");
		fileio.readFile(validInputFilepath);
    }
	
	@Test
	public void testReadFileValidInput() {
		int[] expected = new int[] {11, 566, 76, 44, 224, 29, 61};
		String validInputFilepath = resourcesPath.concat("valid.txt");
		
		Assert.assertArrayEquals(expected, fileio.readFile(validInputFilepath));
 	}
	
	@Test
	public void testReadFileContainsInvalidEntries () {
		int[] expected = new int[] {11, 566, 76, 44, 224, 29, 61};
		String validInputFilepath = resourcesPath.concat("invalid.txt");
		
		Assert.assertArrayEquals(expected, fileio.readFile(validInputFilepath));
 	}
}
