package game;

import transfer.P;

public class Game {

	private World world = new World();
	private P player;
	
	public Game() {
	}
	
	public World getWorld() {
		return world;
	}
	
	public void setPlayer(P o) {
		this.player = o;
	}
	
	public P getPlayer() {
		return player;
	}
	
}