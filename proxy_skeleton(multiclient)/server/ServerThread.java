package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import server.IMagazzino;

public class ServerThread extends Thread {

	private Socket s; 
	private IMagazzino magazzino; 
	
	public ServerThread ( Socket sk, IMagazzino m ){
		s=sk;
		magazzino = m;
		start();
	}
	
	
	public void run ( ){
		
		System.out.println ("[SrvThread] run thread! " );
		
		try{
			
			
			DataInputStream dataIn = new DataInputStream ( s.getInputStream() );
			DataOutputStream dataOut = new DataOutputStream ( s.getOutputStream() );
			
			String method = dataIn.readUTF();
			int x;
			String articolo;
			
			if ( method.compareTo("deposita") == 0 ){
				
				articolo = dataIn.readUTF();
				x=dataIn.readInt();
				System.out.println ("[SrvThread] method: " + method + ", " + articolo + ", " + x);
				
				magazzino.deposita(articolo, x);
				
				dataOut.writeUTF("ack");
				
			}
			else if ( method.compareTo("preleva") == 0 ){
				articolo = dataIn.readUTF();
				System.out.println ("	[SrvThread] method: " + method + ", " + articolo);
				x= magazzino.preleva(articolo); 
				
				dataOut.writeInt (x);
				
			}else
				System.out.println("Error: unknown method!");
						
			s.close();
			
			
		}catch ( IOException e ){
			e.printStackTrace();
		}
		
	}
	
}
