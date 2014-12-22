package rubinstein.paint;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class FillOvalListener implements DrawListener {
	private Canvas canvas;
	private int x1, y1, x2, y2;
	private int strokeThickness;

	// private boolean drawPreview;
	public FillOvalListener(Canvas canvas) {
		this.canvas = canvas;
		strokeThickness = canvas.getStrokeThickness();
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

		g.setStroke(new BasicStroke(canvas.getStrokeThickness(), BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND));
		g.setColor(canvas.getColor());
		g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));

	}


	@Override
	public void drawPreview(Graphics2D g) {
		// TODO Auto-generated method stub
		draw(g);

	}

}
