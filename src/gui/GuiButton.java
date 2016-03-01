package gui;

import core.CharacterController;
import core.Scene;
import gfx.Renderer;
import maths.Bounds;
import maths.Vector2;

public class GuiButton extends GuiComponent {

	protected String text = "";
	private GuiButtonListener buttonlistener;
	private GuiActionListener actionListener;
	private int bgColor;
	private int hoverColor;
	private int color;

	boolean inside;
	boolean pressed;

	public GuiButton(Bounds bounds, int bgColor, int hoverColor) {
		super(bounds);
		this.bgColor = bgColor;
		this.hoverColor = hoverColor;
		setColor(bgColor);
		buttonlistener = new GuiButtonListener() {

			@Override
			public void released(GuiButton b) {
				b.pressed = false;

			}

			@Override
			public void pressed(GuiButton b) {
				setColor(0);
				b.pressed = true;
			}

			@Override
			public void exited(GuiButton b) {
				setColor(b.bgColor);
				b.inside = false;
				b.pressed = false;
			}

			@Override
			public void entered(GuiButton b) {
				setColor(b.hoverColor);
				b.inside = true;
			}

			@Override
			public void action(GuiButton b) {
				if(b.actionListener !=null){
					b.actionListener.perform();					
				} else {
					System.out.println("ActionListener = null");
				}
				b.reset();
			}
		};
	}

	@SuppressWarnings("unused")
	@Override
	public void update(Scene scene) {
		Vector2 p = CharacterController.mGuiCoords;
		boolean mLeft = CharacterController.mouseLeft;
		boolean isInside = getGuiBounds().contains(p);

		if (!inside && getGuiBounds().contains(p)) {
			buttonlistener.entered(this);
		} else if (inside && !getGuiBounds().contains(p)) {
			buttonlistener.exited(this);
		}

		if (!pressed && inside && getGuiBounds().contains(p) && mLeft) {
			buttonlistener.pressed(this);
		} else if (pressed && inside && getGuiBounds().contains(p) && !mLeft) {
			buttonlistener.released(this);
			buttonlistener.action(this);
		} else if (pressed && inside && getGuiBounds().contains(p) && !mLeft) {
			buttonlistener.released(this);
		}

	}

	public void setColor(int color) {
		this.color = color;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	

	public void reset() {
		pressed = false;
		inside = false;
		setColor(hoverColor);
	}
	
	public void setActionListener(GuiActionListener actionListener) {
		this.actionListener = actionListener;
	}

	@Override
	public void render(Renderer renderer, int xOffset, int yOffset) {
		renderer.GUIfillRectangle(color, getWidth(), getHeight(), bounds.getX() + xOffset, bounds.getY() + yOffset);
		renderer.drawGuiText(text, bounds.getX() + xOffset, bounds.getY() + yOffset, 0xffffff, false);
	}

}
