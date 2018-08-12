package transfer;

/*
 * This class is used to transfer player data
 * it is a simplified version of the Player class
*/

public class P extends O {


	private static final long serialVersionUID = 1L;

	private A[] actions;
	
	public P(char display,int x, int y,A[] actions) {
		super(display, x, y);
		this.actions = actions;
	}

	public A[] getActions() {
		return actions;
	}

}
