package gui;

import java.util.ArrayList;
import java.util.List;

import core.Scene;
import gfx.Renderer;
import maths.Bounds;

public class GuiPanel extends GuiComponent implements GuiContainer {

	protected boolean visible;
	protected GuiContainer parent;
	protected List<GuiComponent> childrens = new ArrayList<GuiComponent>();
	private int bgColor;

	public GuiPanel(Bounds bounds, int bgColor) {
		super(bounds);
		this.bgColor = bgColor;
	}

	@Override
	public void render(Renderer renderer, int xOffset, int yOffset) {
		if (visible) {
			if(bgColor>=0){
				renderer.GUIfillRectangle(bgColor, bounds.getWidth(), bounds.getHeight(), bounds.getX() + xOffset, bounds.getY() + yOffset);				
			}

			for (GuiComponent c : childrens) {
				c.render(renderer, (int)bounds.getX(), (int)bounds.getY());
			}
		}
	}

	@Override
	public void update(Scene scene) {
		for (GuiComponent c : childrens) {
			c.update(scene);
		}
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public void show(){
		this.visible = !visible;
	}


	@Override
	public void addChildren(GuiComponent c) {
		childrens.add(c);
		c.setParent(this);
	}

	@Override
	public void removeChildren(GuiComponent c) {
		childrens.remove(c);
		c.setParent(null);
	}

	@Override
	public GuiComponent getChildren(GuiComponent c) {
		for (GuiComponent child : childrens) {
			if (child.equals(c))
				return c;
		}
		return null;
	}

	@Override
	public List<GuiComponent> getChildrens() {
		return childrens;
	}

}
