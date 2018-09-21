package nz.co.troyshaw.befunge;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class BefungeSuccessTest {

	@Test
	public void testHelloworld1() throws IOException {
		Assert.assertEquals("Hello, World!", executeSuccess("programs/hello1.txt"));
	}

	@Test
	public void testHelloworld2() throws IOException {
		Assert.assertEquals("Hello World!\n", executeSuccess("programs/hello2.txt"));
	}

	@Test
	public void testSieve() throws IOException {
		Assert.assertEquals("2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 ", executeSuccess("programs/sieve.txt"));
	}

	private String executeSuccess(String filename) throws IOException {
		BefungeResult result = BefungeDriver.executeFromFile("src/test/resources/" + filename);

		Assert.assertFalse(result.wasError());

		return result.getResult();
	}
}
