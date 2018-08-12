package game;

import objects.Obj;
import transfer.A;
import transfer.U;

public class Update {

	private String title;
	private String description;
	private Action[] actions;

	public Update(String title, String description, Action[] actions) {
		this.title = title;
		this.description = description;
		this.actions = actions;
	}

	public Update(String title, String description) {
		this.title = title;
		this.description = description;
		this.actions = new Action[] { new Action() {

			@Override
			public Update resolve(Obj executor, World world) {
				return new Update("Main menu", "", executor.getActions().values().toArray(new Action[executor.getActions().size()]));
			}

			@Override
			public Update reject(Obj executor, World world) {
				return null;
			}

			@Override
			public String getName() {
				return "return";
			}

			@Override
			public String getLabel() {
				return "Oke";
			}
		} };
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Action[] getActions() {
		return actions;
	}

	public U toClientObject() {
		A[] a = new A[getActions().length];
		for (int i = 0; i < a.length; i++) {
			a[i] = getActions()[i].toClientAction();
		}
		return new U(getTitle(), getDescription(), a);
	}

}
