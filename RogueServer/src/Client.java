import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

import javax.swing.ButtonGroup;

public class Client {

	private ObjectInputStream in;
	private ObjectOutputStream out;
	Player player = null;

	public Client(Socket socket) {
		try {
			this.in = new ObjectInputStream(socket.getInputStream());
			this.out = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						input(in.readObject());
					} catch (IOException e) {
						System.out.println(e);
						try {
							if (player != null) {
								player.destroy(); 
							}
							in.close();
							out.close();
							socket.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						break;
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t.start();
		ServerMain.game.start();
	}

	public void input(Object o) {
		switch (o.getClass().getName()) {
		case "Join":
			Join join = (Join) o;
			player = new Player();
			player.client = this;
			ServerMain.game.addPlayer(player);
			output(player);
			output(new Chunk(0,0));
			break;
		default:
			System.out.println("Unknown input class type: " + o.getClass().getName());
			break;
		}
	}

	public void output(Object o) {
		try {
			out.writeObject(o);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
