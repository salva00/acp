package Server;

public class LoggerServer {

	public static void main(String[] args)  {
		Logger logger = new Logger();
		Skeleton sk = new Skeleton(logger, Integer.parseInt(args[0]));
		sk.runSkeleton();
	}
	
	
}
