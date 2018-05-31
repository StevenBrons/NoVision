import java.util.HashMap;

public class Obj {

	private int x;
	private int y;
	
	private char display = '*';
	
	protected HashMap<String, Action> actions = new HashMap<>();

	public Obj() {
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public char getDisplay() {
		return display;
	}
	
	public boolean isSolid() {
		return false;
	}
}
