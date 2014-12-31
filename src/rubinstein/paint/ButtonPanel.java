package rubinstein.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;

import rubinstein.paint.message.ClearMessage;
import rubinstein.paint.message.Client;

public class ButtonPanel extends JPanel implements ActionListener {
	private Canvas canvas;
	private Client client;
	private JButton pencilButton;
	private JButton rectButton;
	private JButton fillRectButton;
	private JButton ovalButton;
	private JButton fillOvalButton;
	private JButton bucketFillButton;
	private JButton clearScreenButton;
	private DrawListener listener;

	public ButtonPanel(Canvas canvas) {
		this.canvas = canvas;
		client = canvas.getClient();
		pencilButton = new JButton("Pencil");
		rectButton = new JButton("Rectangle");
		fillRectButton = new JButton("Fill Rectangle");
		ovalButton = new JButton("Oval");
		fillOvalButton = new JButton("Fill Oval");
		bucketFillButton = new JButton("Bucket Fill");
		clearScreenButton = new JButton("CLEAR Screen");

		pencilButton.addActionListener(this);
		rectButton.addActionListener(this);
		fillRectButton.addActionListener(this);
		ovalButton.addActionListener(this);
		fillOvalButton.addActionListener(this);
		bucketFillButton.addActionListener(this);
		clearScreenButton.addActionListener(this);

		add(pencilButton);
		add(rectButton);
		add(fillRectButton);
		add(ovalButton);
		add(fillOvalButton);
		add(bucketFillButton);
		add(clearScreenButton);
		pencilButton.doClick();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == clearScreenButton) {
			//canvas.setNewImage();
			//canvas.setPreview(false);
			ClearMessage message = new ClearMessage();
			try {
				client.sendMessage(message.toString());
			} catch (IOException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
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

			}else if (e.getSource() == bucketFillButton) {
				listener = new BucketFillListener(canvas);
			}
			
			canvas.addListener(listener);
		}
	}
}
