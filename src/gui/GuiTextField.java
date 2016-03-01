package gui;

import core.Scene;
import gfx.Renderer;
import maths.Bounds;

public class GuiTextField extends GuiComponent {

	protected String text;
	protected int textColor;

	public GuiTextField(Bounds bounds, int textColor) {
		super(bounds);
		this.textColor = textColor;
		setText("TextField");
	}

	@Override
	public void render(Renderer renderer, int xOffset, int yOffset) {
		renderer.drawGuiText(text, bounds.getX() + xOffset, bounds.getY() + yOffset, getTextColor(), false);
	}

	@Override
	public void update(Scene scene) {
		setText(scene.getPlayer().getPosition().getTileCoords(32).toString());
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public void setTextColor(int textColor) {
		this.textColor = textColor;
	}
	
	public int getTextColor() {
		return textColor;
	}

}
