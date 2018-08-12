package objects;

import game.Action;
import game.Update;
import game.World;

public class Entity extends Obj {

	public Entity() {
		addMoveActions();
	}

	private void addMoveActions() {	
		
		addAction(new Action() {

			@Override
			public String getName() {
				return "moveNorth";
			}
			
			@Override
			public String getLabel() {
				return "Move north";
			}

			@Override
			public Update resolve(Obj executor, World world) {
				executor.moveTo(executor.getX(), executor.getY() + 1, world);
				
				Action a = new Action() {
					
					@Override
					public String getName() {
						return "test";
					}
					
					@Override
					public Update resolve(Obj executor, World world) {
						return null;
					}
					
					@Override
					public Update reject(Obj executor, World world) {
						return null;
					}
					
					@Override
					public String getLabel() {
						return "test";
					}
				};
				
				return getPreviousUpdate();
			}

			@Override
			public Update reject(Obj executor, World world) {
				return new Update("Move", "You couldn't move north");
			}
			
		});

		addAction(new Action() {

			@Override
			public String getName() {
				return "moveEast";
			}
			
			@Override
			public String getLabel() {
				return "Move east";
			}

			@Override
			public Update resolve(Obj executor, World world) {
				executor.moveTo(executor.getX() + 1, executor.getY(), world);
				return getPreviousUpdate();
			}

			@Override
			public Update reject(Obj executor, World world) {
				return new Update("Move", "You couldn't move east");
			}
		});

		addAction(new Action() {

			@Override
			public String getName() {
				return "moveSouth";
			}
			
			@Override
			public String getLabel() {
				return "Move south";
			}

			@Override
			public Update resolve(Obj executor, World world) {
				executor.moveTo(executor.getX(), executor.getY() - 1, world);
				return getPreviousUpdate();
			}

			@Override
			public Update reject(Obj executor, World world) {
				return new Update("Move", "You couldn't move south");
			}
		});

		addAction(new Action() {

			@Override
			public String getName() {
				return "moveWest";
			}
			
			@Override
			public String getLabel() {
				return "Move west";
			}

			@Override
			public Update resolve(Obj executor, World world) {
				executor.moveTo(executor.getX() - 1, executor.getY(), world);
				return getPreviousUpdate();
			}

			@Override
			public Update reject(Obj executor, World world) {
				return new Update("Move", "You couldn't move west");
			}
		});
	}

}
