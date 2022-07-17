package interfaces;

import java.io.Serializable;

public interface IAlertNotification extends Serializable{

	public int getComponentId();
	public int getCriticality();
	
}
