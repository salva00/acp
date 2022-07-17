package server;

public interface IMagazzino {
	public abstract void deposita(String articolo, int id);
	public abstract int preleva(String articolo);
}
