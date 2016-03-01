package gui;

import maths.Bounds;
import maths.Vector2;

public abstract class GuiComponent implements GuiRender, GuiUpdate {

	/**
	 * {@link Vector2} the position relative to a partent obejct
	 */
	protected GuiPanel parent;
	protected Bounds bounds;

	public GuiComponent(Bounds bounds) {
		this.bounds = bounds;
	}

	public Vector2 getPosition() {
		return bounds.getPosition();
	}

	public Bounds getBounds() {
		return bounds;
	}

	public int getWidth() {
		return bounds.getWidth();
	}

	public int getHeight() {
		return bounds.getHeight();
	}

	public void setParent(GuiPanel parent) {
		this.parent = parent;
	}

	public Bounds getGuiBounds() {
		Bounds res = new Bounds(parent.getBounds().getX() + bounds.getX(), parent.getBounds().getY() + bounds.getY(),
				getWidth(), getHeight());

		return res;
	}

}
