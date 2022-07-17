package server;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import coda.CodaCircolare;
import coda.CodaWrapperLock;

public class SensorListener implements MessageListener {
	public static CodaWrapperLock coda;
	private static final int D = 5;
	
	public SensorListener() {
		coda = new CodaWrapperLock( new CodaCircolare(D) );
	}
	
	
	@Override
	public void onMessage(Message arg0) {
		// TODO Auto-generated method stub
		TextMessage msg = (TextMessage) arg0;
		TManager tm;
		try {
			tm = new TManager(coda,msg.getText());
			tm.start();

		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
