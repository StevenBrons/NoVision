package objects;

import java.util.ArrayList;
import java.util.HashMap;

import game.Action;
import game.Update;
import game.World;
import transfer.O;
import transfer.T;

public class Obj {

	private int x;
	private int y;

	private HashMap<String, Action> actions = new HashMap<>();
	private ArrayList<Update> updates = new ArrayList<>();

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
	
	public Action[] getCurrentActions() {
		return updates.get(updates.size() - 1).getActions();
	}

	public void addAction(Action action) {
		actions.put(action.getName(), action);
	}

	public Update getPreviousUpdate() {
		return updates.remove(updates.size() - 1);
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
	
	protected void setCurrentUpdate(Update update) {
		updates.add(update);
	}
	
	@Override
	public String toString() {
		return "[" + getDisplay() + "] " + getX() + ":" + getY();
	}
	
}
