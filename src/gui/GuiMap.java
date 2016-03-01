package gui;

import core.Scene;
import gfx.Bitmap;
import gfx.Renderer;
import maths.Bounds;

public class GuiMap extends GuiPanel{
	
	private Bitmap map;
	private Bitmap toDraw;

	public GuiMap(Bounds bounds) {
		super(bounds, 0xff00ff);
		map = new Bitmap(getWidth(), getWidth());
		visible = true;
	}
	
	
	@Override
	public void render(Renderer renderer, int xOffset, int yOffset) {
		super.render(renderer, xOffset, yOffset);
		if (visible) {
			renderer.GUIdrawBitmap(toDraw, bounds.getX() + xOffset, bounds.getY() + yOffset);
		}
	}
	
	@Override
	public void update(Scene scene) {
		super.update(scene);
		
		map = scene.getTileMap().getMapData();
		toDraw = new Bitmap(getWidth(), getHeight());
		
		float x0 = (scene.getPlayer().getPosition().x / 32)- getWidth()/2;
		float y0 = (scene.getPlayer().getPosition().y / 32) - getHeight()/2;
		
		
		
		for (int y = 0; y < toDraw.getHeight(); y++) {
			int yy = (int) (y + y0);
			if(yy < 0 || yy>=map.getHeight()) continue;
			for (int x = 0; x < map.getWidth(); x++) {
				int xx = (int) (x + x0);
				if(xx < 0 || x>=toDraw.getWidth()) continue;
				toDraw.pix[x + y * getWidth()] = map.pix[xx + yy * map.getWidth()];
			}
		}
		
		
//		for(int y = 0; y<map.getHeight();y++){
//			for(int x = 0; x<map.getWidth();x++){
//				Tile t = scene.getTile(scene.getPlayer().getPosition().x + x, scene.getPlayer().getPosition().y+y);
//				int col = t.getMapColor();
//				//System.out.println(t+" @ "+(col));
//				map.setPixel(x, y, col);
//			}
//		}
		
	}
	
	

}
