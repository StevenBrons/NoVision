package objects;
import java.io.Serializable;
import java.util.HashMap;

import game.Action;
import transfer.O;

public class Obj{

	private int x;
	private int y;
	
	private char display;
	
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
	
	public void addAction(String key, Action action) {
		actions.put(key, action);
	}
	
	public boolean isSolid() {
		return false;
	}

	public void update() {
	}
	
	public O toClientObject() {
		return new O(display, x, y);
	}
}
