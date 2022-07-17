package client;

import java.util.Hashtable;
import java.util.Random;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hashtable <String, String> p = new Hashtable <String, String>();
		
		p.put("java.naming.factory.initial", "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		p.put("java.naming.provider.url", "tcp://127.0.0.1:61616");
		
		p.put("topic.print","print");
		
		try {
			Context ctx = new InitialContext ( p );
			
			TopicConnectionFactory connFactory = (TopicConnectionFactory) ctx.lookup("TopicConnectionFactory");
			
			Topic topicRequest = (Topic) ctx.lookup("print");
			
			TopicConnection tconn = connFactory.createTopicConnection();
			tconn.start();
			
			TopicSession tsession = tconn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			TopicPublisher tpub =  tsession.createPublisher(topicRequest);
			
			MapMessage msg = tsession.createMapMessage();
			
			
			for(int i = 0; i < 5; i++) {
				Random rand = new Random();
				String nomeDocumento = "doc#" + rand.nextInt(41);
				msg.setString( "nomePrinter", args[0]);
				msg.setString( "nomeDocumento", nomeDocumento);
				tpub.publish(msg);
				System.out.println("[CLIENT] Richiesta inviata");
			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
