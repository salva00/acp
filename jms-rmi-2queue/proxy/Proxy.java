package proxy;

import java.rmi.registry.Registry;

import server.IService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class Proxy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Registry registro = LocateRegistry.getRegistry();
			IService service  = (IService) registro.lookup("service");
			
			ProxyReceiverThread receiver = new ProxyReceiverThread(service);
			receiver.start();
			
			System.out.println("[PROXY]		started");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
