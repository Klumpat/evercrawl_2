package gfx;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private String title;
	@SuppressWarnings("unused")
	private int width, height, scale;
	private JFrame frame;

	public Window(int width, int height, String title) {
		this.title = title;
		this.width = width;
		this.height = height;

		Dimension size = new Dimension(width, height);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);

		frame = new JFrame(title);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	public void setTitle(String title) {
		frame.setTitle(title);
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
