package main;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements MouseMotionListener, KeyListener
{
	private Display display;
	private BufferStrategy bs;
	private Graphics g;
	
	private int x = 0, y = 0;
	private int mouseX = 0, mouseY = 0;
	
	private Robot r;
	
	private int height, width;
	private int radius = 200, theta = 0;
	
	private BufferedImage image;
	
	public Game()
	{
		display = new Display();
		display.getF().addMouseMotionListener(this);
		display.getCanvas().addMouseMotionListener(this);
		display.getCanvas().addKeyListener(this);
		display.getF().addKeyListener(this);
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
			System.exit(0);
		}
		GraphicsDevice gd = MouseInfo.getPointerInfo().getDevice();
		width = gd.getDisplayMode().getWidth();
		height = gd.getDisplayMode().getHeight();
		x = width/2;
		y = height/2;
		run();
	}
	
	private void run()
	{
		while(true)
		{
			tick();
			render();
		}
	}
	
	private void tick()
	{
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		x = (int) b.getX();
		y = (int) b.getY();
		image = r.createScreenCapture(new Rectangle(x-50, y-50, 100, 100));
	}
	
	private void render()
	{
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		g.clearRect(0, 0, 500, 500);

		g.drawImage(image, 0, 0, 500, 500, null);
		g.drawRect(250, 250, 100, 100);
		bs.show();
		g.dispose();
	}

	@Override
	public void mouseDragged(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.exit(0);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
