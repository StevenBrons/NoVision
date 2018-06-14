package main;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import objects.Player;
import transfer.A;
import transfer.L;

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
		ServerMain.getGame().start();
	}

	public void input(Object o) {
		switch (o.getClass().getName()) {
		case "transfer.L":
			L login = (L) o;
			player = new Player(this);
			ServerMain.getGame().addPlayer(player);
			output(player.toClientObject());
			break;	
		case "transfer.A":
			player.execute((A) o,ServerMain.getGame().getWorld());
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
