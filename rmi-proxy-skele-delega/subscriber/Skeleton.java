package subscriber;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;

import interfaces.IAlertNotification;
import interfaces.IManager;
import interfaces.ISubscriber;

public class Skeleton implements ISubscriber{
	
	private ISubscriber sub;
	private int port;

	public Skeleton(ISubscriber sub, int port) {
		super();
		this.sub = sub;
		this.port = port;
	}
	
	
	void runSkeleton(){
		ServerSocket server;
		try {
			server = new ServerSocket(port);
			System.out.println("[SUB] server started...");
			Socket sock;
			
			while(true){
				sock = server.accept();
				SkeletonThread t = new SkeletonThread(sock, this);
				t.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void notifyAlert(int c) {
		// TODO Auto-generated method stub
		sub.notifyAlert(c);
	}

}
