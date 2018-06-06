package game;

public class Generator {

	public Generator() {
	}
	
	public World generateWorld() {
		
		World world = new World();
		
		for (int x = -1; x < 2;x++) {
			for (int y = -1; y < 2;y++) {
				Chunk c = new Chunk(x,y);
				world.setChunk(c);
			}
		}
		
		return world;
		
	}
	
}
