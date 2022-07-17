package client;

import java.util.ArrayList;

import server.IMagazzino;

public class ClientA {

	public static void main(String[] args) {
		ArrayList<ClientThread> threads = new ArrayList<ClientThread>();
		
		IMagazzino magazzino = new MagazzinoProxy ( "127.0.0.1", 2222);
		
		for(int i = 0; i<5; i++) {
			threads.add(new ClientThread(magazzino, "deposita"));
		}
	}
}
