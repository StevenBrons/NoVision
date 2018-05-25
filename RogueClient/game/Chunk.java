import java.io.Serializable;

public class Chunk implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int chunkX = 0;
	public int chunkY = 0;
	
	public int getX() {
		return chunkX;
	}

	public int getY() {
		return chunkY;
	}
	
}
