package game;

import java.util.ArrayList;

import objects.Null;
import objects.Obj;
import transfer.C;

public class World {

	private ArrayList<Chunk> chunks = new ArrayList<>();

	public void setChunk(Chunk chunk) {
		for (int i = 0; i < chunks.size(); i++) {
			if (chunks.get(i).getX() == chunk.getX() && chunks.get(i).getY() == chunk.getY()) {
				chunks.set(i, chunk);
				return;
			}
		}
		chunks.add(chunk);
	}

	public Obj getObjectAt(int x, int y) {
		for (Chunk c : chunks) {
			if (toChunkPos(x) == c.getX() && toChunkPos(y) == c.getY()) {
				return c.getObjectAt(x, y);
			}
		}
		return new Null();
	}

	public void setObjectAt(Obj obj, int x, int y) {
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

	public ArrayList<Chunk> getChunks() {
		return chunks;
	}

	public Chunk getChunkAt(int x, int y) {
		for (Chunk c : chunks) {
			if (toChunkPos(x) == c.getX() && toChunkPos(y) == c.getY()) {
				return c;
			}
		}
		return new Chunk(toChunkPos(x), toChunkPos(y));
	}

	public static int toChunkPos(int i) {
		return (int) Math.floor(i / (double) C.SIZE);
	}

	public void swapObjectsAt(int x, int y, int x2, int y2) {
		Obj temp = getObjectAt(x, y);
		setObjectAt(getObjectAt(x2, y2), x, y);
		setObjectAt(temp, x2, y2);
	}

}