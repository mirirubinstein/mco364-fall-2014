package rubinstein.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThreads implements Runnable{
	private ChatFrame frame;
	private Socket socket;
	private StringBuilder message;
	
	//construct thread
	public ServerThreads(Socket socket, ChatFrame frame){
		this.socket = socket;
		this.frame = frame;
		message = new StringBuilder();
	}
	
	public void run(){
		try{
		
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

	
		
	
		String line;
		while((line = reader.readLine()) != null){//read line BLOCKS!!!
			message.append(line);
			frame.appendMessage(message.toString());
			
			out.write(line.getBytes());
			out.flush();
		
		}		
		}catch(IOException ex){
			System.err.println(ex);
		}
	
	}


}
