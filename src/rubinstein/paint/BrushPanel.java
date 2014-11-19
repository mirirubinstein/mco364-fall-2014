package rubinstein.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BrushPanel extends JPanel {
	private JPanel colorPanel;
	private JPanel strokePanel;
	private JLabel strokeLabel;
	private JLabel strokeTitle;
	private int strokeWidth;

	public BrushPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setSize(200, 600);

		colorPanel = new JPanel();
		colorPanel.setBackground(Color.BLACK);
		add(colorPanel);
		strokeWidth = 10;
		strokePanel = new JPanel();
		strokePanel.setLayout(new BoxLayout(strokePanel, BoxLayout.Y_AXIS));
		strokeLabel = new JLabel("" + strokeWidth);
		strokeLabel.setFont(new Font("Helvetica", Font.PLAIN, 150));
		strokeTitle = new JLabel("Stroke width: ");
		strokeTitle.setFont(new Font("Helvetica", Font.PLAIN, 20));
		strokePanel.add(strokeTitle);
		strokePanel.add(strokeLabel);
		add(strokePanel);

		
	}

	public void setColorPanel(Color color) {
		colorPanel.setBackground(color);
	}

	public void setStrokeWidth(int strokeThickness) {
		strokeWidth = strokeThickness;
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		strokeLabel.setText("" + strokeWidth);
	}
}
