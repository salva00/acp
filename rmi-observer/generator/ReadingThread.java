package generator;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;

import interfaces.IDispatcher;
import interfaces.IReading;

public class ReadingThread extends Thread {
	
	public ReadingThread(){
		super();
	}
	
	public void run() {
		
		try {
			Registry registro = LocateRegistry.getRegistry();
			IDispatcher dispatcher = (IDispatcher) registro.lookup("dispatcher");
			
			String tipo = new String();
			int val;
			
			Random rand = new Random();
			
			for(int i =0 ; i< 3 ; i++) {
				
				int randInt = rand.nextInt(2);
				
				switch(randInt) {
				case 0:
					tipo = "temperatura";
					break;
				case 1:
					tipo = "pressione";
					break;
				}
				
				val = rand.nextInt(51);
				
				Reading read = new Reading(tipo,val);
				
				dispatcher.setReading(read);
				
				if (i == 1) {
					sleep(5000);
				}

			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
