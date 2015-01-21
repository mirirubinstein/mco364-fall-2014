package rubinstein.paint.message;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Stack;

import rubinstein.paint.Canvas;


public class BucketFillMessage implements PaintMessage {

	private Canvas canvas; 
	private int x;
	private int y;
	private int color;

	public BucketFillMessage(Canvas canvas,int x, int y, int color) {
		this.canvas = canvas;
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	@Override
	public String toString(){
		return "BUCKET_FILL " + x + " " + y + " " + color + "\n";
	}

	@Override
	public void apply(Graphics2D g) {
		// TODO Auto-generated method stub
		BufferedImage bufferedImage = (BufferedImage) canvas.getImage();
        int clickedColor = bufferedImage.getRGB(x, y);
        int newColor = color;

		floodFill4Stack(x,y, newColor, clickedColor, bufferedImage);

	}
    void floodFill4Stack(int x, int y, int newColor, int oldColor, BufferedImage bufferedImage) {
        Stack<Point> stack = new Stack<Point>();
        stack.push(new Point(x, y));
        if (newColor == oldColor)
            return; // avoid infinite loop
        while (!stack.isEmpty()) {
            
            Point current = stack.pop();
                    //    System.out.println(current);
                        bufferedImage.setRGB((int) current.getX(), (int) current.getY(),
                                newColor);

                        if (current.getX() + 1 < bufferedImage.getWidth()
                                && bufferedImage.getRGB((int)current.getX() + 1, (int)current.getY()) == oldColor) {
                            stack.push(new Point((int)current.getX() + 1, (int)current.getY()));
                        }
                        if (current.getX() - 1 >= 0 && bufferedImage.getRGB((int)current.getX() - 1, (int)current.getY()) == oldColor) {
                            stack.push(new Point((int)current.getX() - 1, (int)current.getY()));
                        }
                        if (current.getY() + 1 < bufferedImage.getHeight()
                                && bufferedImage.getRGB((int)current.getX(), (int)current.getY() + 1) == oldColor) {
                            stack.push(new Point((int)current.getX(), (int)current.getY() + 1));
                        }
                        if (current.getY() - 1 >= 0 && bufferedImage.getRGB((int)current.getX(), (int)current.getY() - 1) == oldColor) {
                            stack.push(new Point((int)current.getX(), (int)current.getY() - 1));
                        }
                    }
       // canvas.repaint();
    }


}
