package manager;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

import interfaces.IAlertNotification;
import interfaces.ISubscriber;

public class Proxy implements ISubscriber {
	
	private String addr;
	private int port;

	public Proxy(String addr, int port) {
		super();
		this.addr = addr;
		this.port = port;
	}

	@Override
	public void notifyAlert(int c) {
		// TODO Auto-generated method stub
		try {
			Socket s = new Socket(addr,port);
			DataInputStream is = new DataInputStream(s.getInputStream());
			DataOutputStream os = new DataOutputStream(s.getOutputStream());
			
			os.writeUTF("notifyAlert");
			os.writeInt(c);
			
			System.out.println("[MAN] sent crit: " + c);
			
			is.readUTF();
			
			s.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
