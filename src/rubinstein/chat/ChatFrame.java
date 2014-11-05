package rubinstein.chat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class ChatFrame extends JFrame implements ActionListener {
	private JTextPane jPane;
	private JPanel containerPanel;
	private JScrollPane areaScrollPane;
	private StringBuilder myMessage;
	private JPanel chatPanel;
	private JTextPane chatBox;
	private JButton sendButton;
	private Socket socket;

	public ChatFrame() {

		chatPanel = new JPanel();
		chatPanel.setSize(getWidth(), 100);
		chatBox = new JTextPane();
		chatBox.setPreferredSize(new Dimension(290, 60));
		sendButton = new JButton("SEND");
		sendButton.addActionListener(this);
		add(chatPanel);
		chatPanel.add(chatBox, BorderLayout.CENTER);
		chatPanel.add(sendButton, BorderLayout.EAST);

		this.jPane = new JTextPane();
		myMessage = new StringBuilder();

		jPane.setText(myMessage.toString());
		areaScrollPane = new JScrollPane(jPane);
		areaScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(360, 250));

		jPane.setPreferredSize(new Dimension(400, 150));
		this.containerPanel = new JPanel();
		containerPanel.setBorder(BorderFactory
				.createEmptyBorder(10, 10, 10, 10));
		add(containerPanel);

		this.setTitle("My Chat");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		containerPanel.add(areaScrollPane);
		containerPanel.add(chatPanel);
		setVisible(true);

	}

	public void appendMessage(String message) {
		myMessage.append(message).append("\n");
		jPane.setText(myMessage.toString());

	}

	public JTextPane getPane() {
		return jPane;
	}

	public void actionPerformed(ActionEvent e) {

		appendMessage(getMessage());
		try {
			sendMessage(getMessage());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		chatBox.setText("");

	}

	public String getMessage() {
		return chatBox.getText();
	}

	public void sendMessage(String message) throws IOException {
		Thread thread = new NetworkRequest(this, socket, message);
		thread.start();

	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

}
