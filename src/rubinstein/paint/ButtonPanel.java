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
	private JButton bucketFillButton;
	private JButton clearCurrentLayerButton;
	private JButton clearScreenButton;
	private DrawListener listener;

	public ButtonPanel(Canvas canvas) {
		this.canvas = canvas;
		pencilButton = new JButton("Pencil");
		rectButton = new JButton("Rectangle");
		fillRectButton = new JButton("Fill Rectangle");
		ovalButton = new JButton("Oval");
		fillOvalButton = new JButton("Fill Oval");
		bucketFillButton = new JButton("Bucket Fill");
		clearCurrentLayerButton = new JButton("CLEAR current layer");
		clearScreenButton = new JButton("CLEAR all layers");

		pencilButton.addActionListener(this);
		rectButton.addActionListener(this);
		fillRectButton.addActionListener(this);
		ovalButton.addActionListener(this);
		fillOvalButton.addActionListener(this);
		bucketFillButton.addActionListener(this);
		clearCurrentLayerButton.addActionListener(this);
		clearScreenButton.addActionListener(this);

		add(pencilButton);
		add(rectButton);
		add(fillRectButton);
		add(ovalButton);
		add(fillOvalButton);
		add(bucketFillButton);
		add(clearCurrentLayerButton);
		add(clearScreenButton);
		pencilButton.doClick();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == clearScreenButton) {
			canvas.setAllNewImages();
			canvas.setPreview(false);
		}else if(e.getSource() == clearCurrentLayerButton){
			canvas.setNewImage(canvas.getCurrentLayer());
			canvas.setPreview(false);
		} else {
			canvas.setPreview(true);
			if (e.getSource() == pencilButton) {
				listener = new PencilListener(canvas);

			} else if (e.getSource() == rectButton) {
				listener = new ShapeListener(canvas, "Draw Rectangle");

			} else if (e.getSource() == fillRectButton) {
				listener = new ShapeListener(canvas, "Fill Rectangle");

			} else if (e.getSource() == ovalButton) {
				listener = new ShapeListener(canvas, "Draw Oval");

			} else if (e.getSource() == fillOvalButton) {
				listener = new ShapeListener(canvas, "Fill Oval");

			}else if (e.getSource() == bucketFillButton) {
				listener = new BucketFillListener(canvas);
			}
			
			canvas.addListener(listener);
		}
	}
}
