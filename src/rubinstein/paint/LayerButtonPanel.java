package rubinstein.paint;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LayerButtonPanel extends JPanel implements ActionListener {
	private Canvas canvas;
	private JButton layer1;
	private JButton layer2;
	private JButton layer3;
	private JButton layer4;
	
	public LayerButtonPanel(Canvas canvas){
		setLayout(new GridLayout(4,1,0,4));

		this.canvas = canvas;
		layer1 = new JButton("Layer 1");
		layer2 = new JButton("Layer 2");
		layer3 = new JButton("Layer 3");
		layer4 = new JButton("Layer 4");
		
		layer1.addActionListener(this);
		layer2.addActionListener(this);
		layer3.addActionListener(this);
		layer4.addActionListener(this);
		
		add(layer1);
		add(layer2);
		add(layer3);
		add(layer4);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == layer1) {
			canvas.setCurrentLayer(0);
		} else if (e.getSource() == layer2) {
			canvas.setCurrentLayer(1);
		} else if (e.getSource() == layer3) {
			canvas.setCurrentLayer(2);
		} else if (e.getSource() == layer4) {
			canvas.setCurrentLayer(3);
	}
		
	}

}
