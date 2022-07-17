package dispatcher;

public class DispatcherServer {
	public static void main(String[] args) {
		Dispatcher dispatcher = new Dispatcher ();
		DispatcherSkeleton skeleton = new DispatcherSkeleton( dispatcher, 2222);
		skeleton.runSkeleton();
	}
}
