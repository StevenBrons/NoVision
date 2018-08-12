package game;

import java.util.ArrayList;

import main.ServerMain;
import objects.Obj;
import objects.Player;
import transfer.B;
import transfer.T;

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

	public World getWorld() {
		return world;
	}
	
	public void emit() {
		for (Player player : players) {
			B bundle = new B();
			for (Chunk chunk : player.getChunksInViewPort()) {
				for (Obj obj : chunk.getChanges()) {
					bundle.addT(obj.toClientObject());
				}
			}
			for (T update:player.getChanges()) {
				bundle.addT(update);
			}
			player.clearChanges();
			if (bundle.getBundle().length != 0) {
				player.getClient().output(bundle);
			}
		}
		world.clearChanges();

	}

	public void addPlayer(Player player) {
		world.setObjectAt(player, 0, 0);
		players.add(player);
		player.updateChunksInViewPort(world);
		start();
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

}
