package objects;

import java.util.ArrayList;

import game.Action;
import game.Chunk;
import game.Update;
import game.World;
import main.Client;
import main.ServerMain;
import transfer.A;
import transfer.O;
import transfer.P;
import transfer.T;

public class Player extends Entity {

	private static final int MAX_CHUNKS = 9;
	private Client client;
	private ArrayList<Chunk> chunksInViewPort = new ArrayList<>();
	private ArrayList<T> changes = new ArrayList<>();
	
	public Player(Client client) {
		this.client = client;
		this.addAction(new Action() {
			
			@Override
			public String getName() {
				return "openInventory";
			}
			
			@Override
			public Update resolve(Obj executor,World world) {
				return new Update("Open inventory", "joehoe");
			}
			
			@Override
			public Update reject(Obj executor,World world) {
				return null;
			}
			
			@Override
			public String getLabel() {
				return "Open inventory";
			}
		});
		setUpdate(new Update("Main menu", "", getActions().values().toArray(new Action[getActions().size()])));
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void destroy() {
		ServerMain.getGame().getPlayers().remove(this);
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public char getDisplay() {
		return 'P';
	}
	
	@Override
	public O toClientObject() {
		return new P(getDisplay(), getX(), getY(), Action.getClientActions(getActions()));
	}

	public void execute(A action,World world) {
		Action actionToInvoke = null;
		for (int i = 0; i < getCurrentActions().length; i++) {
			if (getCurrentActions()[i].getName().equals(action.getName())) {
				actionToInvoke = getCurrentActions()[i];
			}
		}
		Update update = actionToInvoke.invoke(this,world);
		changes.add(update.toClientObject());
		setUpdate(update);
	}

	public void updateChunksInViewPort(World world) {
		for (int x = -1; x < 2; x++) {
			for (int y = -1; y < 2; y++) {
				Chunk c = world.getChunkAt(this.getX() + x * Chunk.SIZE, this.getY() + y * Chunk.SIZE);
				if (!chunksInViewPort.contains(c)) {
					chunksInViewPort.add(c);
					changes.add(c.toClientChunk());
					if (chunksInViewPort.size() > MAX_CHUNKS) {
						chunksInViewPort.remove(0);
					}
				}
			}
		}
		
	}

	public ArrayList<Chunk> getChunksInViewPort() {
		return chunksInViewPort;
	}

	public ArrayList<T> getChanges() {
		return changes;
	}

	public void setUpdate(Update update) {
		changes.add(update.toClientObject());
		setCurrentUpdate(update);
	}
	
	public void clearChanges() {
		changes.clear();
	}

}
