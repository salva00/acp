package subscriber;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import interfaces.ISubscriber;

public class SubscriberImpl implements ISubscriber{
	
	private String file;
	

	public SubscriberImpl(String file) {
		super();
		this.file = file;
	}


	@Override
	public void notifyAlert(int c) {
		// TODO Auto-generated method stub
		System.out.println("[SUB] received: " + c);
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(file,true));
			bw.write(String.valueOf(c));
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}