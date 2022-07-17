package eser_rmi1.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

public class GestoreSportello extends UnicastRemoteObject implements IGestoreSportello {

	private static final long serialVersionUID = -6969629044456152613L;
	private Vector<ISportello> sportelli;
	
	
	protected GestoreSportello() throws RemoteException{
		sportelli = new Vector<ISportello>();
	}
	
	public boolean sottoponiRichiesta(int idCliente) throws RemoteException{
		
		boolean risposta = false;
		int i = 0;
		
		while( !risposta && i< sportelli.size() ) {
			risposta = sportelli.get(i).serviRichiesta(idCliente);
			i++;
		}
		System.out.println("[Gestore] richiesta di " + idCliente + ", status: " + risposta);
		
		return risposta;
		
	}
	
	public void sottoscrivi(ISportello richiesta) throws RemoteException{
		sportelli.add(richiesta);
		System.out.println("[Gestore] aggiunta richiesta");

	}
	
}
