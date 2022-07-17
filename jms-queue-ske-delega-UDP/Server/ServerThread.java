package Server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

import Interfaces.ILogger;

public class ServerThread extends Thread {

	private DatagramPacket packet;
	
	private ILogger logg;

	public ServerThread(DatagramPacket packet, ILogger logg) {
		super();
		this.packet = packet;
		this.logg = logg;
	}
	
	public void run() {
		
		String toConvert = new String(packet.getData(), 0, packet.getLength());
		int data = Integer.valueOf(toConvert);
		System.out.println(toConvert);
		logg.registraDato(data);	
		
	}
	
}
