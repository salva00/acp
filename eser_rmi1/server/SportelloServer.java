package eser_rmi1.server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class SportelloServer {

	public static void main (String[] args) {
		
		try {
			
			Registry registro = LocateRegistry.getRegistry();
			IGestoreSportello gestore = (IGestoreSportello) registro.lookup("gestore");
			
			ISportello sportello = new Sportello();
			gestore.sottoscrivi(sportello);
			
			System.out.println("[SportelloServer] Sottoscritto sportello al gestore");
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
