package actuator;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import interfaces.IActuator;

public class ServerThread extends Thread {
	
	private Socket socket;
	private IActuator act;

	public ServerThread(Socket s, IActuator a) {
		// TODO Auto-generated constructor stub
		socket = s;
		act = a;
	}
	
	public void run() {
		
		DataInputStream is;
		Lock lock = new ReentrantLock();
		
		lock.lock();
		try {
			is = new DataInputStream(socket.getInputStream());
			if(is.readUTF().compareTo("execute")==0){
				act.execute(is.readUTF());
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		
		
		
	}

}
