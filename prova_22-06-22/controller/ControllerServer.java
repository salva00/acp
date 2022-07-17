package controller;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import interfaces.IController;

public class ControllerServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Registry registro = LocateRegistry.getRegistry();
			IController controller = new ControllerImpl();
			registro.rebind("controller", controller);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
