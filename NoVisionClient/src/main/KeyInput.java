package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import transfer.A;

public class KeyInput implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		String actionName = KeyPreferences.getAction(e.getKeyCode());
		if (actionName != null) {
			A action = ClientMain.getGame().getDialog().getActionByName(actionName);
			ClientMain.getConnection().output(action);
		}else {
			int actionIndex = KeyPreferences.getActionIndex(e.getKeyCode());
			if (actionIndex != -1) {
				A action = ClientMain.getGame().getDialog().getActions()[actionIndex];
				ClientMain.getConnection().output(action);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
}
