public class Player{

	private int x = 0;
	private int y = 0;
	private Client client;
	
	public Player(Client client) {
		this.client = client;
	}

	public void destroy() {
		ServerMain.game.getPlayers().remove(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
}
