package rubinstein.paint.message;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import rubinstein.paint.Canvas;

public class ListeningThread extends Thread{
	private Socket socket;
	private Canvas canvas;

	
	public ListeningThread(Socket socket, Canvas canvas){
		this.socket = socket;
		this.canvas = canvas;
		
	}

	@Override
	public void run() {
		try {
			
			StringBuilder message = new StringBuilder("");
			PaintMessageFactory factory = new PaintMessageFactory();
			
			InputStream in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));

			String line;
			while ((line = reader.readLine()) != null) {
				
				PaintMessage paintMessage = factory.getMessage(line);
				
				if (paintMessage != null) {
					paintMessage.apply((Graphics2D) canvas.getImage().getGraphics());
					canvas.repaint();
				}
				
			}
			
		
			
			
			
		} catch (IOException ex) {
			System.err.println(ex);
		}
		
	}
}
