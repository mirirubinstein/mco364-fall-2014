package rubinstein.paint;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import rubinstein.paint.message.Client;
import rubinstein.paint.message.ShapeMessage;

public class ShapeListener implements DrawListener {

	private Canvas canvas;
	private int x1, y1, x2, y2, width, height;
	private int strokeThickness;
	private Client client;
	private String shapeType;

	// private boolean drawPreview;
	public ShapeListener(Canvas canvas, String shapeType) {
		this.canvas = canvas;
		strokeThickness = canvas.getStrokeThickness();
		client = canvas.getClient();
		this.shapeType = shapeType;
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {

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
	public void mousePressed(MouseEvent e) {
		// drawPreview = true;
		// TODO Auto-generated method stub
		x1 = e.getX();
		y1 = e.getY();
		//canvas.repaint();

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		
		width = Math.abs(x2 - x1);
		height = Math.abs(y2 - y2);
		
		canvas.repaint();
		//drawPreview((Graphics2D) canvas.getImage().getGraphics());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		// drawPreview = false;
		x2 = e.getX();
		y2 = e.getY();
		
		width = Math.abs(x2 - x1);
		height = Math.abs(y2 - y2);


		draw();
		canvas.repaint();

	}

	public void draw() {

		ShapeMessage message = null;
		switch (shapeType) {

		case "Draw Rectangle":
			message = new ShapeMessage("RECT", Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2),
					Math.abs(y1 - y2), canvas.getColor().getRGB(), canvas.getStrokeThickness(), Boolean.FALSE);
			break;

		case "Fill Rectangle":
			message = new ShapeMessage("RECT", Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2),
					Math.abs(y1 - y2), canvas.getColor().getRGB(),  canvas.getStrokeThickness(), Boolean.TRUE);
			break;

		case "Draw Oval":
			message = new ShapeMessage("OVAL", Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2),
					Math.abs(y1 - y2), canvas.getColor().getRGB(),  canvas.getStrokeThickness(), Boolean.FALSE);
			break;

		case "Fill Oval":
			message = new ShapeMessage("OVAL", Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2),
					Math.abs(y1 - y2), canvas.getColor().getRGB(),  canvas.getStrokeThickness(), Boolean.TRUE);
			break;
		}

		canvas.getModule().sendMessage(message);
	}

	public void drawPreview(Graphics2D g) {

		width = Math.min(x1, x2);
		height = Math.min(y1,y2); 
		g.setStroke(new BasicStroke(canvas.getStrokeThickness(), BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND));
		g.setColor(canvas.getColor());
			
	
			switch (shapeType) {
			case "Draw Rectangle":
				g.drawRect( Math.min(x1, x2),  Math.min(y1, y2),Math.abs(x1 - x2),
						Math.abs(y1 - y2));
				break;

			case "Fill Rectangle":
				g.fillRect( Math.min(x1, x2),  Math.min(y1, y2),Math.abs(x1 - x2),
						Math.abs(y1 - y2));
				break;

			case "Draw Oval":
				g.drawOval( Math.min(x1, x2),  Math.min(y1, y2),Math.abs(x1 - x2),
						Math.abs(y1 - y2));
				break;

			case "Fill Oval":
				g.fillOval( Math.min(x1, x2),  Math.min(y1, y2),Math.abs(x1 - x2),
						Math.abs(y1 - y2));
				break;
			}
		

	}

}
