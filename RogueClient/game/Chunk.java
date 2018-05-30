import java.io.Serializable;
import java.util.ArrayList;

public class Chunk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int SIZE = 64;

	private int chunkX = 0;
	private int chunkY = 0;

	private Obj[][] objects = new Obj[64][64];

	public int getX() {
		return chunkX;
	}

	public int getY() {
		return chunkY;
	}

	public void setObjectAt(Obj obj, int x, int y) {
		int relX = x - (SIZE * x);
		int relY = y - (SIZE * y);
		objects[relX][relY] = obj;
	}

	public Obj removeObject(int x, int y) {
		int relX = x - (SIZE * x);
		int relY = x - (SIZE * y);
		Obj o = objects[relX][relY];
		objects[relX][relY] = null;
		return o;
	}

	public Obj getObjectAt(int x, int y) {
		return objects[x][y];
	}

}
