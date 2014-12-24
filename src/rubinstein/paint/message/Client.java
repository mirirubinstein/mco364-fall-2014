package rubinstein.paint.message;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import rubinstein.paint.ListeningThread;

public class Client {

	private Socket socket;
	private OutputStream out;
	private ListeningThread thread;

	
	public Client() throws UnknownHostException, IOException {
		//socket = new Socket("localhost", 3773);
		socket = new Socket("192.168.117.107", 3773);
		thread = new ListeningThread(socket);
		
	}
	public void sendMessage(String message) throws IOException {
		out.write(message.toString().getBytes());
		out.flush();
		System.out.println(message);
	}
	
}
