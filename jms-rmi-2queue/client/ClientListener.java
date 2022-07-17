package client;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ClientListener implements MessageListener {

	@Override
	public void onMessage(Message arg0) {
		// TODO Auto-generated method stub
		TextMessage msg = (TextMessage)arg0;
		
		try {
			System.out.println("[LISTENER] Ricevuto messaggo: " + msg.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
