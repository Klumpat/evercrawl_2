package gui;

import java.util.List;

public interface GuiContainer {

	public void addChildren(GuiComponent c);
	public void removeChildren(GuiComponent c);
	public GuiComponent getChildren(GuiComponent c);
	public List<GuiComponent> getChildrens();

}
