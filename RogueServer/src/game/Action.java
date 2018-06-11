package game;

import java.util.HashMap;

import objects.Obj;
import transfer.A;

public interface Action {

	public String getTitle();

	public default String getDescription() {
		return "";
	}

	public default void invoke(Obj executor, String... args) {
		if (Math.random() < getSuccessChance()) {
			resolve(executor);
		} else {
			reject(executor);
		}
	}

	public default float getSuccessChance() {
		return 1;
	}

	public void resolve(Obj executor);

	public void reject(Obj executor);

	public static A[] getClientActions(HashMap<String, Action> actions) {
		A[] acs = new A[actions.size()];
		int i = 0;
		for (Action a: actions.values()) {
			acs[i] = a.toClientAction((String) actions.keySet().toArray()[i]);
			i++;
		}
		return acs;
	}

	public default A toClientAction(String name) {
		return new A(name,getTitle(), getDescription(), getSuccessChance());
	}
}
