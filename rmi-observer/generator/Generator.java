package generator;

public class Generator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadingThread[] threads = new ReadingThread[3];
		
		for(ReadingThread t : threads) {
			t = new ReadingThread();
			t.start();
		}
		
		
		
	}

}
