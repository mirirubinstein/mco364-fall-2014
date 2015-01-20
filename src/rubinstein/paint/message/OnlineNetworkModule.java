package rubinstein.paint.message;

import java.io.IOException;


public class OnlineNetworkModule implements NetworkModule {

	private Client client;

	public OnlineNetworkModule(Client client) {
		this.client = client;
	}

	@Override
	public void sendMessage(PaintMessage message) {
		try {
			client.sendMessage(message.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
