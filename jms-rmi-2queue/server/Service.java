package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import coda.CodaCircolare;
import coda.CodaWrapperLock;

public class Service extends UnicastRemoteObject implements IService {

	private static final long serialVersionUID = -9173926485783732904L;
	private CodaWrapperLock coda;
	
	
	public Service() throws RemoteException {
		super();
		coda = new CodaWrapperLock( new CodaCircolare(5));
	}
	
	@Override
	public void deposita(int id) {
		// TODO Auto-generated method stub
		coda.inserisci(id);
		System.out.println("[SERVICE]	depositato: "+ id);
	}

	@Override
	public int preleva() {
		// TODO Auto-generated method stub
		int id = coda.preleva();
		System.out.println("[SERVICE]	prelevato: "+ id);
		return id;
	}

}
