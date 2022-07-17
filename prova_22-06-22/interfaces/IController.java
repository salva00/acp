package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IController extends Remote {
	public void addActuator(int port) throws RemoteException;
	public boolean sensorRead(IReading r) throws RemoteException;


}
