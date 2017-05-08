package nz.co.troyshaw.befunge;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		char[][] program = getFileProgram();
//
		new BefungeInterpreter(program).execute();
	}
	
	private static char[][] getFileProgram() {
		return BefungeLoader.loadProgramFromFile("src/progs/sieve.txt");
	}
}
