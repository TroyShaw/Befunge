package nz.co.troyshaw.befunge;

import junit.framework.Assert;
import junit.framework.TestCase;

public class BefungeFailTest extends TestCase {
	
	/**
	 * Tests including a non-allowed character, a ')', returns an error result.
	 */
	public void testFailure() {
		BefungeResult result = BefungeDriver.executeFromFile("programs/sieve_fail.txt");
		
		Assert.assertTrue(result.wasError());
		Assert.assertEquals(')', result.getErrorChar());
		Assert.assertEquals(17, result.getErrorXCoord());
		Assert.assertEquals(1, result.getErrorYCoord());
	}
}
