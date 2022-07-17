package client;

import server.IMagazzino;

public class ClientThread extends Thread {
	private IMagazzino mag;
	private String method;
	
	public ClientThread(IMagazzino m, String f) {
		mag = m;
		method = f;
		start();
	}

	public void run() {
		
		System.out.println ("[ClientThread] run thread! " );
		int randomTime = 2 + (int)(Math.random() * 4);
		try {
			sleep(randomTime*1000);
			String toDep = "";
			if(method.compareTo("deposita")==0){
				for(int i = 0; i<3; i++) {
					int random = 1 + (int)(Math.random() * 100);
					int randString = (int)Math.random();
					switch(randString){
					case 0:
						toDep = "laptop";
						break;
					case 1:
						toDep = "smartphone";
						break;
					}
					mag.deposita(toDep,random);
					System.out.println ("[ClientThread] : " + toDep + ", "+ random + "sent! ");
				}
			}
			else if(method.compareTo("preleva")==0){
				for(int i = 0; i<3; i++) {
					int randString = (int)Math.random();
					switch(randString){
					case 0:
						toDep = "laptop";
						break;
					case 1:
						toDep = "smartphone";
						break;
					}
					int result = mag.preleva(toDep);
					System.out.println ("[ClientThread] : result: " + result );
				}
			}
			
			

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
