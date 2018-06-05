package main;
import connection.Connection;
import game.Game;
import transfer.L;

public class ClientMain {

	private static Game game = new Game();
	private static Frame frame;
	private static Connection connection = new Connection();

	public static void main(String[] args) {
		getConnection().output(new L());
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
