package coda;

public class CodaWrapperSynchr extends CodaWrapper {
	
	public CodaWrapperSynchr( Coda c ){
		super (c);		
	}	
	
	public void inserisci( int i){
		
		synchronized(coda) {
			while (coda.full()) {
				try {
					System.out.println("[Prod] wait");
					coda.wait();
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
			} 
			coda.inserisci(i);
			coda.notifyAll();
		}
	}
	
	public int preleva(){
		int x=0;
			
		synchronized(coda) {
			while (coda.empty()) {
				try {
					System.out.println("[Cons] wait");
					coda.wait();
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
			} 
			x = coda.preleva();
			coda.notifyAll();
		}
		return x;
	}
	
}