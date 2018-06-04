package game;
import main.ClientMain;

public class Player extends Entity{

	private static final long serialVersionUID = 1L;
	
	public Player() {
	}
	
	public void destroy() {
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public void execute(Action action) {
		ClientMain.output("execute");
		ClientMain.getConnection().output(action);
	}
	
}
