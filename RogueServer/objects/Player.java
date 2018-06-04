public class Player extends Entity{

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

	public void execute(String name,String...args) {
		getActions().get(name).invoke(this, args);
	}
	
}
