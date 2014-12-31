package rubinstein.paint.message;

import java.awt.Graphics2D;

public class ClearMessage implements PaintMessage {

	@Override
	public String toString() {
		return "CLEAR\n";
	}

	@Override
	public void apply(Graphics2D g) {
		// TODO Auto-generated method stub
		g.fillRect(0, 0, 1000, 600);
	}
	
}
