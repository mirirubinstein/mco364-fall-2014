package rubinstein.paint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ListeningThread implements Runnable{
	private Socket socket;
	private StringBuilder message;
	
	public ListeningThread(Socket socket){
		this.socket = socket;
		message = new StringBuilder();
	}

	@Override
	public void run() {
		try {

			InputStream in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));

			String line;
			while ((line = reader.readLine()) != null) {
				message.append(line);
				System.out.println(message);

			}
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}
