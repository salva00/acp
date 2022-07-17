package manager;

import interfaces.IReading;

public class Reading implements IReading {

	private static final long serialVersionUID = 2970134509762470305L;
	
	private String type;
	private int data;
	
	public Reading (String t, int d) {
		type = new String(t);
		data = d;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public int getData() {
		// TODO Auto-generated method stub
		return data;
	}

}
