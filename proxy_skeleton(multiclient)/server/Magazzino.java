package server;

import coda.CodaCircolare;
import coda.CodaWrapperLock;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Magazzino implements IMagazzino{
	private CodaCircolare laptops;
	private CodaCircolare smartphone;
	private CodaWrapperLock wrapperLap;
	private CodaWrapperLock wrapperSmart;


	public Magazzino(){
		laptops = new CodaCircolare(5);
		smartphone = new CodaCircolare(5);
		wrapperLap = new CodaWrapperLock(laptops);
		wrapperSmart = new CodaWrapperLock(smartphone);
	}
	
	public void deposita(String articolo, int id) {
		if(articolo.compareTo("smartphone") == 0) {
			wrapperSmart.inserisci(id);
		}
		
		if(articolo.compareTo("laptop") == 0) {
			wrapperLap.inserisci(id);
		}
	}
	
	public int preleva(String articolo) {
		int result = 0;
		try {
		if(articolo.compareTo("smartphone") == 0) {
			if(wrapperSmart.empty()) {
			}
			result = wrapperSmart.preleva();
		}
		
		if(articolo.compareTo("laptop") == 0) {
			if(wrapperLap.empty()) {
			}
			result = wrapperLap.preleva();
		}
        BufferedWriter buffwr = new BufferedWriter(new FileWriter("./prelevati.txt",true));
        buffwr.write(result);
        buffwr.write("\n");
        buffwr.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}

		return result;

	}
	
	

}
