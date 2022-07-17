package dispatcher;

import coda.*;


public class Dispatcher implements IDispatcher{

	CodaCircolare coda;	
	CodaWrapperLock wrapper;
	
	public Dispatcher(){
		coda = new CodaCircolare(5);
		wrapper = new CodaWrapperLock(coda);
	} 
	
	public void sendCmd(int command) {
		System.out.println ("[Dispatcher] sendCmd: " + command );
		wrapper.inserisci(command);
	}
	
	public int getCmd(){
		int cmd = wrapper.preleva();
		System.out.println ("[Dispatcher] getCmd: " + cmd );
		return cmd;
	}

}
