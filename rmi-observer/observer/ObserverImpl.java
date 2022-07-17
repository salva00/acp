package observer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import dispatcher.Dispatcher;
import generator.Reading;
import interfaces.IDispatcher;
import interfaces.IObserver;



public class ObserverImpl extends UnicastRemoteObject implements IObserver{	
	
	private static final long serialVersionUID = 1L;

	private IDispatcher disp;
	
	protected ObserverImpl(IDispatcher d) throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		disp = d;
	}

	@Override
	public void notifyReading() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("[OBSERVER] notify request");
		Reading r = disp.getReading();
		System.out.println("[OBSERVER] tipo: " + r.getTipo() + " , val: " + r.getValore());
		try {
			BufferedWriter bw = new BufferedWriter( new FileWriter("./lett.txt",true));
			bw.write("tipo: " + r.getTipo() + " , val: " + Integer.valueOf(r.getValore()));
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}


}
