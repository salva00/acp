package dispatcher;

import java.net.*;
import java.io.*;


public class DispatcherSkeleton implements IDispatcher {
	
	
	private IDispatcher dispatcher; 
	private int port;
	
	
	public DispatcherSkeleton ( IDispatcher d, int p ){
		dispatcher = d;
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
	
	
	public void sendCmd ( int cmd ){
		dispatcher.sendCmd(cmd);
	}
	
	public int getCmd(){
		return dispatcher.getCmd();
	}

}
