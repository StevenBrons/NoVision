package game;

import java.util.HashMap;

import objects.Obj;
import transfer.A;

public interface Action {

	public String getName();
	
	public String getLabel();

	public default Update invoke(Obj executor, World world) {
		if (Math.random() < getSuccessChance()) {
			Update result = resolve(executor,world);
			if (result != null) {
				return result;
			}else {
				return new Update("Success","");
			}
		} else {
			Update result = reject(executor,world);
			if (result != null) {
				return result;
			}else {
				return new Update("Failure","");
			}
		}
	}

	public default float getSuccessChance() {
		return 1;
	}

	public Update resolve(Obj executor, World world);

	public Update reject(Obj executor, World world);

	public default A toClientAction() {
		return new A(getName(),getLabel(), getSuccessChance());
	}

	public static A[] getClientActions(HashMap<String, Action> actions) {
		A[] a = new A[actions.size()];
		for (int i = 0; i < actions.values().toArray().length; i++) {
			a[i] = ((Action)actions.values().toArray()[i]).toClientAction();
		}
		return a;
	}
}
