package server;

import coda.CodaWrapperLock;

public class TManager extends Thread {

	private String cmd;
	private CodaWrapperLock coda;
	public TManager(CodaWrapperLock c, String s) {
		coda = c;
		cmd =  s;
	}
	
	private void put(String cmd) {
		coda.inserisci(cmd);
	}
	
	public void run() {
		put(cmd);
	}
}
