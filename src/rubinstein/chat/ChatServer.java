package rubinstein.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer extends ChatFrame {

	private ServerSocket serverSocket;
	private StringBuilder message;

	public ChatServer() {
		message = new StringBuilder();

		try {
			serverSocket = new ServerSocket(8080);

			int clientNo = 1;
			while (true) {
				Socket socket = serverSocket.accept();
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

				clientNo++;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ChatFrame c1 = new ChatServer();
	}

}
