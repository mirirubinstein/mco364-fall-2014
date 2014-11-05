package rubinstein.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent {
	private int oldX;
	private int oldY;
	private int x;
	private int y;
	BufferedImage image;
	
	public Canvas(){
		image = new BufferedImage(800,600, BufferedImage.TYPE_INT_ARGB);
		
	}
	
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(image,0,0,null);
		oldX = x;
		oldY = y;
		
		
	}
	public void setPoint(int x, int y){
		this.x = x;
		this.y = y;
		Graphics g = image.getGraphics();
		g.setColor(Color.BLACK);
		g.fillOval(x, y, 1,1);
		g.drawLine(oldX, oldY, x, y);
	}


}
