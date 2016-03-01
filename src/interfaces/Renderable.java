package interfaces;

import gfx.Renderer;

public interface Renderable {

	public int getWidth();

	public int getHeight();

	public int[] getPixels();

	
	public void renderSelf(Renderer renderer, int x, int y);

}
