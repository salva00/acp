package server;

import java.net.*;

import server.IMagazzino;
import server.ServerThread;

import java.io.*;

public class MagazzinoSkeleton implements IMagazzino{
	private IMagazzino magazzino; 
	private int port;
	
	
	public MagazzinoSkeleton ( IMagazzino d, int p ){
		magazzino = d;
		port = p;
	}
	
	
	
	public void runSkeleton () {
		
		try{
			ServerSocket server = new ServerSocket ( port );
			
			System.out.println ("Server attivo (*D*); avvio while loop... ");
			
			while ( true ){
				Socket s = server.accept();
				
				ServerThread t = new ServerThread ( s, this );
			}
			
		}catch ( IOException e ){
			e.printStackTrace();
		}
		
	}
	
	public void deposita(String articolo, int id) {
		magazzino.deposita(articolo, id);
	}
	
	public int preleva(String articolo){
		return magazzino.preleva(articolo);
	}

}
