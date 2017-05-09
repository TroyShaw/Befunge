package nz.co.troyshaw.befunge;

/**
 * Represents the result of executing a Befunge program.
 * 
 * @author troys
 */
public class BefungeResult {

	private String result;
	
	private boolean wasError;
	
	private char errorChar;
	private int errorXCoord, errorYCoord;
	
	/**
	 * Represents the result of a Befunge program which executed succesfully.
	 * 
	 * @param result
	 */
	public BefungeResult(String result) {
		this.result = result;
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
		this.result = result;
		
		this.errorChar = errorChar;
		this.errorXCoord = errorXCoord;
		this.errorYCoord = errorYCoord;
		
		wasError = true;
	}
	
	public String getResult() {
		return result;
	}
	
	public boolean wasError() {
		return wasError;
	}
	
	public int getErrorChar() {
		return errorChar;
	}
	
	public int getErrorXCoord() {
		return errorXCoord;
	}
	
	public int getErrorYCoord() {
		return errorYCoord;
	}
}
