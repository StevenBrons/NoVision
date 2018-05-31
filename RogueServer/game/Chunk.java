import java.io.Serializable;

public class Chunk implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int SIZE = 64;
	
	private int chunkX = 0;
	private int chunkY = 0;
	
	private Obj[][] objects = new Obj[64][64];
	
	public Chunk(int chunkX,int chunkY) {
		this.chunkX = chunkX;
		this.chunkY = chunkY;
		clear();
	}
	
	private void clear() {
		for (int x = 0; x < objects.length; x++) {
			for (int y = 0; y < objects[x].length; y++) {
				objects[x][y] = new Null();
			}	
		}
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
	
	public int getX() {
		return chunkX;
	}

	public int getY() {
		return chunkY;
	}

	public void update() {
		for (int x = 0; x < objects.length; x++) {
			for (int y = 0; y < objects[x].length; y++) {
				objects[x][y].update();
			}	
		}
	}
	
}