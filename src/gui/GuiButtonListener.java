package gui;

public interface GuiButtonListener {

	public void entered(GuiButton b);

	public void exited(GuiButton b);

	public void pressed(GuiButton b);

	public void released(GuiButton b);
	
	public void action(GuiButton b);

}
