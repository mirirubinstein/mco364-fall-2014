package rubinstein.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

import rubinstein.paint.message.Client;


public class Paint extends JFrame {
	private JButton colorButton;
	private Canvas canvas;
	private BrushPanel brushPanel;
	private ButtonPanel buttonPanel;
	private Color choice;

	public Paint() throws UnknownHostException, IOException {
		setSize(1000, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Paint");
		setLocationRelativeTo(null);

		brushPanel = new BrushPanel();
		canvas = new Canvas(brushPanel);
		buttonPanel = new ButtonPanel(canvas);
		

		add(canvas, BorderLayout.CENTER);
		add(brushPanel, BorderLayout.EAST);
		add(buttonPanel, BorderLayout.SOUTH);
	

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

	public static void main(String[] args) throws UnknownHostException, IOException {
		Paint paint = new Paint();
		paint.setVisible(true);
	}

}
