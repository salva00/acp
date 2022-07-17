package dispatcher;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DispatcherServer {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("[DISP]	start");
		try {
			Dispatcher disp = new Dispatcher();
			Registry registro = LocateRegistry.getRegistry();
			registro.rebind("dispatcher", disp);
			System.out.println("[DISP]	running...");

			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
