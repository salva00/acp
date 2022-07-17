package coda;

import java.util.concurrent.*;

public class CodaWrapperSem extends CodaWrapper {

	private int MAX_V = coda.getSize();
	
	private Semaphore disponibile;
	private Semaphore pieno;
	
	public CodaWrapperSem ( Coda c ){
		super (c);
		
		disponibile = new Semaphore(MAX_V);
		pieno = new Semaphore(0);
	}
	
	
	public void inserisci( int i){
				
		try {
			disponibile.acquire();
			synchronized(coda) {
				coda.inserisci(i);
			}
			pieno.release();

		}
		catch(InterruptedException e) {}

	}
		
	
	
	public int preleva(){
		
		int x=0;
				
		try {
			pieno.acquire();
			synchronized(coda) {
				x = coda.preleva();
			}
			disponibile.release();

		}
		catch(InterruptedException e) {}
		return x;
	}
}