package manager;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import interfaces.IController;

public class SensorManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Registry registro = LocateRegistry.getRegistry();
			IController controller = (IController)registro.lookup("controller");

			Sensor[] threads = new Sensor[10];
			
			for(Sensor s : threads) {
				s = new Sensor(controller);
				s.start();
			}
		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
