package life.main;

import life.main.gfx.Display;

public class Game implements Runnable{

	protected boolean running;
	protected Thread thread;
	
	private Display display;
	
	private void init() {
		display = new Display(640, 480);
	}
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this, "Game of Life Thread");
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		
		try {
			thread.join();
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		
	}
	
	public void update() {
		
	}
	
	public void render() {
		display.render();
	}
	
	public void run() {
		init();
		
		while(running) {
			update();
			render();
		}
	}
	
}
