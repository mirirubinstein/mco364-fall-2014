package rubinstein.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import rubinstein.paint.message.BucketFillMessage;
import rubinstein.paint.message.Client;

public class BucketFillListener implements DrawListener {
	private Canvas canvas;
	private int x,y;
//	int screenBuffer[][];
	private BufferedImage bufferedImage;
	private Client client;


	public BucketFillListener(Canvas canvas){
		this.canvas = canvas;
		 bufferedImage = (BufferedImage) canvas.getImage();
		 client = canvas.getClient();
		}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	Graphics2D g = (Graphics2D) canvas.getGraphics();
	x = e.getX();
	
	y = e.getY();
	
	
	
	int graphicsRGB = g.getColor().getRGB();
	int imageRGB = bufferedImage.getRGB(x,y);
	
	//floodFill8(x,y, imageRGB, graphicsRGB);
	drawPreview(g);
	

	}
	
	void floodFill8(int x, int y, int newColor, int oldColor)
	{
	    if(x >= 0 && x < canvas.getWidth() && y >= 0 && y < canvas.getHeight() && oldColor != newColor)
	    {
	        //screenBuffer[x][y] = newColor; //set color before starting recursion!
	    	bufferedImage.setRGB(x,y, newColor);
	    	
	        floodFill8(x + 1, y,     newColor, oldColor);
	        floodFill8(x - 1, y,     newColor, oldColor);
	        floodFill8(x,     y + 1, newColor, oldColor);
	        floodFill8(x,     y - 1, newColor, oldColor);
	        floodFill8(x + 1, y + 1, newColor, oldColor);
	        floodFill8(x - 1, y - 1, newColor, oldColor);
	        floodFill8(x - 1, y + 1, newColor, oldColor);
	        floodFill8(x + 1, y - 1, newColor, oldColor);
	    }    
	}

    private int[][] getNeighborPixels(int x, int y) {
    	
        return new int[][] {
            {Math.min(x + 1, canvas.getWidth() - 1), y},  //right neighbor
            {Math.max(x - 1, 0), y},               //left neighbor
            {x, Math.min(y + 1, canvas.getHeight() - 1)}, //up neighbor
            {x, Math.max(y - 1, 0)}                //down neighbor
        };
    }
       


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawPreview(Graphics2D g) {
		// TODO Auto-generated method stub
		BucketFillMessage message = new BucketFillMessage(canvas, x, y, canvas.getColor().getRGB());
		canvas.getModule().sendMessage(message);
		
	}

	
	

}

