package nz.co.troyshaw.befunge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BefungeLoader {
	public static char[][] loadProgramFromFile(String path) {
	    char[][] program;
		
	    List<String> lines = new ArrayList<>();
	    
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
	        String line = br.readLine();

	        while (line != null) {
	        	lines.add(line);
	            line = br.readLine();
	        }
	    } catch (IOException e) {
			e.printStackTrace();
		}
		
		program = new char[lines.size()][];
		
		for (int i = 0; i < lines.size(); i++) {
			program[i] = lines.get(i).toCharArray();
		}
		
		return program;
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
