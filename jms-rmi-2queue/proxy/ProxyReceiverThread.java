package proxy;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;

import server.IService;

public class ProxyReceiverThread extends Thread{

	private IService service;
	
	public ProxyReceiverThread(IService servizio) {
		// TODO Auto-generated constructor stub
		service = servizio;
	}
	
	public void run() {
		Hashtable<String, String> properties = new Hashtable<String,String>();
		properties.put("java.naming.factory.initial","org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		properties.put("java.naming.provider.url","tcp://127.0.0.1:61616");
		properties.put("queue.richiesta", "richiesta");
		
		try {
			
			Context jndiContext = new InitialContext(properties);
			QueueConnectionFactory qcf = (QueueConnectionFactory) jndiContext.lookup("QueueConnectionFactory");
			Queue prod = (Queue)jndiContext.lookup("richiesta");
			QueueConnection qc = qcf.createQueueConnection();
			qc.start();
			
			QueueSession qs = qc.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			QueueReceiver receiverProd = qs.createReceiver(prod);
			
			ProxyListener listener = new ProxyListener(service);
			receiverProd.setMessageListener(listener);
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
