package controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import interfaces.IActuator;

public class Proxy implements IActuator{
	int port;
	
	public Proxy(int p) {
		port = p;
	}

	@Override
	public boolean execute(String cmd) {
		// TODO Auto-generated method stub
		System.out.println("[CONTROLLER] proxy started");

		try {
			Socket s = new Socket("127.0.0.1",port);
			
			DataOutputStream os = new DataOutputStream(s.getOutputStream());
			os.writeUTF("execute");
			os.writeUTF(cmd);
			
			DataInputStream is = new DataInputStream(s.getInputStream());

			is.readUTF();
			s.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	
		
	}
	
	
	

}
