package subscriber;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import interfaces.IManager;
import interfaces.ISubscriber;

public class SkeletonServer {
	
	public static void main(String[] args) {
		try {
			Registry registro = LocateRegistry.getRegistry();
			IManager m = (IManager) registro.lookup("manager");
			m.subscribe(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
			ISubscriber sub = new SubscriberImpl(args[2]);
			Skeleton s = new Skeleton(sub, Integer.parseInt(args[1]));
			s.runSkeleton();
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
