package actuator;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import interfaces.IController;

public class Actuator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Registry registro;
		try {
			registro = LocateRegistry.getRegistry();
			IController controller = (IController)registro.lookup("controller");
			ActuatorImpl sk = new ActuatorImpl(Integer.parseInt(args[0]),args[1]);
			controller.addActuator(Integer.parseInt(args[0]));
			sk.runSkeleton();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
