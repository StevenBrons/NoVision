package transfer;

/*
 * This class is used to transfer player data
 * it is a simplified version of the Player class
*/

public class P extends O {


	private static final long serialVersionUID = 1L;

	private int x;
	private int y;
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

	public A[] getActions() {
		return actions;
	}

}
