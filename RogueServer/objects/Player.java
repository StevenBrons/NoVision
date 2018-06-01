public class Player extends Obj{

	private static final long serialVersionUID = 1L;
	public transient Client client;
	
	public Player() {
	}

	public void destroy() {
		ServerMain.game.getPlayers().remove(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
}
