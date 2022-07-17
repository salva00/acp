package proxy;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import Interfaces.ILogger;

public class Proxy implements ILogger {
	private int port;

	public Proxy (int p) {
		port = p;
	}

	@Override
	public void registraDato(int dato) {
		// TODO Auto-generated method stub
		try {
			DatagramSocket sock = new DatagramSocket();
			String toSend = String.valueOf(dato);
			DatagramPacket p = new DatagramPacket(toSend.getBytes(), toSend.getBytes().length, InetAddress.getLocalHost(),port);
			sock.send( p );
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
