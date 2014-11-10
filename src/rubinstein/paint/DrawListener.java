package rubinstein.paint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawListener implements  MouseMotionListener {
	private Canvas canvas;
	private int oldX, oldY;
	public DrawListener(Canvas canvas){
		this.canvas = canvas;
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
}


