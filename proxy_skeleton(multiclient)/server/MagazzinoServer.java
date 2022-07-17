package server;

import server.Magazzino;
import server.MagazzinoSkeleton;

public class MagazzinoServer {
	public static void main(String[] args) {
		Magazzino magazzino = new Magazzino ();
		MagazzinoSkeleton skeleton = new MagazzinoSkeleton( magazzino, 2222 );
		skeleton.runSkeleton();
		
	}
}
