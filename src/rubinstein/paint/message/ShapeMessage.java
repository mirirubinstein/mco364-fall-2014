package rubinstein.paint.message;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;

public class ShapeMessage implements PaintMessage {
	private String type;
	private int x1;
	private int x2;
	private int y1;
	private int y2;
	private int color;
	private int stroke;
	private boolean fill;
	
	public ShapeMessage(String type, int x, int y, int width, int height, int color, int stroke, boolean fill){
		super();
		this.type = type;
		this.x1 = x;
		this.x2 = y;
		this.y1 = width;
		this.y2 = height;
		this.color = color;
		this.stroke = stroke;
		this.fill = fill;
	}
	

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getX() {
		return x1;
	}


	public void setX(int x) {
		this.x1 = x;
	}


	public int getY() {
		return x2;
	}


	public void setY(int y) {
		this.x2 = y;
	}


	public int getWidth() {
		return y1;
	}


	public void setWidth(int width) {
		this.y1 = width;
	}


	public int getHeight() {
		return y2;
	}


	public void setHeight(int height) {
		this.y2 = height;
	}


	public int getColor() {
		return color;
	}


	public void setColor(int color) {
		this.color = color;
	}


	public int getStroke() {
		return stroke;
	}


	public void setStroke(int stroke) {
		this.stroke = stroke;
	}


	public boolean isFill() {
		return fill;
	}


	public void setFill(boolean fill) {
		this.fill = fill;
	}
	


	@Override
	public String toString() {
		return  "SHAPE " + type + " "  + x1 + " " + x2 + " " + y1 + " " + y2 + " " + color + " " + stroke + " " + fill + "\n" ;
	}


	@Override
	public void apply(Graphics2D g) {
		g.setColor(new Color(color));
		g.setStroke(new BasicStroke(stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

		switch (type) {
		case "RECT":
			if (fill) {
				g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2),
									Math.abs(y1 - y2));
			} else {
				g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2),
									Math.abs(y1 - y2));
			}
			break;
		case "OVAL":
			if (fill) {
				g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
			} else {
				g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
			}
		}
		
	}

}
