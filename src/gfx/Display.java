package gfx;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import core.CoreEngine;
import util.Debug;

public class Display {
	
	private Window window;
	private Graphics graphics;
	private BufferStrategy bufferStrategy;
	private BufferedImage img;
	private int[] pixels;
	
	public Display(Window window){
		this.window = window;
		
		img = new BufferedImage(CoreEngine.WIDTH, CoreEngine.HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
		
		window.createBufferStrategy(2);
		bufferStrategy = window.getBufferStrategy();
		graphics = bufferStrategy.getDrawGraphics();
		
		Debug.init(graphics);
	}
	
	public Graphics getGraphics(){
		return graphics;
	}
	
	public void showImage(){
		graphics = bufferStrategy.getDrawGraphics();
		graphics.drawImage(img, 0, 0, window.getWidth(), window.getHeight(), null);
		graphics.dispose();
		bufferStrategy.show();
	}
	
	public void getPixelData(int[] pixels){
		for(int i = 0; i<pixels.length;i++){
			this.pixels[i] = pixels[i];
		}
		
		//this.pixels = pixels.clone();
	}
	
	
	
	

}
