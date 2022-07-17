package server;

import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
	public static void main(String[] args) {
		
		try {
			Registry registro = LocateRegistry.getRegistry();
			IService service = new Service();
			registro.rebind("service", service);
			System.out.println("[SERVER]:	started!");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
