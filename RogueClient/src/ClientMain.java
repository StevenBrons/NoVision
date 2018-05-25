
public class ClientMain {

	static Game game = new Game();
	static Frame frame = new Frame();
	static Connection connection = new Connection();

	public static void main(String[] args) {
		connection.output(new Join(Math.floor(Math.random() * 1000) + ""));
	}

}
