package generator;

import interfaces.IAlertNotification;

public class AlertNotification implements IAlertNotification {

	private static final long serialVersionUID = 8493039239051003822L;
	
	private int componentId;
	private int criticality;
	
	public AlertNotification(int componentId, int criticality) {
		super();
		this.componentId = componentId;
		this.criticality = criticality;
	}

	@Override
	public int getComponentId() {
		// TODO Auto-generated method stub
		return componentId;
	}

	@Override
	public int getCriticality() {
		// TODO Auto-generated method stub
		return criticality;
	}
}