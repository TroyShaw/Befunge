package nz.co.troyshaw.befunge;

/**
 * Represents the result of executing a Befunge program.
 * 
 * @author troys
 */
public class BefungeResult {

	/**
	 * Represents the result of a Befunge program which executed succesfully.
	 * 
	 * @param result
	 */
	public BefungeResult(String result) {
		
	}
	
	/**
	 * Represents a result of a Befunge program which resulted in program failure due to exception.
	 * 
	 * @param result
	 * @param errorChar
	 * @param errorXCoord
	 * @param errorYCoord
	 */
	public BefungeResult(String result, char errorChar, int errorXCoord, int errorYCoord) {
		
	}
}
