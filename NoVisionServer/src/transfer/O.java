package transfer;

/*
 * This class is used to transfer object data
 * it is a simplified version of the Object class
*/

public class O extends T {

	private static final long serialVersionUID = 1L;

	private int x;
	private int y;

	private char display;

	public O(char display,int x, int y) {
		this.display = display;
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public char getDisplay() {
		return display;
	}

}
