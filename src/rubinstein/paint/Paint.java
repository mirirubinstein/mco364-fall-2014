package rubinstein.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;


public class Paint extends JFrame {
	private JButton colorButton;
	private Canvas canvas;
	private BrushPanel brushPanel;
	private ButtonPanel buttonPanel;
	private LayerButtonPanel layerPanel;
	private Color choice;

	public Paint() {
		setSize(1000, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Paint");
		setLocationRelativeTo(null);

		brushPanel = new BrushPanel();
		canvas = new Canvas(brushPanel);
		buttonPanel = new ButtonPanel(canvas);
		layerPanel = new LayerButtonPanel(canvas);
		

		add(canvas, BorderLayout.CENTER);
		add(brushPanel, BorderLayout.EAST);
		add(buttonPanel, BorderLayout.SOUTH);
		add(layerPanel, BorderLayout.WEST);
	

		colorButton = new JButton("ColorPanel");
		add(colorButton, BorderLayout.NORTH);

		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				Color initialBackground = colorButton.getBackground();
				choice = JColorChooser.showDialog(null, "JColorChooser Sample",
						initialBackground);
				if (choice != null) {
					canvas.setColor(choice);
					brushPanel.setColorPanel(choice);
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
