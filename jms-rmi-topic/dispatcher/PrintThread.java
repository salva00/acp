package dispatcher;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.jms.JMSException;
import javax.jms.MapMessage;

import java.rmi.registry.Registry;

import interfaces.IPrinter;

public class PrintThread extends Thread{

	private MapMessage msg;
	
	public PrintThread(MapMessage m) {
		msg = m;
	}
	
	public void run() {
		
		try {
			String nomePrinter = msg.getString("nomePrinter");
			String nomeDocumento = msg.getString("nomeDocumento");
			System.out.println("[DISPATCHER-THREAD]	Message: " + nomeDocumento);

			Registry registro = LocateRegistry.getRegistry();
			IPrinter printer = (IPrinter) registro.lookup(nomePrinter);

			printer.printDoc(nomeDocumento);
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}
	
}
