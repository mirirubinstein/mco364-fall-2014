package rubinstein.paint.message;

import java.awt.Graphics2D;

public class LineMessage  implements PaintMessage {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int color;
	private int stroke;
	
	public LineMessage(int x1, int y1, int x2, int y2, int color, int stroke){
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
		this.stroke = stroke;
	}

	@Override
	public void apply(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
}
