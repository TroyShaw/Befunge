package nz.co.troyshaw.befunge;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class BefungeFailTest {

	/**
	 * Tests including a non-allowed character, a ')', returns an error result.
	 * @throws IOException 
	 */
	@Test
	public void testFailure() throws IOException {
		BefungeResult result = BefungeDriver.executeFromFile("programs/sieve_fail.txt");

		Assert.assertTrue(result.wasError());
		Assert.assertEquals(')', result.getErrorChar());
		Assert.assertEquals(17, result.getErrorXCoord());
		Assert.assertEquals(1, result.getErrorYCoord());
	}
}
