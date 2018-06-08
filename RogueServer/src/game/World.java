package game;

import java.util.ArrayList;

import objects.Null;
import objects.Obj;

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
			if (Math.floor(x / Chunk.SIZE) == c.getX() && Math.floor(y / Chunk.SIZE) == c.getY()) {
				return c.getObjectAt(x, y);
			}
		}
		return new Null();
	}
	
	public void setObjectAt(Obj obj,int x, int y) {
		for (Chunk c : chunks) {
			if (Math.floor(x / Chunk.SIZE) == c.getX() && Math.floor(y / Chunk.SIZE) == c.getY()) {
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
			if (Math.floor(x / Chunk.SIZE) == c.getX() && Math.floor(y / Chunk.SIZE) == c.getY()) {
				return c;
			}
		}
		return new Chunk((int) Math.floor(x / Chunk.SIZE), (int) Math.floor(y / Chunk.SIZE));
	}

}