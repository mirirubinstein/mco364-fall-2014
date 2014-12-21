package rubinstein.paint;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class BucketFillListener implements DrawListener{
	private Canvas canvas;
	
	public BucketFillListener(Canvas canvas){
		this.canvas = canvas;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		BufferedImage bufferedImage = (BufferedImage) canvas.getImage();
		int clickedColor = bufferedImage.getRGB(x, y);
		int newColor = canvas.getColor().getRGB();
		floodFill4Stack(x,y, newColor, clickedColor, bufferedImage);
		canvas.repaint();
	}
	
	void floodFill4Stack(int x, int y, int newColor, int oldColor, BufferedImage bufferedImage) {
		Stack<Point> stack = new Stack<Point>();
		stack.push(new Point(x, y));
		if (newColor == oldColor)
			return; // avoid infinite loop
		while (!stack.isEmpty()) {
			
			Point current = stack.pop();
					//	System.out.println(current);
						bufferedImage.setRGB((int) current.getX(), (int) current.getY(),
								newColor);

						if (current.getX() + 1 < canvas.getWidth()
								&& bufferedImage.getRGB((int)current.getX() + 1, (int)current.getY()) == oldColor) {
							stack.push(new Point((int)current.getX() + 1, (int)current.getY()));
						}
						if (current.getX() - 1 >= 0 && bufferedImage.getRGB((int)current.getX() - 1, (int)current.getY()) == oldColor) {
							stack.push(new Point((int)current.getX() - 1, (int)current.getY()));
						}
						if (current.getY() + 1 < canvas.getHeight()
								&& bufferedImage.getRGB((int)current.getX(), (int)current.getY() + 1) == oldColor) {
							stack.push(new Point((int)current.getX(), (int)current.getY() + 1));
						}
						if (current.getY() - 1 >= 0 && bufferedImage.getRGB((int)current.getX(), (int)current.getY() - 1) == oldColor) {
							stack.push(new Point((int)current.getX(), (int)current.getY() - 1));
						}
					}
		canvas.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawPreview(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

}
