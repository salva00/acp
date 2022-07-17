package dispatcher;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

public class Listener implements MessageListener{

	@Override
	public void onMessage(Message arg0) {
		// TODO Auto-generated method stub
		MapMessage msg = (MapMessage) arg0;
		PrintThread t = new PrintThread(msg);
		System.out.println("[DISPATCHER]	thread started");
		t.start();
		
	}

}
