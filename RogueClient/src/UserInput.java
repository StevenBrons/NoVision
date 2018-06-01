import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class UserInput implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		String action = KeyPreferences.getAction(e.getKeyCode());
		if (action != null) {
			Player p = ClientMain.game.player;
			p.actions.get(action).execute(p);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
}
