package game;

import java.util.ArrayList;

import main.ServerMain;
import objects.Obj;
import objects.Player;

public class Game {

	private ArrayList<Player> players = new ArrayList<>();
	private World world;

	public Game() {
		Generator g = new Generator();
		this.world = g.generateWorld();
	}

	public void start() {
		if (ServerMain.getServer().getClientAmount() == 1) {
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					while (ServerMain.getServer().getClientAmount() > 0) {
						update();
						emit();
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			});
			t.start();
		}
	}

	public void update() {
		world.update();
	}

	public void emit() {
		for (Player player : players) {
			for (Chunk chunk : player.getChunksInViewPort()) {
				for (Obj obj : chunk.getChanges()) {
					player.getClient().output(obj.toClientObject());
				}
			}
		}
		for (Chunk chunk : world.getChunks()) {
			chunk.clearChanges();
		}

	}

	public void addPlayer(Player player) {
		world.setObjectAt(player, 0, 0);
		players.add(player);
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

}
