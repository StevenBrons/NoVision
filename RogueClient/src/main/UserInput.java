package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import transfer.A;
import transfer.P;

public class UserInput implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		ClientMain.output("Key pressed");
		String action = KeyPreferences.getAction(e.getKeyCode());
		if (action != null) {
			ClientMain.getConnection().output(new A(action,"","",0));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
}
