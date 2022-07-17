package manager;

import java.rmi.RemoteException;
import java.util.Random;

import interfaces.IController;

public class Sensor extends Thread {

	private IController controller;
	
	public Sensor(IController c) {
		controller = c;
	}
	
	public void run() {
		
		System.out.println("[SENSOR] thread started");
		
		String type = new String();
		int data;
		
		Random rand = new Random();
		
		switch(rand.nextInt(2)) {
		case 0:
			type = "temperature";
			break;
		case 1:
			type = "pressure";
			break;
		}
		
		data = 1 + rand.nextInt(50);
		
		try {
			
			System.out.println("[SENSOR] type: " + type + " data: " + data);

			controller.sensorRead(new Reading(type,data));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
}
