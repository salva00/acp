package client;

import java.util.Hashtable;
import java.util.Random;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ControlStation {
	
	private static final int N = 20;
	
	public static void main(String[] args) {
		Hashtable <String, String> p = new Hashtable <String, String>();
		
		p.put("java.naming.factory.initial", "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		p.put("java.naming.provider.url", "tcp://127.0.0.1:61616");
		
		p.put("topic.sensor","sensor");
		
		
		Context ctx;
		try {
			
			ctx = new InitialContext ( p );
			TopicConnectionFactory connFactory = (TopicConnectionFactory) ctx.lookup("TopicConnectionFactory");
			
			Topic topicRequest = (Topic) ctx.lookup("sensor");
			
			TopicConnection tconn = connFactory.createTopicConnection();
			tconn.start();
			
			TopicSession tsession = tconn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			TopicPublisher tpub =  tsession.createPublisher(topicRequest);
			
			System.out.println("[CLIENT] started");
			
			TextMessage msg = tsession.createTextMessage();
			
			for(int i=0; i<N;i++) {
				
				Random rand = new Random();
				String cmdToSend = "";
				int randInt = rand.nextInt(4);
				
				switch(randInt){
				case 0:
					cmdToSend = "startSensor";
					break;
				case 2:
					cmdToSend = "stopSensor";
					break;
				case 3:
					cmdToSend = "read";
					break;
				}
				
				msg.setText(cmdToSend);
				Thread.sleep(1000);
				System.out.println("[CLIENT] cmd sent: " + cmdToSend);
				tpub.publish(msg);
				
			}
			
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
