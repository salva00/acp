package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IService extends Remote{

	public void deposita(int id) throws RemoteException;
	public int preleva() throws RemoteException;
	
}
