package rubinstein.chat;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetworkRequest extends Thread {
	private Socket socket;
	private ChatFrame frame;
	private StringBuilder message;

	public NetworkRequest(ChatFrame frame, Socket socket, String message) {
		this.socket = socket;
		this.frame = frame;
		this.message = new StringBuilder(message + "\n");
	}

	public void run() {
		try {

			OutputStream out = socket.getOutputStream();

			out.write(message.toString().getBytes());
			out.flush();// flush the stream so that the data gets sent

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
