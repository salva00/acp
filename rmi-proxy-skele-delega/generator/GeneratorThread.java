package generator;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import interfaces.IAlertNotification;
import interfaces.IManager;

public class GeneratorThread extends Thread {
	
	IAlertNotification a;
	
	public GeneratorThread(IAlertNotification an) {
		// TODO Auto-generated constructor stub
		a = an;
	}
	
	public void run() {
		System.out.println("[GEN] thread startedS");

		try {
			Registry registro = LocateRegistry.getRegistry();
			IManager m = (IManager) registro.lookup("manager");
			m.sendNotification(a);
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
