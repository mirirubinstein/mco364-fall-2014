package rubinstein.network;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client33 extends JFrame{
	private JTextField jtf = new JTextField();
	private JTextArea jta = new JTextArea();
	
	private DataOutputStream toServer;
	private DataInputStream fromServer;
	
	public static void main (String[] args){
		new Client33();
	}
	public Client33(){
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(new JLabel("Enter radius: "), BorderLayout.WEST);
		p.add(jtf, BorderLayout.CENTER);
		jtf.setHorizontalAlignment(JTextField.RIGHT);
		
		setLayout(new BorderLayout());
		add(p, BorderLayout.NORTH);
		add(new JScrollPane(jta), BorderLayout.CENTER);
		
		jtf.addActionListener(new TextFieldListener());
		
		setTitle("Client");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		try{
			Socket socket = new Socket("localhost", 8085);
			fromServer = new DataInputStream(socket.getInputStream());
			toServer = new DataOutputStream(socket.getOutputStream());
			
		}catch(IOException ex){
			jta.append(ex.toString() + 'n');
		}
	}
	private class TextFieldListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			try{
				double radius = Double.parseDouble(jtf.getText().trim());
				
				toServer.writeDouble(radius);
				toServer.flush();
				
				double area = fromServer.readDouble();
				
				jta.append("Radius is: " + radius + 'n');
				jta.append("Arear rec'd from the server is: " + area + 'n');
			}catch(IOException ex){
				System.err.println(ex);
			}
		}
	}
}
