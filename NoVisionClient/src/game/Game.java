package game;

import transfer.P;
import ui.DialogFeed;

public class Game {

	private World world = new World();
	private P player;
	private DialogFeed dialog = new DialogFeed();

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
	
	public DialogFeed getDialog() {
		return dialog;
	}

	public void start() {
	}

}
