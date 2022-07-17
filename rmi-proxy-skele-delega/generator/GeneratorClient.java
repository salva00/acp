package generator;

import java.util.Random;

public class GeneratorClient {

	public static void main(String[] args) {
		
		System.out.println("[GEN] start");
		
		GeneratorThread[] threads = new GeneratorThread[3];
		Random rand = new Random();
		for(GeneratorThread t: threads) {
			

			t = new GeneratorThread(new AlertNotification(1+rand.nextInt(5),1+ rand.nextInt(3)));
			t.start();
		}
	}
	
}
