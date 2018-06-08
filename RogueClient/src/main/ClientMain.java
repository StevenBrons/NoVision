package main;
import game.Game;
import transfer.L;

public class ClientMain {

	private static Game game = new Game();
	private static Frame frame = new Frame();
	private static Connection connection = new Connection();

	public static void main(String[] args) {
		getConnection().output(new L());
	}

	public static void output(String string) {
		frame.setTitle(string);
	}
	
	public static Game getGame() {
		return game;
	}
	
	public static Frame getFrame() {
		return frame;
	}

	public static Connection getConnection() {
		return connection;
	}


}
