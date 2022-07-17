package actuator;

import dispatcher.*;
import java.io.*;
import client.*;

public class Actuator {
	
	public static void main(String[] args) {
		/*
		 * uso: 		java client.Actuator IP porta
		 * per es.:		java client.Actuator 127.0.0.1 8000
		 */

		
		IDispatcher dispatcher = new DispatcherProxy ( "127.0.0.1",2222);
		int cmd=0;
		
		try{
			FileOutputStream fileOut = new FileOutputStream ( "./cmdlog.txt");
			PrintStream outStream = new PrintStream ( fileOut );
			
			while(true){
				
				cmd = dispatcher.getCmd();
				System.out.println ("[ACT] ricevuto comando # " + cmd );
				outStream.println ( "comando = "+ cmd);
				
				Thread.sleep( 5000 );	
			} 
				
		}catch ( IOException e ){
			e.printStackTrace();
		}catch ( InterruptedException i ){
			i.printStackTrace();
		}
		
	}
	
}
