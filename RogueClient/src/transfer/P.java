package transfer;

import java.io.Serializable;

/*
 * This class is used to transfer player data
 * it is a simplified version of the Player class
*/

public class P extends O implements Serializable {


	private static final long serialVersionUID = 1L;

	private int x;
	private int y;
	private char display = (char) 0;
	private A[] actions;
	
	public P(char display,int x, int y,A[] actions) {
		super(display, x, y);
		this.actions = actions;
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

	public A[] getActions() {
		return actions;
	}

}
