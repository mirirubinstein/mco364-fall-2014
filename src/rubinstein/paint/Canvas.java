package rubinstein.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;


public class Canvas extends JComponent {
	private DrawListener listener;
	private BrushPanel panel;
	private int strokeThickness;
	private int currentLayer;
	private Image[] images;
	private Color paintColor;
	private boolean preview;

	
	public Canvas(BrushPanel panel){
		this.panel = panel;
		images = new BufferedImage [4];
		for(int i = 0; i < 4; i++){
			images[i] = new BufferedImage(1000,600, BufferedImage.TYPE_INT_ARGB);
		}
		paintColor = Color.BLACK;
		strokeThickness = 10;
		preview = true;
		setCurrentLayer(0);
		
		addListener(new PencilListener(this));
		

		addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent e) {
              
              int scrolledAmount = (-e.getWheelRotation());
              if(-scrolledAmount >= strokeThickness){
            	  strokeThickness = 1;
              }else{
              strokeThickness += scrolledAmount;
            
              }
            }
        });
		
	}
	
	
	protected void paintComponent(Graphics g){	
		for(int i = 0; i < 4; i++){
		g.drawImage(images[i],0,0,null);
		}
		panel.setStrokeWidth(strokeThickness);
	
		// all the listeners will implement this method differently, depending on its shape
		if(preview){
			for (int i = 0; i < 4; i++) {
				g.drawImage(images[i], 0, 0, null);
				if (i == currentLayer) {
					listener.drawPreview((Graphics2D) g);
				}
			}
		}
	
		preview = true;
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
	public Image getImage(int i){
		return images[i];
	}
	public boolean getPreview(){
		return preview;
	}
	public void setPreview (boolean preview){
		this.preview = preview;
	}
	public void removeListener(){
		removeMouseListener(listener);
		removeMouseMotionListener(listener);
	}
	public void setNewImage(int i){
		images[i] =  new BufferedImage(1000,600, BufferedImage.TYPE_INT_ARGB);
		repaint();
	}
	public void addListener(DrawListener listener) {
		this.removeMouseListener(this.listener);
		this.removeMouseMotionListener(this.listener);
		this.listener = listener;
		addMouseListener(listener);
		addMouseMotionListener(listener);
		}
	public int getCurrentLayer(){
		return currentLayer;
	}
	public void setCurrentLayer(int i){
		currentLayer = i;
		panel.setCurrentLayer(i);
	}
	public Image getCurrentImage(){
		return images[currentLayer];
	}
	public void setAllNewImages(){
		for(int i = 0; i < 4; i++){
			setNewImage(i);
		}
	}
}
