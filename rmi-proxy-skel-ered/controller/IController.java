package controller;

public interface IController {

	public abstract void addActuator(int port);
	public abstract boolean sensorRead();
}
