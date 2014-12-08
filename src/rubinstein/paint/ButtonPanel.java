package rubinstein.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel implements ActionListener {
	private Canvas canvas;
	private JButton pencilButton;
	private JButton rectButton;
	private JButton fillRectButton;
	private JButton ovalButton;
	private JButton fillOvalButton;
	private JButton clearScreenButton;
	private DrawListener listener;

	public ButtonPanel(Canvas canvas) {
		this.canvas = canvas;
		pencilButton = new JButton("Pencil");
		rectButton = new JButton("Rectangle");
		fillRectButton = new JButton("Fill Rectangle");
		ovalButton = new JButton("Oval");
		fillOvalButton = new JButton("Fill Oval");
		clearScreenButton = new JButton("CLEAR Screen");

		pencilButton.addActionListener(this);
		rectButton.addActionListener(this);
		fillRectButton.addActionListener(this);
		ovalButton.addActionListener(this);
		fillOvalButton.addActionListener(this);
		clearScreenButton.addActionListener(this);

		add(pencilButton);
		add(rectButton);
		add(fillRectButton);
		add(ovalButton);
		add(fillOvalButton);
		add(clearScreenButton);
		pencilButton.doClick();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == clearScreenButton) {
			canvas.setNewImage();
			canvas.setPreview(false);
		} else {
			canvas.setPreview(true);
			if (e.getSource() == pencilButton) {
				listener = new PencilListener(canvas);

			} else if (e.getSource() == rectButton) {
				listener = new RectListener(canvas);

			} else if (e.getSource() == fillRectButton) {
				listener = new FillRectListener(canvas);

			} else if (e.getSource() == ovalButton) {
				listener = new OvalListener(canvas);

			} else if (e.getSource() == fillOvalButton) {
				listener = new FillOvalListener(canvas);

			}
			
			canvas.addListener(listener);
		}
	}
}
