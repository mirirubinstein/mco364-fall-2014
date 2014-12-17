package rubinstein.paint;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

import rubinstein.paint.message.PaintMessage;

public class Connect {
	private String ipAddress;
	private int portNumber;
	public Connect(String ip, int port){
		ipAddress = ip;
	    portNumber = port;
	}

	public String sendMessage(PaintMessage message){
	     String in;
	     Socket clientSocket;
	     try{
	         clientSocket = new Socket(ipAddress, portNumber);
	         DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
	         BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	         //outToServer.writeBytes( '\n');
	        
	         in = inFromServer.readLine();
	         clientSocket.close();
	             outToServer.close();
	         inFromServer.close();
	     }
	     catch (Exception exc)
	     {
	          in = "";
	     }
	          return in;

		
	}public static void main(String argv[]) throws Exception
	{   Scanner scan = new Scanner(System.in);
    while (true)
    {
       String msgcont = scan.nextLine();
       Connect connection = new Connect("192.168.117.107", 3773);
      
    }
}


}

