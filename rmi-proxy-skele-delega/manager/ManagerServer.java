package manager;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import interfaces.IManager;

public class ManagerServer {

	public static void main(String[] args) {
		try {
			Registry registro = LocateRegistry.getRegistry();
			IManager manager = new ManagerImpl();
			registro.rebind("manager", manager);
			
			System.out.println("[MAN] started");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
