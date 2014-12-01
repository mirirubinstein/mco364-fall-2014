package rubinstein.paint;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class FillOvalListener implements DrawListener {
	private Canvas canvas;
	private Graphics2D g;
	private int x1, y1, x2, y2;
	private int strokeThickness;

	public FillOvalListener(Canvas canvas) {
		this.canvas = canvas;
		g = (Graphics2D) canvas.getImage().getGraphics();
		strokeThickness = canvas.getStrokeThickness();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();

		draw(g);
		canvas.repaint();

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
		// TODO Auto-generated method stub
		x1 = e.getX();
		y1 = e.getY();

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setStroke(new BasicStroke(canvas.getStrokeThickness(), BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND));
		g.setColor(canvas.getColor());
		g.fillOval(x1, y1, x2, y2);
		// System.out.println(x1 + "\n" + y1 + "\n" +x2 + "\n" +y2+ "\n" );

	}

}
