package rubinstein.paint;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class PencilListener implements DrawListener{
	private Canvas canvas;
	private int oldX, oldY, currentX, currentY;
	private int strokeThickness;


	public PencilListener(Canvas canvas){
		this.canvas = canvas;
		strokeThickness = canvas.getStrokeThickness();
		}

	
	@Override
	public void mouseDragged(MouseEvent e) {
		setPoint(oldX, oldY, e.getX(), e.getY());		
		canvas.repaint();		
	}
	
	public void setPoint(int x1, int y1, int x2, int y2){
		currentX = x2;
		currentY = y2;
		
		drawPreview((Graphics2D) canvas.getCurrentImage().getGraphics());
		
		oldX = currentX;
		oldY= currentY;	
		
	}


	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
		oldX = e.getX();
		oldY = e.getY();
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}


	@Override
	public void drawPreview(Graphics2D g) {
		g.setStroke(new BasicStroke(canvas.getStrokeThickness(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g.setColor(canvas.getColor());

		g.drawLine(oldX, oldY, currentX, currentY);
	}


}
