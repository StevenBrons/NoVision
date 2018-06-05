package main;
import game.Game;

public class ServerMain {

	static private Server server = new Server();
	static private Game game = new Game();
	
	public static void main(String args[]) {
		server.start();
	}

	public static Game getGame() {
		return game;
	}

	public static Server getServer() {
		return server;
	}
	
}
