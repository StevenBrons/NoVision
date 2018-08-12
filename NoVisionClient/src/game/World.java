package game;

import java.util.ArrayList;

import transfer.C;
import transfer.O;

public class World {

	private static ArrayList<C> chunks = new ArrayList<>();
	private static final int MAX_CHUNKS = 9;
	private static final int WIDTH = 2;
	private static final int HEIGHT = 2;


	public static void setChunk(C chunk) {
		for (int i = 0; i < chunks.size(); i++) {
			if (chunks.get(i).getX() == chunk.getX() && chunks.get(i).getY() == chunk.getY()) {
				chunks.set(i, chunk);
				return;
			}
		}
		chunks.add(chunk);
		if (chunks.size() > MAX_CHUNKS) {
			chunks.remove(0);
		}
	}
	
	private int wrapX(int x) {
		return Math.floorMod(x, WIDTH * Chunk.SIZE);
	}
	
	private int wrapY(int y) {
		return Math.floorMod(y, HEIGHT * Chunk.SIZE);
	}

	public O getObjectAt(int xx, int yy) {
		int x = wrapX(xx);
		int y = wrapY(yy);
		for (C c : chunks) {
			if (toChunkPos(x) == c.getX() && toChunkPos(y) == c.getY()) {
				return c.getObjectAt(x, y);
			}
		}
		return new O((char) '!', x, y);
	}

	public static int toChunkPos(int i) {
		return (int) Math.floor(i / (double) C.SIZE);
	}

	public void setObjectAt(O obj, int xx, int yy) {
		int x = wrapX(xx);
		int y = wrapY(yy);
		for (C c : chunks) {
			if (toChunkPos(x) == c.getX() && toChunkPos(y) == c.getY()) {
				c.setObjectAt(obj, x, y);
			}
		}
	}

}
