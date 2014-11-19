package rubinstein.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

//homework: add to your interface the ability to change between pencil, drawing oval, drawing rect, filling oval, filling rect, drawing line
//clear screen
//buttons to implement it
public class Paint extends JFrame {
	private JButton colorButton;
	private Canvas canvas;
	private BrushPanel panel;
	private Color choice;

	public Paint() {
		setSize(1000, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Paint");
		setLocationRelativeTo(null);

		panel = new BrushPanel();
		canvas = new Canvas(panel);

		add(canvas, BorderLayout.CENTER);
		add(panel, BorderLayout.EAST);
		RectListener listener = new RectListener(canvas);
		canvas.addMouseMotionListener(listener);
		canvas.addMouseListener(listener);

		colorButton = new JButton("ColorPanel");
		add(colorButton, BorderLayout.NORTH);

		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Color initialBackground = colorButton.getBackground();
				choice = JColorChooser.showDialog(null, "JColorChooser Sample",
						initialBackground);
				if (choice != null) {
					canvas.setColor(choice);
					panel.setColorPanel(choice);
				}
			}
		};
		colorButton.addActionListener(actionListener);
	}

	public static void main(String[] args) {
		Paint paint = new Paint();
		paint.setVisible(true);
	}

}
