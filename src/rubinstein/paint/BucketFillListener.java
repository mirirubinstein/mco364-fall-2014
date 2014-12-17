package rubinstein.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class BucketFillListener implements DrawListener {
	private Canvas canvas;
	private int x,y;
//	int screenBuffer[][];
	BufferedImage bufferedImage;



	public BucketFillListener(Canvas canvas){
		this.canvas = canvas;
		// screenBuffer = new int[canvas.getWidth()][canvas.getHeight()];
		 bufferedImage = (BufferedImage) canvas.getImage();
		}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	Graphics2D g = (Graphics2D) canvas.getGraphics();
	x = e.getX();
	
	y = e.getY();
	
	
	
	int graphicsRGB = g.getColor().getRGB();
	int imageRGB = bufferedImage.getRGB(x,y);
	
	floodFill8(x,y, imageRGB, graphicsRGB);
/*	System.out.println(graphicsRGB);
	System.out.println(imageRGB);
	int[][] neighbors = getNeighborPixels(x,y);
	for(int i = 0; i < neighbors.length; i++){
		for(int j = 0; j < neighbors[i].length; j++){
			System.out.println(neighbors[i][j]);
				bufferedImage.setRGB(x,y, graphicsRGB);
			 if (bufferedImage.getRGB(neighbors[i][0], neighbors[i][1]) == imageRGB) {
                 bufferedImage.setRGB(neighbors[i][0], neighbors[i][1], graphicsRGB);
			 }
                  canvas.repaint(); 
		}
		
	}
	
		
	/*	while(graphicsRGB != imageRGB){
		
		  Queue<int[]> pixelQueue = new LinkedList<int[]>();
          pixelQueue.add(new int[] {x, y});        
          int[] pixel;
          int nx, ny;
          
          while (!pixelQueue.isEmpty()) {
              pixel = pixelQueue.poll();
              nx = pixel[0];
              ny = pixel[1];
              if (bufferedImage.getRGB(nx, ny) == imageRGB) {
                  bufferedImage.setRGB(nx, ny, graphicsRGB);
                  
                  for (int[] neighbor : getNeighborPixels(nx, ny)) {
                      if (bufferedImage.getRGB(neighbor[0], neighbor[1]) != graphicsRGB) {
                          pixelQueue.add(new int[] {neighbor[0], neighbor[1]});
                      }
                  }
              }
		
          }
		
		
	} 
	*/	
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
		
	}

	
	

}

