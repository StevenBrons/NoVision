package game;
import java.util.ArrayList;

public class World {

	private static ArrayList<Chunk> chunks = new ArrayList<>();
	private static final int MAX_CHUNKS = 9;
	
	public static void setChunk(Chunk chunk) {
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
	
	public Obj getObjectAt(int x, int y) {
		for (Chunk c:chunks) {
			if (Math.floor(x / Chunk.SIZE) == c.getX() && Math.floor(y / Chunk.SIZE) == c.getY()) {
				return c.getObjectAt(x, y);
			}
		}
		return new Obj();
	}
	
}
