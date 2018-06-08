package game;

import main.ClientMain;
import transfer.P;

public class Game {

	private World world;
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

	public void run() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					ClientMain.getFrame().getScreen().makeAll();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}

}
