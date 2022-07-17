package eser_rmi1.server;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Sportello implements ISportello {

	private Semaphore maxRichiesteTotali;
	private Semaphore maxRichiesteSportello;
	
	protected Sportello() throws RemoteException {
		// TODO Auto-generated constructor stub
		
		maxRichiesteTotali = new Semaphore(5);
		maxRichiesteSportello = new Semaphore(3);
		
	}
	
	@Override
	public boolean serviRichiesta(int idCliente) throws RemoteException {
		
		boolean risultato = false;
		
		if (!maxRichiesteSportello.tryAcquire()) {
			
			System.out.println("[Sportello] Limite richieste raggiunto");
			System.out.println("[Sportello] Richiesta dell'utente " + idCliente + " non può essere servito");
			return risultato;
		}
		
		
		try {
			
			maxRichiesteTotali.acquire();
			
			Random rand = new Random();
			
			Thread.sleep( (rand.nextInt(5) + 1) * 1000);
			
			BufferedWriter w = new BufferedWriter(new FileWriter("./file.txt",true));
			
			w.write(idCliente);
			w.newLine();

			w.close();
			
			risultato = true;
			
			System.out.println("[Sportello] Servita richiesta da " + idCliente);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			risultato = false;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			risultato = false;
			
		} finally {
			maxRichiesteTotali.release();
			maxRichiesteSportello.release();
		}
		
		return risultato;
	}

}
