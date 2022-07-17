package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import interfaces.IPrinter;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Registry registro = LocateRegistry.getRegistry();
			IPrinter printer = new Printer();
			registro.rebind(args[0], printer);
			System.out.println("[SERVER]:	started!");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
