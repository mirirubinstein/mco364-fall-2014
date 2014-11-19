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
//this class should have only one responsibility! to draw the image!

public class Canvas extends JComponent {
	private DrawListener listener;
	private BrushPanel panel;
	private int strokeThickness;
	private Image image;
	private Color paintColor;

	
	public Canvas(BrushPanel panel){
		this.panel = panel;
		
	image = new BufferedImage(800,600, BufferedImage.TYPE_INT_ARGB);
		paintColor = Color.BLACK;
		strokeThickness = 10;
		

		addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent e) {
              
              int scrolledAmount = (-e.getWheelRotation());
              if(-scrolledAmount >= strokeThickness){
            	  strokeThickness = 1;
              }else{
              strokeThickness += scrolledAmount;
               
              }
           
              repaint();
            }
        });
		
	}
	
	
	protected void paintComponent(Graphics g){
		//super.paintComponent(g);
	
		g.drawImage(image,0,0,null);
		panel.setStrokeWidth(strokeThickness);
	
		// all the listeners will implement this method differently, depending on its shape
		//listener.drawPreview((Graphics2D) g);
		
		
	}
	
	public void setColor(Color color){
		paintColor = color;
	}
	public Color getColor(){
		return paintColor;
	}
	public int getStrokeThickness(){
		return strokeThickness;
	}
	public Image getImage(){
		return image;
	}
	


}
