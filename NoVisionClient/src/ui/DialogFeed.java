package ui;

import transfer.U;
import game.Action;
import main.KeyPreferences;
import transfer.A;

public class DialogFeed {

	private String title = "";
	private String description = "";
	private A actions[] = new A[0];
	
	
	public void setDialog(U update) {
		title = update.getTitle();
		description = update.getDescription();
		actions = update.getActions();
	}
	
	public char[][] getDialog(int width, int height) {
		char[][] dialog = new char[width][height];
		
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				dialog[x][y] = ' ';
			}
		}
		for (int x = 0; x < width; x++) {
			if (x < title.length()) {
				dialog[x][0] = title.charAt(x);
			}else {
				dialog[x][0] = '=';
			}
		}
		for (int x = 0; x < width; x++) {
			if (x < description.length()) {
				dialog[x][1] = description.charAt(x);
			}else {
				dialog[x][1] = ' ';
			}
		}
		for (int i = 0; i < actions.length; i++) {
			dialog[0][i + 2] = KeyPreferences.getKeyFromAction(actions[i].getName(), i);
		}

		
		for (int i = 0; i < actions.length; i++) {
			for (int x = 0; x < actions[i].getLabel().length(); x++) {
				dialog[x + 2][i + 2] = actions[i].getLabel().charAt(x);
			}
		}
		
		return dialog;
	}

	public A getActionByName(String name) {
		for (A a: actions) {
			if (a.getName().equals(name)) {
				return a;
			}
		}
		return null;
	}
	
	public A[] getActions() {
		return actions;
	}
	
}
