package eser_rmi1.server;

import java.rmi.RemoteException;

public interface ISportello {

	public abstract boolean serviRichiesta(int idCliente) throws RemoteException;
}
