package proxy;

import javax.jms.JMSException;
import javax.jms.MapMessage;


public class DiskThread extends Thread{
	
	private MapMessage msg;

	public DiskThread(MapMessage m) {
		// TODO Auto-generated constructor stub
		msg = m;
	}
	
	public void run() {
		
		try {
			Proxy p = new Proxy(Integer.parseInt(msg.getString("port")));
			System.out.println("[DISK]	send:" + Integer.parseInt(msg.getString("dato")));

			p.registraDato(Integer.parseInt(msg.getString("dato")));
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
