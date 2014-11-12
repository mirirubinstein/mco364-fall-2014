package rubinstein.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent {
	private int oldX;
	private int oldY;
	private int currentX;
	private int currentY;
	private int strokeThickness;
	private Image image;
	private Graphics2D g;
	private Color paintColor;

	
	public Canvas(){
	image = new BufferedImage(800,600, BufferedImage.TYPE_INT_ARGB);
		paintColor = Color.BLACK;
		strokeThickness = 10;
		
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				oldX = e.getX();
				oldY = e.getY();
			}
		});
		

		addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent e) {
              
              int scrolledAmount = -(e.getWheelRotation());
              if(scrolledAmount < 0){
            	  strokeThickness = 0;
              }else{
              strokeThickness += scrolledAmount;
              }
              g.setStroke(new BasicStroke(strokeThickness));
               
            }
        });
 

		
	}
	
	
	protected void paintComponent(Graphics g){
		//super.paintComponent(g);
	
		g.drawImage(image,0,0,null);
		//oldX = x;
		//oldY = y;
		
		
	}
	public void setPoint(int x1, int y1, int x2, int y2){
		currentX = x2;
		currentY = y2;
		g = (Graphics2D) image.getGraphics();
		g.setStroke(new BasicStroke(strokeThickness));
		g.setColor(paintColor);
	//	g.fillOval(x2, y2, 10,10);
		g.drawLine(oldX, oldY, currentX, currentY);
		repaint();
		oldX = currentX;
		oldY= currentY;
		
		
	}
	public void setColor(Color color){
		paintColor = color;
	}



}
