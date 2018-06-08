package game;
import java.util.ArrayList;

import transfer.C;
import transfer.O;

public class World {

	private static ArrayList<C> chunks = new ArrayList<>();
	private static final int MAX_CHUNKS = 9;
	
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
	
	public O getObjectAt(int x, int y) {
		for (C c:chunks) {
			if (Math.floor(x / C.SIZE) == c.getX() && Math.floor(y / C.SIZE) == c.getY()) {
				return c.getObjectAt(x, y);
			}
		}
		return new O((char) '!',x,y);
	}
	
}
