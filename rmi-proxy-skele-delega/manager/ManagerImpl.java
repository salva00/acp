package manager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import interfaces.IAlertNotification;
import interfaces.IManager;

public class ManagerImpl extends UnicastRemoteObject implements IManager {

	private Vector<Subsciption> subs;
		
	private static final long serialVersionUID = -4665384736407771713L;

	protected ManagerImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		subs = new Vector<Subsciption>();
	}

	@Override
	synchronized public void sendNotification(IAlertNotification n) {
		// TODO Auto-generated method stub
		
		for(Subsciption s: subs) {
			if(n.getComponentId() == s.getcId()) {
				Proxy proxy = new Proxy("127.0.0.1", s.getP());
				proxy.notifyAlert(n.getCriticality());
			}
		}
	}

	@Override
	public void subscribe(int cId, int port) {
		// TODO Auto-generated method stub
		subs.add(new Subsciption(cId,port));

	}
}