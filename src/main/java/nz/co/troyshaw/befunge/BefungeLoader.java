package nz.co.troyshaw.befunge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class BefungeLoader {
	
	public static char[][] loadProgramFromFile(String path) throws IOException {
		String fileContents = new String(Files.readAllBytes(Paths.get(path)));

		return loadProgramFromString(fileContents);
	}

	public static char[][] loadProgramFromString(String programString) {
		String[] strings = programString.split(Pattern.quote("\n"));

		char[][] program = new char[strings.length][];

		for (int i = 0; i < program.length; i++) {
			program[i] = strings[i].toCharArray();
		}

		return program;
	}
}
