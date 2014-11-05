package rubinstein.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Queue;

public class SocketHandler  extends Thread{
	private Socket socket;
	private Queue<String> messages;
	
	public SocketHandler(Socket socket, Queue<String> messages){
		this.socket = socket;
		this.messages = messages;
	}
	//creates list of messages
	public void run(){
		
		try {
		InputStream	in = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		String line;
		while((line = reader.readLine()) != null){
			messages.add(line);
			System.out.println(line);
		}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
