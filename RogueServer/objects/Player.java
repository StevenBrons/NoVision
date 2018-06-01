public class Player extends Obj{

	private transient Client client;
	
	
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
