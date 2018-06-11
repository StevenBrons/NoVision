package objects;

import java.util.ArrayList;

import game.Action;
import game.Chunk;
import game.World;
import main.Client;
import main.ServerMain;
import transfer.A;
import transfer.O;
import transfer.P;

public class Player extends Entity {

	private static final int MAX_CHUNKS = 9;
	private Client client;
	private ArrayList<Chunk> chunksInViewPort = new ArrayList<>();

	public Player(Client client) {
		this.client = client;
		this.addAction("openInventory", new Action() {
			
			@Override
			public void resolve(Obj executor) {
				
			}
			
			@Override
			public void reject(Obj executor) {
			}
			
			@Override
			public String getTitle() {
				return "Open inventory";
			}
		});
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

	public void execute(String name, String... args) {
		getActions().get(name).invoke(this, args);
	}

	@Override
	public O toClientObject() {
		return new P(getDisplay(), getX(), getY(), Action.getClientActions(getActions()));
	}

	public void execute(A action) {
		getActions().get(action.getName()).invoke(this);
	}

	public void updateChunksInViewPort(World world) {
		for (int x = -1; x < 2; x++) {
			for (int y = -1; y < 2; y++) {
				Chunk c = world.getChunkAt(this.getX() + x * Chunk.SIZE, this.getY() + y * Chunk.SIZE);
				if (!chunksInViewPort.contains(c)) {
					chunksInViewPort.add(c);
					client.output(c.toClientChunk());
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

}
