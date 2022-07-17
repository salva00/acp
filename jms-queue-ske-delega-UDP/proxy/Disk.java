package proxy;

import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Interfaces.ILogger;


public class Disk{
	
	public static void main(String[] args) {
		
		Hashtable <String, String> p = new Hashtable <String, String>();
		
		p.put("java.naming.factory.initial", "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		p.put("java.naming.provider.url", "tcp://127.0.0.1:61616");
		
		p.put("queue.registra", "registra");
		
		try {
			Context ctx = new InitialContext ( p );
			QueueConnectionFactory qconnf = (QueueConnectionFactory)ctx.lookup("QueueConnectionFactory");
			Queue queueReg = (Queue) ctx.lookup("registra");
			QueueConnection qconn = qconnf.createQueueConnection();
			qconn.start();

			QueueSession qsession = qconn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			//QueueSender sender = qsession.createSender(queueReg);
			QueueReceiver receiver = qsession.createReceiver(queueReg);
			
			System.out.println("[DISK]	started ");

			receiver.setMessageListener(new Listener());
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
