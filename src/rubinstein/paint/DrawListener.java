package rubinstein.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public interface DrawListener extends MouseMotionListener, MouseListener {

	void draw(Graphics2D g);
}
