package proxy;

import java.rmi.RemoteException;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import server.IService;

public class ProxyListener implements MessageListener{

	private IService service;
	
	public ProxyListener(IService s) {
		// TODO Auto-generated constructor stu
		service = s;
	}

	@Override
	public void onMessage(Message arg0) {
		// TODO Auto-generated method stub
		TextMessage msg = (TextMessage)arg0;
		
		try {
			String messagge = msg.getText();
			
			if(messagge.equalsIgnoreCase("Preleva")){
				// Prelievo
				System.out.println("[LISTENER] prelievo");
				
				int idPrelevato = service.preleva();
				ProxySenderThread sender = new ProxySenderThread("Id prelevato " + idPrelevato);
				sender.start();
			}
			else{
				// Deposito
				String[] splitted = messagge.split("-");
				Integer valoreDaDepositare = Integer.valueOf(splitted[1]);
				System.out.println("[LISTENER] Ricevuta richiesta di deposito. Valore da depositare " + valoreDaDepositare );
				
				service.deposita(valoreDaDepositare);
			}
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
