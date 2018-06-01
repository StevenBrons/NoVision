import java.io.Serializable;
import java.util.HashMap;

public class Obj implements Serializable{

	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	
	private char display = (char) 0;
	
	private HashMap<String, Action> actions = new HashMap<>();

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
	
	public HashMap<String, Action> getActions() {
		return actions;
	}
	
	public boolean isSolid() {
		return false;
	}

	public void update() {
	}
}
