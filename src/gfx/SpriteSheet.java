package gfx;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	public static Bitmap spriteSheet = loadSpriteSheet("spritesheet");
	public static Bitmap sheet = loadSpriteSheet("sheet");
	public static Bitmap ocean_sheet = loadSpriteSheet("Ocean_SpriteSheet");
	public static Bitmap magma_sheet = loadSpriteSheet("Magma_SpriteSheet");
	public static Bitmap playersheet = loadSpriteSheet("playersheet");
	public static Bitmap fontSheet16x16 = loadSpriteSheet("fonts");
	public static Bitmap fontSheet8x8 = loadSpriteSheet("fonts8x8");
	public static Bitmap torch = loadSpriteSheet("torch");

	private static Bitmap loadSpriteSheet(String path) {
		
		Bitmap result = null;
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new File("res/SpriteSheets/" + path + ".png"));
			int width = img.getWidth();
			int height = img.getHeight();
			
			result = new Bitmap(width, height);
			img.getRGB(0, 0, width, height, result.pix, 0, width);
			System.out.println("Spritesheet: " + path + " loaded, w/h: " + result.getWidth() + " / " + result.getHeight());
//			for(int i = 0; i<width * height; i++){
				//System.out.println(0xffffffff == result.pix[width]);
//			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("cant load SpriteSheet from " + path +" !");
			System.exit(1);
		}
		
		
		if(result == null){
			System.err.println("There was a problem while loading Spritesheet: " + "/res" + path + ".png");
			System.exit(1);
		}
		
		return result;
		
		
		
	}

}
