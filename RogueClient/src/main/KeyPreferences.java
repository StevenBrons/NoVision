package main;
import java.awt.event.KeyEvent;

public class KeyPreferences {
	
	static KeyPreference[] preferences = {
		new KeyPreference("moveNorth", KeyEvent.VK_W),
		new KeyPreference("moveEast", KeyEvent.VK_D),
		new KeyPreference("moveSouth", KeyEvent.VK_S),
		new KeyPreference("moveWest", KeyEvent.VK_A)
	};
	
	public static String getAction(int keyCode) {
		for(KeyPreference pref:preferences) {
			if (pref.getKeyCode() == keyCode) {
				return pref.getAction();
			}
		}
		return null;
	}
	
	public static int getKeyCode(String action) {
		for(KeyPreference pref:preferences) {
			if (pref.getAction().equals(action)) {
				return pref.getKeyCode();
			}
		}
		return -1;
	}
	
}

class KeyPreference {
	
	private String action;
	private int keyCode;
	
	public KeyPreference(String action,int keyCode) {
		this.action = action;
		this.keyCode = keyCode;
	}

	public int getKeyCode() {
		return keyCode;
	}

	public String getAction() {
		return action;
	}
	
}