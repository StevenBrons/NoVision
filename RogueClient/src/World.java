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
	
}
