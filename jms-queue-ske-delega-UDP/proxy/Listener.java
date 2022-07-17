package proxy;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

public class Listener implements MessageListener {

	@Override
	public void onMessage(Message arg0) {
		// TODO Auto-generated method stub
		MapMessage msg = (MapMessage) arg0;
		System.out.println("[DISK]	thread started");

		DiskThread t = new DiskThread(msg);
		t.start();
		
	}

}
