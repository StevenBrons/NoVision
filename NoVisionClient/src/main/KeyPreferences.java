package main;

import java.awt.event.KeyEvent;

public class KeyPreferences {

	static KeyPreference[] preferences = { new KeyPreference("openInventory", KeyEvent.VK_I),
			new KeyPreference("moveNorth", KeyEvent.VK_W), new KeyPreference("moveEast", KeyEvent.VK_D),
			new KeyPreference("moveSouth", KeyEvent.VK_S), new KeyPreference("moveWest", KeyEvent.VK_A) };

	static int[] defaultList = { KeyEvent.VK_H, KeyEvent.VK_I, KeyEvent.VK_J, KeyEvent.VK_K, };

	public static String getAction(int keyCode) {
		for (KeyPreference pref : preferences) {
			if (pref.getKeyCode() == keyCode) {
				return pref.getAction();
			}
		}
		return null;
	}

	public static int getActionIndex(int keyCode) {
		for (int i = 0; i < defaultList.length; i++) {
			if (defaultList[i] == keyCode) {
				return i;
			}
		}
		return -1;
	}
	
	public static int getKeyCode(String action) {
		for (KeyPreference pref : preferences) {
			if (pref.getAction().equals(action)) {
				return pref.getKeyCode();
			}
		}
		return -1;
	}
	
	public static char getKeyFromAction(String action,int index) {
		for (KeyPreference k: preferences) {
			if (k.getAction().equals(action)) {
				return (char) k.getKeyCode();
			}
		}
		return (char) defaultList[index];
	}

}

class KeyPreference {

	private String action;
	private int keyCode;

	public KeyPreference(String action, int keyCode) {
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