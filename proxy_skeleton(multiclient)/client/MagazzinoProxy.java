package client;

import server.IMagazzino;

import java.net.*;
import java.io.*;


public class MagazzinoProxy implements IMagazzino {
	private String addr;
	private int port;
	
	
	public MagazzinoProxy ( String a, int p ){
		addr = new String ( a);
		port = p;	
	}
	
	public void deposita(String articolo, int id){
		try{
			Socket s = new Socket ( addr, port );
			
			DataOutputStream dataOut = new DataOutputStream ( s.getOutputStream() );
			DataInputStream dataIn = new DataInputStream ( s.getInputStream() );
			
			dataOut.writeUTF("deposita");
			dataOut.writeUTF(articolo);
			dataOut.writeInt( id );
			
			dataIn.readUTF();	// forza il proxy ad attendere
								
			s.close();
			
		}catch (UnknownHostException u ){
			u.printStackTrace();
		}catch (IOException e ){
			e.printStackTrace();
		}
	}
	
	public int preleva(String articolo){
		int id=0;
		
		try{
			
			Socket s = new Socket ( addr, port );
			DataOutputStream dataOut = new DataOutputStream ( s.getOutputStream() );
			DataInputStream dataIn = new DataInputStream ( s.getInputStream() );
			
			dataOut.writeUTF("preleva");
			dataOut.writeUTF(articolo);
			id=dataIn.readInt();
			
			s.close();
			
		}catch (UnknownHostException u ){
			u.printStackTrace();
		}catch (IOException e ){
			e.printStackTrace();
		}
		
		return id;
	}
	
	
}
