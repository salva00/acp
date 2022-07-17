package client;

import java.util.ArrayList;

import dispatcher.IDispatcher;

public class Client {
	
	public static void main(String[] args) {
	
		ArrayList<ClientThread> threads = new ArrayList<ClientThread>();
		
		IDispatcher dispatcher = new DispatcherProxy ( "127.0.0.1",2222 );
		
		for(int i = 0; i<5; i++) {
			threads.add(new ClientThread(dispatcher));
		}

	}

}
