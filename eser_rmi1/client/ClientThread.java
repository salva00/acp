package eser_rmi1.client;

import java.rmi.RemoteException;

import server.IGestoreSportello;

public class ClientThread extends Thread {
	private int requests;
	private IGestoreSportello gestore;
	
	public ClientThread(int requests, IGestoreSportello gestore) {
		this.requests = requests;
		this.gestore = gestore;
	}
	
	public void run(){
		for(int i = 0; i < requests; i++) {
			int rand = 1 + (int )(Math.random()*3);
			try {
				sleep(rand * 1000);
				int idCliente = 1 + (int )(Math.random()*100);
				boolean risultato = gestore.sottoponiRichiesta(idCliente);
				System.out.println("[ClientThread] Status request: " + risultato);
			} catch (InterruptedException | RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
