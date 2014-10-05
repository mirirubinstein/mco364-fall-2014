package rubinstein.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatClient extends ChatFrame {

	private Socket socket;
	private StringBuilder message;

	public ChatClient() {
		message = new StringBuilder();

		try {
			socket = new Socket("localhost", 8080);
			setSocket(socket);

			try {

				InputStream in = socket.getInputStream();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(in));

				String line;
				while ((line = reader.readLine()) != null) {
					message.append(line);
					this.appendMessage(line);

				}
			} catch (IOException ex) {
				System.err.println(ex);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ChatFrame c2 = new ChatClient();
		c2.setLocationRelativeTo(null);

	}

}
