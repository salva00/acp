package client;

public class Client {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientSenderThread sender = new ClientSenderThread();
		ClientReceiverThread receiver = new ClientReceiverThread();
		sender.start();
		receiver.start();
		System.out.println("[CLIENT] started");
	}
}
