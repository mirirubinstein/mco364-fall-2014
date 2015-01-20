package rubinstein.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.io.IOException;

import rubinstein.paint.message.Client;
import rubinstein.paint.message.ShapeMessage;

public class ShapeListener implements DrawListener {

	private Canvas canvas;
	private int x1, y1, x2, y2;
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
		// canvas.repaint();

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		// canvas.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		// drawPreview = false;
		x2 = e.getX();
		y2 = e.getY();

		draw((Graphics2D) canvas.getImage().getGraphics());
		// canvas.repaint();

	}

	public void draw(Graphics2D g) {

		// g.setStroke(new BasicStroke(canvas.getStrokeThickness(),
		// BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		// g.setColor(canvas.getColor());
		// g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2),
		// Math.abs(y1 - y2));

		ShapeMessage message = null;
		switch (shapeType) {

		case "Draw Rectangle":
			message = new ShapeMessage("RECT", x1, x2, y1, y2, canvas
					.getColor().getRGB(), strokeThickness, Boolean.FALSE);
			break;

		case "Fill Rectangle":
			message = new ShapeMessage("RECT", x1, x2, y1, y2, canvas
					.getColor().getRGB(), strokeThickness, Boolean.TRUE);
			break;

		case "Draw Oval":
			message = new ShapeMessage("OVAL", x1, x2, y1, y2, canvas
					.getColor().getRGB(), strokeThickness, Boolean.FALSE);
			break;

		case "Fill Oval":
			message = new ShapeMessage("OVAL", x1, x2, y1, y2, canvas
					.getColor().getRGB(), strokeThickness, Boolean.TRUE);
			break;
		}

		canvas.getModule().sendMessage(message);
	}

	@Override
	public void drawPreview(Graphics2D g) {
		// TODO Auto-generated method stub
		draw(g);

	}

}
