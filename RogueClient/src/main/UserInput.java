package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.Player;

public class UserInput implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		ClientMain.output("Key pressed");
		String action = KeyPreferences.getAction(e.getKeyCode());
		if (action != null) {
			Player p = ClientMain.getGame().getPlayer();
			p.execute(p.getActions().get(action));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
}
