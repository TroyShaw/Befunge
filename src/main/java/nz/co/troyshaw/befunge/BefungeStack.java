package nz.co.troyshaw.befunge;

public class BefungeStack {
    final StringBuilder sb = new StringBuilder();

    public void push(char ch) {
        sb.append(ch);
    }
    
    public void push(int i) {
    	char c = (char) i;
    	
    	if (c != i) {
    		//System.out.println("Warning: tried to push an int to char-stack which would overflow: " + i);
    	}
    	
    	push(c);
    }

    /**
     * Pops the last character that was pushed to the stack.
     * If the stack is empty, this simply returns 0 and throws
     * no error.
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
