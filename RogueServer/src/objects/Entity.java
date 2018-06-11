package objects;
import game.Action;

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
			public void resolve(Obj executor) {
				System.out.println("RESOLVED");
			}

			@Override
			public float getSuccessChance() {
				return 0.5f;
			}

			@Override
			public void reject(Obj executor) {
				System.out.println("REJECTED");
			}
		});

		addAction("moveEast", new Action() {

			@Override
			public String getTitle() {
				return "Move east";
			}

			@Override
			public void resolve(Obj executor) {
			}

			@Override
			public void reject(Obj executor) {
			}
		});

		addAction("moveSouth", new Action() {

			@Override
			public String getTitle() {
				return "Move south";
			}

			@Override
			public void resolve(Obj executor) {
			}

			@Override
			public void reject(Obj executor) {
			}
		});

		addAction("moveWidth", new Action() {

			@Override
			public String getTitle() {
				return "Move west";
			}

			@Override
			public void resolve(Obj executor) {
			}

			@Override
			public void reject(Obj executor) {
			}
		});
	}

}
