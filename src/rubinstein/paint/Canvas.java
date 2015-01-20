package rubinstein.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.ConnectException;

import javax.swing.JComponent;

import rubinstein.paint.message.Client;
import rubinstein.paint.message.LoopbackNetworkModule;
import rubinstein.paint.message.NetworkModule;
import rubinstein.paint.message.OnlineNetworkModule;

public class Canvas extends JComponent {
	private DrawListener listener;
	private BrushPanel panel;
	private Client client;
	private NetworkModule module;
	private int strokeThickness;
	private Image image;
	private Color paintColor;
	private boolean preview;

	public Canvas(BrushPanel panel) throws IOException {
		this.panel = panel;
		try {
			client = new Client(this);
			module = new OnlineNetworkModule(client);
		} catch (Exception e) {
			if (e instanceof ConnectException) {
				module = new LoopbackNetworkModule(this);
			}
		}
		image = new BufferedImage(1000, 600, BufferedImage.TYPE_INT_ARGB);
		image.getGraphics().fillRect(0, 0, 1000, 600);
		paintColor = Color.BLACK;
		strokeThickness = 10;
		preview = true;

		addListener(new PencilListener(this));

		addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {

				int scrolledAmount = (-e.getWheelRotation());
				if (-scrolledAmount >= strokeThickness) {
					strokeThickness = 1;
				} else {
					strokeThickness += scrolledAmount;

				}
			}
		});
	}
	
	protected void paintComponent(Graphics g) {

		g.drawImage(image, 0, 0, null);
		panel.setStrokeWidth(strokeThickness);

		// all the listeners will implement this method differently, depending
		// on its shape
		//if (preview) {
		//	listener.drawPreview((Graphics2D) g);
		//}

		preview = true;
	}

	public Client getClient() {
		return client;
	}
	
	public void setColor(Color color) {
		paintColor = color;
	}

	public Color getColor() {
		return paintColor;
	}

	public int getStrokeThickness() {
		return strokeThickness;
	}

	public Image getImage() {
		return image;
	}

	public boolean getPreview() {
		return preview;
	}

	public void setPreview(boolean preview) {
		this.preview = preview;
	}

	public void removeListener() {
		removeMouseListener(listener);
		removeMouseMotionListener(listener);
	}

	public void setNewImage() {
		image = new BufferedImage(1000, 600, BufferedImage.TYPE_INT_ARGB);
		repaint();
	}

	public void addListener(DrawListener listener) {
		this.removeMouseListener(this.listener);
		this.removeMouseMotionListener(this.listener);
		this.listener = listener;
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}
	public NetworkModule getModule(){
		return module;
	}

}
