package nz.co.troyshaw.befunge;

public class BefungeDriver {

	public static String executeFromFile(String filename) {
		char[][] program = BefungeLoader.loadProgramFromFile(filename);
		
		return new BefungeInterpreter(program).execute();
	}
}
