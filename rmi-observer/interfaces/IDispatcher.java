package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import generator.Reading;
import observer.ObserverImpl;

public interface IDispatcher extends Remote{
		
	public void  setReading(Reading reading) throws RemoteException;
	public Reading getReading()throws RemoteException;
	public void attach(IObserver o,String s)throws RemoteException;
	
}
