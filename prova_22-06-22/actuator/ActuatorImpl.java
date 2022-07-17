package actuator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ActuatorImpl extends Skeleton{

	private String fileName;
	
	public ActuatorImpl (int p, String n) {
		super(p);
		fileName = n;
	}

	@Override
	public boolean execute(String cmd) {
		// TODO Auto-generated method stub
		
		Lock lock = new ReentrantLock();
		if(lock.tryLock()) {
			try {
				StringTokenizer tokenizer = new StringTokenizer(cmd,"#");
				
				String[] tokens = new String[2];
				
				for(int i = 0; i < 2; i++) {
					tokens[i] = tokenizer.nextToken();
					System.out.println("[ACT] " + tokens[i]);
				}
				
				BufferedWriter bw;
				
				bw = new BufferedWriter(new FileWriter(fileName,true));
				bw.write(tokens[0] + " " + tokens[1]);
				bw.newLine();
				bw.close();				
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				lock.unlock();
			}
			
			return true;
		}
		else {
			return false;
		}

	
		
	}
	
}
