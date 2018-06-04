package game;

public class Game {

	private World world = new World();
	private Player player;
	
	public Game() {
	}
	
	public World getWorld() {
		return world;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return player;
	}
	
}
