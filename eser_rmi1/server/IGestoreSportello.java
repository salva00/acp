package eser_rmi1.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IGestoreSportello extends Remote {

	public abstract boolean sottoponiRichiesta(int idCliente) throws RemoteException;
	public abstract void sottoscrivi(ISportello richiesta) throws RemoteException;
}
