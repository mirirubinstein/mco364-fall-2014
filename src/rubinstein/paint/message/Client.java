package rubinstein.paint.message;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private Socket socket;

	public Client() throws UnknownHostException, IOException {
		socket = new Socket("localhost", 3773);
	}

	public void sendMessage(String message) throws IOException {
		OutputStream output = socket.getOutputStream();
		output.write(message.toString().getBytes());
		output.flush();
	}
}
