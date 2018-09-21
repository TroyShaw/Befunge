package nz.co.troyshaw.befunge;

import java.io.IOException;

public class BefungeDriver {

	public static BefungeResult executeFromFile(String filename) throws IOException {
		char[][] program = BefungeLoader.loadProgramFromFile(filename);

		return new BefungeInterpreter(program).execute();
	}
}
