package rubinstein.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;


public class NetworkRequest {
	public static void main(String[] args) throws IOException{
		

	
		//Socket socket = new Socket("www.amazon.com", 80);
		Socket socket = new Socket("192.168.117.107", 3773);
		//InputStream in = socket.getInputStream();//reads information from the socket aka amazon server
		OutputStream out = socket.getOutputStream();//sends data to the amazon server
		//String request = "GET /index.html\n\n";
		String request = "test";
		out.write(request.getBytes());
		out.flush();//flush the stream so that the data gets sent
	//	BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		//plain input stream cant read full stream
		
	//	String line;
	//	while((line = reader.readLine()) != null) {
	//		System.out.println(line + "\n");
	//	}
		
	
	}

}
