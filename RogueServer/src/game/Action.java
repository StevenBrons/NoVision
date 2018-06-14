package game;

import java.util.HashMap;

import objects.Obj;
import transfer.A;
import transfer.T;
import transfer.U;

public interface Action {

	public String getTitle();

	public default String getDescription() {
		return "";
	}

	public default T invoke(Obj executor, World world) {
		if (Math.random() < getSuccessChance()) {
			T result = resolve(executor,world);
			if (result != null) {
				return result;
			}else {
				return new U("Success","");
			}
		} else {
			T result = reject(executor,world);
			if (result != null) {
				return result;
			}else {
				return new U("Failure","");
			}
		}
	}

	public default float getSuccessChance() {
		return 1;
	}

	public T resolve(Obj executor, World world);

	public T reject(Obj executor, World world);

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
