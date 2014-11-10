package rubinstein.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent {
	private int oldX;
	private int oldY;
	private int currentX;
	private int currentY;
	private Image image;
	private Graphics2D g;
	private Color paintColor;
	private boolean clean;

	
	public Canvas(){
	image = new BufferedImage(800,600, BufferedImage.TYPE_INT_ARGB);
		paintColor = Color.BLACK;
		clean = true;		
		
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				oldX = e.getX();
				oldY = e.getY();
			}
		});
		
	}
	
	
	protected void paintComponent(Graphics g){
		g.drawImage(image,0,0,null);
		
	}
	public void setPoint(int x1, int y1, int x2, int y2){
		currentX = x2;
		currentY = y2;
		g = (Graphics2D) image.getGraphics();
		if(paintColor == Color.WHITE){
			g.setStroke(new BasicStroke(25));
		}else{
		g.setStroke(new BasicStroke(10));
		}
		g.setColor(paintColor);
		if(clean){
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, getSize().width, getSize().height);
		}
			clean = false;

		g.drawLine(oldX, oldY, currentX, currentY);
		repaint();
		oldX = currentX;
		oldY= currentY;
		
		
	}
	public void setColor(Color color){
		paintColor = color;
	}


}
