package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IManager extends Remote{

	public void sendNotification(IAlertNotification n) throws RemoteException;
	public void subscribe(int cId, int port) throws RemoteException;
	
}
