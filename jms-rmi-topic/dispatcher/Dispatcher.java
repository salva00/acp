package dispatcher;

import java.util.Hashtable;
import java.util.Random;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Dispatcher {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<String, String> properties = new Hashtable<String,String>();
		properties.put("java.naming.factory.initial","org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		properties.put("java.naming.provider.url","tcp://127.0.0.1:61616");
		properties.put("topic.print", "print");
	
		try {
			Context ctx = new InitialContext ( properties );
			
			TopicConnectionFactory connFactory = (TopicConnectionFactory) ctx.lookup("TopicConnectionFactory");
			
			Topic topicResponse = (Topic) ctx.lookup("print");
			
			TopicConnection tconn = connFactory.createTopicConnection();
			tconn.start();
			
			TopicSession tsession = tconn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			TopicSubscriber tpub =  tsession.createSubscriber(topicResponse);
			
			tpub.setMessageListener(new Listener());
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
