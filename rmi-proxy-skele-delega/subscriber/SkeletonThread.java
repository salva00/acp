package subscriber;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import interfaces.ISubscriber;

public class SkeletonThread extends Thread {

	private Socket sock;
	private ISubscriber sub;
	
	public SkeletonThread(Socket sock, ISubscriber sub) {
		super();
		this.sock = sock;
		this.sub = sub;
	}

	public void run() {
		System.out.println("[SUB] thread started");
		
		try {
			DataInputStream is = new DataInputStream(sock.getInputStream());
			DataOutputStream os = new DataOutputStream(sock.getOutputStream());
			
			String command = is.readUTF();
			int crit = is.readInt();
			
			if(command.compareTo("notifyAlert")==0) {
				sub.notifyAlert(crit);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
