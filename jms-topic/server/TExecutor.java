package server;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import coda.CodaWrapperLock;

public class TExecutor extends Thread {
	
	private CodaWrapperLock coda;

	public TExecutor(CodaWrapperLock c) {
		// TODO Auto-generated constructor stub
		coda = c;
	}

	public void run() {
		while(!coda.empty()) {
			String cmd = coda.preleva();
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("./CmdLog.txt",true));
				bw.write(cmd);
				System.out.println("[SENSOR] scitto: " + cmd);
				bw.newLine();
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
