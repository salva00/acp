package Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import Interfaces.ILogger;

public class Skeleton implements ILogger{
	
	private ILogger log;
	private int port;
	
	public Skeleton(ILogger log, int port) {
		super();
		this.log = log;
		this.port = port;
	}

	public void runSkeleton() {
		System.out.println("[SERVER]	Skeleton started, listening on port: " + port);

		try {
			DatagramSocket sock = new DatagramSocket(port);

			while(true) {
				byte[] buff = new byte[65508];
				DatagramPacket packet = new DatagramPacket(buff,0, buff.length);
				sock.receive( packet);
				ServerThread t = new ServerThread(packet,this);
				t.start();
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void registraDato(int dato) {
		// TODO Auto-generated method stub
		log.registraDato(dato);
	}
	

}
