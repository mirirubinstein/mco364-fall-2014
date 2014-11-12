package rubinstein.paint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawListener implements MouseListener, MouseMotionListener {
	private Canvas canvas;
	private int oldX, oldY;
	public DrawListener(Canvas canvas){
		this.canvas = canvas;
	}

	@Override
	public void mousePressed(MouseEvent e){
		oldX = e.getX();
		oldY = e.getY();
	}

	
	@Override
	public void mouseDragged(MouseEvent e) {
		canvas.setPoint(oldX, oldY, e.getX(), e.getY());
		canvas.repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
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
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
