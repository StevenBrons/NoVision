package objects;
import game.Action;
import transfer.T;
import transfer.U;

public class Entity extends Obj {

	public Entity() {
		addMoveActions();
	}

	private void addMoveActions() {
		addAction("moveNorth", new Action() {

			@Override
			public String getTitle() {
				return "Move north";
			}

			@Override
			public T resolve(Obj executor) {
				return null;
			}

			@Override
			public float getSuccessChance() {
				return 0.5f;
			}

			@Override
			public T reject(Obj executor) {
				return null;
			}
		});

		addAction("moveEast", new Action() {

			@Override
			public String getTitle() {
				return "Move east";
			}

			@Override
			public T resolve(Obj executor) {
				return null;
			}

			@Override
			public T reject(Obj executor) {
				return null;
			}
		});

		addAction("moveSouth", new Action() {

			@Override
			public String getTitle() {
				return "Move south";
			}

			@Override
			public T resolve(Obj executor) {
				return null;
			}

			@Override
			public T reject(Obj executor) {
				return null;
			}
		});

		addAction("moveWest", new Action() {

			@Override
			public String getTitle() {
				return "Move west";
			}

			@Override
			public T resolve(Obj executor) {
				return null;
			}

			@Override
			public T reject(Obj executor) {
				return null;
			}
		});
	}

}
