package objects;

import game.Action;
import game.World;
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
			public T resolve(Obj executor, World world) {
				executor.moveTo(executor.getX(), executor.getY() + 1, world);
				return new U("Move", "You moved north");
			}

			@Override
			public T reject(Obj executor, World world) {
				return new U("Move", "You couldn't move north");
			}
		});

		addAction("moveEast", new Action() {

			@Override
			public String getTitle() {
				return "Move east";
			}

			@Override
			public T resolve(Obj executor, World world) {
				executor.moveTo(executor.getX() + 1, executor.getY(), world);
				return new U("Move", "You moved east");
			}

			@Override
			public T reject(Obj executor, World world) {
				return new U("Move", "You couldn't move east");
			}
		});

		addAction("moveSouth", new Action() {

			@Override
			public String getTitle() {
				return "Move south";
			}

			@Override
			public T resolve(Obj executor, World world) {
				executor.moveTo(executor.getX(), executor.getY() - 1, world);
				return new U("Move", "You moved south");
			}

			@Override
			public T reject(Obj executor, World world) {
				return new U("Move", "You couldn't move south");
			}
		});

		addAction("moveWest", new Action() {

			@Override
			public String getTitle() {
				return "Move west";
			}

			@Override
			public T resolve(Obj executor, World world) {
				executor.moveTo(executor.getX() - 1, executor.getY(), world);
				return new U("Move", "You moved west");
			}

			@Override
			public T reject(Obj executor, World world) {
				return new U("Move", "You couldn't move west");
			}
		});
	}

}
