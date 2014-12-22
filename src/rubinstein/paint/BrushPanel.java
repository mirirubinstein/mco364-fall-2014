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
	private JPanel layerPanel;
	private JLabel strokeLabel;
	private JLabel strokeTitle;
	private JLabel currentLayer;
	private JLabel currentLayerLabel;
	private int strokeWidth;
	private int currentLayerNum;

	public BrushPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setSize(200, 600);

		colorPanel = new JPanel();
		
		colorPanel.setBackground(Color.BLACK);
		add(colorPanel);
		strokeWidth = 10;
		currentLayerNum = 1;
		strokePanel = new JPanel();
		strokePanel.setLayout(new BoxLayout(strokePanel, BoxLayout.Y_AXIS));
		strokeLabel = new JLabel("" + strokeWidth);
		strokeLabel.setFont(new Font("Helvetica", Font.PLAIN, 100));
		strokeTitle = new JLabel("Stroke width: ");
		strokeTitle.setFont(new Font("Helvetica", Font.PLAIN, 20));
		
		strokePanel.add(strokeTitle);
		strokePanel.add(strokeLabel);
		add(strokePanel);
		
		layerPanel = new JPanel();
		layerPanel.setLayout(new BoxLayout(layerPanel, BoxLayout.Y_AXIS));
		currentLayer = new JLabel("Current Layer: ");
		currentLayer.setFont(new Font("Helvetica", Font.PLAIN, 20));
		currentLayerLabel = new JLabel("" + currentLayerNum);
		currentLayerLabel.setFont(new Font("Helvetica", Font.PLAIN, 100));
		layerPanel.add(currentLayer);
		layerPanel.add(currentLayerLabel);
		add(layerPanel);
		

		
	}

	public void setColorPanel(Color color) {
		colorPanel.setBackground(color);
	}

	public void setStrokeWidth(int strokeThickness) {
		strokeWidth = strokeThickness;
		repaint();
	}
	public void setCurrentLayer(int currentLayer){
		currentLayerNum = currentLayer + 1;
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		strokeLabel.setText("" + strokeWidth);
		currentLayerLabel.setText("" + currentLayerNum);
		
	}
}
