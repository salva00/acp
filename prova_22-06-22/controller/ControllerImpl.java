package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import actuator.ActuatorImpl;
import interfaces.IActuator;
import interfaces.IController;
import interfaces.IReading;

public class ControllerImpl extends UnicastRemoteObject implements IController {

	private Vector<IActuator> actuators;
	private static final long serialVersionUID = -1661756502852068387L;

	public ControllerImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		actuators = new Vector<IActuator>();
	}


	
	@Override
	public void addActuator(int port) throws RemoteException {
		// TODO Auto-generated method stub
		actuators.add( new ActuatorImpl( port, "execution.txt"));
	}

	@Override
	public boolean sensorRead(IReading r) throws RemoteException {
		// TODO Auto-generated method stub

		for(IActuator a : actuators) {
			if(!a.execute(r.getType()+"#"+r.getData())) {
				return false;
			}
			
		}
		return true;

	}

}
