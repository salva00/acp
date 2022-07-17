package client;

import dispatcher.IDispatcher;


public class ClientThread extends Thread {
	
	private IDispatcher disp;
	
	public ClientThread(IDispatcher d) {
		disp = d;
		start();
	}

	public void run() {
		
		System.out.println ("[ClientThread] run thread! " );
		int randomTime = 2 + (int)(Math.random() * 4);
		try {
			sleep(randomTime*1000);
			
			for(int i = 0; i<3; i++) {
				int random = (int)(Math.random() * 3);
				disp.sendCmd(random);
				System.out.println ("[ClientThread] :" + random + "sent! " );
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
