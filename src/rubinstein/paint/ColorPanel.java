package rubinstein.paint;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ColorPanel extends JPanel implements ActionListener{
	private Canvas canvas;
	private JButton black;
	private JButton red;
	private JButton blue;
	private JButton green;
	private JButton orange;
	private JButton yellow;
	private JButton purple;
	private JButton white;
	
	public ColorPanel(Canvas canvas){
		this.canvas = canvas;
		setSize(100,600);
		setLayout(new GridLayout(4,1));
		black = new JButton("Black");
		red = new JButton("Red");
		blue = new JButton("Blue");
		green = new JButton("Green");
		orange = new JButton("Orange");
		yellow = new JButton("Yellow");	
		purple = new JButton("Purple");
		white = new JButton("White");
		black.addActionListener(this);
		red.addActionListener(this);
		blue.addActionListener(this);
		green.addActionListener(this);
		orange.addActionListener(this);
		yellow.addActionListener(this);
		purple.addActionListener(this);
		white.addActionListener(this);
		add(black);
		add(red);
		add(blue);
		add(green);
		add(orange);
		add(yellow);
		add(purple);
		add(white);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		  if(e.getSource() == black){
	        	canvas.setColor(Color.BLACK);
	        }else if(e.getSource() == red){
	        	canvas.setColor(Color.RED);
	        }else if(e.getSource() == blue){
	        	canvas.setColor(Color.BLUE);
	        }else if(e.getSource() == green){
	        	canvas.setColor(Color.GREEN);
	        }else if(e.getSource() == orange){
	        	canvas.setColor(Color.ORANGE);
	        }else if(e.getSource() == yellow){
	        	canvas.setColor(Color.YELLOW);
	        }else if(e.getSource() == purple){
	        	canvas.setColor(Color.MAGENTA);
	        }else if(e.getSource() == white){
	        	canvas.setColor(Color.WHITE);
	        }
		
	}
	

}

