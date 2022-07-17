package server;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import interfaces.IPrinter;

public class Printer extends UnicastRemoteObject implements IPrinter {
	
	private static final long serialVersionUID = -632230298994120521L;

	protected Printer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printDoc(String doc) {
		// TODO Auto-generated method stub
		Lock lock = new ReentrantLock();
		lock.lock();
		
		BufferedWriter w;
		try {
			w = new BufferedWriter(new FileWriter("./print.txt",true));
			w.write(doc);
			System.out.println("[PRINTER] scitto: " + doc);
			w.newLine();
			w.close();
			Thread.sleep(5000);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		

	}

}
