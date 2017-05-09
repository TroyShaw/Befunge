package nz.co.troyshaw.befunge;

import junit.framework.Assert;
import junit.framework.TestCase;

public class BefungeSuccessTest extends TestCase {

	public void testHelloworld1() {
		Assert.assertEquals("Hello, World!", executeSuccess("programs/hello1.txt"));
	}

	public void testHelloworld2() {
		Assert.assertEquals("Hello World!\n", executeSuccess("programs/hello2.txt"));
	}
	
	public void testSieve() {
		Assert.assertEquals("2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 ", executeSuccess("programs/sieve.txt"));
	}
	
	private String executeSuccess(String filename) {
		return BefungeDriver.executeFromFile(filename).getResult();
	}
}
