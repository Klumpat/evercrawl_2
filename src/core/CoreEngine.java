package core;

import gfx.Display;
import gfx.Renderer;
import gfx.Window;

public class CoreEngine implements Runnable {

	// TODO bring this stuff into the game class....
	public static final int SCALE = 2;
	public static final int WIDTH = 512;
	public static final int HEIGHT = 384;

	private boolean isRunning;
	private Thread gameLoop = new Thread();
	private Game game;
	private TileMapViewer tmv;
	private Renderer renderer;
	private Input input;

	private Display display;
	private Window window;
	
	boolean TMV;

	public CoreEngine(Game game, TileMapViewer tmv) {
		window = new Window(WIDTH * SCALE, HEIGHT * SCALE, "");
		display = new Display(window);
		isRunning = false;
		renderer = new Renderer(WIDTH, HEIGHT, SCALE);
		this.game = game;
		this.tmv = tmv;
		
		if(game == null){
			TMV = true;
		}
		input = new Input();
		window.addKeyListener(input);
		window.addMouseMotionListener(input);
		window.addMouseListener(input);

	}

	public synchronized void start() {
		if (isRunning)
			return;
		Time.start();
		gameLoop = new Thread(this);
		gameLoop.start();
	}

	public synchronized void stop() {
		if (isRunning)
			return;

		try {
			gameLoop.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void update() {
		if(TMV){
			tmv.update();	
		} else {
			game.update(input);
		}
		
	}

	public void render() {
		if(TMV){
			tmv.render(renderer);	
		} else {
			game.render(renderer);			
		}
		display.getPixelData(renderer.getPix());
		display.showImage();
		renderer.clear(0x0);
		

	}

	public void run() {
		isRunning = true;
		window.requestFocus();

		long lastTime = System.nanoTime();
		double unprocessed = 0.0;
		double tickTime = 1.0 / 60.0;
		double SECOND_IN_NS = 1000000000.0;
		double SECOND_IN_MS = 1000.0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		boolean render = false;
		while (isRunning) {
			long now = System.nanoTime();
			float delta = (float) ((now - lastTime) / SECOND_IN_NS);
			unprocessed += delta;
			lastTime = now;

			while (unprocessed >= tickTime) {
				Time.update(delta);
				update();
				updates++;
				frames++;
				unprocessed -= tickTime;
				render = true;
			}

			if (render) {
				render();
				frames++;
			}
			if (System.currentTimeMillis() - timer > SECOND_IN_MS) {
				timer += SECOND_IN_MS;
				// System.out.println(updates + " ups | " + frames + " fps");
				window.setTitle(updates + " ups | " + frames + " fps");
				frames = 0;
				updates = 0;
			}
		}

		stop();

	}

}
