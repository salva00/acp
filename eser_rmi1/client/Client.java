package eser_rmi1.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.IGestoreSportello;

public class Client {
	public static void main (String[] args) {
		final int T = 10;
		final int R = 10;
		
		try {
			Registry registro = LocateRegistry.getRegistry();
			IGestoreSportello gestore = (IGestoreSportello) registro.lookup("gestore");
			
			ClientThread[] threads = new ClientThread[T];
			
			for (ClientThread th: threads) {
				th = new ClientThread(R, gestore);
				th.start();
			}
			
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
