package rubinstein.paint.message;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;

public class ShapeMessage implements PaintMessage {
	private String type;
	private int x;
	private int y;
	private int width;
	private int height;
	private int color;
	private int stroke;
	private boolean fill;
	
	public ShapeMessage(String type, int x, int y, int width, int height, int color, int stroke, boolean fill){
		super();
		this.type = type;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
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


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
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
		return  "SHAPE " + type + " "  + x + " " + y + " " + width + " " + height + " " + color + " " + stroke + " " + fill + "\n" ;
	}


	@Override
	public void apply(Graphics2D g) {
		try{
		g.setColor(new Color(color));
		g.setStroke(new BasicStroke(stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

		switch (type) {
		case "RECT":
			if (fill) {
				g.fillRect(x,y,width,height);
			} else {
				g.drawRect(x,y,width,height);
			}
			break;
		case "OVAL":
			if (fill) {
				g.fillOval(x,y,width,height);
			} else {
				g.drawOval(x,y,width,height);
			}
		}
		}catch(Exception x){
			
		}
	}

}
