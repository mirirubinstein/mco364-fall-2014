package rubinstein.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
//homework: color chooser should work, and display stroke width and color
public class Paint extends JFrame {
	private JButton colorButton;
	public Paint(){
		setSize(800,600);
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
		
		colorButton = new JButton("ColorPanel");
		add(colorButton, BorderLayout.NORTH);
	//	ColorPanel colorPanel = new ColorPanel(canvas);
	//	add(colorPanel, BorderLayout.EAST);
		
		
		
		  ActionListener actionListener = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		        Color initialBackground = colorButton.getBackground();
		        Color choice = JColorChooser.showDialog(null, "JColorChooser Sample", initialBackground);
		        if (choice != null) {
		          canvas.setColor(choice);
		        }
		      }
		    };
		    colorButton.addActionListener(actionListener);
	}
	public static void main(String[] args){
		Paint paint = new Paint();
		paint.setVisible(true);
	}

}
