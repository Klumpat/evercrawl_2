package gui;

import core.Scene;
import gfx.Renderer;
import maths.Bounds;

public class GuiBorder extends GuiComponent {

	private int thickness;
	private int bgColor;
	@SuppressWarnings("unused")
	private int fgColor;

	public GuiBorder(Bounds bounds, int bgColor, int fgColor, int thickness) {
		super(bounds);
		this.thickness = thickness;
		this.bgColor = bgColor;
		this.fgColor = fgColor;
	}

	@Override
	public void render(Renderer renderer, int xOffset, int yOffset) {
		renderer.drawRectangle(bgColor, getWidth(), getHeight(),bounds.getX() + xOffset, bounds.getY() + yOffset,
				thickness);
	}

	@Override
	public void update(Scene scene) {

	}
	
	public void setFgColor(int fgColor) {
		this.fgColor = fgColor;
	}
	
	public void setBgColor(int bgColor) {
		this.bgColor = bgColor;
	}

}
