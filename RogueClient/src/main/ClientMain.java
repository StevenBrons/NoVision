package main;
import connection.Connection;
import connection.Join;
import game.Game;

public class ClientMain {

	private static Game game = new Game();
	private static Frame frame;
	private static Connection connection = new Connection();

	public static void main(String[] args) {
		getConnection().output(new Join());
		frame = new Frame();
	}

	public static void output(String string) {
		frame.setTitle(string);
	}
	
	public static Game getGame() {
		return game;
	}

	public static Connection getConnection() {
		return connection;
	}


}
