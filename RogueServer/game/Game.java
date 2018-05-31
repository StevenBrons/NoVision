import java.util.ArrayList;

public class Game {

	private ArrayList<Player> players = new ArrayList<>();
	private World world;
	
	public Game() {
		Generator g = new Generator();
		this.world = g.generateWorld(); 
	}
	
	public void start() {
		if (ServerMain.server.getClientAmount() == 1) {
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					while (ServerMain.server.getClientAmount() > 0) {
						update();
					}
				}
			});
			t.start();
		}
	}

	public void update() {
		world.update();
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}

}
