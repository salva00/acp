package coda;

import java.util.concurrent.locks.*;

public class CodaWrapperLock extends CodaWrapper {
	
	final Lock lock;
	private Condition consumer;
	private Condition producer;

	public CodaWrapperLock( Coda c ){
		super (c);
		lock  =  new ReentrantLock();
		consumer = lock.newCondition();
		producer = lock.newCondition();
		
	}

	public void inserisci( int i){
		lock.lock();
		try {
			while(coda.full()) {
				producer.await();
			}
			coda.inserisci(i);
			consumer.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
				
	}
	
	
	public int preleva(){
		
		int x=0;		
		lock.lock();
		try {
			while(coda.empty()) {
				consumer.await();
			}
			x = coda.preleva();
			producer.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		return x;
	}
	
}
