package nz.co.troyshaw.befunge;

/**
 * Implementation of a char-stack for Befunge which implements
 * Befunge's stack semantics.
 * 
 * @author troys
 */
public class BefungeStack {

	private StringBuilder sb = new StringBuilder();

	public void push(char ch) {
		sb.append(ch);
	}

	public void push(int i) {
		push((char) i);
	}

	/**
	 * Pops the last character that was pushed to the stack. 
	 * If the stack is empty, this simply returns 0 and throws no error.
	 *
	 * @return the last value on the stack, or 0 if the stack is empty
	 */
	public char pop() {
		int last = sb.length() - 1;

		if (last == -1) {
			return 0;
		} else {
			char ch = sb.charAt(last);
			sb.setLength(last);

			return ch;
		}
	}
}
