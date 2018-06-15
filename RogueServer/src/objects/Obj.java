package objects;

import java.util.HashMap;

import game.Action;
import game.World;
import transfer.O;
import transfer.T;

public class Obj {

	private int x;
	private int y;

	private HashMap<String, Action> actions = new HashMap<>();

	public Obj() {
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) throws Exception {
		this.x = x;
		throw new Exception("Only the Chunk class is allowed to use this function");
	}

	public void setY(int y) throws Exception {
		this.y = y;
		throw new Exception("Only the Chunk class is allowed to use this function");
	}
	
	public void moveTo(int x, int y, World world) {
		world.swapObjectsAt(getX(),getY(), x, y);
	}

	public char getDisplay() {
		return '*';
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

	public void input(T update) {

	}

	public O toClientObject() {
		return new O(getDisplay(), x, y);
	}
	
	@Override
	public String toString() {
		return "[" + getDisplay() + "] " + getX() + ":" + getY();
	}
	
}
