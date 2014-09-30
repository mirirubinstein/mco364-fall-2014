package rubinstein.network;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MultiThreadServer33 extends JFrame {
	private JTextArea jta = new JTextArea();

	public static void main(String[] args) {
		new MultiThreadServer33();
	}

	public MultiThreadServer33(){
		setLayout(new BorderLayout());
		add(new JScrollPane(jta), BorderLayout.CENTER);
		
		setTitle("Multi Thread Server");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		try{
			ServerSocket serverSocket = new ServerSocket(8085);
			jta.append("Multi Thread server started at " + new Date() + '\n');
			
			int clientNo = 1;
			
			while(true){
				Socket socket = serverSocket.accept();
				
				jta.append("Starting thread for client " + clientNo + "at" + new Date() + 'n');
				
				InetAddress inetAddress = socket.getInetAddress();
				jta.append("Client" + clientNo + "'s host name is: " + inetAddress.getHostName() + "\n");
				jta.append("Client" + clientNo + "'s IP address is: " + inetAddress.getHostAddress() + "\n");
				
				HandleAClient task = new HandleAClient(socket);
				
				new Thread(task).start();
				
				clientNo++;
			}
		}catch(IOException ex){
			System.err.println(ex);
		}
}
	//inner class
	//thread that handles new connection
	class HandleAClient implements Runnable{
		private Socket socket;
		
		//construct thread
		public HandleAClient(Socket socket){
			this.socket = socket;
		}
		
		public void run(){
			try{
				DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
				DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
				
				//continuously serve the client
				while(true){
					double radius = inputFromClient.readDouble();
					
					double area =radius * radius * Math.PI;
					
					outputToClient.writeDouble(area);
					
					jta.append("radius rec'd from client: " + radius + '\n');
					jta.append("Area found: " + area + '\n');
				}
				
			}catch(IOException e){
				System.err.println(e);
			}
		}
	}
}
