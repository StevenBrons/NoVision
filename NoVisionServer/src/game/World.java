package game;

import java.util.ArrayList;

import objects.Null;
import objects.Obj;
import transfer.C;

public class World {

	private ArrayList<Chunk> chunks = new ArrayList<>();
	private static final int WIDTH = 2; //amount of chunks the world is wide, must be capt in sync with client world
	private static final int HEIGHT = 2; //amount of chunks the world is heigh, must be capt in sync with client world
	
	public World() {
		for (int x = 0; x < WIDTH; x++) {
			for (int y = 0; y < HEIGHT; y++) {
				Chunk c = new Chunk(x,y);
				chunks.add(c);
			}
		}
		
	}

	private int wrapX(int x) {
		return Math.floorMod(x, WIDTH * Chunk.SIZE);
	}
	
	private int wrapY(int y) {
		return Math.floorMod(y, HEIGHT * Chunk.SIZE);
	}
	
	public Obj getObjectAt(int xx, int yy) {
		int x = wrapX(xx);
		int y = wrapY(yy);
		for (Chunk c : chunks) {
			if (toChunkPos(x) == c.getX() && toChunkPos(y) == c.getY()) {
				return c.getObjectAt(x, y);
			}
		}
		return new Null();
	}

	public void setObjectAt(Obj obj, int xx, int yy) {
		int x = wrapX(xx);
		int y = wrapY(yy);
		for (Chunk c : chunks) {
			if (toChunkPos(x) == c.getX() && toChunkPos(y) == c.getY()) {
				c.setObjectAt(obj, x, y);
			}
		}
	}

	public void update() {
		chunks.forEach((c) -> {
			c.update();
		});
	}

	public Chunk getChunkAt(int x, int y) {
		for (Chunk c : chunks) {
			if (Math.floorMod(toChunkPos(x),WIDTH) == c.getX() && Math.floorMod(toChunkPos(y),HEIGHT) == c.getY()) {
				return c;
			}
		}
		return new Chunk(toChunkPos(x), toChunkPos(y));
	}

	private int toChunkPos(int i) {
		return (int) Math.floor(i / (double) C.SIZE);
	}

	public void swapObjectsAt(int xx, int yy, int xx2, int yy2) {
		int x = wrapX(xx);
		int y = wrapX(yy);
		int x2 = wrapX(xx2);
		int y2 = wrapX(yy2);
		System.out.println("swap" + x + "," + y + "," + x2 + "," + y2);
		Obj temp = getObjectAt(x, y);
		setObjectAt(getObjectAt(x2, y2), x, y);
		setObjectAt(temp, x2, y2);
	}

	public void clearChanges() {
		for (Chunk chunk : chunks) {
			chunk.clearChanges();
		}		
	}

}