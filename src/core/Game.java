package core;

import gfx.Renderer;
import gui.GuiManager;

public abstract class Game {

	protected CoreEngine core;
	protected Scene scene;
	
	protected CharacterController cc;
	protected GuiManager guiManager;

	public Game() {
		guiManager = new GuiManager();
		cc = new CharacterController();
		core = new CoreEngine(this, null);
		
		initGui();
		initScene();
		
	}
	
	public void start(){
		core.start();

	}
	
	public void stop(){
		core.stop();
	}

	public void update(Input input) {
		int xx = (int) (scene.getPlayer().getPosition().x);
		int yy = (int) (scene.getPlayer().getPosition().y);

		cc.update(input.mousePosition.mouseToTile(xx, yy), input.mousePosition.mouseToWorld(xx, yy),
				input.mousePosition.mouseToGui(), input.mouseButtons);
		scene.update(input);
		guiManager.update(scene);

	}

	public void render(Renderer renderer) {
		renderer.setOffset((int)scene.getPlayer().getPosition().x, (int)scene.getPlayer().getPosition().y);
		scene.render(renderer);
		renderer.postProcess();
		guiManager.render(renderer, 0, 0);

	}
	
	protected abstract void initScene();
	protected abstract void initGui();

}
