package rubinstein.paint;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Paint extends JFrame {
	public Paint(){
		setSize(900,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Paint");
		setLocationRelativeTo(null);
	//	BorderLayout layout = new BorderLayout();
	//	Container container = getContentPane();
	//	container.setLayout(layout);
		
		Canvas canvas = new Canvas();
		add(canvas, BorderLayout.CENTER);
		DrawListener listener = new DrawListener(canvas);
		canvas.addMouseMotionListener(listener);
		
		ColorPanel colorPanel = new ColorPanel(canvas);
		add(colorPanel, BorderLayout.EAST);
		
		
		
	}
	public static void main(String[] args){
		Paint paint = new Paint();
		paint.setVisible(true);
	}

}
