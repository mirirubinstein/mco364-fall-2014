package rubinstein.paint;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class ShapeListener implements DrawListener {

	private Canvas canvas;
	private int x1, y1, x2, y2;
	private int strokeThickness;
	private String shapeType;

	// private boolean drawPreview;
	public ShapeListener(Canvas canvas, String shapeType) {
		this.canvas = canvas;
		strokeThickness = canvas.getStrokeThickness();
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
		canvas.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		// drawPreview = false;
		x2 = e.getX();
		y2 = e.getY();

		draw((Graphics2D) canvas.getCurrentImage().getGraphics());
		canvas.repaint();

	}

	public void draw(Graphics2D g) {

		g.setStroke(new BasicStroke(canvas.getStrokeThickness(),
				BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g.setColor(canvas.getColor());
		switch (shapeType) {
		case "Draw Rectangle":
			g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2),
					Math.abs(y1 - y2));
			break;

		case "Fill Rectangle":
			g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2),
					Math.abs(y1 - y2));
			break;

		case "Draw Oval":
			g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2),
					Math.abs(y1 - y2));
			break;

		case "Fill Oval":
			g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2),
					Math.abs(y1 - y2));
			break;
		}

	}

	@Override
	public void drawPreview(Graphics2D g) {
		// TODO Auto-generated method stub
		draw(g);

	}

}
