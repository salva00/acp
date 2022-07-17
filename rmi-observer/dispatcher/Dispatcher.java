package dispatcher;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;
import java.util.Vector;

import generator.Reading;
import interfaces.IDispatcher;
import interfaces.IObserver;
import observer.ObserverImpl;

public class Dispatcher extends UnicastRemoteObject implements IDispatcher {
	
	private static final long serialVersionUID = -2266342388118062121L;

	private Reading reading;
	
	private Vector<IObserver> obsTemp;
	private Vector<IObserver> obsPress;

	
	public Dispatcher() throws RemoteException {
		super();
		this.reading = null;
		this.obsTemp = new Vector<IObserver>();
		this.obsPress = new Vector<IObserver>();

	}
	
	public void notifyTemp() throws RemoteException{
		for(IObserver o : obsTemp) {
			o.notifyReading();
			}
	}
	
	public void notifyPress() throws RemoteException{
		for(IObserver o : obsPress) {
			o.notifyReading();
			}
	}

	
	@Override
	synchronized public void setReading(Reading reading) throws RemoteException{
		// TODO Auto-generated method stub
		try {
			Random rand = new Random();
			int randInt = 1 + rand.nextInt(5);
			this.reading = reading;
			if(reading.getTipo().compareTo("temperatura")==0){
				notifyTemp();
			}else {
				notifyPress();
			}
			Thread.sleep(randInt*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void attach(IObserver o,String s) {
		// TODO Auto-generated method stub
		if(s.compareTo("temperatura") == 0) {
			obsTemp.add( o);
		}
		if(s.compareTo("pressione") == 0) {
			obsPress.add( o);
		}
	}

	@Override
	public Reading getReading() throws RemoteException {
		// TODO Auto-generated method stub
		return reading;
	}

}
