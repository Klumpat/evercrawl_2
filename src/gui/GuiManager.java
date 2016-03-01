package gui;

import java.util.ArrayList;
import java.util.List;

import core.Scene;
import gfx.Renderer;
import maths.Bounds;

public class GuiManager implements GuiContainer, GuiUpdate, GuiRender {

	private List<GuiComponent> childrens = new ArrayList<GuiComponent>();
	
	private GuiPanel panel;

	public GuiManager() {
		panel = new GuiPanel(new Bounds(), 0xff00ff);
		panel.setVisible(true);
	}

	@Override
	public void render(Renderer renderer, int xOffset, int yOffset) {
		for (GuiRender child : childrens) {
			child.render(renderer, xOffset, yOffset);
		}
	}

	@Override
	public void update(Scene scene) {
		for(GuiComponent child : childrens){
			child.update(scene);
		}
	}

	@Override
	public void addChildren(GuiComponent c) {
		childrens.add(c);
		c.setParent(panel);
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
