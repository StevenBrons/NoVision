package game;

import objects.Null;

public class Generator {

	public Generator() {
	}
	
	public World generateWorld() {
		
		World world = new World();
		
		for (int i = -1; i < 2;i++) {
			for (int j = -1; j < 2;j++) {
				Chunk c = new Chunk(i,j);
				world.setChunk(c);
			}
		}
		
		for (int a = 0; a < 5; a++) {
			for (int b = 0; b < 5; b++) {
				world.setObjectAt(new Null(), a, b);
			}
		}
		
		return world;
		
	}
	
}
