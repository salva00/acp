package Server;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import Interfaces.ILogger;

public class Logger implements ILogger{

	@Override
	public void registraDato(int dato) {
		// TODO Auto-generated method stub
		Lock lock = new ReentrantLock();
		
		lock.lock();
		
		try {
			BufferedWriter bw = new BufferedWriter( new FileWriter("./log.txt",true));
			bw.write(dato);
			System.out.println("[ERVER]	write "+dato);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
		
	}

}
