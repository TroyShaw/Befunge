package nz.co.troyshaw.befunge;

import java.util.Random;
import java.util.Scanner;

public class BefungeInterpreter {

	private char[][] program;
	
	private int pcX, pcY;
	private int dx, dy;
	
	private BefungeStack stack;
	
	private boolean stringMode;
	
	private Scanner scanner;
	private Random random;

	private StringBuffer stringbuffer;
	
	public BefungeInterpreter(char[][] program) {
		this.program = program;
		
		stringbuffer = new StringBuffer();
		
		stack = new BefungeStack();
		
		scanner = new Scanner(System.in);
		random = new Random();

		setDir(Dir.Right);
	}
	
	public String execute() {
		char c = getChar();
		
		while (c != '@') {
			executeSingleCycle(c);
			c = getChar();
		}

		return stringbuffer.toString();
	}
	
	private void executeSingleCycle(char c) {
		int a, b;
		
		int x, y;
		
		if (stringMode) {
			if (c == '"') stringMode = false;
			else stack.push(c);
		} else {
			switch (c) {
			case '+':
				a = stack.pop();
				b = stack.pop();
				stack.push(b + a);

				break;
			case '-':
				a = stack.pop();
				b = stack.pop();
				stack.push(b - a);

				break;
			case '*':
				a = stack.pop();
				b = stack.pop();
				stack.push(b * a);

				break;
			case '/':
				a = stack.pop();
				b = stack.pop();
				stack.push(b / a);

				break;
			case '%':
				a = stack.pop();
				b = stack.pop();
				stack.push(b % a);

				break;
			case '!':
				a = stack.pop();
				stack.push(a == 0 ? 1 : 0);

				break;
			case '`':
				a = stack.pop();
				b = stack.pop();
				stack.push(b > a ? 1 : 0);

				break;
			case '>':
				setDir(Dir.Right);

				break;
			case '<':
				setDir(Dir.Left);

				break;
			case '^':
				setDir(Dir.Up);

				break;
			case 'v':
				setDir(Dir.Down);

				break;
			case '?':
				setRandDir();

				break;
			case '_':
				a = stack.pop();
				if (a == 0) setDir(Dir.Right);
				else setDir(Dir.Left);

				break;
			case '|':
				a = stack.pop();
				if (a == 0) setDir(Dir.Down);
				else setDir(Dir.Up);

				break;
			case '"':
				stringMode = true;

				break;
			case ':':
				a = stack.pop();
				stack.push(a);
				stack.push(a);

				break;
			case '\\':
				a = stack.pop();
				b = stack.pop();
				stack.push(a);
				stack.push(b);

				break;
			case '$':
				stack.pop();

				break;
			case '.':
				a = stack.pop();
				stringbuffer.append(a);
				stringbuffer.append(' ');

				break;
			case ',':
				a = stack.pop();
				stringbuffer.append((char) a);

				break;
			case '#':
				pcX += dx;
				pcY += dy;

				break;
			case 'g':
				y = stack.pop();
				x = stack.pop();
				stack.push(program[y][x]);

				break;
			case 'p':
				y = stack.pop();
				x = stack.pop();
				char v = stack.pop();
				program[y][x] = v;

				break;
			case '&':
				int i = getIntFromUser();
				stack.push(i);

				break;
			case '~':
				char ch = getCharFromUser();
				stack.push(ch);

				break;
			case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
				stack.push(c - '0');

				break;
			case ' ':
				//space is a no-op

				break;
			default:
				throw new RuntimeException("Unknown command encountered: " + (char) c + ", at (" + dx + ", " + dy + ")");
			}
		}
		
		pcX += dx;
		pcY += dy;
	}
	
	private char getChar() {
		int y = Math.abs(pcY % program.length);
		int x = Math.abs(pcX % program[y].length);

		return program[y][x];
	}
	
	private char getCharFromUser() {
		System.out.println("Enter a single char then press enter");
		String str = scanner.next();
		
		if (str.length() != 1) {
			System.out.println("You fool. Enter a single character. You get 'x' because of this.");
			return 'x';
		}
		
		return str.charAt(0);
	}
	
	private int getIntFromUser() {
		System.out.println("Enter an integer then press enter");
		return scanner.nextInt();
	}
	
	private void setRandDir() {
		int r = random.nextInt(4);

		setDir(Dir.values()[r]);
	}
	
	private void setDir(Dir dir) {
		dx = dir.dx;
		dy = dir.dy;
	}
	
	private enum Dir {
		Up(0, -1),
		Down(0, 1),
		Left(-1, 0),
		Right(1, 0);
		
		public final int dx;
		public final int dy;
		
		Dir(int dx, int dy) {
			this.dx = dx;
			this.dy = dy;
		}
	}
}
