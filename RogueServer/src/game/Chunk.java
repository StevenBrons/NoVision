package game;

import java.util.ArrayList;

import objects.Null;
import objects.Obj;
import objects.Stone;
import transfer.C;

public class Chunk{

	public static final int SIZE = 64;
	
	private int chunkX = 0;
	private int chunkY = 0;
	
	private Obj[][] objects = new Obj[64][64];
	private ArrayList<Obj> changes = new ArrayList<>();

	public Chunk(int chunkX,int chunkY) {
		this.chunkX = chunkX;
		this.chunkY = chunkY;
		clear();
	}
	
	private void clear() {
		for (int x = 0; x < objects.length; x++) {
			for (int y = 0; y < objects[x].length; y++) {
				objects[x][y] = new Stone();
				reportChange(x, y);
			}	
		}
	}

	public void setObjectAt(Obj obj, int x, int y) {
		objects[toRelX(x)][toRelY(y)] = obj;
		reportChange(toRelX(x), toRelY(y));
	}

	public Obj removeObject(int x, int y) {
		Obj o = objects[toRelX(x)][toRelY(y)];
		objects[toRelX(x)][toRelY(y)] = new Null();
		reportChange(toRelX(x), toRelY(y));
		return o;
	}

	private int toRelX(int x) {
		return x - (SIZE * getX());
	}
	
	private int toRelY(int y) {
		return y - (SIZE * getY());
	}
	
	public Obj getObjectAt(int x, int y) {
		return objects[toRelX(x)][toRelY(y)];
	}
	
	public int getX() {
		return chunkX;
	}

	public int getY() {
		return chunkY;
	}

	public void update() {
		for (int x = 0; x < objects.length; x++) {
			for (int y = 0; y < objects[x].length; y++) {
				objects[x][y].update();
			}	
		}
	}

	public C toClientChunk() {
		C clientChunk = new C(chunkX, chunkY);
		for (int x = 0; x < objects.length; x++) {
			for (int y = 0; y < objects[x].length; y++) {
				clientChunk.setObjectAt(objects[x][y].toClientObject(), x + getX() * SIZE, y + getY() * SIZE);
			}	
		}
		return clientChunk;
	}

	private void reportChange(int x, int y) {
		System.out.println("Report: " + x + "-=" + y);
		try {
			objects[x][y].setX(x + (SIZE * getX()));
		} catch (Exception e) {
		}
		try {
			objects[x][y].setY(y + (SIZE * getY()));
		} catch (Exception e) {
		}
		changes.add(objects[x][y]);
	}
	
	public ArrayList<Obj> getChanges() {
		return changes;
	}

	public void clearChanges() {
		changes.clear();
	}
	
}