package eser_rmi1.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class GestoreServer {

	public static void main(String[] args) {
		Registry registro;

		try {
			registro = LocateRegistry.getRegistry();
			IGestoreSportello gestore = new GestoreSportello();
			registro.rebind("gestore", gestore);
			System.out.println("[GestoreServer] Gestore started ");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
