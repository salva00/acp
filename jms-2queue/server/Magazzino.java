package server;

import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import coda.*;

public class Magazzino {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hashtable <String, String> p = new Hashtable <String, String>();
		
		p.put("java.naming.factory.initial", "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		p.put("java.naming.provider.url", "tcp://127.0.0.1:61616");
		
		p.put("queue.Richiesta", "Richiesta");
		
		try{
			Context ctx = new InitialContext ( p );
		
			QueueConnectionFactory qconnf = (QueueConnectionFactory)ctx.lookup("QueueConnectionFactory");
			
			/*
			 * Magazzino attende sulla coda 'Richiesta'; MagazzinoThread
			 * invia i messagi di risposta sulla coda 'Risposta'
			 */
			
			Queue queueRequest = (Queue)ctx.lookup("Richiesta");
			
			QueueConnection qconn = qconnf.createQueueConnection();
			qconn.start();
			
			QueueSession qsession = qconn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			QueueReceiver qreceiver = qsession.createReceiver(queueRequest);
			
			
			/*
			 * Creazione della coda a gestione circolare per la memorizzazione
			 * degli id articolo (Coda presa dall'esercitazione su CodaCircolare)
			 */
			Coda coda = new CodaWrapperLock ( new CodaCircolare (5) ) ; 
			
			
			/*
			 * Receive asincrona: il costruttore di MagazzinoListener
			 * riceve coda e qconn 
			 * 
			 */
			
			MagazzinoListener l = new MagazzinoListener ( coda, qconn );
			qreceiver.setMessageListener( l );
			
			System.out.println("[MAGAZZINO] Server avviato");
			
			
		}catch ( NamingException e ){
			e.printStackTrace();
		}catch ( JMSException e ){
			e.printStackTrace();
		}

	}
}
