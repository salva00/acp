package observer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import interfaces.IDispatcher;
import interfaces.IObserver;

public class ObserverClient {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Registry registro;
		try {
			registro = LocateRegistry.getRegistry();
			IDispatcher dispatcher = (IDispatcher) registro.lookup("dispatcher");

			System.out.println("[OBS_CLIENT] started");
			
			IObserver obs = new ObserverImpl(dispatcher);
			
			dispatcher.attach(obs,"temperatura");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
