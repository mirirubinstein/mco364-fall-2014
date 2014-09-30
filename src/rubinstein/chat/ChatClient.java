package rubinstein.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ChatClient {
	private ChatFrame frame;
	private Socket socket;
	private InputStream in;
	private OutputStream out;
	
	public ChatClient(ChatFrame frame){
		this.frame = frame;
		try {
			socket = new Socket("localhost", 8080);
			in = socket.getInputStream();
			out = socket.getOutputStream();
			
		/*	while (true) {

				ServerThreads task = new ServerThreads(socket, frame);

				new Thread(task).start();
				
				
			}
*/
			
			
		} catch ( IOException e) {
			e.printStackTrace();
		}
		
	}
	public void sendMessage(String message) throws IOException{
		out.write(message.getBytes());
	}

}
