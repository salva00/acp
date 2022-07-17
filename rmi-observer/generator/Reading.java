package generator;

import interfaces.IReading;

public class Reading implements IReading{
	
	private static final long serialVersionUID = -1770963318892503776L;
	private String tipo;
	private int valore;
	
	public Reading(String tipo, int valore) {
		super();
		this.tipo = tipo;
		this.valore = valore;
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return tipo;
	}

	@Override
	public int getValore() {
		// TODO Auto-generated method stub
		return valore;
	}
}
