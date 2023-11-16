package main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display 
{
	private JFrame f;
	private Canvas canvas;
	
	public Display()
	{
		f = new JFrame("GAME");
		f.setSize(500,500);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(500,500));
		canvas.setMaximumSize(new Dimension(500,500));
		canvas.setMinimumSize(new Dimension(500,500));
		f.add(canvas);
		f.pack();
		f.setVisible(true);
	}

	public JFrame getF() {
		return f;
	}

	public Canvas getCanvas() {
		return canvas;
	}
}
