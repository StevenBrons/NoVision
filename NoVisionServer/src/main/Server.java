package main;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	public static final int SERVER_PORT = 26194;

	private ServerSocket serverSocket;
	private ArrayList<Client> clients = new ArrayList<>();
	
	public Server() {
		try {
			serverSocket = new ServerSocket(SERVER_PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void start() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				runServer();
			}
		});
		t.start();
	}
	
	public void runServer() {
		System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
		while (true) {
			try {
				Socket socket = serverSocket.accept();
				clients.add(new Client(socket));
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public int getClientAmount() {
		return clients.size();
	}

}
