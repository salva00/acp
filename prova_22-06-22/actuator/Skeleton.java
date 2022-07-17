package actuator;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import interfaces.IActuator;

public abstract class Skeleton implements IActuator{
	private int port;
	
	public Skeleton(int p) {
		port = p;
	}
	
	
	public void runSkeleton() {
		try {
			ServerSocket server = new ServerSocket(port);
			System.out.println ("[ACT] server started ");
			
			Socket s;
			
			while(true) {
				s = server.accept();
				ServerThread t = new ServerThread(s,this);
				t.start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
