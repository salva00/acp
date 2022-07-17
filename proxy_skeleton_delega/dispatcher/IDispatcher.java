package dispatcher;

public interface IDispatcher {
	public abstract void sendCmd(int command);
	public abstract int getCmd();
}
