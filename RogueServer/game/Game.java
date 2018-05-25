import java.util.ArrayList;

public class Game {

	private ArrayList<Player> players = new ArrayList<>();
	
	public void start() {

		if (ServerMain.server.getClientAmount() == 1) {
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
				}
			});
			t.start();
		}
	}

	public void addPlayer(Player player) {
		
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}

}
