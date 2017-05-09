package nz.co.troyshaw.befunge;

public class BefungeDriver {

	public static BefungeResult executeFromFile(String filename) {
		char[][] program = BefungeLoader.loadProgramFromFile(filename);
		
		return new BefungeInterpreter(program).execute();
	}
}
